package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ObjectUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder.CompareToBuilder;
import java.io.Serializable;

public abstract class Triple<L, M, R>
  implements Comparable<Triple<L, M, R>>, Serializable
{
  private static final long serialVersionUID = 1L;
  
  public static <L, M, R> Triple<L, M, R> of(L left, M middle, R right)
  {
    return new ImmutableTriple(left, middle, right);
  }
  
  public abstract L getLeft();
  
  public abstract M getMiddle();
  
  public abstract R getRight();
  
  public int compareTo(Triple<L, M, R> other)
  {
    return new CompareToBuilder().append(getLeft(), other.getLeft()).append(getMiddle(), other.getMiddle()).append(getRight(), other.getRight()).toComparison();
  }
  
  public boolean equals(Object obj)
  {
    if (obj == this) {
      return true;
    }
    if ((obj instanceof Triple))
    {
      Triple<?, ?, ?> other = (Triple)obj;
      return (ObjectUtils.equals(getLeft(), other.getLeft())) && (ObjectUtils.equals(getMiddle(), other.getMiddle())) && (ObjectUtils.equals(getRight(), other.getRight()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return (getLeft() == null ? 0 : getLeft().hashCode()) ^ (getMiddle() == null ? 0 : getMiddle().hashCode()) ^ (getRight() == null ? 0 : getRight().hashCode());
  }
  
  public String toString()
  {
    return '(' + getLeft() + ',' + getMiddle() + ',' + getRight() + ')';
  }
  
  public String toString(String format)
  {
    return String.format(format, new Object[] { getLeft(), getMiddle(), getRight() });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.Triple
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */