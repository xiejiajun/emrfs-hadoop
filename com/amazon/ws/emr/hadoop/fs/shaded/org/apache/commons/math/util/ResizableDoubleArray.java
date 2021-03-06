package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import java.io.Serializable;
import java.util.Arrays;

public class ResizableDoubleArray
  implements DoubleArray, Serializable
{
  public static final int ADDITIVE_MODE = 1;
  public static final int MULTIPLICATIVE_MODE = 0;
  private static final long serialVersionUID = -3485529955529426875L;
  protected float contractionCriteria = 2.5F;
  protected float expansionFactor = 2.0F;
  protected int expansionMode = 0;
  protected int initialCapacity = 16;
  protected double[] internalArray;
  protected int numElements = 0;
  protected int startIndex = 0;
  
  public ResizableDoubleArray()
  {
    internalArray = new double[initialCapacity];
  }
  
  public ResizableDoubleArray(int initialCapacity)
  {
    setInitialCapacity(initialCapacity);
    internalArray = new double[this.initialCapacity];
  }
  
  public ResizableDoubleArray(int initialCapacity, float expansionFactor)
  {
    this.expansionFactor = expansionFactor;
    setInitialCapacity(initialCapacity);
    internalArray = new double[initialCapacity];
    setContractionCriteria(expansionFactor + 0.5F);
  }
  
  public ResizableDoubleArray(int initialCapacity, float expansionFactor, float contractionCriteria)
  {
    this.expansionFactor = expansionFactor;
    setContractionCriteria(contractionCriteria);
    setInitialCapacity(initialCapacity);
    internalArray = new double[initialCapacity];
  }
  
  public ResizableDoubleArray(int initialCapacity, float expansionFactor, float contractionCriteria, int expansionMode)
  {
    this.expansionFactor = expansionFactor;
    setContractionCriteria(contractionCriteria);
    setInitialCapacity(initialCapacity);
    setExpansionMode(expansionMode);
    internalArray = new double[initialCapacity];
  }
  
  public ResizableDoubleArray(ResizableDoubleArray original)
  {
    copy(original, this);
  }
  
  public synchronized void addElement(double value)
  {
    numElements += 1;
    if (startIndex + numElements > internalArray.length) {
      expand();
    }
    internalArray[(startIndex + (numElements - 1))] = value;
    if (shouldContract()) {
      contract();
    }
  }
  
  public synchronized double addElementRolling(double value)
  {
    double discarded = internalArray[startIndex];
    if (startIndex + (numElements + 1) > internalArray.length) {
      expand();
    }
    startIndex += 1;
    
    internalArray[(startIndex + (numElements - 1))] = value;
    if (shouldContract()) {
      contract();
    }
    return discarded;
  }
  
  public synchronized double substituteMostRecentElement(double value)
  {
    if (numElements < 1) {
      throw MathRuntimeException.createArrayIndexOutOfBoundsException("cannot substitute an element from an empty array", new Object[0]);
    }
    double discarded = internalArray[(startIndex + (numElements - 1))];
    
    internalArray[(startIndex + (numElements - 1))] = value;
    
    return discarded;
  }
  
  protected void checkContractExpand(float contraction, float expansion)
  {
    if (contraction < expansion) {
      throw MathRuntimeException.createIllegalArgumentException("contraction criteria ({0}) smaller than the expansion factor ({1}).  This would lead to a never ending loop of expansion and contraction as a newly expanded internal storage array would immediately satisfy the criteria for contraction", new Object[] { Float.valueOf(contraction), Float.valueOf(expansion) });
    }
    if (contraction <= 1.0D) {
      throw MathRuntimeException.createIllegalArgumentException("contraction criteria smaller than one ({0}).  This would lead to a never ending loop of expansion and contraction as an internal storage array length equal to the number of elements would satisfy the contraction criteria.", new Object[] { Float.valueOf(contraction) });
    }
    if (expansion <= 1.0D) {
      throw MathRuntimeException.createIllegalArgumentException("expansion factor smaller than one ({0})", new Object[] { Float.valueOf(expansion) });
    }
  }
  
  public synchronized void clear()
  {
    numElements = 0;
    startIndex = 0;
    internalArray = new double[initialCapacity];
  }
  
  public synchronized void contract()
  {
    double[] tempArray = new double[numElements + 1];
    
    System.arraycopy(internalArray, startIndex, tempArray, 0, numElements);
    internalArray = tempArray;
    
    startIndex = 0;
  }
  
  public synchronized void discardFrontElements(int i)
  {
    discardExtremeElements(i, true);
  }
  
  public synchronized void discardMostRecentElements(int i)
  {
    discardExtremeElements(i, false);
  }
  
  private synchronized void discardExtremeElements(int i, boolean front)
  {
    if (i > numElements) {
      throw MathRuntimeException.createIllegalArgumentException("cannot discard {0} elements from a {1} elements array", new Object[] { Integer.valueOf(i), Integer.valueOf(numElements) });
    }
    if (i < 0) {
      throw MathRuntimeException.createIllegalArgumentException("cannot discard a negative number of elements ({0})", new Object[] { Integer.valueOf(i) });
    }
    numElements -= i;
    if (front) {
      startIndex += i;
    }
    if (shouldContract()) {
      contract();
    }
  }
  
  protected synchronized void expand()
  {
    int newSize = 0;
    if (expansionMode == 0) {
      newSize = (int)Math.ceil(internalArray.length * expansionFactor);
    } else {
      newSize = internalArray.length + Math.round(expansionFactor);
    }
    double[] tempArray = new double[newSize];
    
    System.arraycopy(internalArray, 0, tempArray, 0, internalArray.length);
    internalArray = tempArray;
  }
  
  private synchronized void expandTo(int size)
  {
    double[] tempArray = new double[size];
    
    System.arraycopy(internalArray, 0, tempArray, 0, internalArray.length);
    internalArray = tempArray;
  }
  
  public float getContractionCriteria()
  {
    return contractionCriteria;
  }
  
  public synchronized double getElement(int index)
  {
    if (index >= numElements) {
      throw MathRuntimeException.createArrayIndexOutOfBoundsException("the index specified: {0} is larger than the current maximal index {1}", new Object[] { Integer.valueOf(index), Integer.valueOf(numElements - 1) });
    }
    if (index >= 0) {
      return internalArray[(startIndex + index)];
    }
    throw MathRuntimeException.createArrayIndexOutOfBoundsException("elements cannot be retrieved from a negative array index {0}", new Object[] { Integer.valueOf(index) });
  }
  
  public synchronized double[] getElements()
  {
    double[] elementArray = new double[numElements];
    System.arraycopy(internalArray, startIndex, elementArray, 0, numElements);
    
    return elementArray;
  }
  
  public float getExpansionFactor()
  {
    return expansionFactor;
  }
  
  public int getExpansionMode()
  {
    return expansionMode;
  }
  
  synchronized int getInternalLength()
  {
    return internalArray.length;
  }
  
  public synchronized int getNumElements()
  {
    return numElements;
  }
  
  @Deprecated
  public synchronized double[] getValues()
  {
    return internalArray;
  }
  
  public synchronized double[] getInternalValues()
  {
    return internalArray;
  }
  
  public void setContractionCriteria(float contractionCriteria)
  {
    checkContractExpand(contractionCriteria, getExpansionFactor());
    synchronized (this)
    {
      this.contractionCriteria = contractionCriteria;
    }
  }
  
  public synchronized void setElement(int index, double value)
  {
    if (index < 0) {
      throw MathRuntimeException.createArrayIndexOutOfBoundsException("cannot set an element at a negative index {0}", new Object[] { Integer.valueOf(index) });
    }
    if (index + 1 > numElements) {
      numElements = (index + 1);
    }
    if (startIndex + index >= internalArray.length) {
      expandTo(startIndex + (index + 1));
    }
    internalArray[(startIndex + index)] = value;
  }
  
  public void setExpansionFactor(float expansionFactor)
  {
    checkContractExpand(getContractionCriteria(), expansionFactor);
    synchronized (this)
    {
      this.expansionFactor = expansionFactor;
    }
  }
  
  public void setExpansionMode(int expansionMode)
  {
    if ((expansionMode != 0) && (expansionMode != 1)) {
      throw MathRuntimeException.createIllegalArgumentException("unsupported expansion mode {0}, supported modes are {1} ({2}) and {3} ({4})", new Object[] { Integer.valueOf(expansionMode), Integer.valueOf(0), "MULTIPLICATIVE_MODE", Integer.valueOf(1), "ADDITIVE_MODE" });
    }
    synchronized (this)
    {
      this.expansionMode = expansionMode;
    }
  }
  
  protected void setInitialCapacity(int initialCapacity)
  {
    if (initialCapacity > 0) {
      synchronized (this)
      {
        this.initialCapacity = initialCapacity;
      }
    } else {
      throw MathRuntimeException.createIllegalArgumentException("initial capacity ({0}) is not positive", new Object[] { Integer.valueOf(initialCapacity) });
    }
  }
  
  public synchronized void setNumElements(int i)
  {
    if (i < 0) {
      throw MathRuntimeException.createIllegalArgumentException("index ({0}) is not positive", new Object[] { Integer.valueOf(i) });
    }
    if (startIndex + i > internalArray.length) {
      expandTo(startIndex + i);
    }
    numElements = i;
  }
  
  private synchronized boolean shouldContract()
  {
    if (expansionMode == 0) {
      return internalArray.length / numElements > contractionCriteria;
    }
    return internalArray.length - numElements > contractionCriteria;
  }
  
  public synchronized int start()
  {
    return startIndex;
  }
  
  public static void copy(ResizableDoubleArray source, ResizableDoubleArray dest)
  {
    synchronized (source)
    {
      synchronized (dest)
      {
        initialCapacity = initialCapacity;
        contractionCriteria = contractionCriteria;
        expansionFactor = expansionFactor;
        expansionMode = expansionMode;
        internalArray = new double[internalArray.length];
        System.arraycopy(internalArray, 0, internalArray, 0, internalArray.length);
        
        numElements = numElements;
        startIndex = startIndex;
      }
    }
  }
  
  public synchronized ResizableDoubleArray copy()
  {
    ResizableDoubleArray result = new ResizableDoubleArray();
    copy(this, result);
    return result;
  }
  
  public boolean equals(Object object)
  {
    if (object == this) {
      return true;
    }
    if (!(object instanceof ResizableDoubleArray)) {
      return false;
    }
    synchronized (this)
    {
      synchronized (object)
      {
        boolean result = true;
        ResizableDoubleArray other = (ResizableDoubleArray)object;
        result = (result) && (initialCapacity == initialCapacity);
        result = (result) && (contractionCriteria == contractionCriteria);
        result = (result) && (expansionFactor == expansionFactor);
        result = (result) && (expansionMode == expansionMode);
        result = (result) && (numElements == numElements);
        result = (result) && (startIndex == startIndex);
        if (!result) {
          return false;
        }
        return Arrays.equals(internalArray, internalArray);
      }
    }
  }
  
  public synchronized int hashCode()
  {
    int[] hashData = new int[7];
    hashData[0] = new Float(expansionFactor).hashCode();
    hashData[1] = new Float(contractionCriteria).hashCode();
    hashData[2] = expansionMode;
    hashData[3] = Arrays.hashCode(internalArray);
    hashData[4] = initialCapacity;
    hashData[5] = numElements;
    hashData[6] = startIndex;
    return Arrays.hashCode(hashData);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.ResizableDoubleArray
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */