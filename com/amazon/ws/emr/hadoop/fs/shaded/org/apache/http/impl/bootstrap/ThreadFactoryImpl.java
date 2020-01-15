package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.bootstrap;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

class ThreadFactoryImpl
  implements ThreadFactory
{
  private final String namePrefix;
  private final ThreadGroup group;
  private final AtomicLong count;
  
  ThreadFactoryImpl(String namePrefix, ThreadGroup group)
  {
    this.namePrefix = namePrefix;
    this.group = group;
    count = new AtomicLong();
  }
  
  ThreadFactoryImpl(String namePrefix)
  {
    this(namePrefix, null);
  }
  
  public Thread newThread(Runnable target)
  {
    return new Thread(group, target, namePrefix + "-" + count.incrementAndGet());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.bootstrap.ThreadFactoryImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */