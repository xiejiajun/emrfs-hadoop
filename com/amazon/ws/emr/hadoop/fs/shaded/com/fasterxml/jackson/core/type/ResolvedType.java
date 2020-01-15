package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.type;

public abstract class ResolvedType
{
  public abstract Class<?> getRawClass();
  
  public abstract boolean hasRawClass(Class<?> paramClass);
  
  public abstract boolean isAbstract();
  
  public abstract boolean isConcrete();
  
  public abstract boolean isThrowable();
  
  public abstract boolean isArrayType();
  
  public abstract boolean isEnumType();
  
  public abstract boolean isInterface();
  
  public abstract boolean isPrimitive();
  
  public abstract boolean isFinal();
  
  public abstract boolean isContainerType();
  
  public abstract boolean isCollectionLikeType();
  
  public boolean isReferenceType()
  {
    return getReferencedType() != null;
  }
  
  public abstract boolean isMapLikeType();
  
  public abstract boolean hasGenericTypes();
  
  public Class<?> getParameterSource()
  {
    return null;
  }
  
  public abstract ResolvedType getKeyType();
  
  public abstract ResolvedType getContentType();
  
  public abstract ResolvedType getReferencedType();
  
  public abstract int containedTypeCount();
  
  public abstract ResolvedType containedType(int paramInt);
  
  public abstract String containedTypeName(int paramInt);
  
  public abstract String toCanonical();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.type.ResolvedType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */