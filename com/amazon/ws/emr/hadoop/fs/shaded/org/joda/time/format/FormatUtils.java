package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import java.io.IOException;
import java.io.Writer;

public class FormatUtils
{
  private static final double LOG_10 = Math.log(10.0D);
  
  public static void appendPaddedInteger(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    try
    {
      appendPaddedInteger(paramStringBuffer, paramInt1, paramInt2);
    }
    catch (IOException localIOException) {}
  }
  
  public static void appendPaddedInteger(Appendable paramAppendable, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt1 < 0)
    {
      paramAppendable.append('-');
      if (paramInt1 != Integer.MIN_VALUE)
      {
        paramInt1 = -paramInt1;
      }
      else
      {
        for (; paramInt2 > 10; paramInt2--) {
          paramAppendable.append('0');
        }
        paramAppendable.append("2147483648");
        return;
      }
    }
    if (paramInt1 < 10)
    {
      for (; paramInt2 > 1; paramInt2--) {
        paramAppendable.append('0');
      }
      paramAppendable.append((char)(paramInt1 + 48));
    }
    else
    {
      int i;
      if (paramInt1 < 100)
      {
        for (; paramInt2 > 2; paramInt2--) {
          paramAppendable.append('0');
        }
        i = (paramInt1 + 1) * 13421772 >> 27;
        paramAppendable.append((char)(i + 48));
        
        paramAppendable.append((char)(paramInt1 - (i << 3) - (i << 1) + 48));
      }
      else
      {
        if (paramInt1 < 1000) {
          i = 3;
        } else if (paramInt1 < 10000) {
          i = 4;
        } else {
          i = (int)(Math.log(paramInt1) / LOG_10) + 1;
        }
        for (; paramInt2 > i; paramInt2--) {
          paramAppendable.append('0');
        }
        paramAppendable.append(Integer.toString(paramInt1));
      }
    }
  }
  
  public static void appendPaddedInteger(StringBuffer paramStringBuffer, long paramLong, int paramInt)
  {
    try
    {
      appendPaddedInteger(paramStringBuffer, paramLong, paramInt);
    }
    catch (IOException localIOException) {}
  }
  
  public static void appendPaddedInteger(Appendable paramAppendable, long paramLong, int paramInt)
    throws IOException
  {
    int i = (int)paramLong;
    if (i == paramLong)
    {
      appendPaddedInteger(paramAppendable, i, paramInt);
    }
    else if (paramInt <= 19)
    {
      paramAppendable.append(Long.toString(paramLong));
    }
    else
    {
      if (paramLong < 0L)
      {
        paramAppendable.append('-');
        if (paramLong != Long.MIN_VALUE)
        {
          paramLong = -paramLong;
        }
        else
        {
          for (; paramInt > 19; paramInt--) {
            paramAppendable.append('0');
          }
          paramAppendable.append("9223372036854775808");
          return;
        }
      }
      int j = (int)(Math.log(paramLong) / LOG_10) + 1;
      for (; paramInt > j; paramInt--) {
        paramAppendable.append('0');
      }
      paramAppendable.append(Long.toString(paramLong));
    }
  }
  
  public static void writePaddedInteger(Writer paramWriter, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt1 < 0)
    {
      paramWriter.write(45);
      if (paramInt1 != Integer.MIN_VALUE)
      {
        paramInt1 = -paramInt1;
      }
      else
      {
        for (; paramInt2 > 10; paramInt2--) {
          paramWriter.write(48);
        }
        paramWriter.write("2147483648");
        return;
      }
    }
    if (paramInt1 < 10)
    {
      for (; paramInt2 > 1; paramInt2--) {
        paramWriter.write(48);
      }
      paramWriter.write(paramInt1 + 48);
    }
    else
    {
      int i;
      if (paramInt1 < 100)
      {
        for (; paramInt2 > 2; paramInt2--) {
          paramWriter.write(48);
        }
        i = (paramInt1 + 1) * 13421772 >> 27;
        paramWriter.write(i + 48);
        
        paramWriter.write(paramInt1 - (i << 3) - (i << 1) + 48);
      }
      else
      {
        if (paramInt1 < 1000) {
          i = 3;
        } else if (paramInt1 < 10000) {
          i = 4;
        } else {
          i = (int)(Math.log(paramInt1) / LOG_10) + 1;
        }
        for (; paramInt2 > i; paramInt2--) {
          paramWriter.write(48);
        }
        paramWriter.write(Integer.toString(paramInt1));
      }
    }
  }
  
  public static void writePaddedInteger(Writer paramWriter, long paramLong, int paramInt)
    throws IOException
  {
    int i = (int)paramLong;
    if (i == paramLong)
    {
      writePaddedInteger(paramWriter, i, paramInt);
    }
    else if (paramInt <= 19)
    {
      paramWriter.write(Long.toString(paramLong));
    }
    else
    {
      if (paramLong < 0L)
      {
        paramWriter.write(45);
        if (paramLong != Long.MIN_VALUE)
        {
          paramLong = -paramLong;
        }
        else
        {
          for (; paramInt > 19; paramInt--) {
            paramWriter.write(48);
          }
          paramWriter.write("9223372036854775808");
          return;
        }
      }
      int j = (int)(Math.log(paramLong) / LOG_10) + 1;
      for (; paramInt > j; paramInt--) {
        paramWriter.write(48);
      }
      paramWriter.write(Long.toString(paramLong));
    }
  }
  
  public static void appendUnpaddedInteger(StringBuffer paramStringBuffer, int paramInt)
  {
    try
    {
      appendUnpaddedInteger(paramStringBuffer, paramInt);
    }
    catch (IOException localIOException) {}
  }
  
  public static void appendUnpaddedInteger(Appendable paramAppendable, int paramInt)
    throws IOException
  {
    if (paramInt < 0)
    {
      paramAppendable.append('-');
      if (paramInt != Integer.MIN_VALUE)
      {
        paramInt = -paramInt;
      }
      else
      {
        paramAppendable.append("2147483648");
        return;
      }
    }
    if (paramInt < 10)
    {
      paramAppendable.append((char)(paramInt + 48));
    }
    else if (paramInt < 100)
    {
      int i = (paramInt + 1) * 13421772 >> 27;
      paramAppendable.append((char)(i + 48));
      
      paramAppendable.append((char)(paramInt - (i << 3) - (i << 1) + 48));
    }
    else
    {
      paramAppendable.append(Integer.toString(paramInt));
    }
  }
  
  public static void appendUnpaddedInteger(StringBuffer paramStringBuffer, long paramLong)
  {
    try
    {
      appendUnpaddedInteger(paramStringBuffer, paramLong);
    }
    catch (IOException localIOException) {}
  }
  
  public static void appendUnpaddedInteger(Appendable paramAppendable, long paramLong)
    throws IOException
  {
    int i = (int)paramLong;
    if (i == paramLong) {
      appendUnpaddedInteger(paramAppendable, i);
    } else {
      paramAppendable.append(Long.toString(paramLong));
    }
  }
  
  public static void writeUnpaddedInteger(Writer paramWriter, int paramInt)
    throws IOException
  {
    if (paramInt < 0)
    {
      paramWriter.write(45);
      if (paramInt != Integer.MIN_VALUE)
      {
        paramInt = -paramInt;
      }
      else
      {
        paramWriter.write("2147483648");
        return;
      }
    }
    if (paramInt < 10)
    {
      paramWriter.write(paramInt + 48);
    }
    else if (paramInt < 100)
    {
      int i = (paramInt + 1) * 13421772 >> 27;
      paramWriter.write(i + 48);
      
      paramWriter.write(paramInt - (i << 3) - (i << 1) + 48);
    }
    else
    {
      paramWriter.write(Integer.toString(paramInt));
    }
  }
  
  public static void writeUnpaddedInteger(Writer paramWriter, long paramLong)
    throws IOException
  {
    int i = (int)paramLong;
    if (i == paramLong) {
      writeUnpaddedInteger(paramWriter, i);
    } else {
      paramWriter.write(Long.toString(paramLong));
    }
  }
  
  public static int calculateDigitCount(long paramLong)
  {
    if (paramLong < 0L)
    {
      if (paramLong != Long.MIN_VALUE) {
        return calculateDigitCount(-paramLong) + 1;
      }
      return 20;
    }
    return paramLong < 10000L ? 4 : paramLong < 1000L ? 3 : paramLong < 100L ? 2 : paramLong < 10L ? 1 : (int)(Math.log(paramLong) / LOG_10) + 1;
  }
  
  static int parseTwoDigits(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.charAt(paramInt) - '0';
    return (i << 3) + (i << 1) + paramCharSequence.charAt(paramInt + 1) - 48;
  }
  
  static String createErrorMessage(String paramString, int paramInt)
  {
    int i = paramInt + 32;
    String str;
    if (paramString.length() <= i + 3) {
      str = paramString;
    } else {
      str = paramString.substring(0, i).concat("...");
    }
    if (paramInt <= 0) {
      return "Invalid format: \"" + str + '"';
    }
    if (paramInt >= paramString.length()) {
      return "Invalid format: \"" + str + "\" is too short";
    }
    return "Invalid format: \"" + str + "\" is malformed at \"" + str.substring(paramInt) + '"';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.FormatUtils
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */