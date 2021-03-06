package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import javax.annotation.Nullable;

final class AbstractFuture$Sync<V>
  extends AbstractQueuedSynchronizer
{
  private static final long serialVersionUID = 0L;
  static final int RUNNING = 0;
  static final int COMPLETING = 1;
  static final int COMPLETED = 2;
  static final int CANCELLED = 4;
  static final int INTERRUPTED = 8;
  private V value;
  private Throwable exception;
  
  protected int tryAcquireShared(int ignored)
  {
    if (isDone()) {
      return 1;
    }
    return -1;
  }
  
  protected boolean tryReleaseShared(int finalState)
  {
    setState(finalState);
    return true;
  }
  
  V get(long nanos)
    throws TimeoutException, CancellationException, ExecutionException, InterruptedException
  {
    if (!tryAcquireSharedNanos(-1, nanos)) {
      throw new TimeoutException("Timeout waiting for task.");
    }
    return (V)getValue();
  }
  
  V get()
    throws CancellationException, ExecutionException, InterruptedException
  {
    acquireSharedInterruptibly(-1);
    return (V)getValue();
  }
  
  private V getValue()
    throws CancellationException, ExecutionException
  {
    int state = getState();
    switch (state)
    {
    case 2: 
      if (exception != null) {
        throw new ExecutionException(exception);
      }
      return (V)value;
    case 4: 
    case 8: 
      throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", exception);
    }
    int i = state;throw new IllegalStateException(49 + "Error, synchronizer in invalid state: " + i);
  }
  
  boolean isDone()
  {
    return (getState() & 0xE) != 0;
  }
  
  boolean isCancelled()
  {
    return (getState() & 0xC) != 0;
  }
  
  boolean wasInterrupted()
  {
    return getState() == 8;
  }
  
  boolean set(@Nullable V v)
  {
    return complete(v, null, 2);
  }
  
  boolean setException(Throwable t)
  {
    return complete(null, t, 2);
  }
  
  boolean cancel(boolean interrupt)
  {
    return complete(null, null, interrupt ? 8 : 4);
  }
  
  private boolean complete(@Nullable V v, @Nullable Throwable t, int finalState)
  {
    boolean doCompletion = compareAndSetState(0, 1);
    if (doCompletion)
    {
      value = v;
      
      exception = ((finalState & 0xC) != 0 ? new CancellationException("Future.cancel() was called.") : t);
      
      releaseShared(finalState);
    }
    else if (getState() == 1)
    {
      acquireShared(-1);
    }
    return doCompletion;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.AbstractFuture.Sync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */