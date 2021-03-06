package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
final class FilteredKeySetMultimap<K, V>
  extends FilteredKeyMultimap<K, V>
  implements FilteredSetMultimap<K, V>
{
  FilteredKeySetMultimap(SetMultimap<K, V> unfiltered, Predicate<? super K> keyPredicate)
  {
    super(unfiltered, keyPredicate);
  }
  
  public SetMultimap<K, V> unfiltered()
  {
    return (SetMultimap)unfiltered;
  }
  
  public Set<V> get(K key)
  {
    return (Set)super.get(key);
  }
  
  public Set<V> removeAll(Object key)
  {
    return (Set)super.removeAll(key);
  }
  
  public Set<V> replaceValues(K key, Iterable<? extends V> values)
  {
    return (Set)super.replaceValues(key, values);
  }
  
  public Set<Map.Entry<K, V>> entries()
  {
    return (Set)super.entries();
  }
  
  Set<Map.Entry<K, V>> createEntries()
  {
    return new EntrySet();
  }
  
  class EntrySet
    extends FilteredKeyMultimap<K, V>.Entries
    implements Set<Map.Entry<K, V>>
  {
    EntrySet()
    {
      super();
    }
    
    public int hashCode()
    {
      return Sets.hashCodeImpl(this);
    }
    
    public boolean equals(@Nullable Object o)
    {
      return Sets.equalsImpl(this, o);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FilteredKeySetMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */