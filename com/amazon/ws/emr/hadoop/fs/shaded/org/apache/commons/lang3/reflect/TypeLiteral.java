package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.Validate;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

public abstract class TypeLiteral<T>
  implements Typed<T>
{
  private static final TypeVariable<Class<TypeLiteral>> T = TypeLiteral.class.getTypeParameters()[0];
  public final Type value;
  private final String toString;
  
  protected TypeLiteral()
  {
    value = ((Type)Validate.notNull(TypeUtils.getTypeArguments(getClass(), TypeLiteral.class).get(T), "%s does not assign type parameter %s", new Object[] { getClass(), TypeUtils.toLongString(T) }));
    
    toString = String.format("%s<%s>", new Object[] { TypeLiteral.class.getSimpleName(), TypeUtils.toString(value) });
  }
  
  public final boolean equals(Object obj)
  {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof TypeLiteral)) {
      return false;
    }
    TypeLiteral<?> other = (TypeLiteral)obj;
    return TypeUtils.equals(value, value);
  }
  
  public int hashCode()
  {
    return 0x250 | value.hashCode();
  }
  
  public String toString()
  {
    return toString;
  }
  
  public Type getType()
  {
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect.TypeLiteral
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */