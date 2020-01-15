package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.nio.charset.Charset;

abstract class AbstractCompositeHashFunction
  extends AbstractStreamingHashFunction
{
  final HashFunction[] functions;
  private static final long serialVersionUID = 0L;
  
  AbstractCompositeHashFunction(HashFunction... functions)
  {
    for (HashFunction function : functions) {
      Preconditions.checkNotNull(function);
    }
    this.functions = functions;
  }
  
  abstract HashCode makeHash(Hasher[] paramArrayOfHasher);
  
  public Hasher newHasher()
  {
    final Hasher[] hashers = new Hasher[functions.length];
    for (int i = 0; i < hashers.length; i++) {
      hashers[i] = functions[i].newHasher();
    }
    new Hasher()
    {
      public Hasher putByte(byte b)
      {
        for (Hasher hasher : hashers) {
          hasher.putByte(b);
        }
        return this;
      }
      
      public Hasher putBytes(byte[] bytes)
      {
        for (Hasher hasher : hashers) {
          hasher.putBytes(bytes);
        }
        return this;
      }
      
      public Hasher putBytes(byte[] bytes, int off, int len)
      {
        for (Hasher hasher : hashers) {
          hasher.putBytes(bytes, off, len);
        }
        return this;
      }
      
      public Hasher putShort(short s)
      {
        for (Hasher hasher : hashers) {
          hasher.putShort(s);
        }
        return this;
      }
      
      public Hasher putInt(int i)
      {
        for (Hasher hasher : hashers) {
          hasher.putInt(i);
        }
        return this;
      }
      
      public Hasher putLong(long l)
      {
        for (Hasher hasher : hashers) {
          hasher.putLong(l);
        }
        return this;
      }
      
      public Hasher putFloat(float f)
      {
        for (Hasher hasher : hashers) {
          hasher.putFloat(f);
        }
        return this;
      }
      
      public Hasher putDouble(double d)
      {
        for (Hasher hasher : hashers) {
          hasher.putDouble(d);
        }
        return this;
      }
      
      public Hasher putBoolean(boolean b)
      {
        for (Hasher hasher : hashers) {
          hasher.putBoolean(b);
        }
        return this;
      }
      
      public Hasher putChar(char c)
      {
        for (Hasher hasher : hashers) {
          hasher.putChar(c);
        }
        return this;
      }
      
      public Hasher putUnencodedChars(CharSequence chars)
      {
        for (Hasher hasher : hashers) {
          hasher.putUnencodedChars(chars);
        }
        return this;
      }
      
      public Hasher putString(CharSequence chars, Charset charset)
      {
        for (Hasher hasher : hashers) {
          hasher.putString(chars, charset);
        }
        return this;
      }
      
      public <T> Hasher putObject(T instance, Funnel<? super T> funnel)
      {
        for (Hasher hasher : hashers) {
          hasher.putObject(instance, funnel);
        }
        return this;
      }
      
      public HashCode hash()
      {
        return makeHash(hashers);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.AbstractCompositeHashFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */