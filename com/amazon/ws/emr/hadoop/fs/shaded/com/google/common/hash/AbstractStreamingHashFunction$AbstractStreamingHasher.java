package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class AbstractStreamingHashFunction$AbstractStreamingHasher
  extends AbstractHasher
{
  private final ByteBuffer buffer;
  private final int bufferSize;
  private final int chunkSize;
  
  protected AbstractStreamingHashFunction$AbstractStreamingHasher(int chunkSize)
  {
    this(chunkSize, chunkSize);
  }
  
  protected AbstractStreamingHashFunction$AbstractStreamingHasher(int chunkSize, int bufferSize)
  {
    Preconditions.checkArgument(bufferSize % chunkSize == 0);
    
    buffer = ByteBuffer.allocate(bufferSize + 7).order(ByteOrder.LITTLE_ENDIAN);
    
    this.bufferSize = bufferSize;
    this.chunkSize = chunkSize;
  }
  
  protected abstract void process(ByteBuffer paramByteBuffer);
  
  protected void processRemaining(ByteBuffer bb)
  {
    bb.position(bb.limit());
    bb.limit(chunkSize + 7);
    while (bb.position() < chunkSize) {
      bb.putLong(0L);
    }
    bb.limit(chunkSize);
    bb.flip();
    process(bb);
  }
  
  public final Hasher putBytes(byte[] bytes)
  {
    return putBytes(bytes, 0, bytes.length);
  }
  
  public final Hasher putBytes(byte[] bytes, int off, int len)
  {
    return putBytes(ByteBuffer.wrap(bytes, off, len).order(ByteOrder.LITTLE_ENDIAN));
  }
  
  private Hasher putBytes(ByteBuffer readBuffer)
  {
    if (readBuffer.remaining() <= buffer.remaining())
    {
      buffer.put(readBuffer);
      munchIfFull();
      return this;
    }
    int bytesToCopy = bufferSize - buffer.position();
    for (int i = 0; i < bytesToCopy; i++) {
      buffer.put(readBuffer.get());
    }
    munch();
    while (readBuffer.remaining() >= chunkSize) {
      process(readBuffer);
    }
    buffer.put(readBuffer);
    return this;
  }
  
  public final Hasher putUnencodedChars(CharSequence charSequence)
  {
    for (int i = 0; i < charSequence.length(); i++) {
      putChar(charSequence.charAt(i));
    }
    return this;
  }
  
  public final Hasher putByte(byte b)
  {
    buffer.put(b);
    munchIfFull();
    return this;
  }
  
  public final Hasher putShort(short s)
  {
    buffer.putShort(s);
    munchIfFull();
    return this;
  }
  
  public final Hasher putChar(char c)
  {
    buffer.putChar(c);
    munchIfFull();
    return this;
  }
  
  public final Hasher putInt(int i)
  {
    buffer.putInt(i);
    munchIfFull();
    return this;
  }
  
  public final Hasher putLong(long l)
  {
    buffer.putLong(l);
    munchIfFull();
    return this;
  }
  
  public final <T> Hasher putObject(T instance, Funnel<? super T> funnel)
  {
    funnel.funnel(instance, this);
    return this;
  }
  
  public final HashCode hash()
  {
    munch();
    buffer.flip();
    if (buffer.remaining() > 0) {
      processRemaining(buffer);
    }
    return makeHash();
  }
  
  abstract HashCode makeHash();
  
  private void munchIfFull()
  {
    if (buffer.remaining() < 8) {
      munch();
    }
  }
  
  private void munch()
  {
    buffer.flip();
    while (buffer.remaining() >= chunkSize) {
      process(buffer);
    }
    buffer.compact();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */