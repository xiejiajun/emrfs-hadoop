package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Duration;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Interval;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutableInterval;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Period;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.PeriodType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInterval;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;

public abstract class AbstractInterval
  implements ReadableInterval
{
  protected void checkInterval(long paramLong1, long paramLong2)
  {
    if (paramLong2 < paramLong1) {
      throw new IllegalArgumentException("The end instant must be greater the start");
    }
  }
  
  public DateTime getStart()
  {
    return new DateTime(getStartMillis(), getChronology());
  }
  
  public DateTime getEnd()
  {
    return new DateTime(getEndMillis(), getChronology());
  }
  
  public boolean contains(long paramLong)
  {
    long l1 = getStartMillis();
    long l2 = getEndMillis();
    return (paramLong >= l1) && (paramLong < l2);
  }
  
  public boolean containsNow()
  {
    return contains(DateTimeUtils.currentTimeMillis());
  }
  
  public boolean contains(ReadableInstant paramReadableInstant)
  {
    if (paramReadableInstant == null) {
      return containsNow();
    }
    return contains(paramReadableInstant.getMillis());
  }
  
  public boolean contains(ReadableInterval paramReadableInterval)
  {
    if (paramReadableInterval == null) {
      return containsNow();
    }
    long l1 = paramReadableInterval.getStartMillis();
    long l2 = paramReadableInterval.getEndMillis();
    long l3 = getStartMillis();
    long l4 = getEndMillis();
    return (l3 <= l1) && (l1 < l4) && (l2 <= l4);
  }
  
  public boolean overlaps(ReadableInterval paramReadableInterval)
  {
    long l1 = getStartMillis();
    long l2 = getEndMillis();
    if (paramReadableInterval == null)
    {
      l3 = DateTimeUtils.currentTimeMillis();
      return (l1 < l3) && (l3 < l2);
    }
    long l3 = paramReadableInterval.getStartMillis();
    long l4 = paramReadableInterval.getEndMillis();
    return (l1 < l4) && (l3 < l2);
  }
  
  public boolean isEqual(ReadableInterval paramReadableInterval)
  {
    return (getStartMillis() == paramReadableInterval.getStartMillis()) && (getEndMillis() == paramReadableInterval.getEndMillis());
  }
  
  public boolean isBefore(long paramLong)
  {
    return getEndMillis() <= paramLong;
  }
  
  public boolean isBeforeNow()
  {
    return isBefore(DateTimeUtils.currentTimeMillis());
  }
  
  public boolean isBefore(ReadableInstant paramReadableInstant)
  {
    if (paramReadableInstant == null) {
      return isBeforeNow();
    }
    return isBefore(paramReadableInstant.getMillis());
  }
  
  public boolean isBefore(ReadableInterval paramReadableInterval)
  {
    if (paramReadableInterval == null) {
      return isBeforeNow();
    }
    return isBefore(paramReadableInterval.getStartMillis());
  }
  
  public boolean isAfter(long paramLong)
  {
    return getStartMillis() > paramLong;
  }
  
  public boolean isAfterNow()
  {
    return isAfter(DateTimeUtils.currentTimeMillis());
  }
  
  public boolean isAfter(ReadableInstant paramReadableInstant)
  {
    if (paramReadableInstant == null) {
      return isAfterNow();
    }
    return isAfter(paramReadableInstant.getMillis());
  }
  
  public boolean isAfter(ReadableInterval paramReadableInterval)
  {
    long l;
    if (paramReadableInterval == null) {
      l = DateTimeUtils.currentTimeMillis();
    } else {
      l = paramReadableInterval.getEndMillis();
    }
    return getStartMillis() >= l;
  }
  
  public Interval toInterval()
  {
    return new Interval(getStartMillis(), getEndMillis(), getChronology());
  }
  
  public MutableInterval toMutableInterval()
  {
    return new MutableInterval(getStartMillis(), getEndMillis(), getChronology());
  }
  
  public long toDurationMillis()
  {
    return FieldUtils.safeSubtract(getEndMillis(), getStartMillis());
  }
  
  public Duration toDuration()
  {
    long l = toDurationMillis();
    if (l == 0L) {
      return Duration.ZERO;
    }
    return new Duration(l);
  }
  
  public Period toPeriod()
  {
    return new Period(getStartMillis(), getEndMillis(), getChronology());
  }
  
  public Period toPeriod(PeriodType paramPeriodType)
  {
    return new Period(getStartMillis(), getEndMillis(), paramPeriodType, getChronology());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ReadableInterval)) {
      return false;
    }
    ReadableInterval localReadableInterval = (ReadableInterval)paramObject;
    return (getStartMillis() == localReadableInterval.getStartMillis()) && (getEndMillis() == localReadableInterval.getEndMillis()) && (FieldUtils.equals(getChronology(), localReadableInterval.getChronology()));
  }
  
  public int hashCode()
  {
    long l1 = getStartMillis();
    long l2 = getEndMillis();
    int i = 97;
    i = 31 * i + (int)(l1 ^ l1 >>> 32);
    i = 31 * i + (int)(l2 ^ l2 >>> 32);
    i = 31 * i + getChronology().hashCode();
    return i;
  }
  
  public String toString()
  {
    DateTimeFormatter localDateTimeFormatter = ISODateTimeFormat.dateTime();
    localDateTimeFormatter = localDateTimeFormatter.withChronology(getChronology());
    StringBuffer localStringBuffer = new StringBuffer(48);
    localDateTimeFormatter.printTo(localStringBuffer, getStartMillis());
    localStringBuffer.append('/');
    localDateTimeFormatter.printTo(localStringBuffer, getEndMillis());
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.AbstractInterval
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */