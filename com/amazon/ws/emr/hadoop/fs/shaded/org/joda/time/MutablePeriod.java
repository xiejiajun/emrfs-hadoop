package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BasePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISOPeriodFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatter;
import java.io.Serializable;
import org.joda.convert.FromString;

public class MutablePeriod
  extends BasePeriod
  implements ReadWritablePeriod, Cloneable, Serializable
{
  private static final long serialVersionUID = 3436451121567212165L;
  
  @FromString
  public static MutablePeriod parse(String paramString)
  {
    return parse(paramString, ISOPeriodFormat.standard());
  }
  
  public static MutablePeriod parse(String paramString, PeriodFormatter paramPeriodFormatter)
  {
    return paramPeriodFormatter.parsePeriod(paramString).toMutablePeriod();
  }
  
  public MutablePeriod()
  {
    super(0L, null, null);
  }
  
  public MutablePeriod(PeriodType paramPeriodType)
  {
    super(0L, paramPeriodType, null);
  }
  
  public MutablePeriod(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(0, 0, 0, 0, paramInt1, paramInt2, paramInt3, paramInt4, PeriodType.standard());
  }
  
  public MutablePeriod(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, PeriodType.standard());
  }
  
  public MutablePeriod(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, PeriodType paramPeriodType)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramPeriodType);
  }
  
  public MutablePeriod(long paramLong)
  {
    super(paramLong);
  }
  
  public MutablePeriod(long paramLong, PeriodType paramPeriodType)
  {
    super(paramLong, paramPeriodType, null);
  }
  
  public MutablePeriod(long paramLong, Chronology paramChronology)
  {
    super(paramLong, null, paramChronology);
  }
  
  public MutablePeriod(long paramLong, PeriodType paramPeriodType, Chronology paramChronology)
  {
    super(paramLong, paramPeriodType, paramChronology);
  }
  
  public MutablePeriod(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2, null, null);
  }
  
  public MutablePeriod(long paramLong1, long paramLong2, PeriodType paramPeriodType)
  {
    super(paramLong1, paramLong2, paramPeriodType, null);
  }
  
  public MutablePeriod(long paramLong1, long paramLong2, Chronology paramChronology)
  {
    super(paramLong1, paramLong2, null, paramChronology);
  }
  
  public MutablePeriod(long paramLong1, long paramLong2, PeriodType paramPeriodType, Chronology paramChronology)
  {
    super(paramLong1, paramLong2, paramPeriodType, paramChronology);
  }
  
  public MutablePeriod(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    super(paramReadableInstant1, paramReadableInstant2, null);
  }
  
  public MutablePeriod(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2, PeriodType paramPeriodType)
  {
    super(paramReadableInstant1, paramReadableInstant2, paramPeriodType);
  }
  
  public MutablePeriod(ReadableInstant paramReadableInstant, ReadableDuration paramReadableDuration)
  {
    super(paramReadableInstant, paramReadableDuration, null);
  }
  
  public MutablePeriod(ReadableInstant paramReadableInstant, ReadableDuration paramReadableDuration, PeriodType paramPeriodType)
  {
    super(paramReadableInstant, paramReadableDuration, paramPeriodType);
  }
  
  public MutablePeriod(ReadableDuration paramReadableDuration, ReadableInstant paramReadableInstant)
  {
    super(paramReadableDuration, paramReadableInstant, null);
  }
  
  public MutablePeriod(ReadableDuration paramReadableDuration, ReadableInstant paramReadableInstant, PeriodType paramPeriodType)
  {
    super(paramReadableDuration, paramReadableInstant, paramPeriodType);
  }
  
  public MutablePeriod(Object paramObject)
  {
    super(paramObject, null, null);
  }
  
  public MutablePeriod(Object paramObject, PeriodType paramPeriodType)
  {
    super(paramObject, paramPeriodType, null);
  }
  
  public MutablePeriod(Object paramObject, Chronology paramChronology)
  {
    super(paramObject, null, paramChronology);
  }
  
  public MutablePeriod(Object paramObject, PeriodType paramPeriodType, Chronology paramChronology)
  {
    super(paramObject, paramPeriodType, paramChronology);
  }
  
  public void clear()
  {
    super.setValues(new int[size()]);
  }
  
  public void setValue(int paramInt1, int paramInt2)
  {
    super.setValue(paramInt1, paramInt2);
  }
  
  public void set(DurationFieldType paramDurationFieldType, int paramInt)
  {
    super.setField(paramDurationFieldType, paramInt);
  }
  
  public void setPeriod(ReadablePeriod paramReadablePeriod)
  {
    super.setPeriod(paramReadablePeriod);
  }
  
  public void setPeriod(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    super.setPeriod(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public void setPeriod(ReadableInterval paramReadableInterval)
  {
    if (paramReadableInterval == null)
    {
      setPeriod(0L);
    }
    else
    {
      Chronology localChronology = DateTimeUtils.getChronology(paramReadableInterval.getChronology());
      setPeriod(paramReadableInterval.getStartMillis(), paramReadableInterval.getEndMillis(), localChronology);
    }
  }
  
  public void setPeriod(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    if (paramReadableInstant1 == paramReadableInstant2)
    {
      setPeriod(0L);
    }
    else
    {
      long l1 = DateTimeUtils.getInstantMillis(paramReadableInstant1);
      long l2 = DateTimeUtils.getInstantMillis(paramReadableInstant2);
      Chronology localChronology = DateTimeUtils.getIntervalChronology(paramReadableInstant1, paramReadableInstant2);
      setPeriod(l1, l2, localChronology);
    }
  }
  
  public void setPeriod(long paramLong1, long paramLong2)
  {
    setPeriod(paramLong1, paramLong2, null);
  }
  
  public void setPeriod(long paramLong1, long paramLong2, Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    setValues(paramChronology.get(this, paramLong1, paramLong2));
  }
  
  public void setPeriod(ReadableDuration paramReadableDuration)
  {
    setPeriod(paramReadableDuration, null);
  }
  
  public void setPeriod(ReadableDuration paramReadableDuration, Chronology paramChronology)
  {
    long l = DateTimeUtils.getDurationMillis(paramReadableDuration);
    setPeriod(l, paramChronology);
  }
  
  public void setPeriod(long paramLong)
  {
    setPeriod(paramLong, null);
  }
  
  public void setPeriod(long paramLong, Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    setValues(paramChronology.get(this, paramLong));
  }
  
  public void add(DurationFieldType paramDurationFieldType, int paramInt)
  {
    super.addField(paramDurationFieldType, paramInt);
  }
  
  public void add(ReadablePeriod paramReadablePeriod)
  {
    super.addPeriod(paramReadablePeriod);
  }
  
  public void add(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    setPeriod(FieldUtils.safeAdd(getYears(), paramInt1), FieldUtils.safeAdd(getMonths(), paramInt2), FieldUtils.safeAdd(getWeeks(), paramInt3), FieldUtils.safeAdd(getDays(), paramInt4), FieldUtils.safeAdd(getHours(), paramInt5), FieldUtils.safeAdd(getMinutes(), paramInt6), FieldUtils.safeAdd(getSeconds(), paramInt7), FieldUtils.safeAdd(getMillis(), paramInt8));
  }
  
  public void add(ReadableInterval paramReadableInterval)
  {
    if (paramReadableInterval != null) {
      add(paramReadableInterval.toPeriod(getPeriodType()));
    }
  }
  
  public void add(ReadableDuration paramReadableDuration)
  {
    if (paramReadableDuration != null) {
      add(new Period(paramReadableDuration.getMillis(), getPeriodType()));
    }
  }
  
  public void add(long paramLong)
  {
    add(new Period(paramLong, getPeriodType()));
  }
  
  public void add(long paramLong, Chronology paramChronology)
  {
    add(new Period(paramLong, getPeriodType(), paramChronology));
  }
  
  public void mergePeriod(ReadablePeriod paramReadablePeriod)
  {
    super.mergePeriod(paramReadablePeriod);
  }
  
  public int getYears()
  {
    return getPeriodType().getIndexedField(this, PeriodType.YEAR_INDEX);
  }
  
  public int getMonths()
  {
    return getPeriodType().getIndexedField(this, PeriodType.MONTH_INDEX);
  }
  
  public int getWeeks()
  {
    return getPeriodType().getIndexedField(this, PeriodType.WEEK_INDEX);
  }
  
  public int getDays()
  {
    return getPeriodType().getIndexedField(this, PeriodType.DAY_INDEX);
  }
  
  public int getHours()
  {
    return getPeriodType().getIndexedField(this, PeriodType.HOUR_INDEX);
  }
  
  public int getMinutes()
  {
    return getPeriodType().getIndexedField(this, PeriodType.MINUTE_INDEX);
  }
  
  public int getSeconds()
  {
    return getPeriodType().getIndexedField(this, PeriodType.SECOND_INDEX);
  }
  
  public int getMillis()
  {
    return getPeriodType().getIndexedField(this, PeriodType.MILLI_INDEX);
  }
  
  public void setYears(int paramInt)
  {
    super.setField(DurationFieldType.years(), paramInt);
  }
  
  public void addYears(int paramInt)
  {
    super.addField(DurationFieldType.years(), paramInt);
  }
  
  public void setMonths(int paramInt)
  {
    super.setField(DurationFieldType.months(), paramInt);
  }
  
  public void addMonths(int paramInt)
  {
    super.addField(DurationFieldType.months(), paramInt);
  }
  
  public void setWeeks(int paramInt)
  {
    super.setField(DurationFieldType.weeks(), paramInt);
  }
  
  public void addWeeks(int paramInt)
  {
    super.addField(DurationFieldType.weeks(), paramInt);
  }
  
  public void setDays(int paramInt)
  {
    super.setField(DurationFieldType.days(), paramInt);
  }
  
  public void addDays(int paramInt)
  {
    super.addField(DurationFieldType.days(), paramInt);
  }
  
  public void setHours(int paramInt)
  {
    super.setField(DurationFieldType.hours(), paramInt);
  }
  
  public void addHours(int paramInt)
  {
    super.addField(DurationFieldType.hours(), paramInt);
  }
  
  public void setMinutes(int paramInt)
  {
    super.setField(DurationFieldType.minutes(), paramInt);
  }
  
  public void addMinutes(int paramInt)
  {
    super.addField(DurationFieldType.minutes(), paramInt);
  }
  
  public void setSeconds(int paramInt)
  {
    super.setField(DurationFieldType.seconds(), paramInt);
  }
  
  public void addSeconds(int paramInt)
  {
    super.addField(DurationFieldType.seconds(), paramInt);
  }
  
  public void setMillis(int paramInt)
  {
    super.setField(DurationFieldType.millis(), paramInt);
  }
  
  public void addMillis(int paramInt)
  {
    super.addField(DurationFieldType.millis(), paramInt);
  }
  
  public MutablePeriod copy()
  {
    return (MutablePeriod)clone();
  }
  
  public Object clone()
  {
    try
    {
      return super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new InternalError("Clone error");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutablePeriod
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */