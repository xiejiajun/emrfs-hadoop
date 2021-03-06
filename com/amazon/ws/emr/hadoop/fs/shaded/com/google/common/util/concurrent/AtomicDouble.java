package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class AtomicDouble
  extends Number
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private volatile transient long value;
  private static final AtomicLongFieldUpdater<AtomicDouble> updater = AtomicLongFieldUpdater.newUpdater(AtomicDouble.class, "value");
  
  public AtomicDouble(double initialValue)
  {
    value = Double.doubleToRawLongBits(initialValue);
  }
  
  public AtomicDouble() {}
  
  public final double get()
  {
    return Double.longBitsToDouble(value);
  }
  
  public final void set(double newValue)
  {
    long next = Double.doubleToRawLongBits(newValue);
    value = next;
  }
  
  public final void lazySet(double newValue)
  {
    set(newValue);
  }
  
  public final double getAndSet(double newValue)
  {
    long next = Double.doubleToRawLongBits(newValue);
    return Double.longBitsToDouble(updater.getAndSet(this, next));
  }
  
  public final boolean compareAndSet(double expect, double update)
  {
    return updater.compareAndSet(this, Double.doubleToRawLongBits(expect), Double.doubleToRawLongBits(update));
  }
  
  public final boolean weakCompareAndSet(double expect, double update)
  {
    return updater.weakCompareAndSet(this, Double.doubleToRawLongBits(expect), Double.doubleToRawLongBits(update));
  }
  
  public final double getAndAdd(double delta)
  {
    for (;;)
    {
      long current = value;
      double currentVal = Double.longBitsToDouble(current);
      double nextVal = currentVal + delta;
      long next = Double.doubleToRawLongBits(nextVal);
      if (updater.compareAndSet(this, current, next)) {
        return currentVal;
      }
    }
  }
  
  public final double addAndGet(double delta)
  {
    for (;;)
    {
      long current = value;
      double currentVal = Double.longBitsToDouble(current);
      double nextVal = currentVal + delta;
      long next = Double.doubleToRawLongBits(nextVal);
      if (updater.compareAndSet(this, current, next)) {
        return nextVal;
      }
    }
  }
  
  public String toString()
  {
    return Double.toString(get());
  }
  
  public int intValue()
  {
    return (int)get();
  }
  
  public long longValue()
  {
    return get();
  }
  
  public float floatValue()
  {
    return (float)get();
  }
  
  public double doubleValue()
  {
    return get();
  }
  
  private void writeObject(ObjectOutputStream s)
    throws IOException
  {
    s.defaultWriteObject();
    
    s.writeDouble(get());
  }
  
  private void readObject(ObjectInputStream s)
    throws IOException, ClassNotFoundException
  {
    s.defaultReadObject();
    
    set(s.readDouble());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AtomicDouble
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */