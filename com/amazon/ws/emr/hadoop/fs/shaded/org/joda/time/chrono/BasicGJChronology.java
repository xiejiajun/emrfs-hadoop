package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;

abstract class BasicGJChronology
  extends BasicChronology
{
  private static final long serialVersionUID = 538276888268L;
  private static final int[] MIN_DAYS_PER_MONTH_ARRAY = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  private static final int[] MAX_DAYS_PER_MONTH_ARRAY = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  private static final long[] MIN_TOTAL_MILLIS_BY_MONTH_ARRAY = new long[12];
  private static final long[] MAX_TOTAL_MILLIS_BY_MONTH_ARRAY = new long[12];
  private static final long FEB_29 = 5097600000L;
  
  static
  {
    long l1 = 0L;
    long l2 = 0L;
    for (int i = 0; i < 11; i++)
    {
      long l3 = MIN_DAYS_PER_MONTH_ARRAY[i] * 86400000L;
      
      l1 += l3;
      MIN_TOTAL_MILLIS_BY_MONTH_ARRAY[(i + 1)] = l1;
      
      l3 = MAX_DAYS_PER_MONTH_ARRAY[i] * 86400000L;
      
      l2 += l3;
      MAX_TOTAL_MILLIS_BY_MONTH_ARRAY[(i + 1)] = l2;
    }
  }
  
  BasicGJChronology(Chronology paramChronology, Object paramObject, int paramInt)
  {
    super(paramChronology, paramObject, paramInt);
  }
  
  boolean isLeapDay(long paramLong)
  {
    return (dayOfMonth().get(paramLong) == 29) && (monthOfYear().isLeap(paramLong));
  }
  
  int getMonthOfYear(long paramLong, int paramInt)
  {
    int i = (int)(paramLong - getYearMillis(paramInt) >> 10);
    
    return i < 28181250 ? 11 : i < 25650000 ? 10 : i < 23034375 ? 9 : i < 20503125 ? 8 : i < 17887500 ? 7 : i < 15271875 ? 6 : i < 12740625 ? 5 : i < 10125000 ? 4 : i < 7593750 ? 3 : i < 4978125 ? 2 : i < 2615625 ? 1 : isLeapYear(paramInt) ? 12 : i < 28265625 ? 11 : i < 25734375 ? 10 : i < 23118750 ? 9 : i < 20587500 ? 8 : i < 17971875 ? 7 : i < 15356250 ? 6 : i < 12825000 ? 5 : i < 10209375 ? 4 : i < 7678125 ? 3 : i < 5062500 ? 2 : i < 2615625 ? 1 : 12;
  }
  
  int getDaysInYearMonth(int paramInt1, int paramInt2)
  {
    if (isLeapYear(paramInt1)) {
      return MAX_DAYS_PER_MONTH_ARRAY[(paramInt2 - 1)];
    }
    return MIN_DAYS_PER_MONTH_ARRAY[(paramInt2 - 1)];
  }
  
  int getDaysInMonthMax(int paramInt)
  {
    return MAX_DAYS_PER_MONTH_ARRAY[(paramInt - 1)];
  }
  
  int getDaysInMonthMaxForSet(long paramLong, int paramInt)
  {
    return (paramInt > 28) || (paramInt < 1) ? getDaysInMonthMax(paramLong) : 28;
  }
  
  long getTotalMillisByYearMonth(int paramInt1, int paramInt2)
  {
    if (isLeapYear(paramInt1)) {
      return MAX_TOTAL_MILLIS_BY_MONTH_ARRAY[(paramInt2 - 1)];
    }
    return MIN_TOTAL_MILLIS_BY_MONTH_ARRAY[(paramInt2 - 1)];
  }
  
  long getYearDifference(long paramLong1, long paramLong2)
  {
    int i = getYear(paramLong1);
    int j = getYear(paramLong2);
    
    long l1 = paramLong1 - getYearMillis(i);
    long l2 = paramLong2 - getYearMillis(j);
    if (l2 >= 5097600000L) {
      if (isLeapYear(j))
      {
        if (!isLeapYear(i)) {
          l2 -= 86400000L;
        }
      }
      else if ((l1 >= 5097600000L) && (isLeapYear(i))) {
        l1 -= 86400000L;
      }
    }
    int k = i - j;
    if (l1 < l2) {
      k--;
    }
    return k;
  }
  
  long setYear(long paramLong, int paramInt)
  {
    int i = getYear(paramLong);
    int j = getDayOfYear(paramLong, i);
    int k = getMillisOfDay(paramLong);
    if (j > 59) {
      if (isLeapYear(i))
      {
        if (!isLeapYear(paramInt)) {
          j--;
        }
      }
      else if (isLeapYear(paramInt)) {
        j++;
      }
    }
    paramLong = getYearMonthDayMillis(paramInt, 1, j);
    paramLong += k;
    
    return paramLong;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BasicGJChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */