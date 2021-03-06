package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseSingleFieldPeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISOPeriodFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatter;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

public final class Hours
  extends BaseSingleFieldPeriod
{
  public static final Hours ZERO = new Hours(0);
  public static final Hours ONE = new Hours(1);
  public static final Hours TWO = new Hours(2);
  public static final Hours THREE = new Hours(3);
  public static final Hours FOUR = new Hours(4);
  public static final Hours FIVE = new Hours(5);
  public static final Hours SIX = new Hours(6);
  public static final Hours SEVEN = new Hours(7);
  public static final Hours EIGHT = new Hours(8);
  public static final Hours MAX_VALUE = new Hours(Integer.MAX_VALUE);
  public static final Hours MIN_VALUE = new Hours(Integer.MIN_VALUE);
  private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.hours());
  private static final long serialVersionUID = 87525275727380864L;
  
  public static Hours hours(int paramInt)
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
    case 8: 
      return EIGHT;
    case 2147483647: 
      return MAX_VALUE;
    case -2147483648: 
      return MIN_VALUE;
    }
    return new Hours(paramInt);
  }
  
  public static Hours hoursBetween(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    int i = BaseSingleFieldPeriod.between(paramReadableInstant1, paramReadableInstant2, DurationFieldType.hours());
    return hours(i);
  }
  
  public static Hours hoursBetween(ReadablePartial paramReadablePartial1, ReadablePartial paramReadablePartial2)
  {
    if (((paramReadablePartial1 instanceof LocalTime)) && ((paramReadablePartial2 instanceof LocalTime)))
    {
      Chronology localChronology = DateTimeUtils.getChronology(paramReadablePartial1.getChronology());
      int j = localChronology.hours().getDifference(((LocalTime)paramReadablePartial2).getLocalMillis(), ((LocalTime)paramReadablePartial1).getLocalMillis());
      
      return hours(j);
    }
    int i = BaseSingleFieldPeriod.between(paramReadablePartial1, paramReadablePartial2, ZERO);
    return hours(i);
  }
  
  public static Hours hoursIn(ReadableInterval paramReadableInterval)
  {
    if (paramReadableInterval == null) {
      return ZERO;
    }
    int i = BaseSingleFieldPeriod.between(paramReadableInterval.getStart(), paramReadableInterval.getEnd(), DurationFieldType.hours());
    return hours(i);
  }
  
  public static Hours standardHoursIn(ReadablePeriod paramReadablePeriod)
  {
    int i = BaseSingleFieldPeriod.standardPeriodIn(paramReadablePeriod, 3600000L);
    return hours(i);
  }
  
  @FromString
  public static Hours parseHours(String paramString)
  {
    if (paramString == null) {
      return ZERO;
    }
    Period localPeriod = PARSER.parsePeriod(paramString);
    return hours(localPeriod.getHours());
  }
  
  private Hours(int paramInt)
  {
    super(paramInt);
  }
  
  private Object readResolve()
  {
    return hours(getValue());
  }
  
  public DurationFieldType getFieldType()
  {
    return DurationFieldType.hours();
  }
  
  public PeriodType getPeriodType()
  {
    return PeriodType.hours();
  }
  
  public Weeks toStandardWeeks()
  {
    return Weeks.weeks(getValue() / 168);
  }
  
  public Days toStandardDays()
  {
    return Days.days(getValue() / 24);
  }
  
  public Minutes toStandardMinutes()
  {
    return Minutes.minutes(FieldUtils.safeMultiply(getValue(), 60));
  }
  
  public Seconds toStandardSeconds()
  {
    return Seconds.seconds(FieldUtils.safeMultiply(getValue(), 3600));
  }
  
  public Duration toStandardDuration()
  {
    long l = getValue();
    return new Duration(l * 3600000L);
  }
  
  public int getHours()
  {
    return getValue();
  }
  
  public Hours plus(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    return hours(FieldUtils.safeAdd(getValue(), paramInt));
  }
  
  public Hours plus(Hours paramHours)
  {
    if (paramHours == null) {
      return this;
    }
    return plus(paramHours.getValue());
  }
  
  public Hours minus(int paramInt)
  {
    return plus(FieldUtils.safeNegate(paramInt));
  }
  
  public Hours minus(Hours paramHours)
  {
    if (paramHours == null) {
      return this;
    }
    return minus(paramHours.getValue());
  }
  
  public Hours multipliedBy(int paramInt)
  {
    return hours(FieldUtils.safeMultiply(getValue(), paramInt));
  }
  
  public Hours dividedBy(int paramInt)
  {
    if (paramInt == 1) {
      return this;
    }
    return hours(getValue() / paramInt);
  }
  
  public Hours negated()
  {
    return hours(FieldUtils.safeNegate(getValue()));
  }
  
  public boolean isGreaterThan(Hours paramHours)
  {
    if (paramHours == null) {
      return getValue() > 0;
    }
    return getValue() > paramHours.getValue();
  }
  
  public boolean isLessThan(Hours paramHours)
  {
    if (paramHours == null) {
      return getValue() < 0;
    }
    return getValue() < paramHours.getValue();
  }
  
  @ToString
  public String toString()
  {
    return "PT" + String.valueOf(getValue()) + "H";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Hours
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */