package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseSingleFieldPeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISOPeriodFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatter;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

public final class Months
  extends BaseSingleFieldPeriod
{
  public static final Months ZERO = new Months(0);
  public static final Months ONE = new Months(1);
  public static final Months TWO = new Months(2);
  public static final Months THREE = new Months(3);
  public static final Months FOUR = new Months(4);
  public static final Months FIVE = new Months(5);
  public static final Months SIX = new Months(6);
  public static final Months SEVEN = new Months(7);
  public static final Months EIGHT = new Months(8);
  public static final Months NINE = new Months(9);
  public static final Months TEN = new Months(10);
  public static final Months ELEVEN = new Months(11);
  public static final Months TWELVE = new Months(12);
  public static final Months MAX_VALUE = new Months(Integer.MAX_VALUE);
  public static final Months MIN_VALUE = new Months(Integer.MIN_VALUE);
  private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.months());
  private static final long serialVersionUID = 87525275727380867L;
  
  public static Months months(int paramInt)
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
    case 9: 
      return NINE;
    case 10: 
      return TEN;
    case 11: 
      return ELEVEN;
    case 12: 
      return TWELVE;
    case 2147483647: 
      return MAX_VALUE;
    case -2147483648: 
      return MIN_VALUE;
    }
    return new Months(paramInt);
  }
  
  public static Months monthsBetween(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    int i = BaseSingleFieldPeriod.between(paramReadableInstant1, paramReadableInstant2, DurationFieldType.months());
    return months(i);
  }
  
  public static Months monthsBetween(ReadablePartial paramReadablePartial1, ReadablePartial paramReadablePartial2)
  {
    if (((paramReadablePartial1 instanceof LocalDate)) && ((paramReadablePartial2 instanceof LocalDate)))
    {
      Chronology localChronology = DateTimeUtils.getChronology(paramReadablePartial1.getChronology());
      int j = localChronology.months().getDifference(((LocalDate)paramReadablePartial2).getLocalMillis(), ((LocalDate)paramReadablePartial1).getLocalMillis());
      
      return months(j);
    }
    int i = BaseSingleFieldPeriod.between(paramReadablePartial1, paramReadablePartial2, ZERO);
    return months(i);
  }
  
  public static Months monthsIn(ReadableInterval paramReadableInterval)
  {
    if (paramReadableInterval == null) {
      return ZERO;
    }
    int i = BaseSingleFieldPeriod.between(paramReadableInterval.getStart(), paramReadableInterval.getEnd(), DurationFieldType.months());
    return months(i);
  }
  
  @FromString
  public static Months parseMonths(String paramString)
  {
    if (paramString == null) {
      return ZERO;
    }
    Period localPeriod = PARSER.parsePeriod(paramString);
    return months(localPeriod.getMonths());
  }
  
  private Months(int paramInt)
  {
    super(paramInt);
  }
  
  private Object readResolve()
  {
    return months(getValue());
  }
  
  public DurationFieldType getFieldType()
  {
    return DurationFieldType.months();
  }
  
  public PeriodType getPeriodType()
  {
    return PeriodType.months();
  }
  
  public int getMonths()
  {
    return getValue();
  }
  
  public Months plus(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    return months(FieldUtils.safeAdd(getValue(), paramInt));
  }
  
  public Months plus(Months paramMonths)
  {
    if (paramMonths == null) {
      return this;
    }
    return plus(paramMonths.getValue());
  }
  
  public Months minus(int paramInt)
  {
    return plus(FieldUtils.safeNegate(paramInt));
  }
  
  public Months minus(Months paramMonths)
  {
    if (paramMonths == null) {
      return this;
    }
    return minus(paramMonths.getValue());
  }
  
  public Months multipliedBy(int paramInt)
  {
    return months(FieldUtils.safeMultiply(getValue(), paramInt));
  }
  
  public Months dividedBy(int paramInt)
  {
    if (paramInt == 1) {
      return this;
    }
    return months(getValue() / paramInt);
  }
  
  public Months negated()
  {
    return months(FieldUtils.safeNegate(getValue()));
  }
  
  public boolean isGreaterThan(Months paramMonths)
  {
    if (paramMonths == null) {
      return getValue() > 0;
    }
    return getValue() > paramMonths.getValue();
  }
  
  public boolean isLessThan(Months paramMonths)
  {
    if (paramMonths == null) {
      return getValue() < 0;
    }
    return getValue() < paramMonths.getValue();
  }
  
  @ToString
  public String toString()
  {
    return "P" + String.valueOf(getValue()) + "M";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Months
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */