package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
class StandardRowSortedTable<R, C, V>
  extends StandardTable<R, C, V>
  implements RowSortedTable<R, C, V>
{
  private static final long serialVersionUID = 0L;
  
  StandardRowSortedTable(SortedMap<R, Map<C, V>> backingMap, Supplier<? extends Map<C, V>> factory)
  {
    super(backingMap, factory);
  }
  
  private SortedMap<R, Map<C, V>> sortedBackingMap()
  {
    return (SortedMap)backingMap;
  }
  
  public SortedSet<R> rowKeySet()
  {
    return (SortedSet)rowMap().keySet();
  }
  
  public SortedMap<R, Map<C, V>> rowMap()
  {
    return (SortedMap)super.rowMap();
  }
  
  SortedMap<R, Map<C, V>> createRowMap()
  {
    return new RowSortedMap(null);
  }
  
  private class RowSortedMap
    extends StandardTable<R, C, V>.RowMap
    implements SortedMap<R, Map<C, V>>
  {
    private RowSortedMap()
    {
      super();
    }
    
    public SortedSet<R> keySet()
    {
      return (SortedSet)super.keySet();
    }
    
    SortedSet<R> createKeySet()
    {
      return new Maps.SortedKeySet(this);
    }
    
    public Comparator<? super R> comparator()
    {
      return StandardRowSortedTable.this.sortedBackingMap().comparator();
    }
    
    public R firstKey()
    {
      return (R)StandardRowSortedTable.this.sortedBackingMap().firstKey();
    }
    
    public R lastKey()
    {
      return (R)StandardRowSortedTable.this.sortedBackingMap().lastKey();
    }
    
    public SortedMap<R, Map<C, V>> headMap(R toKey)
    {
      Preconditions.checkNotNull(toKey);
      return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().headMap(toKey), factory).rowMap();
    }
    
    public SortedMap<R, Map<C, V>> subMap(R fromKey, R toKey)
    {
      Preconditions.checkNotNull(fromKey);
      Preconditions.checkNotNull(toKey);
      return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().subMap(fromKey, toKey), factory).rowMap();
    }
    
    public SortedMap<R, Map<C, V>> tailMap(R fromKey)
    {
      Preconditions.checkNotNull(fromKey);
      return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().tailMap(fromKey), factory).rowMap();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardRowSortedTable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */