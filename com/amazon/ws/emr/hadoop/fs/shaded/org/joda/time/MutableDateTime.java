package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseDateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractReadableInstantFieldProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Locale;
import org.joda.convert.FromString;

public class MutableDateTime
  extends BaseDateTime
  implements ReadWritableDateTime, Cloneable, Serializable
{
  private static final long serialVersionUID = 2852608688135209575L;
  public static final int ROUND_NONE = 0;
  public static final int ROUND_FLOOR = 1;
  public static final int ROUND_CEILING = 2;
  public static final int ROUND_HALF_FLOOR = 3;
  public static final int ROUND_HALF_CEILING = 4;
  public static final int ROUND_HALF_EVEN = 5;
  private DateTimeField iRoundingField;
  private int iRoundingMode;
  
  public static MutableDateTime now()
  {
    return new MutableDateTime();
  }
  
  public static MutableDateTime now(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      throw new NullPointerException("Zone must not be null");
    }
    return new MutableDateTime(paramDateTimeZone);
  }
  
  public static MutableDateTime now(Chronology paramChronology)
  {
    if (paramChronology == null) {
      throw new NullPointerException("Chronology must not be null");
    }
    return new MutableDateTime(paramChronology);
  }
  
  @FromString
  public static MutableDateTime parse(String paramString)
  {
    return parse(paramString, ISODateTimeFormat.dateTimeParser().withOffsetParsed());
  }
  
  public static MutableDateTime parse(String paramString, DateTimeFormatter paramDateTimeFormatter)
  {
    return paramDateTimeFormatter.parseDateTime(paramString).toMutableDateTime();
  }
  
  public MutableDateTime() {}
  
  public MutableDateTime(DateTimeZone paramDateTimeZone)
  {
    super(paramDateTimeZone);
  }
  
  public MutableDateTime(Chronology paramChronology)
  {
    super(paramChronology);
  }
  
  public MutableDateTime(long paramLong)
  {
    super(paramLong);
  }
  
  public MutableDateTime(long paramLong, DateTimeZone paramDateTimeZone)
  {
    super(paramLong, paramDateTimeZone);
  }
  
  public MutableDateTime(long paramLong, Chronology paramChronology)
  {
    super(paramLong, paramChronology);
  }
  
  public MutableDateTime(Object paramObject)
  {
    super(paramObject, (Chronology)null);
  }
  
  public MutableDateTime(Object paramObject, DateTimeZone paramDateTimeZone)
  {
    super(paramObject, paramDateTimeZone);
  }
  
  public MutableDateTime(Object paramObject, Chronology paramChronology)
  {
    super(paramObject, DateTimeUtils.getChronology(paramChronology));
  }
  
  public MutableDateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public MutableDateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, DateTimeZone paramDateTimeZone)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramDateTimeZone);
  }
  
  public MutableDateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Chronology paramChronology)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramChronology);
  }
  
  public DateTimeField getRoundingField()
  {
    return iRoundingField;
  }
  
  public int getRoundingMode()
  {
    return iRoundingMode;
  }
  
  public void setRounding(DateTimeField paramDateTimeField)
  {
    setRounding(paramDateTimeField, 1);
  }
  
  public void setRounding(DateTimeField paramDateTimeField, int paramInt)
  {
    if ((paramDateTimeField != null) && ((paramInt < 0) || (paramInt > 5))) {
      throw new IllegalArgumentException("Illegal rounding mode: " + paramInt);
    }
    iRoundingField = (paramInt == 0 ? null : paramDateTimeField);
    iRoundingMode = (paramDateTimeField == null ? 0 : paramInt);
    setMillis(getMillis());
  }
  
  public void setMillis(long paramLong)
  {
    switch (iRoundingMode)
    {
    case 0: 
      break;
    case 1: 
      paramLong = iRoundingField.roundFloor(paramLong);
      break;
    case 2: 
      paramLong = iRoundingField.roundCeiling(paramLong);
      break;
    case 3: 
      paramLong = iRoundingField.roundHalfFloor(paramLong);
      break;
    case 4: 
      paramLong = iRoundingField.roundHalfCeiling(paramLong);
      break;
    case 5: 
      paramLong = iRoundingField.roundHalfEven(paramLong);
    }
    super.setMillis(paramLong);
  }
  
  public void setMillis(ReadableInstant paramReadableInstant)
  {
    long l = DateTimeUtils.getInstantMillis(paramReadableInstant);
    setMillis(l);
  }
  
  public void add(long paramLong)
  {
    setMillis(FieldUtils.safeAdd(getMillis(), paramLong));
  }
  
  public void add(ReadableDuration paramReadableDuration)
  {
    add(paramReadableDuration, 1);
  }
  
  public void add(ReadableDuration paramReadableDuration, int paramInt)
  {
    if (paramReadableDuration != null) {
      add(FieldUtils.safeMultiply(paramReadableDuration.getMillis(), paramInt));
    }
  }
  
  public void add(ReadablePeriod paramReadablePeriod)
  {
    add(paramReadablePeriod, 1);
  }
  
  public void add(ReadablePeriod paramReadablePeriod, int paramInt)
  {
    if (paramReadablePeriod != null) {
      setMillis(getChronology().add(paramReadablePeriod, getMillis(), paramInt));
    }
  }
  
  public void setChronology(Chronology paramChronology)
  {
    super.setChronology(paramChronology);
  }
  
  public void setZone(DateTimeZone paramDateTimeZone)
  {
    paramDateTimeZone = DateTimeUtils.getZone(paramDateTimeZone);
    Chronology localChronology = getChronology();
    if (localChronology.getZone() != paramDateTimeZone) {
      setChronology(localChronology.withZone(paramDateTimeZone));
    }
  }
  
  public void setZoneRetainFields(DateTimeZone paramDateTimeZone)
  {
    paramDateTimeZone = DateTimeUtils.getZone(paramDateTimeZone);
    DateTimeZone localDateTimeZone = DateTimeUtils.getZone(getZone());
    if (paramDateTimeZone == localDateTimeZone) {
      return;
    }
    long l = localDateTimeZone.getMillisKeepLocal(paramDateTimeZone, getMillis());
    setChronology(getChronology().withZone(paramDateTimeZone));
    setMillis(l);
  }
  
  public void set(DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("Field must not be null");
    }
    setMillis(paramDateTimeFieldType.getField(getChronology()).set(getMillis(), paramInt));
  }
  
  public void add(DurationFieldType paramDurationFieldType, int paramInt)
  {
    if (paramDurationFieldType == null) {
      throw new IllegalArgumentException("Field must not be null");
    }
    if (paramInt != 0) {
      setMillis(paramDurationFieldType.getField(getChronology()).add(getMillis(), paramInt));
    }
  }
  
  public void setYear(int paramInt)
  {
    setMillis(getChronology().year().set(getMillis(), paramInt));
  }
  
  public void addYears(int paramInt)
  {
    if (paramInt != 0) {
      setMillis(getChronology().years().add(getMillis(), paramInt));
    }
  }
  
  public void setWeekyear(int paramInt)
  {
    setMillis(getChronology().weekyear().set(getMillis(), paramInt));
  }
  
  public void addWeekyears(int paramInt)
  {
    if (paramInt != 0) {
      setMillis(getChronology().weekyears().add(getMillis(), paramInt));
    }
  }
  
  public void setMonthOfYear(int paramInt)
  {
    setMillis(getChronology().monthOfYear().set(getMillis(), paramInt));
  }
  
  public void addMonths(int paramInt)
  {
    if (paramInt != 0) {
      setMillis(getChronology().months().add(getMillis(), paramInt));
    }
  }
  
  public void setWeekOfWeekyear(int paramInt)
  {
    setMillis(getChronology().weekOfWeekyear().set(getMillis(), paramInt));
  }
  
  public void addWeeks(int paramInt)
  {
    if (paramInt != 0) {
      setMillis(getChronology().weeks().add(getMillis(), paramInt));
    }
  }
  
  public void setDayOfYear(int paramInt)
  {
    setMillis(getChronology().dayOfYear().set(getMillis(), paramInt));
  }
  
  public void setDayOfMonth(int paramInt)
  {
    setMillis(getChronology().dayOfMonth().set(getMillis(), paramInt));
  }
  
  public void setDayOfWeek(int paramInt)
  {
    setMillis(getChronology().dayOfWeek().set(getMillis(), paramInt));
  }
  
  public void addDays(int paramInt)
  {
    if (paramInt != 0) {
      setMillis(getChronology().days().add(getMillis(), paramInt));
    }
  }
  
  public void setHourOfDay(int paramInt)
  {
    setMillis(getChronology().hourOfDay().set(getMillis(), paramInt));
  }
  
  public void addHours(int paramInt)
  {
    if (paramInt != 0) {
      setMillis(getChronology().hours().add(getMillis(), paramInt));
    }
  }
  
  public void setMinuteOfDay(int paramInt)
  {
    setMillis(getChronology().minuteOfDay().set(getMillis(), paramInt));
  }
  
  public void setMinuteOfHour(int paramInt)
  {
    setMillis(getChronology().minuteOfHour().set(getMillis(), paramInt));
  }
  
  public void addMinutes(int paramInt)
  {
    if (paramInt != 0) {
      setMillis(getChronology().minutes().add(getMillis(), paramInt));
    }
  }
  
  public void setSecondOfDay(int paramInt)
  {
    setMillis(getChronology().secondOfDay().set(getMillis(), paramInt));
  }
  
  public void setSecondOfMinute(int paramInt)
  {
    setMillis(getChronology().secondOfMinute().set(getMillis(), paramInt));
  }
  
  public void addSeconds(int paramInt)
  {
    if (paramInt != 0) {
      setMillis(getChronology().seconds().add(getMillis(), paramInt));
    }
  }
  
  public void setMillisOfDay(int paramInt)
  {
    setMillis(getChronology().millisOfDay().set(getMillis(), paramInt));
  }
  
  public void setMillisOfSecond(int paramInt)
  {
    setMillis(getChronology().millisOfSecond().set(getMillis(), paramInt));
  }
  
  public void addMillis(int paramInt)
  {
    if (paramInt != 0) {
      setMillis(getChronology().millis().add(getMillis(), paramInt));
    }
  }
  
  public void setDate(long paramLong)
  {
    setMillis(getChronology().millisOfDay().set(paramLong, getMillisOfDay()));
  }
  
  public void setDate(ReadableInstant paramReadableInstant)
  {
    long l = DateTimeUtils.getInstantMillis(paramReadableInstant);
    if ((paramReadableInstant instanceof ReadableDateTime))
    {
      ReadableDateTime localReadableDateTime = (ReadableDateTime)paramReadableInstant;
      Chronology localChronology = DateTimeUtils.getChronology(localReadableDateTime.getChronology());
      DateTimeZone localDateTimeZone = localChronology.getZone();
      if (localDateTimeZone != null) {
        l = localDateTimeZone.getMillisKeepLocal(getZone(), l);
      }
    }
    setDate(l);
  }
  
  public void setDate(int paramInt1, int paramInt2, int paramInt3)
  {
    Chronology localChronology = getChronology();
    long l = localChronology.getDateTimeMillis(paramInt1, paramInt2, paramInt3, 0);
    setDate(l);
  }
  
  public void setTime(long paramLong)
  {
    int i = ISOChronology.getInstanceUTC().millisOfDay().get(paramLong);
    setMillis(getChronology().millisOfDay().set(getMillis(), i));
  }
  
  public void setTime(ReadableInstant paramReadableInstant)
  {
    long l = DateTimeUtils.getInstantMillis(paramReadableInstant);
    Chronology localChronology = DateTimeUtils.getInstantChronology(paramReadableInstant);
    DateTimeZone localDateTimeZone = localChronology.getZone();
    if (localDateTimeZone != null) {
      l = localDateTimeZone.getMillisKeepLocal(DateTimeZone.UTC, l);
    }
    setTime(l);
  }
  
  public void setTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l = getChronology().getDateTimeMillis(getMillis(), paramInt1, paramInt2, paramInt3, paramInt4);
    
    setMillis(l);
  }
  
  public void setDateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    long l = getChronology().getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    
    setMillis(l);
  }
  
  public Property property(DateTimeFieldType paramDateTimeFieldType)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }
    DateTimeField localDateTimeField = paramDateTimeFieldType.getField(getChronology());
    if (!localDateTimeField.isSupported()) {
      throw new IllegalArgumentException("Field '" + paramDateTimeFieldType + "' is not supported");
    }
    return new Property(this, localDateTimeField);
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
  
  public Property minuteOfDay()
  {
    return new Property(this, getChronology().minuteOfDay());
  }
  
  public Property minuteOfHour()
  {
    return new Property(this, getChronology().minuteOfHour());
  }
  
  public Property secondOfDay()
  {
    return new Property(this, getChronology().secondOfDay());
  }
  
  public Property secondOfMinute()
  {
    return new Property(this, getChronology().secondOfMinute());
  }
  
  public Property millisOfDay()
  {
    return new Property(this, getChronology().millisOfDay());
  }
  
  public Property millisOfSecond()
  {
    return new Property(this, getChronology().millisOfSecond());
  }
  
  public MutableDateTime copy()
  {
    return (MutableDateTime)clone();
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
  
  public static final class Property
    extends AbstractReadableInstantFieldProperty
  {
    private static final long serialVersionUID = -4481126543819298617L;
    private MutableDateTime iInstant;
    private DateTimeField iField;
    
    Property(MutableDateTime paramMutableDateTime, DateTimeField paramDateTimeField)
    {
      iInstant = paramMutableDateTime;
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
      iInstant = ((MutableDateTime)paramObjectInputStream.readObject());
      DateTimeFieldType localDateTimeFieldType = (DateTimeFieldType)paramObjectInputStream.readObject();
      iField = localDateTimeFieldType.getField(iInstant.getChronology());
    }
    
    public DateTimeField getField()
    {
      return iField;
    }
    
    protected long getMillis()
    {
      return iInstant.getMillis();
    }
    
    protected Chronology getChronology()
    {
      return iInstant.getChronology();
    }
    
    public MutableDateTime getMutableDateTime()
    {
      return iInstant;
    }
    
    public MutableDateTime add(int paramInt)
    {
      iInstant.setMillis(getField().add(iInstant.getMillis(), paramInt));
      return iInstant;
    }
    
    public MutableDateTime add(long paramLong)
    {
      iInstant.setMillis(getField().add(iInstant.getMillis(), paramLong));
      return iInstant;
    }
    
    public MutableDateTime addWrapField(int paramInt)
    {
      iInstant.setMillis(getField().addWrapField(iInstant.getMillis(), paramInt));
      return iInstant;
    }
    
    public MutableDateTime set(int paramInt)
    {
      iInstant.setMillis(getField().set(iInstant.getMillis(), paramInt));
      return iInstant;
    }
    
    public MutableDateTime set(String paramString, Locale paramLocale)
    {
      iInstant.setMillis(getField().set(iInstant.getMillis(), paramString, paramLocale));
      return iInstant;
    }
    
    public MutableDateTime set(String paramString)
    {
      set(paramString, null);
      return iInstant;
    }
    
    public MutableDateTime roundFloor()
    {
      iInstant.setMillis(getField().roundFloor(iInstant.getMillis()));
      return iInstant;
    }
    
    public MutableDateTime roundCeiling()
    {
      iInstant.setMillis(getField().roundCeiling(iInstant.getMillis()));
      return iInstant;
    }
    
    public MutableDateTime roundHalfFloor()
    {
      iInstant.setMillis(getField().roundHalfFloor(iInstant.getMillis()));
      return iInstant;
    }
    
    public MutableDateTime roundHalfCeiling()
    {
      iInstant.setMillis(getField().roundHalfCeiling(iInstant.getMillis()));
      return iInstant;
    }
    
    public MutableDateTime roundHalfEven()
    {
      iInstant.setMillis(getField().roundHalfEven(iInstant.getMillis()));
      return iInstant;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutableDateTime
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */