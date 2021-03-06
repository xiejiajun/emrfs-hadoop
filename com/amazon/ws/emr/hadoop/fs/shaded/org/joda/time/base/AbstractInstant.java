package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Instant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutableDateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import java.util.Date;
import org.joda.convert.ToString;

public abstract class AbstractInstant
  implements ReadableInstant
{
  public DateTimeZone getZone()
  {
    return getChronology().getZone();
  }
  
  public int get(DateTimeFieldType paramDateTimeFieldType)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }
    return paramDateTimeFieldType.getField(getChronology()).get(getMillis());
  }
  
  public boolean isSupported(DateTimeFieldType paramDateTimeFieldType)
  {
    if (paramDateTimeFieldType == null) {
      return false;
    }
    return paramDateTimeFieldType.getField(getChronology()).isSupported();
  }
  
  public int get(DateTimeField paramDateTimeField)
  {
    if (paramDateTimeField == null) {
      throw new IllegalArgumentException("The DateTimeField must not be null");
    }
    return paramDateTimeField.get(getMillis());
  }
  
  public Instant toInstant()
  {
    return new Instant(getMillis());
  }
  
  public DateTime toDateTime()
  {
    return new DateTime(getMillis(), getZone());
  }
  
  public DateTime toDateTimeISO()
  {
    return new DateTime(getMillis(), ISOChronology.getInstance(getZone()));
  }
  
  public DateTime toDateTime(DateTimeZone paramDateTimeZone)
  {
    Chronology localChronology = DateTimeUtils.getChronology(getChronology());
    localChronology = localChronology.withZone(paramDateTimeZone);
    return new DateTime(getMillis(), localChronology);
  }
  
  public DateTime toDateTime(Chronology paramChronology)
  {
    return new DateTime(getMillis(), paramChronology);
  }
  
  public MutableDateTime toMutableDateTime()
  {
    return new MutableDateTime(getMillis(), getZone());
  }
  
  public MutableDateTime toMutableDateTimeISO()
  {
    return new MutableDateTime(getMillis(), ISOChronology.getInstance(getZone()));
  }
  
  public MutableDateTime toMutableDateTime(DateTimeZone paramDateTimeZone)
  {
    Chronology localChronology = DateTimeUtils.getChronology(getChronology());
    localChronology = localChronology.withZone(paramDateTimeZone);
    return new MutableDateTime(getMillis(), localChronology);
  }
  
  public MutableDateTime toMutableDateTime(Chronology paramChronology)
  {
    return new MutableDateTime(getMillis(), paramChronology);
  }
  
  public Date toDate()
  {
    return new Date(getMillis());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ReadableInstant)) {
      return false;
    }
    ReadableInstant localReadableInstant = (ReadableInstant)paramObject;
    return (getMillis() == localReadableInstant.getMillis()) && (FieldUtils.equals(getChronology(), localReadableInstant.getChronology()));
  }
  
  public int hashCode()
  {
    return (int)(getMillis() ^ getMillis() >>> 32) + getChronology().hashCode();
  }
  
  public int compareTo(ReadableInstant paramReadableInstant)
  {
    if (this == paramReadableInstant) {
      return 0;
    }
    long l1 = paramReadableInstant.getMillis();
    long l2 = getMillis();
    if (l2 == l1) {
      return 0;
    }
    if (l2 < l1) {
      return -1;
    }
    return 1;
  }
  
  public boolean isAfter(long paramLong)
  {
    return getMillis() > paramLong;
  }
  
  public boolean isAfterNow()
  {
    return isAfter(DateTimeUtils.currentTimeMillis());
  }
  
  public boolean isAfter(ReadableInstant paramReadableInstant)
  {
    long l = DateTimeUtils.getInstantMillis(paramReadableInstant);
    return isAfter(l);
  }
  
  public boolean isBefore(long paramLong)
  {
    return getMillis() < paramLong;
  }
  
  public boolean isBeforeNow()
  {
    return isBefore(DateTimeUtils.currentTimeMillis());
  }
  
  public boolean isBefore(ReadableInstant paramReadableInstant)
  {
    long l = DateTimeUtils.getInstantMillis(paramReadableInstant);
    return isBefore(l);
  }
  
  public boolean isEqual(long paramLong)
  {
    return getMillis() == paramLong;
  }
  
  public boolean isEqualNow()
  {
    return isEqual(DateTimeUtils.currentTimeMillis());
  }
  
  public boolean isEqual(ReadableInstant paramReadableInstant)
  {
    long l = DateTimeUtils.getInstantMillis(paramReadableInstant);
    return isEqual(l);
  }
  
  @ToString
  public String toString()
  {
    return ISODateTimeFormat.dateTime().print(this);
  }
  
  public String toString(DateTimeFormatter paramDateTimeFormatter)
  {
    if (paramDateTimeFormatter == null) {
      return toString();
    }
    return paramDateTimeFormatter.print(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.AbstractInstant
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */