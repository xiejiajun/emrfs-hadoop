package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

class $MapMaker$LinkedStrongEntry<K, V>
  extends .MapMaker.StrongEntry<K, V>
{
  final .MapMaker.ReferenceEntry<K, V> next;
  
  $MapMaker$LinkedStrongEntry(.CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals, K key, int hash, .MapMaker.ReferenceEntry<K, V> next)
  {
    super(internals, key, hash);
    this.next = next;
  }
  
  public .MapMaker.ReferenceEntry<K, V> getNext()
  {
    return next;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.LinkedStrongEntry
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */