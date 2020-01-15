package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util;

public final class TextUtils
{
  public static boolean isEmpty(CharSequence s)
  {
    if (s == null) {
      return true;
    }
    return s.length() == 0;
  }
  
  public static boolean isBlank(CharSequence s)
  {
    if (s == null) {
      return true;
    }
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isWhitespace(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean containsBlanks(CharSequence s)
  {
    if (s == null) {
      return false;
    }
    for (int i = 0; i < s.length(); i++) {
      if (Character.isWhitespace(s.charAt(i))) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.TextUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */