package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

public enum WireFormat$JavaType
{
  INT(Integer.valueOf(0)),  LONG(Long.valueOf(0L)),  FLOAT(Float.valueOf(0.0F)),  DOUBLE(Double.valueOf(0.0D)),  BOOLEAN(Boolean.valueOf(false)),  STRING(""),  BYTE_STRING(ByteString.EMPTY),  ENUM(null),  MESSAGE(null);
  
  private final Object defaultDefault;
  
  private WireFormat$JavaType(Object defaultDefault)
  {
    this.defaultDefault = defaultDefault;
  }
  
  Object getDefaultDefault()
  {
    return defaultDefault;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.WireFormat.JavaType
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */