package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DecoratedDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;

class ISOYearOfEraDateTimeField
  extends DecoratedDateTimeField
{
  private static final long serialVersionUID = 7037524068969447317L;
  static final DateTimeField INSTANCE = new ISOYearOfEraDateTimeField();
  
  private ISOYearOfEraDateTimeField()
  {
    super(GregorianChronology.getInstanceUTC().year(), DateTimeFieldType.yearOfEra());
  }
  
  public DurationField getRangeDurationField()
  {
    return GregorianChronology.getInstanceUTC().eras();
  }
  
  public int get(long paramLong)
  {
    int i = getWrappedField().get(paramLong);
    return i < 0 ? -i : i;
  }
  
  public long add(long paramLong, int paramInt)
  {
    return getWrappedField().add(paramLong, paramInt);
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    return getWrappedField().add(paramLong1, paramLong2);
  }
  
  public long addWrapField(long paramLong, int paramInt)
  {
    return getWrappedField().addWrapField(paramLong, paramInt);
  }
  
  public int[] addWrapField(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    return getWrappedField().addWrapField(paramReadablePartial, paramInt1, paramArrayOfInt, paramInt2);
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    return getWrappedField().getDifference(paramLong1, paramLong2);
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    return getWrappedField().getDifferenceAsLong(paramLong1, paramLong2);
  }
  
  public long set(long paramLong, int paramInt)
  {
    FieldUtils.verifyValueBounds(this, paramInt, 0, getMaximumValue());
    if (getWrappedField().get(paramLong) < 0) {
      paramInt = -paramInt;
    }
    return super.set(paramLong, paramInt);
  }
  
  public int getMinimumValue()
  {
    return 0;
  }
  
  public int getMaximumValue()
  {
    return getWrappedField().getMaximumValue();
  }
  
  public long roundFloor(long paramLong)
  {
    return getWrappedField().roundFloor(paramLong);
  }
  
  public long roundCeiling(long paramLong)
  {
    return getWrappedField().roundCeiling(paramLong);
  }
  
  public long remainder(long paramLong)
  {
    return getWrappedField().remainder(paramLong);
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOYearOfEraDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */