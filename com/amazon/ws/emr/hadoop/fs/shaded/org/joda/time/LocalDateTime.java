package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseLocal;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ConverterManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.PartialConverter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractReadableInstantFieldProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

public final class LocalDateTime
  extends BaseLocal
  implements ReadablePartial, Serializable
{
  private static final long serialVersionUID = -268716875315837168L;
  private static final int YEAR = 0;
  private static final int MONTH_OF_YEAR = 1;
  private static final int DAY_OF_MONTH = 2;
  private static final int MILLIS_OF_DAY = 3;
  private final long iLocalMillis;
  private final Chronology iChronology;
  
  public static LocalDateTime now()
  {
    return new LocalDateTime();
  }
  
  public static LocalDateTime now(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      throw new NullPointerException("Zone must not be null");
    }
    return new LocalDateTime(paramDateTimeZone);
  }
  
  public static LocalDateTime now(Chronology paramChronology)
  {
    if (paramChronology == null) {
      throw new NullPointerException("Chronology must not be null");
    }
    return new LocalDateTime(paramChronology);
  }
  
  @FromString
  public static LocalDateTime parse(String paramString)
  {
    return parse(paramString, ISODateTimeFormat.localDateOptionalTimeParser());
  }
  
  public static LocalDateTime parse(String paramString, DateTimeFormatter paramDateTimeFormatter)
  {
    return paramDateTimeFormatter.parseLocalDateTime(paramString);
  }
  
  public static LocalDateTime fromCalendarFields(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("The calendar must not be null");
    }
    int i = paramCalendar.get(0);
    int j = paramCalendar.get(1);
    return new LocalDateTime(i == 1 ? j : 1 - j, paramCalendar.get(2) + 1, paramCalendar.get(5), paramCalendar.get(11), paramCalendar.get(12), paramCalendar.get(13), paramCalendar.get(14));
  }
  
  public static LocalDateTime fromDateFields(Date paramDate)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    if (paramDate.getTime() < 0L)
    {
      GregorianCalendar localGregorianCalendar = new GregorianCalendar();
      localGregorianCalendar.setTime(paramDate);
      return fromCalendarFields(localGregorianCalendar);
    }
    return new LocalDateTime(paramDate.getYear() + 1900, paramDate.getMonth() + 1, paramDate.getDate(), paramDate.getHours(), paramDate.getMinutes(), paramDate.getSeconds(), ((int)(paramDate.getTime() % 1000L) + 1000) % 1000);
  }
  
  public LocalDateTime()
  {
    this(DateTimeUtils.currentTimeMillis(), ISOChronology.getInstance());
  }
  
  public LocalDateTime(DateTimeZone paramDateTimeZone)
  {
    this(DateTimeUtils.currentTimeMillis(), ISOChronology.getInstance(paramDateTimeZone));
  }
  
  public LocalDateTime(Chronology paramChronology)
  {
    this(DateTimeUtils.currentTimeMillis(), paramChronology);
  }
  
  public LocalDateTime(long paramLong)
  {
    this(paramLong, ISOChronology.getInstance());
  }
  
  public LocalDateTime(long paramLong, DateTimeZone paramDateTimeZone)
  {
    this(paramLong, ISOChronology.getInstance(paramDateTimeZone));
  }
  
  public LocalDateTime(long paramLong, Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    
    long l = paramChronology.getZone().getMillisKeepLocal(DateTimeZone.UTC, paramLong);
    iLocalMillis = l;
    iChronology = paramChronology.withUTC();
  }
  
  public LocalDateTime(Object paramObject)
  {
    this(paramObject, (Chronology)null);
  }
  
  public LocalDateTime(Object paramObject, DateTimeZone paramDateTimeZone)
  {
    PartialConverter localPartialConverter = ConverterManager.getInstance().getPartialConverter(paramObject);
    Chronology localChronology = localPartialConverter.getChronology(paramObject, paramDateTimeZone);
    localChronology = DateTimeUtils.getChronology(localChronology);
    iChronology = localChronology.withUTC();
    int[] arrayOfInt = localPartialConverter.getPartialValues(this, paramObject, localChronology, ISODateTimeFormat.localDateOptionalTimeParser());
    iLocalMillis = iChronology.getDateTimeMillis(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
  }
  
  public LocalDateTime(Object paramObject, Chronology paramChronology)
  {
    PartialConverter localPartialConverter = ConverterManager.getInstance().getPartialConverter(paramObject);
    paramChronology = localPartialConverter.getChronology(paramObject, paramChronology);
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    iChronology = paramChronology.withUTC();
    int[] arrayOfInt = localPartialConverter.getPartialValues(this, paramObject, paramChronology, ISODateTimeFormat.localDateOptionalTimeParser());
    iLocalMillis = iChronology.getDateTimeMillis(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
  }
  
  public LocalDateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 0, 0, ISOChronology.getInstanceUTC());
  }
  
  public LocalDateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 0, ISOChronology.getInstanceUTC());
  }
  
  public LocalDateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, ISOChronology.getInstanceUTC());
  }
  
  public LocalDateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology).withUTC();
    long l = paramChronology.getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    
    iChronology = paramChronology;
    iLocalMillis = l;
  }
  
  private Object readResolve()
  {
    if (iChronology == null) {
      return new LocalDateTime(iLocalMillis, ISOChronology.getInstanceUTC());
    }
    if (!DateTimeZone.UTC.equals(iChronology.getZone())) {
      return new LocalDateTime(iLocalMillis, iChronology.withUTC());
    }
    return this;
  }
  
  public int size()
  {
    return 4;
  }
  
  protected DateTimeField getField(int paramInt, Chronology paramChronology)
  {
    switch (paramInt)
    {
    case 0: 
      return paramChronology.year();
    case 1: 
      return paramChronology.monthOfYear();
    case 2: 
      return paramChronology.dayOfMonth();
    case 3: 
      return paramChronology.millisOfDay();
    }
    throw new IndexOutOfBoundsException("Invalid index: " + paramInt);
  }
  
  public int getValue(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
      return getChronology().year().get(getLocalMillis());
    case 1: 
      return getChronology().monthOfYear().get(getLocalMillis());
    case 2: 
      return getChronology().dayOfMonth().get(getLocalMillis());
    case 3: 
      return getChronology().millisOfDay().get(getLocalMillis());
    }
    throw new IndexOutOfBoundsException("Invalid index: " + paramInt);
  }
  
  public int get(DateTimeFieldType paramDateTimeFieldType)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }
    return paramDateTimeFieldType.getField(getChronology()).get(getLocalMillis());
  }
  
  public boolean isSupported(DateTimeFieldType paramDateTimeFieldType)
  {
    if (paramDateTimeFieldType == null) {
      return false;
    }
    return paramDateTimeFieldType.getField(getChronology()).isSupported();
  }
  
  public boolean isSupported(DurationFieldType paramDurationFieldType)
  {
    if (paramDurationFieldType == null) {
      return false;
    }
    return paramDurationFieldType.getField(getChronology()).isSupported();
  }
  
  protected long getLocalMillis()
  {
    return iLocalMillis;
  }
  
  public Chronology getChronology()
  {
    return iChronology;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof LocalDateTime))
    {
      LocalDateTime localLocalDateTime = (LocalDateTime)paramObject;
      if (iChronology.equals(iChronology)) {
        return iLocalMillis == iLocalMillis;
      }
    }
    return super.equals(paramObject);
  }
  
  public int compareTo(ReadablePartial paramReadablePartial)
  {
    if (this == paramReadablePartial) {
      return 0;
    }
    if ((paramReadablePartial instanceof LocalDateTime))
    {
      LocalDateTime localLocalDateTime = (LocalDateTime)paramReadablePartial;
      if (iChronology.equals(iChronology)) {
        return iLocalMillis == iLocalMillis ? 0 : iLocalMillis < iLocalMillis ? -1 : 1;
      }
    }
    return super.compareTo(paramReadablePartial);
  }
  
  public DateTime toDateTime()
  {
    return toDateTime((DateTimeZone)null);
  }
  
  public DateTime toDateTime(DateTimeZone paramDateTimeZone)
  {
    paramDateTimeZone = DateTimeUtils.getZone(paramDateTimeZone);
    Chronology localChronology = iChronology.withZone(paramDateTimeZone);
    return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), getHourOfDay(), getMinuteOfHour(), getSecondOfMinute(), getMillisOfSecond(), localChronology);
  }
  
  public LocalDate toLocalDate()
  {
    return new LocalDate(getLocalMillis(), getChronology());
  }
  
  public LocalTime toLocalTime()
  {
    return new LocalTime(getLocalMillis(), getChronology());
  }
  
  public Date toDate()
  {
    int i = getDayOfMonth();
    Date localDate = new Date(getYear() - 1900, getMonthOfYear() - 1, i, getHourOfDay(), getMinuteOfHour(), getSecondOfMinute());
    
    localDate.setTime(localDate.getTime() + getMillisOfSecond());
    return correctDstTransition(localDate, TimeZone.getDefault());
  }
  
  public Date toDate(TimeZone paramTimeZone)
  {
    Calendar localCalendar = Calendar.getInstance(paramTimeZone);
    localCalendar.clear();
    localCalendar.set(getYear(), getMonthOfYear() - 1, getDayOfMonth(), getHourOfDay(), getMinuteOfHour(), getSecondOfMinute());
    
    Date localDate = localCalendar.getTime();
    localDate.setTime(localDate.getTime() + getMillisOfSecond());
    return correctDstTransition(localDate, paramTimeZone);
  }
  
  private Date correctDstTransition(Date paramDate, TimeZone paramTimeZone)
  {
    Object localObject = Calendar.getInstance(paramTimeZone);
    ((Calendar)localObject).setTime(paramDate);
    LocalDateTime localLocalDateTime = fromCalendarFields((Calendar)localObject);
    if (localLocalDateTime.isBefore(this))
    {
      while (localLocalDateTime.isBefore(this))
      {
        ((Calendar)localObject).setTimeInMillis(((Calendar)localObject).getTimeInMillis() + 60000L);
        localLocalDateTime = fromCalendarFields((Calendar)localObject);
      }
      while (!localLocalDateTime.isBefore(this))
      {
        ((Calendar)localObject).setTimeInMillis(((Calendar)localObject).getTimeInMillis() - 1000L);
        localLocalDateTime = fromCalendarFields((Calendar)localObject);
      }
      ((Calendar)localObject).setTimeInMillis(((Calendar)localObject).getTimeInMillis() + 1000L);
    }
    else if (localLocalDateTime.equals(this))
    {
      Calendar localCalendar = Calendar.getInstance(paramTimeZone);
      localCalendar.setTimeInMillis(((Calendar)localObject).getTimeInMillis() - paramTimeZone.getDSTSavings());
      localLocalDateTime = fromCalendarFields(localCalendar);
      if (localLocalDateTime.equals(this)) {
        localObject = localCalendar;
      }
    }
    return ((Calendar)localObject).getTime();
  }
  
  LocalDateTime withLocalMillis(long paramLong)
  {
    return paramLong == getLocalMillis() ? this : new LocalDateTime(paramLong, getChronology());
  }
  
  public LocalDateTime withDate(int paramInt1, int paramInt2, int paramInt3)
  {
    Chronology localChronology = getChronology();
    long l = getLocalMillis();
    l = localChronology.year().set(l, paramInt1);
    l = localChronology.monthOfYear().set(l, paramInt2);
    l = localChronology.dayOfMonth().set(l, paramInt3);
    return withLocalMillis(l);
  }
  
  public LocalDateTime withTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Chronology localChronology = getChronology();
    long l = getLocalMillis();
    l = localChronology.hourOfDay().set(l, paramInt1);
    l = localChronology.minuteOfHour().set(l, paramInt2);
    l = localChronology.secondOfMinute().set(l, paramInt3);
    l = localChronology.millisOfSecond().set(l, paramInt4);
    return withLocalMillis(l);
  }
  
  public LocalDateTime withFields(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial == null) {
      return this;
    }
    return withLocalMillis(getChronology().set(paramReadablePartial, getLocalMillis()));
  }
  
  public LocalDateTime withField(DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("Field must not be null");
    }
    long l = paramDateTimeFieldType.getField(getChronology()).set(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime withFieldAdded(DurationFieldType paramDurationFieldType, int paramInt)
  {
    if (paramDurationFieldType == null) {
      throw new IllegalArgumentException("Field must not be null");
    }
    if (paramInt == 0) {
      return this;
    }
    long l = paramDurationFieldType.getField(getChronology()).add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime withDurationAdded(ReadableDuration paramReadableDuration, int paramInt)
  {
    if ((paramReadableDuration == null) || (paramInt == 0)) {
      return this;
    }
    long l = getChronology().add(getLocalMillis(), paramReadableDuration.getMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime withPeriodAdded(ReadablePeriod paramReadablePeriod, int paramInt)
  {
    if ((paramReadablePeriod == null) || (paramInt == 0)) {
      return this;
    }
    long l = getChronology().add(paramReadablePeriod, getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime plus(ReadableDuration paramReadableDuration)
  {
    return withDurationAdded(paramReadableDuration, 1);
  }
  
  public LocalDateTime plus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, 1);
  }
  
  public LocalDateTime plusYears(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().years().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime plusMonths(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().months().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime plusWeeks(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().weeks().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime plusDays(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().days().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime plusHours(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().hours().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime plusMinutes(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().minutes().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime plusSeconds(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().seconds().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime plusMillis(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().millis().add(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime minus(ReadableDuration paramReadableDuration)
  {
    return withDurationAdded(paramReadableDuration, -1);
  }
  
  public LocalDateTime minus(ReadablePeriod paramReadablePeriod)
  {
    return withPeriodAdded(paramReadablePeriod, -1);
  }
  
  public LocalDateTime minusYears(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().years().subtract(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime minusMonths(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().months().subtract(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime minusWeeks(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().weeks().subtract(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime minusDays(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().days().subtract(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime minusHours(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().hours().subtract(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime minusMinutes(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().minutes().subtract(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime minusSeconds(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().seconds().subtract(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public LocalDateTime minusMillis(int paramInt)
  {
    if (paramInt == 0) {
      return this;
    }
    long l = getChronology().millis().subtract(getLocalMillis(), paramInt);
    return withLocalMillis(l);
  }
  
  public Property property(DateTimeFieldType paramDateTimeFieldType)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }
    if (!isSupported(paramDateTimeFieldType)) {
      throw new IllegalArgumentException("Field '" + paramDateTimeFieldType + "' is not supported");
    }
    return new Property(this, paramDateTimeFieldType.getField(getChronology()));
  }
  
  public int getEra()
  {
    return getChronology().era().get(getLocalMillis());
  }
  
  public int getCenturyOfEra()
  {
    return getChronology().centuryOfEra().get(getLocalMillis());
  }
  
  public int getYearOfEra()
  {
    return getChronology().yearOfEra().get(getLocalMillis());
  }
  
  public int getYearOfCentury()
  {
    return getChronology().yearOfCentury().get(getLocalMillis());
  }
  
  public int getYear()
  {
    return getChronology().year().get(getLocalMillis());
  }
  
  public int getWeekyear()
  {
    return getChronology().weekyear().get(getLocalMillis());
  }
  
  public int getMonthOfYear()
  {
    return getChronology().monthOfYear().get(getLocalMillis());
  }
  
  public int getWeekOfWeekyear()
  {
    return getChronology().weekOfWeekyear().get(getLocalMillis());
  }
  
  public int getDayOfYear()
  {
    return getChronology().dayOfYear().get(getLocalMillis());
  }
  
  public int getDayOfMonth()
  {
    return getChronology().dayOfMonth().get(getLocalMillis());
  }
  
  public int getDayOfWeek()
  {
    return getChronology().dayOfWeek().get(getLocalMillis());
  }
  
  public int getHourOfDay()
  {
    return getChronology().hourOfDay().get(getLocalMillis());
  }
  
  public int getMinuteOfHour()
  {
    return getChronology().minuteOfHour().get(getLocalMillis());
  }
  
  public int getSecondOfMinute()
  {
    return getChronology().secondOfMinute().get(getLocalMillis());
  }
  
  public int getMillisOfSecond()
  {
    return getChronology().millisOfSecond().get(getLocalMillis());
  }
  
  public int getMillisOfDay()
  {
    return getChronology().millisOfDay().get(getLocalMillis());
  }
  
  public LocalDateTime withEra(int paramInt)
  {
    return withLocalMillis(getChronology().era().set(getLocalMillis(), paramInt));
  }
  
  public LocalDateTime withCenturyOfEra(int paramInt)
  {
    return withLocalMillis(getChronology().centuryOfEra().set(getLocalMillis(), paramInt));
  }
  
  public LocalDateTime withYearOfEra(int paramInt)
  {
    return withLocalMillis(getChronology().yearOfEra().set(getLocalMillis(), paramInt));
  }
  
  public LocalDateTime withYearOfCentury(int paramInt)
  {
    return withLocalMillis(getChronology().yearOfCentury().set(getLocalMillis(), paramInt));
  }
  
  public LocalDateTime withYear(int paramInt)
  {
    return withLocalMillis(getChronology().year().set(getLocalMillis(), paramInt));
  }
  
  public LocalDateTime withWeekyear(int paramInt)
  {
    return withLocalMillis(getChronology().weekyear().set(getLocalMillis(), paramInt));
  }
  
  public LocalDateTime withMonthOfYear(int paramInt)
  {
    return withLocalMillis(getChronology().monthOfYear().set(getLocalMillis(), paramInt));
  }
  
  public LocalDateTime withWeekOfWeekyear(int paramInt)
  {
    return withLocalMillis(getChronology().weekOfWeekyear().set(getLocalMillis(), paramInt));
  }
  
  public LocalDateTime withDayOfYear(int paramInt)
  {
    return withLocalMillis(getChronology().dayOfYear().set(getLocalMillis(), paramInt));
  }
  
  public LocalDateTime withDayOfMonth(int paramInt)
  {
    return withLocalMillis(getChronology().dayOfMonth().set(getLocalMillis(), paramInt));
  }
  
  public LocalDateTime withDayOfWeek(int paramInt)
  {
    return withLocalMillis(getChronology().dayOfWeek().set(getLocalMillis(), paramInt));
  }
  
  public LocalDateTime withHourOfDay(int paramInt)
  {
    return withLocalMillis(getChronology().hourOfDay().set(getLocalMillis(), paramInt));
  }
  
  public LocalDateTime withMinuteOfHour(int paramInt)
  {
    return withLocalMillis(getChronology().minuteOfHour().set(getLocalMillis(), paramInt));
  }
  
  public LocalDateTime withSecondOfMinute(int paramInt)
  {
    return withLocalMillis(getChronology().secondOfMinute().set(getLocalMillis(), paramInt));
  }
  
  public LocalDateTime withMillisOfSecond(int paramInt)
  {
    return withLocalMillis(getChronology().millisOfSecond().set(getLocalMillis(), paramInt));
  }
  
  public LocalDateTime withMillisOfDay(int paramInt)
  {
    return withLocalMillis(getChronology().millisOfDay().set(getLocalMillis(), paramInt));
  }
  
  public Property era()
  {
    return new Property(this, getChronology().era());
  }
  
  public Property centuryOfEra()
  {
    return new Property(this, getChronology().centuryOfEra());
  }
  
  public Property yearOfCentury()
  {
    return new Property(this, getChronology().yearOfCentury());
  }
  
  public Property yearOfEra()
  {
    return new Property(this, getChronology().yearOfEra());
  }
  
  public Property year()
  {
    return new Property(this, getChronology().year());
  }
  
  public Property weekyear()
  {
    return new Property(this, getChronology().weekyear());
  }
  
  public Property monthOfYear()
  {
    return new Property(this, getChronology().monthOfYear());
  }
  
  public Property weekOfWeekyear()
  {
    return new Property(this, getChronology().weekOfWeekyear());
  }
  
  public Property dayOfYear()
  {
    return new Property(this, getChronology().dayOfYear());
  }
  
  public Property dayOfMonth()
  {
    return new Property(this, getChronology().dayOfMonth());
  }
  
  public Property dayOfWeek()
  {
    return new Property(this, getChronology().dayOfWeek());
  }
  
  public Property hourOfDay()
  {
    return new Property(this, getChronology().hourOfDay());
  }
  
  public Property minuteOfHour()
  {
    return new Property(this, getChronology().minuteOfHour());
  }
  
  public Property secondOfMinute()
  {
    return new Property(this, getChronology().secondOfMinute());
  }
  
  public Property millisOfSecond()
  {
    return new Property(this, getChronology().millisOfSecond());
  }
  
  public Property millisOfDay()
  {
    return new Property(this, getChronology().millisOfDay());
  }
  
  @ToString
  public String toString()
  {
    return ISODateTimeFormat.dateTime().print(this);
  }
  
  public String toString(String paramString)
  {
    if (paramString == null) {
      return toString();
    }
    return DateTimeFormat.forPattern(paramString).print(this);
  }
  
  public String toString(String paramString, Locale paramLocale)
    throws IllegalArgumentException
  {
    if (paramString == null) {
      return toString();
    }
    return DateTimeFormat.forPattern(paramString).withLocale(paramLocale).print(this);
  }
  
  public static final class Property
    extends AbstractReadableInstantFieldProperty
  {
    private static final long serialVersionUID = -358138762846288L;
    private transient LocalDateTime iInstant;
    private transient DateTimeField iField;
    
    Property(LocalDateTime paramLocalDateTime, DateTimeField paramDateTimeField)
    {
      iInstant = paramLocalDateTime;
      iField = paramDateTimeField;
    }
    
    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.writeObject(iInstant);
      paramObjectOutputStream.writeObject(iField.getType());
    }
    
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      iInstant = ((LocalDateTime)paramObjectInputStream.readObject());
      DateTimeFieldType localDateTimeFieldType = (DateTimeFieldType)paramObjectInputStream.readObject();
      iField = localDateTimeFieldType.getField(iInstant.getChronology());
    }
    
    public DateTimeField getField()
    {
      return iField;
    }
    
    protected long getMillis()
    {
      return iInstant.getLocalMillis();
    }
    
    protected Chronology getChronology()
    {
      return iInstant.getChronology();
    }
    
    public LocalDateTime getLocalDateTime()
    {
      return iInstant;
    }
    
    public LocalDateTime addToCopy(int paramInt)
    {
      return iInstant.withLocalMillis(iField.add(iInstant.getLocalMillis(), paramInt));
    }
    
    public LocalDateTime addToCopy(long paramLong)
    {
      return iInstant.withLocalMillis(iField.add(iInstant.getLocalMillis(), paramLong));
    }
    
    public LocalDateTime addWrapFieldToCopy(int paramInt)
    {
      return iInstant.withLocalMillis(iField.addWrapField(iInstant.getLocalMillis(), paramInt));
    }
    
    public LocalDateTime setCopy(int paramInt)
    {
      return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), paramInt));
    }
    
    public LocalDateTime setCopy(String paramString, Locale paramLocale)
    {
      return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), paramString, paramLocale));
    }
    
    public LocalDateTime setCopy(String paramString)
    {
      return setCopy(paramString, null);
    }
    
    public LocalDateTime withMaximumValue()
    {
      return setCopy(getMaximumValue());
    }
    
    public LocalDateTime withMinimumValue()
    {
      return setCopy(getMinimumValue());
    }
    
    public LocalDateTime roundFloorCopy()
    {
      return iInstant.withLocalMillis(iField.roundFloor(iInstant.getLocalMillis()));
    }
    
    public LocalDateTime roundCeilingCopy()
    {
      return iInstant.withLocalMillis(iField.roundCeiling(iInstant.getLocalMillis()));
    }
    
    public LocalDateTime roundHalfFloorCopy()
    {
      return iInstant.withLocalMillis(iField.roundHalfFloor(iInstant.getLocalMillis()));
    }
    
    public LocalDateTime roundHalfCeilingCopy()
    {
      return iInstant.withLocalMillis(iField.roundHalfCeiling(iInstant.getLocalMillis()));
    }
    
    public LocalDateTime roundHalfEvenCopy()
    {
      return iInstant.withLocalMillis(iField.roundHalfEven(iInstant.getLocalMillis()));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.LocalDateTime
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */