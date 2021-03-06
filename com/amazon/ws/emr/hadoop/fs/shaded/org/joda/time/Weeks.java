package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseSingleFieldPeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISOPeriodFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatter;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

public final class Weeks
  extends BaseSingleFieldPeriod
{
  public static final Weeks ZERO = new Weeks(0);
  public static final Weeks ONE = new Weeks(1);
  public static final Weeks TWO = new Weeks(2);
  public static final Weeks THREE = new Weeks(3);
  public static final Weeks MAX_VALUE = new Weeks(Integer.MAX_VALUE);
  public static final Weeks MIN_VALUE = new Weeks(Integer.MIN_VALUE);
  private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.weeks());
  private static final long serialVersionUID = 87525275727380866L;
  
  public static Weeks weeks(int paramInt)
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
    return new Weeks(paramInt);
  }
  
  public static Weeks weeksBetween(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    int i = BaseSingleFieldPeriod.between(paramReadableInstant1, paramReadableInstant2, DurationFieldType.weeks());
    return weeks(i);
  }
  
  public static Weeks weeksBetween(ReadablePartial paramReadablePartial1, ReadablePartial paramReadablePartial2)
  {
    if (((paramReadablePartial1 instanceof LocalDate)) && ((paramReadablePartial2 instanceof LocalDate)))
    {
      Chronology localChronology = DateTimeUtils.getChronology(paramReadablePartial1.getChronology());
      int j = localChronology.weeks().getDifference(((LocalDate)paramReadablePartial2).getLocalMillis(), ((LocalDate)paramReadablePartial1).getLocalMillis());
      
      return weeks(j);
    }
    int i = BaseSingleFieldPeriod.between(paramReadablePartial1, paramReadablePartial2, ZERO);
    return weeks(i);
  }
  
  public static Weeks weeksIn(ReadableInterval paramReadableInterval)
  {
    if (paramReadableInterval == null) {
      return ZERO;
    }
    int i = BaseSingleFieldPeriod.between(paramReadableInterval.getStart(), paramReadableInterval.getEnd(), DurationFieldType.weeks());
    return weeks(i);
  }
  
  public static Weeks standardWeeksIn(ReadablePeriod paramReadablePeriod)
  {
    int i = BaseSingleFieldPeriod.standardPeriodIn(paramReadablePeriod, 604800000L);
    return weeks(i);
  }
  
  @FromString
  public static Weeks parseWeeks(String paramString)
  {
    if (paramString == null) {
      return ZERO;
    }
    Period localPeriod = PARSER.parsePeriod(paramString);
    return weeks(localPeriod.getWeeks());
  }
  
  private Weeks(int paramInt)
  {
    super(paramInt);
  }
  
  private Object readResolve()
  {
    return weeks(getValue());
  }
  
  public DurationFieldType getFieldType()
  {
    return DurationFieldType.weeks();
  }
  
  public PeriodType getPeriodType()
  {
    return PeriodType.weeks();
  }
  
  public Days toStandardDays()
  {
    return Days.days(FieldUtils.safeMultiply(getValue(), 7));
  }
  
  public Hours toStandardHours()
  {
    return Hours.hours(FieldUtils.safeMultiply(getValue(), 168));
  }
  
  public Minutes toStandardMinutes()
  {
    return Minutes.minutes(FieldUtils.safeMultiply(getValue(), 10080));
  }
  
  public Seconds toStandardSeconds()
  {
    return Seconds.seconds(FieldUtils.safeMultiply(getValue(), 604800));
  }
  
  public Duration toStandardDuration()
  {
    long l = getValue();
    return new Duration(l * 604800000L);
  }
  
  public int getWeeks()
  {
    return getValue();
  }
  
  public Weeks plus(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    return weeks(FieldUtils.safeAdd(getValue(), paramInt));
  }
  
  public Weeks plus(Weeks paramWeeks)
  {
    if (paramWeeks == null) {
      return this;
    }
    return plus(paramWeeks.getValue());
  }
  
  public Weeks minus(int paramInt)
  {
    return plus(FieldUtils.safeNegate(paramInt));
  }
  
  public Weeks minus(Weeks paramWeeks)
  {
    if (paramWeeks == null) {
      return this;
    }
    return minus(paramWeeks.getValue());
  }
  
  public Weeks multipliedBy(int paramInt)
  {
    return weeks(FieldUtils.safeMultiply(getValue(), paramInt));
  }
  
  public Weeks dividedBy(int paramInt)
  {
    if (paramInt == 1) {
      return this;
    }
    return weeks(getValue() / paramInt);
  }
  
  public Weeks negated()
  {
    return weeks(FieldUtils.safeNegate(getValue()));
  }
  
  public boolean isGreaterThan(Weeks paramWeeks)
  {
    if (paramWeeks == null) {
      return getValue() > 0;
    }
    return getValue() > paramWeeks.getValue();
  }
  
  public boolean isLessThan(Weeks paramWeeks)
  {
    if (paramWeeks == null) {
      return getValue() < 0;
    }
    return getValue() < paramWeeks.getValue();
  }
  
  @ToString
  public String toString()
  {
    return "P" + String.valueOf(getValue()) + "W";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Weeks
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */