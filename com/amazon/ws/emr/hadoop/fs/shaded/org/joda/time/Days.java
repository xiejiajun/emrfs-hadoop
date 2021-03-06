package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseSingleFieldPeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISOPeriodFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatter;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

public final class Days
  extends BaseSingleFieldPeriod
{
  public static final Days ZERO = new Days(0);
  public static final Days ONE = new Days(1);
  public static final Days TWO = new Days(2);
  public static final Days THREE = new Days(3);
  public static final Days FOUR = new Days(4);
  public static final Days FIVE = new Days(5);
  public static final Days SIX = new Days(6);
  public static final Days SEVEN = new Days(7);
  public static final Days MAX_VALUE = new Days(Integer.MAX_VALUE);
  public static final Days MIN_VALUE = new Days(Integer.MIN_VALUE);
  private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.days());
  private static final long serialVersionUID = 87525275727380865L;
  
  public static Days days(int paramInt)
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
    case 4: 
      return FOUR;
    case 5: 
      return FIVE;
    case 6: 
      return SIX;
    case 7: 
      return SEVEN;
    case 2147483647: 
      return MAX_VALUE;
    case -2147483648: 
      return MIN_VALUE;
    }
    return new Days(paramInt);
  }
  
  public static Days daysBetween(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    int i = BaseSingleFieldPeriod.between(paramReadableInstant1, paramReadableInstant2, DurationFieldType.days());
    return days(i);
  }
  
  public static Days daysBetween(ReadablePartial paramReadablePartial1, ReadablePartial paramReadablePartial2)
  {
    if (((paramReadablePartial1 instanceof LocalDate)) && ((paramReadablePartial2 instanceof LocalDate)))
    {
      Chronology localChronology = DateTimeUtils.getChronology(paramReadablePartial1.getChronology());
      int j = localChronology.days().getDifference(((LocalDate)paramReadablePartial2).getLocalMillis(), ((LocalDate)paramReadablePartial1).getLocalMillis());
      
      return days(j);
    }
    int i = BaseSingleFieldPeriod.between(paramReadablePartial1, paramReadablePartial2, ZERO);
    return days(i);
  }
  
  public static Days daysIn(ReadableInterval paramReadableInterval)
  {
    if (paramReadableInterval == null) {
      return ZERO;
    }
    int i = BaseSingleFieldPeriod.between(paramReadableInterval.getStart(), paramReadableInterval.getEnd(), DurationFieldType.days());
    return days(i);
  }
  
  public static Days standardDaysIn(ReadablePeriod paramReadablePeriod)
  {
    int i = BaseSingleFieldPeriod.standardPeriodIn(paramReadablePeriod, 86400000L);
    return days(i);
  }
  
  @FromString
  public static Days parseDays(String paramString)
  {
    if (paramString == null) {
      return ZERO;
    }
    Period localPeriod = PARSER.parsePeriod(paramString);
    return days(localPeriod.getDays());
  }
  
  private Days(int paramInt)
  {
    super(paramInt);
  }
  
  private Object readResolve()
  {
    return days(getValue());
  }
  
  public DurationFieldType getFieldType()
  {
    return DurationFieldType.days();
  }
  
  public PeriodType getPeriodType()
  {
    return PeriodType.days();
  }
  
  public Weeks toStandardWeeks()
  {
    return Weeks.weeks(getValue() / 7);
  }
  
  public Hours toStandardHours()
  {
    return Hours.hours(FieldUtils.safeMultiply(getValue(), 24));
  }
  
  public Minutes toStandardMinutes()
  {
    return Minutes.minutes(FieldUtils.safeMultiply(getValue(), 1440));
  }
  
  public Seconds toStandardSeconds()
  {
    return Seconds.seconds(FieldUtils.safeMultiply(getValue(), 86400));
  }
  
  public Duration toStandardDuration()
  {
    long l = getValue();
    return new Duration(l * 86400000L);
  }
  
  public int getDays()
  {
    return getValue();
  }
  
  public Days plus(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    return days(FieldUtils.safeAdd(getValue(), paramInt));
  }
  
  public Days plus(Days paramDays)
  {
    if (paramDays == null) {
      return this;
    }
    return plus(paramDays.getValue());
  }
  
  public Days minus(int paramInt)
  {
    return plus(FieldUtils.safeNegate(paramInt));
  }
  
  public Days minus(Days paramDays)
  {
    if (paramDays == null) {
      return this;
    }
    return minus(paramDays.getValue());
  }
  
  public Days multipliedBy(int paramInt)
  {
    return days(FieldUtils.safeMultiply(getValue(), paramInt));
  }
  
  public Days dividedBy(int paramInt)
  {
    if (paramInt == 1) {
      return this;
    }
    return days(getValue() / paramInt);
  }
  
  public Days negated()
  {
    return days(FieldUtils.safeNegate(getValue()));
  }
  
  public boolean isGreaterThan(Days paramDays)
  {
    if (paramDays == null) {
      return getValue() > 0;
    }
    return getValue() > paramDays.getValue();
  }
  
  public boolean isLessThan(Days paramDays)
  {
    if (paramDays == null) {
      return getValue() < 0;
    }
    return getValue() < paramDays.getValue();
  }
  
  @ToString
  public String toString()
  {
    return "P" + String.valueOf(getValue()) + "D";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Days
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */