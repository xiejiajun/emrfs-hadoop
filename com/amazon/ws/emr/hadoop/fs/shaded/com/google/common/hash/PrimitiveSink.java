package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import java.nio.charset.Charset;

@Beta
public abstract interface PrimitiveSink
{
  public abstract PrimitiveSink putByte(byte paramByte);
  
  public abstract PrimitiveSink putBytes(byte[] paramArrayOfByte);
  
  public abstract PrimitiveSink putBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract PrimitiveSink putShort(short paramShort);
  
  public abstract PrimitiveSink putInt(int paramInt);
  
  public abstract PrimitiveSink putLong(long paramLong);
  
  public abstract PrimitiveSink putFloat(float paramFloat);
  
  public abstract PrimitiveSink putDouble(double paramDouble);
  
  public abstract PrimitiveSink putBoolean(boolean paramBoolean);
  
  public abstract PrimitiveSink putChar(char paramChar);
  
  public abstract PrimitiveSink putUnencodedChars(CharSequence paramCharSequence);
  
  public abstract PrimitiveSink putString(CharSequence paramCharSequence, Charset paramCharset);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.PrimitiveSink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */