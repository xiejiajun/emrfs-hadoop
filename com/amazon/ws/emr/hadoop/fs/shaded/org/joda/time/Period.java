package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BasePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISOPeriodFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormatter;
import java.io.Serializable;
import org.joda.convert.FromString;

public final class Period
  extends BasePeriod
  implements ReadablePeriod, Serializable
{
  public static final Period ZERO = new Period();
  private static final long serialVersionUID = 741052353876488155L;
  
  @FromString
  public static Period parse(String paramString)
  {
    return parse(paramString, ISOPeriodFormat.standard());
  }
  
  public static Period parse(String paramString, PeriodFormatter paramPeriodFormatter)
  {
    return paramPeriodFormatter.parsePeriod(paramString);
  }
  
  public static Period years(int paramInt)
  {
    return new Period(new int[] { paramInt, 0, 0, 0, 0, 0, 0, 0, 0 }, PeriodType.standard());
  }
  
  public static Period months(int paramInt)
  {
    return new Period(new int[] { 0, paramInt, 0, 0, 0, 0, 0, 0 }, PeriodType.standard());
  }
  
  public static Period weeks(int paramInt)
  {
    return new Period(new int[] { 0, 0, paramInt, 0, 0, 0, 0, 0 }, PeriodType.standard());
  }
  
  public static Period days(int paramInt)
  {
    return new Period(new int[] { 0, 0, 0, paramInt, 0, 0, 0, 0 }, PeriodType.standard());
  }
  
  public static Period hours(int paramInt)
  {
    return new Period(new int[] { 0, 0, 0, 0, paramInt, 0, 0, 0 }, PeriodType.standard());
  }
  
  public static Period minutes(int paramInt)
  {
    return new Period(new int[] { 0, 0, 0, 0, 0, paramInt, 0, 0 }, PeriodType.standard());
  }
  
  public static Period seconds(int paramInt)
  {
    return new Period(new int[] { 0, 0, 0, 0, 0, 0, paramInt, 0 }, PeriodType.standard());
  }
  
  public static Period millis(int paramInt)
  {
    return new Period(new int[] { 0, 0, 0, 0, 0, 0, 0, paramInt }, PeriodType.standard());
  }
  
  public static Period fieldDifference(ReadablePartial paramReadablePartial1, ReadablePartial paramReadablePartial2)
  {
    if ((paramReadablePartial1 == null) || (paramReadablePartial2 == null)) {
      throw new IllegalArgumentException("ReadablePartial objects must not be null");
    }
    if (paramReadablePartial1.size() != paramReadablePartial2.size()) {
      throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
    }
    DurationFieldType[] arrayOfDurationFieldType = new DurationFieldType[paramReadablePartial1.size()];
    int[] arrayOfInt = new int[paramReadablePartial1.size()];
    int i = 0;
    for (int j = paramReadablePartial1.size(); i < j; i++)
    {
      if (paramReadablePartial1.getFieldType(i) != paramReadablePartial2.getFieldType(i)) {
        throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
      }
      arrayOfDurationFieldType[i] = paramReadablePartial1.getFieldType(i).getDurationType();
      if ((i > 0) && (arrayOfDurationFieldType[(i - 1)] == arrayOfDurationFieldType[i])) {
        throw new IllegalArgumentException("ReadablePartial objects must not have overlapping fields");
      }
      arrayOfInt[i] = (paramReadablePartial2.getValue(i) - paramReadablePartial1.getValue(i));
    }
    return new Period(arrayOfInt, PeriodType.forFields(arrayOfDurationFieldType));
  }
  
  public Period()
  {
    super(0L, null, null);
  }
  
  public Period(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(0, 0, 0, 0, paramInt1, paramInt2, paramInt3, paramInt4, PeriodType.standard());
  }
  
  public Period(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, PeriodType.standard());
  }
  
  public Period(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, PeriodType paramPeriodType)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramPeriodType);
  }
  
  public Period(long paramLong)
  {
    super(paramLong);
  }
  
  public Period(long paramLong, PeriodType paramPeriodType)
  {
    super(paramLong, paramPeriodType, null);
  }
  
  public Period(long paramLong, Chronology paramChronology)
  {
    super(paramLong, null, paramChronology);
  }
  
  public Period(long paramLong, PeriodType paramPeriodType, Chronology paramChronology)
  {
    super(paramLong, paramPeriodType, paramChronology);
  }
  
  public Period(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2, null, null);
  }
  
  public Period(long paramLong1, long paramLong2, PeriodType paramPeriodType)
  {
    super(paramLong1, paramLong2, paramPeriodType, null);
  }
  
  public Period(long paramLong1, long paramLong2, Chronology paramChronology)
  {
    super(paramLong1, paramLong2, null, paramChronology);
  }
  
  public Period(long paramLong1, long paramLong2, PeriodType paramPeriodType, Chronology paramChronology)
  {
    super(paramLong1, paramLong2, paramPeriodType, paramChronology);
  }
  
  public Period(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    super(paramReadableInstant1, paramReadableInstant2, null);
  }
  
  public Period(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2, PeriodType paramPeriodType)
  {
    super(paramReadableInstant1, paramReadableInstant2, paramPeriodType);
  }
  
  public Period(ReadablePartial paramReadablePartial1, ReadablePartial paramReadablePartial2)
  {
    super(paramReadablePartial1, paramReadablePartial2, null);
  }
  
  public Period(ReadablePartial paramReadablePartial1, ReadablePartial paramReadablePartial2, PeriodType paramPeriodType)
  {
    super(paramReadablePartial1, paramReadablePartial2, paramPeriodType);
  }
  
  public Period(ReadableInstant paramReadableInstant, ReadableDuration paramReadableDuration)
  {
    super(paramReadableInstant, paramReadableDuration, null);
  }
  
  public Period(ReadableInstant paramReadableInstant, ReadableDuration paramReadableDuration, PeriodType paramPeriodType)
  {
    super(paramReadableInstant, paramReadableDuration, paramPeriodType);
  }
  
  public Period(ReadableDuration paramReadableDuration, ReadableInstant paramReadableInstant)
  {
    super(paramReadableDuration, paramReadableInstant, null);
  }
  
  public Period(ReadableDuration paramReadableDuration, ReadableInstant paramReadableInstant, PeriodType paramPeriodType)
  {
    super(paramReadableDuration, paramReadableInstant, paramPeriodType);
  }
  
  public Period(Object paramObject)
  {
    super(paramObject, null, null);
  }
  
  public Period(Object paramObject, PeriodType paramPeriodType)
  {
    super(paramObject, paramPeriodType, null);
  }
  
  public Period(Object paramObject, Chronology paramChronology)
  {
    super(paramObject, null, paramChronology);
  }
  
  public Period(Object paramObject, PeriodType paramPeriodType, Chronology paramChronology)
  {
    super(paramObject, paramPeriodType, paramChronology);
  }
  
  private Period(int[] paramArrayOfInt, PeriodType paramPeriodType)
  {
    super(paramArrayOfInt, paramPeriodType);
  }
  
  public Period toPeriod()
  {
    return this;
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
  
  public Period withPeriodType(PeriodType paramPeriodType)
  {
    paramPeriodType = DateTimeUtils.getPeriodType(paramPeriodType);
    if (paramPeriodType.equals(getPeriodType())) {
      return this;
    }
    return new Period(this, paramPeriodType);
  }
  
  public Period withFields(ReadablePeriod paramReadablePeriod)
  {
    if (paramReadablePeriod == null) {
      return this;
    }
    int[] arrayOfInt = getValues();
    arrayOfInt = super.mergePeriodInto(arrayOfInt, paramReadablePeriod);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period withField(DurationFieldType paramDurationFieldType, int paramInt)
  {
    if (paramDurationFieldType == null) {
      throw new IllegalArgumentException("Field must not be null");
    }
    int[] arrayOfInt = getValues();
    super.setFieldInto(arrayOfInt, paramDurationFieldType, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period withFieldAdded(DurationFieldType paramDurationFieldType, int paramInt)
  {
    if (paramDurationFieldType == null) {
      throw new IllegalArgumentException("Field must not be null");
    }
    if (paramInt == 0) {
      return this;
    }
    int[] arrayOfInt = getValues();
    super.addFieldInto(arrayOfInt, paramDurationFieldType, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period withYears(int paramInt)
  {
    int[] arrayOfInt = getValues();
    getPeriodType().setIndexedField(this, PeriodType.YEAR_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period withMonths(int paramInt)
  {
    int[] arrayOfInt = getValues();
    getPeriodType().setIndexedField(this, PeriodType.MONTH_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period withWeeks(int paramInt)
  {
    int[] arrayOfInt = getValues();
    getPeriodType().setIndexedField(this, PeriodType.WEEK_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period withDays(int paramInt)
  {
    int[] arrayOfInt = getValues();
    getPeriodType().setIndexedField(this, PeriodType.DAY_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period withHours(int paramInt)
  {
    int[] arrayOfInt = getValues();
    getPeriodType().setIndexedField(this, PeriodType.HOUR_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period withMinutes(int paramInt)
  {
    int[] arrayOfInt = getValues();
    getPeriodType().setIndexedField(this, PeriodType.MINUTE_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period withSeconds(int paramInt)
  {
    int[] arrayOfInt = getValues();
    getPeriodType().setIndexedField(this, PeriodType.SECOND_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period withMillis(int paramInt)
  {
    int[] arrayOfInt = getValues();
    getPeriodType().setIndexedField(this, PeriodType.MILLI_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period plus(ReadablePeriod paramReadablePeriod)
  {
    if (paramReadablePeriod == null) {
      return this;
    }
    int[] arrayOfInt = getValues();
    getPeriodType().addIndexedField(this, PeriodType.YEAR_INDEX, arrayOfInt, paramReadablePeriod.get(DurationFieldType.YEARS_TYPE));
    getPeriodType().addIndexedField(this, PeriodType.MONTH_INDEX, arrayOfInt, paramReadablePeriod.get(DurationFieldType.MONTHS_TYPE));
    getPeriodType().addIndexedField(this, PeriodType.WEEK_INDEX, arrayOfInt, paramReadablePeriod.get(DurationFieldType.WEEKS_TYPE));
    getPeriodType().addIndexedField(this, PeriodType.DAY_INDEX, arrayOfInt, paramReadablePeriod.get(DurationFieldType.DAYS_TYPE));
    getPeriodType().addIndexedField(this, PeriodType.HOUR_INDEX, arrayOfInt, paramReadablePeriod.get(DurationFieldType.HOURS_TYPE));
    getPeriodType().addIndexedField(this, PeriodType.MINUTE_INDEX, arrayOfInt, paramReadablePeriod.get(DurationFieldType.MINUTES_TYPE));
    getPeriodType().addIndexedField(this, PeriodType.SECOND_INDEX, arrayOfInt, paramReadablePeriod.get(DurationFieldType.SECONDS_TYPE));
    getPeriodType().addIndexedField(this, PeriodType.MILLI_INDEX, arrayOfInt, paramReadablePeriod.get(DurationFieldType.MILLIS_TYPE));
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period plusYears(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    int[] arrayOfInt = getValues();
    getPeriodType().addIndexedField(this, PeriodType.YEAR_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period plusMonths(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    int[] arrayOfInt = getValues();
    getPeriodType().addIndexedField(this, PeriodType.MONTH_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period plusWeeks(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    int[] arrayOfInt = getValues();
    getPeriodType().addIndexedField(this, PeriodType.WEEK_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period plusDays(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    int[] arrayOfInt = getValues();
    getPeriodType().addIndexedField(this, PeriodType.DAY_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period plusHours(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    int[] arrayOfInt = getValues();
    getPeriodType().addIndexedField(this, PeriodType.HOUR_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period plusMinutes(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    int[] arrayOfInt = getValues();
    getPeriodType().addIndexedField(this, PeriodType.MINUTE_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period plusSeconds(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    int[] arrayOfInt = getValues();
    getPeriodType().addIndexedField(this, PeriodType.SECOND_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period plusMillis(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    int[] arrayOfInt = getValues();
    getPeriodType().addIndexedField(this, PeriodType.MILLI_INDEX, arrayOfInt, paramInt);
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period minus(ReadablePeriod paramReadablePeriod)
  {
    if (paramReadablePeriod == null) {
      return this;
    }
    int[] arrayOfInt = getValues();
    getPeriodType().addIndexedField(this, PeriodType.YEAR_INDEX, arrayOfInt, -paramReadablePeriod.get(DurationFieldType.YEARS_TYPE));
    getPeriodType().addIndexedField(this, PeriodType.MONTH_INDEX, arrayOfInt, -paramReadablePeriod.get(DurationFieldType.MONTHS_TYPE));
    getPeriodType().addIndexedField(this, PeriodType.WEEK_INDEX, arrayOfInt, -paramReadablePeriod.get(DurationFieldType.WEEKS_TYPE));
    getPeriodType().addIndexedField(this, PeriodType.DAY_INDEX, arrayOfInt, -paramReadablePeriod.get(DurationFieldType.DAYS_TYPE));
    getPeriodType().addIndexedField(this, PeriodType.HOUR_INDEX, arrayOfInt, -paramReadablePeriod.get(DurationFieldType.HOURS_TYPE));
    getPeriodType().addIndexedField(this, PeriodType.MINUTE_INDEX, arrayOfInt, -paramReadablePeriod.get(DurationFieldType.MINUTES_TYPE));
    getPeriodType().addIndexedField(this, PeriodType.SECOND_INDEX, arrayOfInt, -paramReadablePeriod.get(DurationFieldType.SECONDS_TYPE));
    getPeriodType().addIndexedField(this, PeriodType.MILLI_INDEX, arrayOfInt, -paramReadablePeriod.get(DurationFieldType.MILLIS_TYPE));
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period minusYears(int paramInt)
  {
    return plusYears(-paramInt);
  }
  
  public Period minusMonths(int paramInt)
  {
    return plusMonths(-paramInt);
  }
  
  public Period minusWeeks(int paramInt)
  {
    return plusWeeks(-paramInt);
  }
  
  public Period minusDays(int paramInt)
  {
    return plusDays(-paramInt);
  }
  
  public Period minusHours(int paramInt)
  {
    return plusHours(-paramInt);
  }
  
  public Period minusMinutes(int paramInt)
  {
    return plusMinutes(-paramInt);
  }
  
  public Period minusSeconds(int paramInt)
  {
    return plusSeconds(-paramInt);
  }
  
  public Period minusMillis(int paramInt)
  {
    return plusMillis(-paramInt);
  }
  
  public Period multipliedBy(int paramInt)
  {
    if ((this == ZERO) || (paramInt == 1)) {
      return this;
    }
    int[] arrayOfInt = getValues();
    for (int i = 0; i < arrayOfInt.length; i++) {
      arrayOfInt[i] = FieldUtils.safeMultiply(arrayOfInt[i], paramInt);
    }
    return new Period(arrayOfInt, getPeriodType());
  }
  
  public Period negated()
  {
    return multipliedBy(-1);
  }
  
  public Weeks toStandardWeeks()
  {
    checkYearsAndMonths("Weeks");
    long l1 = getMillis();
    l1 += getSeconds() * 1000L;
    l1 += getMinutes() * 60000L;
    l1 += getHours() * 3600000L;
    l1 += getDays() * 86400000L;
    long l2 = getWeeks() + l1 / 604800000L;
    return Weeks.weeks(FieldUtils.safeToInt(l2));
  }
  
  public Days toStandardDays()
  {
    checkYearsAndMonths("Days");
    long l1 = getMillis();
    l1 += getSeconds() * 1000L;
    l1 += getMinutes() * 60000L;
    l1 += getHours() * 3600000L;
    long l2 = l1 / 86400000L;
    l2 = FieldUtils.safeAdd(l2, getDays());
    l2 = FieldUtils.safeAdd(l2, getWeeks() * 7L);
    return Days.days(FieldUtils.safeToInt(l2));
  }
  
  public Hours toStandardHours()
  {
    checkYearsAndMonths("Hours");
    long l1 = getMillis();
    l1 += getSeconds() * 1000L;
    l1 += getMinutes() * 60000L;
    long l2 = l1 / 3600000L;
    l2 = FieldUtils.safeAdd(l2, getHours());
    l2 = FieldUtils.safeAdd(l2, getDays() * 24L);
    l2 = FieldUtils.safeAdd(l2, getWeeks() * 168L);
    return Hours.hours(FieldUtils.safeToInt(l2));
  }
  
  public Minutes toStandardMinutes()
  {
    checkYearsAndMonths("Minutes");
    long l1 = getMillis();
    l1 += getSeconds() * 1000L;
    long l2 = l1 / 60000L;
    l2 = FieldUtils.safeAdd(l2, getMinutes());
    l2 = FieldUtils.safeAdd(l2, getHours() * 60L);
    l2 = FieldUtils.safeAdd(l2, getDays() * 1440L);
    l2 = FieldUtils.safeAdd(l2, getWeeks() * 10080L);
    return Minutes.minutes(FieldUtils.safeToInt(l2));
  }
  
  public Seconds toStandardSeconds()
  {
    checkYearsAndMonths("Seconds");
    long l = getMillis() / 1000;
    l = FieldUtils.safeAdd(l, getSeconds());
    l = FieldUtils.safeAdd(l, getMinutes() * 60L);
    l = FieldUtils.safeAdd(l, getHours() * 3600L);
    l = FieldUtils.safeAdd(l, getDays() * 86400L);
    l = FieldUtils.safeAdd(l, getWeeks() * 604800L);
    return Seconds.seconds(FieldUtils.safeToInt(l));
  }
  
  public Duration toStandardDuration()
  {
    checkYearsAndMonths("Duration");
    long l = getMillis();
    l += getSeconds() * 1000L;
    l += getMinutes() * 60000L;
    l += getHours() * 3600000L;
    l += getDays() * 86400000L;
    l += getWeeks() * 604800000L;
    return new Duration(l);
  }
  
  private void checkYearsAndMonths(String paramString)
  {
    if (getMonths() != 0) {
      throw new UnsupportedOperationException("Cannot convert to " + paramString + " as this period contains months and months vary in length");
    }
    if (getYears() != 0) {
      throw new UnsupportedOperationException("Cannot convert to " + paramString + " as this period contains years and years vary in length");
    }
  }
  
  public Period normalizedStandard()
  {
    return normalizedStandard(PeriodType.standard());
  }
  
  public Period normalizedStandard(PeriodType paramPeriodType)
  {
    paramPeriodType = DateTimeUtils.getPeriodType(paramPeriodType);
    long l1 = getMillis();
    l1 += getSeconds() * 1000L;
    l1 += getMinutes() * 60000L;
    l1 += getHours() * 3600000L;
    l1 += getDays() * 86400000L;
    l1 += getWeeks() * 604800000L;
    Period localPeriod = new Period(l1, paramPeriodType, ISOChronology.getInstanceUTC());
    int i = getYears();
    int j = getMonths();
    if ((i != 0) || (j != 0))
    {
      long l2 = i * 12L + j;
      int k;
      if (paramPeriodType.isSupported(DurationFieldType.YEARS_TYPE))
      {
        k = FieldUtils.safeToInt(l2 / 12L);
        localPeriod = localPeriod.withYears(k);
        l2 -= k * 12;
      }
      if (paramPeriodType.isSupported(DurationFieldType.MONTHS_TYPE))
      {
        k = FieldUtils.safeToInt(l2);
        localPeriod = localPeriod.withMonths(k);
        l2 -= k;
      }
      if (l2 != 0L) {
        throw new UnsupportedOperationException("Unable to normalize as PeriodType is missing either years or months but period has a month/year amount: " + toString());
      }
    }
    return localPeriod;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Period
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */