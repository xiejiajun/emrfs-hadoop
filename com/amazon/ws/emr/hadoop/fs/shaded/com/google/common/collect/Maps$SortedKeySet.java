package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

class Maps$SortedKeySet<K, V>
  extends Maps.KeySet<K, V>
  implements SortedSet<K>
{
  Maps$SortedKeySet(SortedMap<K, V> map)
  {
    super(map);
  }
  
  SortedMap<K, V> map()
  {
    return (SortedMap)super.map();
  }
  
  public Comparator<? super K> comparator()
  {
    return map().comparator();
  }
  
  public SortedSet<K> subSet(K fromElement, K toElement)
  {
    return new SortedKeySet(map().subMap(fromElement, toElement));
  }
  
  public SortedSet<K> headSet(K toElement)
  {
    return new SortedKeySet(map().headMap(toElement));
  }
  
  public SortedSet<K> tailSet(K fromElement)
  {
    return new SortedKeySet(map().tailMap(fromElement));
  }
  
  public K first()
  {
    return (K)map().firstKey();
  }
  
  public K last()
  {
    return (K)map().lastKey();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.SortedKeySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */