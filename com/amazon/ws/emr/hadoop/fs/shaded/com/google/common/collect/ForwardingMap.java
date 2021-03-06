package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingMap<K, V>
  extends ForwardingObject
  implements Map<K, V>
{
  protected abstract Map<K, V> delegate();
  
  public int size()
  {
    return delegate().size();
  }
  
  public boolean isEmpty()
  {
    return delegate().isEmpty();
  }
  
  public V remove(Object object)
  {
    return (V)delegate().remove(object);
  }
  
  public void clear()
  {
    delegate().clear();
  }
  
  public boolean containsKey(@Nullable Object key)
  {
    return delegate().containsKey(key);
  }
  
  public boolean containsValue(@Nullable Object value)
  {
    return delegate().containsValue(value);
  }
  
  public V get(@Nullable Object key)
  {
    return (V)delegate().get(key);
  }
  
  public V put(K key, V value)
  {
    return (V)delegate().put(key, value);
  }
  
  public void putAll(Map<? extends K, ? extends V> map)
  {
    delegate().putAll(map);
  }
  
  public Set<K> keySet()
  {
    return delegate().keySet();
  }
  
  public Collection<V> values()
  {
    return delegate().values();
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return delegate().entrySet();
  }
  
  public boolean equals(@Nullable Object object)
  {
    return (object == this) || (delegate().equals(object));
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  protected void standardPutAll(Map<? extends K, ? extends V> map)
  {
    Maps.putAllImpl(this, map);
  }
  
  @Beta
  protected V standardRemove(@Nullable Object key)
  {
    Iterator<Map.Entry<K, V>> entryIterator = entrySet().iterator();
    while (entryIterator.hasNext())
    {
      Map.Entry<K, V> entry = (Map.Entry)entryIterator.next();
      if (Objects.equal(entry.getKey(), key))
      {
        V value = entry.getValue();
        entryIterator.remove();
        return value;
      }
    }
    return null;
  }
  
  protected void standardClear()
  {
    Iterators.clear(entrySet().iterator());
  }
  
  @Beta
  protected class StandardKeySet
    extends Maps.KeySet<K, V>
  {
    public StandardKeySet()
    {
      super();
    }
  }
  
  @Beta
  protected boolean standardContainsKey(@Nullable Object key)
  {
    return Maps.containsKeyImpl(this, key);
  }
  
  @Beta
  protected class StandardValues
    extends Maps.Values<K, V>
  {
    public StandardValues()
    {
      super();
    }
  }
  
  protected boolean standardContainsValue(@Nullable Object value)
  {
    return Maps.containsValueImpl(this, value);
  }
  
  @Beta
  protected abstract class StandardEntrySet
    extends Maps.EntrySet<K, V>
  {
    public StandardEntrySet() {}
    
    Map<K, V> map()
    {
      return ForwardingMap.this;
    }
  }
  
  protected boolean standardIsEmpty()
  {
    return !entrySet().iterator().hasNext();
  }
  
  protected boolean standardEquals(@Nullable Object object)
  {
    return Maps.equalsImpl(this, object);
  }
  
  protected int standardHashCode()
  {
    return Sets.hashCodeImpl(entrySet());
  }
  
  protected String standardToString()
  {
    return Maps.toStringImpl(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */