package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

@GwtCompatible(emulated=true)
abstract class DescendingMultiset<E>
  extends ForwardingMultiset<E>
  implements SortedMultiset<E>
{
  private transient Comparator<? super E> comparator;
  private transient NavigableSet<E> elementSet;
  private transient Set<Multiset.Entry<E>> entrySet;
  
  abstract SortedMultiset<E> forwardMultiset();
  
  public Comparator<? super E> comparator()
  {
    Comparator<? super E> result = comparator;
    if (result == null) {
      return comparator = Ordering.from(forwardMultiset().comparator()).reverse();
    }
    return result;
  }
  
  public NavigableSet<E> elementSet()
  {
    NavigableSet<E> result = elementSet;
    if (result == null) {
      return elementSet = new SortedMultisets.NavigableElementSet(this);
    }
    return result;
  }
  
  public Multiset.Entry<E> pollFirstEntry()
  {
    return forwardMultiset().pollLastEntry();
  }
  
  public Multiset.Entry<E> pollLastEntry()
  {
    return forwardMultiset().pollFirstEntry();
  }
  
  public SortedMultiset<E> headMultiset(E toElement, BoundType boundType)
  {
    return forwardMultiset().tailMultiset(toElement, boundType).descendingMultiset();
  }
  
  public SortedMultiset<E> subMultiset(E fromElement, BoundType fromBoundType, E toElement, BoundType toBoundType)
  {
    return forwardMultiset().subMultiset(toElement, toBoundType, fromElement, fromBoundType).descendingMultiset();
  }
  
  public SortedMultiset<E> tailMultiset(E fromElement, BoundType boundType)
  {
    return forwardMultiset().headMultiset(fromElement, boundType).descendingMultiset();
  }
  
  protected Multiset<E> delegate()
  {
    return forwardMultiset();
  }
  
  public SortedMultiset<E> descendingMultiset()
  {
    return forwardMultiset();
  }
  
  public Multiset.Entry<E> firstEntry()
  {
    return forwardMultiset().lastEntry();
  }
  
  public Multiset.Entry<E> lastEntry()
  {
    return forwardMultiset().firstEntry();
  }
  
  abstract Iterator<Multiset.Entry<E>> entryIterator();
  
  public Set<Multiset.Entry<E>> entrySet()
  {
    Set<Multiset.Entry<E>> result = entrySet;
    return result == null ? (entrySet = createEntrySet()) : result;
  }
  
  Set<Multiset.Entry<E>> createEntrySet()
  {
    new Multisets.EntrySet()
    {
      Multiset<E> multiset()
      {
        return DescendingMultiset.this;
      }
      
      public Iterator<Multiset.Entry<E>> iterator()
      {
        return entryIterator();
      }
      
      public int size()
      {
        return forwardMultiset().entrySet().size();
      }
    };
  }
  
  public Iterator<E> iterator()
  {
    return Multisets.iteratorImpl(this);
  }
  
  public Object[] toArray()
  {
    return standardToArray();
  }
  
  public <T> T[] toArray(T[] array)
  {
    return standardToArray(array);
  }
  
  public String toString()
  {
    return entrySet().toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.DescendingMultiset
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */