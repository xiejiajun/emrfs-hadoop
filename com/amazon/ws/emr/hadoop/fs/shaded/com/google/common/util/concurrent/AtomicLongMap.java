package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible
public final class AtomicLongMap<K>
{
  private final ConcurrentHashMap<K, AtomicLong> map;
  private transient Map<K, Long> asMap;
  
  private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> map)
  {
    this.map = ((ConcurrentHashMap)Preconditions.checkNotNull(map));
  }
  
  public static <K> AtomicLongMap<K> create()
  {
    return new AtomicLongMap(new ConcurrentHashMap());
  }
  
  public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> m)
  {
    AtomicLongMap<K> result = create();
    result.putAll(m);
    return result;
  }
  
  public long get(K key)
  {
    AtomicLong atomic = (AtomicLong)map.get(key);
    return atomic == null ? 0L : atomic.get();
  }
  
  public long incrementAndGet(K key)
  {
    return addAndGet(key, 1L);
  }
  
  public long decrementAndGet(K key)
  {
    return addAndGet(key, -1L);
  }
  
  public long addAndGet(K key, long delta)
  {
    AtomicLong atomic = (AtomicLong)map.get(key);
    if (atomic == null)
    {
      atomic = (AtomicLong)map.putIfAbsent(key, new AtomicLong(delta));
      if (atomic == null) {
        return delta;
      }
    }
    for (;;)
    {
      long oldValue = atomic.get();
      if (oldValue == 0L)
      {
        if (!map.replace(key, atomic, new AtomicLong(delta))) {
          break;
        }
        return delta;
      }
      long newValue = oldValue + delta;
      if (atomic.compareAndSet(oldValue, newValue)) {
        return newValue;
      }
    }
  }
  
  public long getAndIncrement(K key)
  {
    return getAndAdd(key, 1L);
  }
  
  public long getAndDecrement(K key)
  {
    return getAndAdd(key, -1L);
  }
  
  public long getAndAdd(K key, long delta)
  {
    AtomicLong atomic = (AtomicLong)map.get(key);
    if (atomic == null)
    {
      atomic = (AtomicLong)map.putIfAbsent(key, new AtomicLong(delta));
      if (atomic == null) {
        return 0L;
      }
    }
    for (;;)
    {
      long oldValue = atomic.get();
      if (oldValue == 0L)
      {
        if (!map.replace(key, atomic, new AtomicLong(delta))) {
          break;
        }
        return 0L;
      }
      long newValue = oldValue + delta;
      if (atomic.compareAndSet(oldValue, newValue)) {
        return oldValue;
      }
    }
  }
  
  public long put(K key, long newValue)
  {
    AtomicLong atomic = (AtomicLong)map.get(key);
    if (atomic == null)
    {
      atomic = (AtomicLong)map.putIfAbsent(key, new AtomicLong(newValue));
      if (atomic == null) {
        return 0L;
      }
    }
    for (;;)
    {
      long oldValue = atomic.get();
      if (oldValue == 0L)
      {
        if (!map.replace(key, atomic, new AtomicLong(newValue))) {
          break;
        }
        return 0L;
      }
      if (atomic.compareAndSet(oldValue, newValue)) {
        return oldValue;
      }
    }
  }
  
  public void putAll(Map<? extends K, ? extends Long> m)
  {
    for (Map.Entry<? extends K, ? extends Long> entry : m.entrySet()) {
      put(entry.getKey(), ((Long)entry.getValue()).longValue());
    }
  }
  
  public long remove(K key)
  {
    AtomicLong atomic = (AtomicLong)map.get(key);
    if (atomic == null) {
      return 0L;
    }
    for (;;)
    {
      long oldValue = atomic.get();
      if ((oldValue == 0L) || (atomic.compareAndSet(oldValue, 0L)))
      {
        map.remove(key, atomic);
        
        return oldValue;
      }
    }
  }
  
  public void removeAllZeros()
  {
    for (K key : map.keySet())
    {
      AtomicLong atomic = (AtomicLong)map.get(key);
      if ((atomic != null) && (atomic.get() == 0L)) {
        map.remove(key, atomic);
      }
    }
  }
  
  public long sum()
  {
    long sum = 0L;
    for (AtomicLong value : map.values()) {
      sum += value.get();
    }
    return sum;
  }
  
  public Map<K, Long> asMap()
  {
    Map<K, Long> result = asMap;
    return result == null ? (asMap = createAsMap()) : result;
  }
  
  private Map<K, Long> createAsMap()
  {
    Collections.unmodifiableMap(Maps.transformValues(map, new Function()
    {
      public Long apply(AtomicLong atomic)
      {
        return Long.valueOf(atomic.get());
      }
    }));
  }
  
  public boolean containsKey(Object key)
  {
    return map.containsKey(key);
  }
  
  public int size()
  {
    return map.size();
  }
  
  public boolean isEmpty()
  {
    return map.isEmpty();
  }
  
  public void clear()
  {
    map.clear();
  }
  
  public String toString()
  {
    return map.toString();
  }
  
  long putIfAbsent(K key, long newValue)
  {
    AtomicLong atomic;
    long oldValue;
    do
    {
      atomic = (AtomicLong)map.get(key);
      if (atomic == null)
      {
        atomic = (AtomicLong)map.putIfAbsent(key, new AtomicLong(newValue));
        if (atomic == null) {
          return 0L;
        }
      }
      oldValue = atomic.get();
      if (oldValue != 0L) {
        break;
      }
    } while (!map.replace(key, atomic, new AtomicLong(newValue)));
    return 0L;
    
    return oldValue;
  }
  
  boolean replace(K key, long expectedOldValue, long newValue)
  {
    if (expectedOldValue == 0L) {
      return putIfAbsent(key, newValue) == 0L;
    }
    AtomicLong atomic = (AtomicLong)map.get(key);
    return atomic == null ? false : atomic.compareAndSet(expectedOldValue, newValue);
  }
  
  boolean remove(K key, long value)
  {
    AtomicLong atomic = (AtomicLong)map.get(key);
    if (atomic == null) {
      return false;
    }
    long oldValue = atomic.get();
    if (oldValue != value) {
      return false;
    }
    if ((oldValue == 0L) || (atomic.compareAndSet(oldValue, 0L)))
    {
      map.remove(key, atomic);
      
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AtomicLongMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */