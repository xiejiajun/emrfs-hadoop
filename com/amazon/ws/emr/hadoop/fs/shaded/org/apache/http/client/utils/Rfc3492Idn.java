package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import java.util.StringTokenizer;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class Rfc3492Idn
  implements Idn
{
  private static final int base = 36;
  private static final int tmin = 1;
  private static final int tmax = 26;
  private static final int skew = 38;
  private static final int damp = 700;
  private static final int initial_bias = 72;
  private static final int initial_n = 128;
  private static final char delimiter = '-';
  private static final String ACE_PREFIX = "xn--";
  
  private int adapt(int delta, int numpoints, boolean firsttime)
  {
    int d = delta;
    if (firsttime) {
      d /= 700;
    } else {
      d /= 2;
    }
    d += d / numpoints;
    int k = 0;
    while (d > 455)
    {
      d /= 35;
      k += 36;
    }
    return k + 36 * d / (d + 38);
  }
  
  private int digit(char c)
  {
    if ((c >= 'A') && (c <= 'Z')) {
      return c - 'A';
    }
    if ((c >= 'a') && (c <= 'z')) {
      return c - 'a';
    }
    if ((c >= '0') && (c <= '9')) {
      return c - '0' + 26;
    }
    throw new IllegalArgumentException("illegal digit: " + c);
  }
  
  public String toUnicode(String punycode)
  {
    StringBuilder unicode = new StringBuilder(punycode.length());
    StringTokenizer tok = new StringTokenizer(punycode, ".");
    while (tok.hasMoreTokens())
    {
      String t = tok.nextToken();
      if (unicode.length() > 0) {
        unicode.append('.');
      }
      if (t.startsWith("xn--")) {
        t = decode(t.substring(4));
      }
      unicode.append(t);
    }
    return unicode.toString();
  }
  
  protected String decode(String s)
  {
    String input = s;
    int n = 128;
    int i = 0;
    int bias = 72;
    StringBuilder output = new StringBuilder(input.length());
    int lastdelim = input.lastIndexOf('-');
    if (lastdelim != -1)
    {
      output.append(input.subSequence(0, lastdelim));
      input = input.substring(lastdelim + 1);
    }
    while (!input.isEmpty())
    {
      int oldi = i;
      int w = 1;
      for (int k = 36; !input.isEmpty(); k += 36)
      {
        char c = input.charAt(0);
        input = input.substring(1);
        int digit = digit(c);
        i += digit * w;
        int t;
        int t;
        if (k <= bias + 1)
        {
          t = 1;
        }
        else
        {
          int t;
          if (k >= bias + 26) {
            t = 26;
          } else {
            t = k - bias;
          }
        }
        if (digit < t) {
          break;
        }
        w *= (36 - t);
      }
      bias = adapt(i - oldi, output.length() + 1, oldi == 0);
      n += i / (output.length() + 1);
      i %= (output.length() + 1);
      
      output.insert(i, (char)n);
      i++;
    }
    return output.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils.Rfc3492Idn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */