package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import java.util.SimpleTimeZone;
import java.util.TimeZone;

final class UTCDateTimeZone
  extends DateTimeZone
{
  static final DateTimeZone INSTANCE = new UTCDateTimeZone();
  private static final long serialVersionUID = -3513011772763289092L;
  
  public UTCDateTimeZone()
  {
    super("UTC");
  }
  
  public String getNameKey(long paramLong)
  {
    return "UTC";
  }
  
  public int getOffset(long paramLong)
  {
    return 0;
  }
  
  public int getStandardOffset(long paramLong)
  {
    return 0;
  }
  
  public int getOffsetFromLocal(long paramLong)
  {
    return 0;
  }
  
  public boolean isFixed()
  {
    return true;
  }
  
  public long nextTransition(long paramLong)
  {
    return paramLong;
  }
  
  public long previousTransition(long paramLong)
  {
    return paramLong;
  }
  
  public TimeZone toTimeZone()
  {
    return new SimpleTimeZone(0, getID());
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof UTCDateTimeZone;
  }
  
  public int hashCode()
  {
    return getID().hashCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.UTCDateTimeZone
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */