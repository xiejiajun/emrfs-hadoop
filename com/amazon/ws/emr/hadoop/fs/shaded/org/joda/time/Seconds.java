package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseSingleFieldPeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISOPeriodFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatter;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

public final class Seconds
  extends BaseSingleFieldPeriod
{
  public static final Seconds ZERO = new Seconds(0);
  public static final Seconds ONE = new Seconds(1);
  public static final Seconds TWO = new Seconds(2);
  public static final Seconds THREE = new Seconds(3);
  public static final Seconds MAX_VALUE = new Seconds(Integer.MAX_VALUE);
  public static final Seconds MIN_VALUE = new Seconds(Integer.MIN_VALUE);
  private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.seconds());
  private static final long serialVersionUID = 87525275727380862L;
  
  public static Seconds seconds(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
      return ZERO;
    case 1: 
      return ONE;
    case 2: 
      return TWO;
    case 3: 
      return THREE;
    case 2147483647: 
      return MAX_VALUE;
    case -2147483648: 
      return MIN_VALUE;
    }
    return new Seconds(paramInt);
  }
  
  public static Seconds secondsBetween(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    int i = BaseSingleFieldPeriod.between(paramReadableInstant1, paramReadableInstant2, DurationFieldType.seconds());
    return seconds(i);
  }
  
  public static Seconds secondsBetween(ReadablePartial paramReadablePartial1, ReadablePartial paramReadablePartial2)
  {
    if (((paramReadablePartial1 instanceof LocalTime)) && ((paramReadablePartial2 instanceof LocalTime)))
    {
      Chronology localChronology = DateTimeUtils.getChronology(paramReadablePartial1.getChronology());
      int j = localChronology.seconds().getDifference(((LocalTime)paramReadablePartial2).getLocalMillis(), ((LocalTime)paramReadablePartial1).getLocalMillis());
      
      return seconds(j);
    }
    int i = BaseSingleFieldPeriod.between(paramReadablePartial1, paramReadablePartial2, ZERO);
    return seconds(i);
  }
  
  public static Seconds secondsIn(ReadableInterval paramReadableInterval)
  {
    if (paramReadableInterval == null) {
      return ZERO;
    }
    int i = BaseSingleFieldPeriod.between(paramReadableInterval.getStart(), paramReadableInterval.getEnd(), DurationFieldType.seconds());
    return seconds(i);
  }
  
  public static Seconds standardSecondsIn(ReadablePeriod paramReadablePeriod)
  {
    int i = BaseSingleFieldPeriod.standardPeriodIn(paramReadablePeriod, 1000L);
    return seconds(i);
  }
  
  @FromString
  public static Seconds parseSeconds(String paramString)
  {
    if (paramString == null) {
      return ZERO;
    }
    Period localPeriod = PARSER.parsePeriod(paramString);
    return seconds(localPeriod.getSeconds());
  }
  
  private Seconds(int paramInt)
  {
    super(paramInt);
  }
  
  private Object readResolve()
  {
    return seconds(getValue());
  }
  
  public DurationFieldType getFieldType()
  {
    return DurationFieldType.seconds();
  }
  
  public PeriodType getPeriodType()
  {
    return PeriodType.seconds();
  }
  
  public Weeks toStandardWeeks()
  {
    return Weeks.weeks(getValue() / 604800);
  }
  
  public Days toStandardDays()
  {
    return Days.days(getValue() / 86400);
  }
  
  public Hours toStandardHours()
  {
    return Hours.hours(getValue() / 3600);
  }
  
  public Minutes toStandardMinutes()
  {
    return Minutes.minutes(getValue() / 60);
  }
  
  public Duration toStandardDuration()
  {
    long l = getValue();
    return new Duration(l * 1000L);
  }
  
  public int getSeconds()
  {
    return getValue();
  }
  
  public Seconds plus(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    return seconds(FieldUtils.safeAdd(getValue(), paramInt));
  }
  
  public Seconds plus(Seconds paramSeconds)
  {
    if (paramSeconds == null) {
      return this;
    }
    return plus(paramSeconds.getValue());
  }
  
  public Seconds minus(int paramInt)
  {
    return plus(FieldUtils.safeNegate(paramInt));
  }
  
  public Seconds minus(Seconds paramSeconds)
  {
    if (paramSeconds == null) {
      return this;
    }
    return minus(paramSeconds.getValue());
  }
  
  public Seconds multipliedBy(int paramInt)
  {
    return seconds(FieldUtils.safeMultiply(getValue(), paramInt));
  }
  
  public Seconds dividedBy(int paramInt)
  {
    if (paramInt == 1) {
      return this;
    }
    return seconds(getValue() / paramInt);
  }
  
  public Seconds negated()
  {
    return seconds(FieldUtils.safeNegate(getValue()));
  }
  
  public boolean isGreaterThan(Seconds paramSeconds)
  {
    if (paramSeconds == null) {
      return getValue() > 0;
    }
    return getValue() > paramSeconds.getValue();
  }
  
  public boolean isLessThan(Seconds paramSeconds)
  {
    if (paramSeconds == null) {
      return getValue() < 0;
    }
    return getValue() < paramSeconds.getValue();
  }
  
  @ToString
  public String toString()
  {
    return "PT" + String.valueOf(getValue()) + "S";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Seconds
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */