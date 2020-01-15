package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math.LongMath;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Ints;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;

 enum BloomFilterStrategies
  implements BloomFilter.Strategy
{
  MURMUR128_MITZ_32,  MURMUR128_MITZ_64;
  
  private BloomFilterStrategies() {}
  
  static final class BitArray
  {
    final long[] data;
    long bitCount;
    
    BitArray(long bits)
    {
      this(new long[Ints.checkedCast(LongMath.divide(bits, 64L, RoundingMode.CEILING))]);
    }
    
    BitArray(long[] data)
    {
      Preconditions.checkArgument(data.length > 0, "data length is zero!");
      this.data = data;
      long bitCount = 0L;
      for (long value : data) {
        bitCount += Long.bitCount(value);
      }
      this.bitCount = bitCount;
    }
    
    boolean set(long index)
    {
      if (!get(index))
      {
        data[((int)(index >>> 6))] |= 1L << (int)index;
        bitCount += 1L;
        return true;
      }
      return false;
    }
    
    boolean get(long index)
    {
      return (data[((int)(index >>> 6))] & 1L << (int)index) != 0L;
    }
    
    long bitSize()
    {
      return data.length * 64L;
    }
    
    long bitCount()
    {
      return bitCount;
    }
    
    BitArray copy()
    {
      return new BitArray((long[])data.clone());
    }
    
    void putAll(BitArray array)
    {
      Preconditions.checkArgument(data.length == data.length, "BitArrays must be of equal length (%s != %s)", new Object[] { Integer.valueOf(data.length), Integer.valueOf(data.length) });
      
      bitCount = 0L;
      for (int i = 0; i < data.length; i++)
      {
        data[i] |= data[i];
        bitCount += Long.bitCount(data[i]);
      }
    }
    
    public boolean equals(Object o)
    {
      if ((o instanceof BitArray))
      {
        BitArray bitArray = (BitArray)o;
        return Arrays.equals(data, data);
      }
      return false;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(data);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.BloomFilterStrategies
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */