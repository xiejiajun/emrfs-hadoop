package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseSingleFieldPeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISOPeriodFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatter;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

public final class Years
  extends BaseSingleFieldPeriod
{
  public static final Years ZERO = new Years(0);
  public static final Years ONE = new Years(1);
  public static final Years TWO = new Years(2);
  public static final Years THREE = new Years(3);
  public static final Years MAX_VALUE = new Years(Integer.MAX_VALUE);
  public static final Years MIN_VALUE = new Years(Integer.MIN_VALUE);
  private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.years());
  private static final long serialVersionUID = 87525275727380868L;
  
  public static Years years(int paramInt)
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
    return new Years(paramInt);
  }
  
  public static Years yearsBetween(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    int i = BaseSingleFieldPeriod.between(paramReadableInstant1, paramReadableInstant2, DurationFieldType.years());
    return years(i);
  }
  
  public static Years yearsBetween(ReadablePartial paramReadablePartial1, ReadablePartial paramReadablePartial2)
  {
    if (((paramReadablePartial1 instanceof LocalDate)) && ((paramReadablePartial2 instanceof LocalDate)))
    {
      Chronology localChronology = DateTimeUtils.getChronology(paramReadablePartial1.getChronology());
      int j = localChronology.years().getDifference(((LocalDate)paramReadablePartial2).getLocalMillis(), ((LocalDate)paramReadablePartial1).getLocalMillis());
      
      return years(j);
    }
    int i = BaseSingleFieldPeriod.between(paramReadablePartial1, paramReadablePartial2, ZERO);
    return years(i);
  }
  
  public static Years yearsIn(ReadableInterval paramReadableInterval)
  {
    if (paramReadableInterval == null) {
      return ZERO;
    }
    int i = BaseSingleFieldPeriod.between(paramReadableInterval.getStart(), paramReadableInterval.getEnd(), DurationFieldType.years());
    return years(i);
  }
  
  @FromString
  public static Years parseYears(String paramString)
  {
    if (paramString == null) {
      return ZERO;
    }
    Period localPeriod = PARSER.parsePeriod(paramString);
    return years(localPeriod.getYears());
  }
  
  private Years(int paramInt)
  {
    super(paramInt);
  }
  
  private Object readResolve()
  {
    return years(getValue());
  }
  
  public DurationFieldType getFieldType()
  {
    return DurationFieldType.years();
  }
  
  public PeriodType getPeriodType()
  {
    return PeriodType.years();
  }
  
  public int getYears()
  {
    return getValue();
  }
  
  public Years plus(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    return years(FieldUtils.safeAdd(getValue(), paramInt));
  }
  
  public Years plus(Years paramYears)
  {
    if (paramYears == null) {
      return this;
    }
    return plus(paramYears.getValue());
  }
  
  public Years minus(int paramInt)
  {
    return plus(FieldUtils.safeNegate(paramInt));
  }
  
  public Years minus(Years paramYears)
  {
    if (paramYears == null) {
      return this;
    }
    return minus(paramYears.getValue());
  }
  
  public Years multipliedBy(int paramInt)
  {
    return years(FieldUtils.safeMultiply(getValue(), paramInt));
  }
  
  public Years dividedBy(int paramInt)
  {
    if (paramInt == 1) {
      return this;
    }
    return years(getValue() / paramInt);
  }
  
  public Years negated()
  {
    return years(FieldUtils.safeNegate(getValue()));
  }
  
  public boolean isGreaterThan(Years paramYears)
  {
    if (paramYears == null) {
      return getValue() > 0;
    }
    return getValue() > paramYears.getValue();
  }
  
  public boolean isLessThan(Years paramYears)
  {
    if (paramYears == null) {
      return getValue() < 0;
    }
    return getValue() < paramYears.getValue();
  }
  
  @ToString
  public String toString()
  {
    return "P" + String.valueOf(getValue()) + "Y";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Years
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */