package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;

class $CallbackInfo
{
  private Class cls;
  private .CallbackGenerator generator;
  private .Type type;
  
  public static .Type[] determineTypes(Class[] callbackTypes)
  {
    .Type[] types = new .Type[callbackTypes.length];
    for (int i = 0; i < types.length; i++) {
      types[i] = determineType(callbackTypes[i]);
    }
    return types;
  }
  
  public static .Type[] determineTypes(.Callback[] callbacks)
  {
    .Type[] types = new .Type[callbacks.length];
    for (int i = 0; i < types.length; i++) {
      types[i] = determineType(callbacks[i]);
    }
    return types;
  }
  
  public static .CallbackGenerator[] getGenerators(.Type[] callbackTypes)
  {
    .CallbackGenerator[] generators = new .CallbackGenerator[callbackTypes.length];
    for (int i = 0; i < generators.length; i++) {
      generators[i] = getGenerator(callbackTypes[i]);
    }
    return generators;
  }
  
  private static final CallbackInfo[] CALLBACKS = { new CallbackInfo(.NoOp.class, .NoOpGenerator.INSTANCE), new CallbackInfo(.MethodInterceptor.class, .MethodInterceptorGenerator.INSTANCE), new CallbackInfo(.InvocationHandler.class, .InvocationHandlerGenerator.INSTANCE), new CallbackInfo(.LazyLoader.class, .LazyLoaderGenerator.INSTANCE), new CallbackInfo(.Dispatcher.class, .DispatcherGenerator.INSTANCE), new CallbackInfo(.FixedValue.class, .FixedValueGenerator.INSTANCE), new CallbackInfo(.ProxyRefDispatcher.class, .DispatcherGenerator.PROXY_REF_INSTANCE) };
  
  private $CallbackInfo(Class cls, .CallbackGenerator generator)
  {
    this.cls = cls;
    this.generator = generator;
    type = .Type.getType(cls);
  }
  
  private static .Type determineType(.Callback callback)
  {
    if (callback == null) {
      throw new IllegalStateException("Callback is null");
    }
    return determineType(callback.getClass());
  }
  
  private static .Type determineType(Class callbackType)
  {
    Class cur = null;
    for (int i = 0; i < CALLBACKS.length; i++)
    {
      CallbackInfo info = CALLBACKS[i];
      if (cls.isAssignableFrom(callbackType))
      {
        if (cur != null) {
          throw new IllegalStateException("Callback implements both " + cur + " and " + cls);
        }
        cur = cls;
      }
    }
    if (cur == null) {
      throw new IllegalStateException("Unknown callback type " + callbackType);
    }
    return .Type.getType(cur);
  }
  
  private static .CallbackGenerator getGenerator(.Type callbackType)
  {
    for (int i = 0; i < CALLBACKS.length; i++)
    {
      CallbackInfo info = CALLBACKS[i];
      if (type.equals(callbackType)) {
        return generator;
      }
    }
    throw new IllegalStateException("Unknown callback type " + callbackType);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..CallbackInfo
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */