package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.event;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect.MethodUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EventUtils
{
  public static <L> void addEventListener(Object eventSource, Class<L> listenerType, L listener)
  {
    try
    {
      MethodUtils.invokeMethod(eventSource, "add" + listenerType.getSimpleName(), new Object[] { listener });
    }
    catch (NoSuchMethodException e)
    {
      throw new IllegalArgumentException("Class " + eventSource.getClass().getName() + " does not have a public add" + listenerType.getSimpleName() + " method which takes a parameter of type " + listenerType.getName() + ".");
    }
    catch (IllegalAccessException e)
    {
      throw new IllegalArgumentException("Class " + eventSource.getClass().getName() + " does not have an accessible add" + listenerType.getSimpleName() + " method which takes a parameter of type " + listenerType.getName() + ".");
    }
    catch (InvocationTargetException e)
    {
      throw new RuntimeException("Unable to add listener.", e.getCause());
    }
  }
  
  public static <L> void bindEventsToMethod(Object target, String methodName, Object eventSource, Class<L> listenerType, String... eventTypes)
  {
    L listener = listenerType.cast(Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[] { listenerType }, new EventBindingInvocationHandler(target, methodName, eventTypes)));
    
    addEventListener(eventSource, listenerType, listener);
  }
  
  private static class EventBindingInvocationHandler
    implements InvocationHandler
  {
    private final Object target;
    private final String methodName;
    private final Set<String> eventTypes;
    
    EventBindingInvocationHandler(Object target, String methodName, String[] eventTypes)
    {
      this.target = target;
      this.methodName = methodName;
      this.eventTypes = new HashSet(Arrays.asList(eventTypes));
    }
    
    public Object invoke(Object proxy, Method method, Object[] parameters)
      throws Throwable
    {
      if ((eventTypes.isEmpty()) || (eventTypes.contains(method.getName())))
      {
        if (hasMatchingParametersMethod(method)) {
          return MethodUtils.invokeMethod(target, methodName, parameters);
        }
        return MethodUtils.invokeMethod(target, methodName, new Object[0]);
      }
      return null;
    }
    
    private boolean hasMatchingParametersMethod(Method method)
    {
      return MethodUtils.getAccessibleMethod(target.getClass(), methodName, method.getParameterTypes()) != null;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.event.EventUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */