package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;

 enum MapMakerInternalMap$Strength$2
{
  MapMakerInternalMap$Strength$2()
  {
    super(paramString, paramInt, null);
  }
  
  <K, V> MapMakerInternalMap.ValueReference<K, V> referenceValue(MapMakerInternalMap.Segment<K, V> segment, MapMakerInternalMap.ReferenceEntry<K, V> entry, V value)
  {
    return new MapMakerInternalMap.SoftValueReference(valueReferenceQueue, value, entry);
  }
  
  Equivalence<Object> defaultEquivalence()
  {
    return Equivalence.identity();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.Strength.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */