package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Map;

@Beta
@GwtCompatible
public abstract class ArrayBasedCharEscaper
  extends CharEscaper
{
  private final char[][] replacements;
  private final int replacementsLength;
  private final char safeMin;
  private final char safeMax;
  
  protected ArrayBasedCharEscaper(Map<Character, String> replacementMap, char safeMin, char safeMax)
  {
    this(ArrayBasedEscaperMap.create(replacementMap), safeMin, safeMax);
  }
  
  protected ArrayBasedCharEscaper(ArrayBasedEscaperMap escaperMap, char safeMin, char safeMax)
  {
    Preconditions.checkNotNull(escaperMap);
    replacements = escaperMap.getReplacementArray();
    replacementsLength = replacements.length;
    if (safeMax < safeMin)
    {
      safeMax = '\000';
      safeMin = 65535;
    }
    this.safeMin = safeMin;
    this.safeMax = safeMax;
  }
  
  public final String escape(String s)
  {
    Preconditions.checkNotNull(s);
    for (int i = 0; i < s.length(); i++)
    {
      char c = s.charAt(i);
      if (((c < replacementsLength) && (replacements[c] != null)) || (c > safeMax) || (c < safeMin)) {
        return escapeSlow(s, i);
      }
    }
    return s;
  }
  
  protected final char[] escape(char c)
  {
    if (c < replacementsLength)
    {
      char[] chars = replacements[c];
      if (chars != null) {
        return chars;
      }
    }
    if ((c >= safeMin) && (c <= safeMax)) {
      return null;
    }
    return escapeUnsafe(c);
  }
  
  protected abstract char[] escapeUnsafe(char paramChar);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.escape.ArrayBasedCharEscaper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */