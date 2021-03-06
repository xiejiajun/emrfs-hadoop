package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CloneUtils
{
  public static <T> T cloneObject(T obj)
    throws CloneNotSupportedException
  {
    if (obj == null) {
      return null;
    }
    if ((obj instanceof Cloneable))
    {
      Class<?> clazz = obj.getClass();
      Method m;
      try
      {
        m = clazz.getMethod("clone", (Class[])null);
      }
      catch (NoSuchMethodException ex)
      {
        throw new NoSuchMethodError(ex.getMessage());
      }
      try
      {
        return (T)m.invoke(obj, (Object[])null);
      }
      catch (InvocationTargetException ex)
      {
        Throwable cause = ex.getCause();
        if ((cause instanceof CloneNotSupportedException)) {
          throw ((CloneNotSupportedException)cause);
        }
        throw new Error("Unexpected exception", cause);
      }
      catch (IllegalAccessException ex)
      {
        throw new IllegalAccessError(ex.getMessage());
      }
    }
    throw new CloneNotSupportedException();
  }
  
  public static Object clone(Object obj)
    throws CloneNotSupportedException
  {
    return cloneObject(obj);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils.CloneUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */