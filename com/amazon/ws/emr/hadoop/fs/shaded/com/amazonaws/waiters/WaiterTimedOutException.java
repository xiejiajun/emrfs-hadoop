package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;

public class WaiterTimedOutException
  extends SdkClientException
{
  public WaiterTimedOutException(String message)
  {
    super(message);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterTimedOutException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */