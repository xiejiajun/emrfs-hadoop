package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.SetCookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.ParserCursor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class LaxExpiresHandler
  extends AbstractCookieAttributeHandler
  implements CommonCookieAttributeHandler
{
  static final TimeZone UTC = TimeZone.getTimeZone("UTC");
  private static final BitSet DELIMS;
  private static final Map<String, Integer> MONTHS;
  
  static
  {
    BitSet bitSet = new BitSet();
    bitSet.set(9);
    for (int b = 32; b <= 47; b++) {
      bitSet.set(b);
    }
    for (int b = 59; b <= 64; b++) {
      bitSet.set(b);
    }
    for (int b = 91; b <= 96; b++) {
      bitSet.set(b);
    }
    for (int b = 123; b <= 126; b++) {
      bitSet.set(b);
    }
    DELIMS = bitSet;
    
    ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap(12);
    map.put("jan", Integer.valueOf(0));
    map.put("feb", Integer.valueOf(1));
    map.put("mar", Integer.valueOf(2));
    map.put("apr", Integer.valueOf(3));
    map.put("may", Integer.valueOf(4));
    map.put("jun", Integer.valueOf(5));
    map.put("jul", Integer.valueOf(6));
    map.put("aug", Integer.valueOf(7));
    map.put("sep", Integer.valueOf(8));
    map.put("oct", Integer.valueOf(9));
    map.put("nov", Integer.valueOf(10));
    map.put("dec", Integer.valueOf(11));
    MONTHS = map;
  }
  
  private static final Pattern TIME_PATTERN = Pattern.compile("^([0-9]{1,2}):([0-9]{1,2}):([0-9]{1,2})([^0-9].*)?$");
  private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("^([0-9]{1,2})([^0-9].*)?$");
  private static final Pattern MONTH_PATTERN = Pattern.compile("^(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)(.*)?$", 2);
  private static final Pattern YEAR_PATTERN = Pattern.compile("^([0-9]{2,4})([^0-9].*)?$");
  
  public void parse(SetCookie cookie, String value)
    throws MalformedCookieException
  {
    Args.notNull(cookie, "Cookie");
    ParserCursor cursor = new ParserCursor(0, value.length());
    StringBuilder content = new StringBuilder();
    
    int second = 0;int minute = 0;int hour = 0;int day = 0;int month = 0;int year = 0;
    boolean foundTime = false;boolean foundDayOfMonth = false;boolean foundMonth = false;boolean foundYear = false;
    try
    {
      while (!cursor.atEnd())
      {
        skipDelims(value, cursor);
        content.setLength(0);
        copyContent(value, cursor, content);
        if (content.length() == 0) {
          break;
        }
        if (!foundTime)
        {
          Matcher matcher = TIME_PATTERN.matcher(content);
          if (matcher.matches())
          {
            foundTime = true;
            hour = Integer.parseInt(matcher.group(1));
            minute = Integer.parseInt(matcher.group(2));
            second = Integer.parseInt(matcher.group(3));
            continue;
          }
        }
        if (!foundDayOfMonth)
        {
          Matcher matcher = DAY_OF_MONTH_PATTERN.matcher(content);
          if (matcher.matches())
          {
            foundDayOfMonth = true;
            day = Integer.parseInt(matcher.group(1));
            continue;
          }
        }
        if (!foundMonth)
        {
          Matcher matcher = MONTH_PATTERN.matcher(content);
          if (matcher.matches())
          {
            foundMonth = true;
            month = ((Integer)MONTHS.get(matcher.group(1).toLowerCase(Locale.ROOT))).intValue();
            continue;
          }
        }
        if (!foundYear)
        {
          Matcher matcher = YEAR_PATTERN.matcher(content);
          if (matcher.matches())
          {
            foundYear = true;
            year = Integer.parseInt(matcher.group(1));
          }
        }
      }
    }
    catch (NumberFormatException ignore)
    {
      throw new MalformedCookieException("Invalid 'expires' attribute: " + value);
    }
    if ((!foundTime) || (!foundDayOfMonth) || (!foundMonth) || (!foundYear)) {
      throw new MalformedCookieException("Invalid 'expires' attribute: " + value);
    }
    if ((year >= 70) && (year <= 99)) {
      year = 1900 + year;
    }
    if ((year >= 0) && (year <= 69)) {
      year = 2000 + year;
    }
    if ((day < 1) || (day > 31) || (year < 1601) || (hour > 23) || (minute > 59) || (second > 59)) {
      throw new MalformedCookieException("Invalid 'expires' attribute: " + value);
    }
    Calendar c = Calendar.getInstance();
    c.setTimeZone(UTC);
    c.setTimeInMillis(0L);
    c.set(13, second);
    c.set(12, minute);
    c.set(11, hour);
    c.set(5, day);
    c.set(2, month);
    c.set(1, year);
    cookie.setExpiryDate(c.getTime());
  }
  
  private void skipDelims(CharSequence buf, ParserCursor cursor)
  {
    int pos = cursor.getPos();
    int indexFrom = cursor.getPos();
    int indexTo = cursor.getUpperBound();
    for (int i = indexFrom; i < indexTo; i++)
    {
      char current = buf.charAt(i);
      if (!DELIMS.get(current)) {
        break;
      }
      pos++;
    }
    cursor.updatePos(pos);
  }
  
  private void copyContent(CharSequence buf, ParserCursor cursor, StringBuilder dst)
  {
    int pos = cursor.getPos();
    int indexFrom = cursor.getPos();
    int indexTo = cursor.getUpperBound();
    for (int i = indexFrom; i < indexTo; i++)
    {
      char current = buf.charAt(i);
      if (DELIMS.get(current)) {
        break;
      }
      pos++;
      dst.append(current);
    }
    cursor.updatePos(pos);
  }
  
  public String getAttributeName()
  {
    return "expires";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.LaxExpiresHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */