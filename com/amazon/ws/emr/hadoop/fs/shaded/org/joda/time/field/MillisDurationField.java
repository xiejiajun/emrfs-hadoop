package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import java.io.Serializable;

public final class MillisDurationField
  extends DurationField
  implements Serializable
{
  private static final long serialVersionUID = 2656707858124633367L;
  public static final DurationField INSTANCE = new MillisDurationField();
  
  public DurationFieldType getType()
  {
    return DurationFieldType.millis();
  }
  
  public String getName()
  {
    return "millis";
  }
  
  public boolean isSupported()
  {
    return true;
  }
  
  public final boolean isPrecise()
  {
    return true;
  }
  
  public final long getUnitMillis()
  {
    return 1L;
  }
  
  public int getValue(long paramLong)
  {
    return FieldUtils.safeToInt(paramLong);
  }
  
  public long getValueAsLong(long paramLong)
  {
    return paramLong;
  }
  
  public int getValue(long paramLong1, long paramLong2)
  {
    return FieldUtils.safeToInt(paramLong1);
  }
  
  public long getValueAsLong(long paramLong1, long paramLong2)
  {
    return paramLong1;
  }
  
  public long getMillis(int paramInt)
  {
    return paramInt;
  }
  
  public long getMillis(long paramLong)
  {
    return paramLong;
  }
  
  public long getMillis(int paramInt, long paramLong)
  {
    return paramInt;
  }
  
  public long getMillis(long paramLong1, long paramLong2)
  {
    return paramLong1;
  }
  
  public long add(long paramLong, int paramInt)
  {
    return FieldUtils.safeAdd(paramLong, paramInt);
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    return FieldUtils.safeAdd(paramLong1, paramLong2);
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    return FieldUtils.safeToInt(FieldUtils.safeSubtract(paramLong1, paramLong2));
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    return FieldUtils.safeSubtract(paramLong1, paramLong2);
  }
  
  public int compareTo(DurationField paramDurationField)
  {
    long l1 = paramDurationField.getUnitMillis();
    long l2 = getUnitMillis();
    if (l2 == l1) {
      return 0;
    }
    if (l2 < l1) {
      return -1;
    }
    return 1;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof MillisDurationField)) {
      return getUnitMillis() == ((MillisDurationField)paramObject).getUnitMillis();
    }
    return false;
  }
  
  public int hashCode()
  {
    return (int)getUnitMillis();
  }
  
  public String toString()
  {
    return "DurationField[millis]";
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.MillisDurationField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */