package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeEndpointsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeEndpointsResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$11
  implements Callable<DescribeEndpointsResult>
{
  AmazonDynamoDBAsyncClient$11(AmazonDynamoDBAsyncClient this$0, DescribeEndpointsRequest paramDescribeEndpointsRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeEndpointsResult call()
    throws Exception
  {
    DescribeEndpointsResult result = null;
    try
    {
      result = this$0.executeDescribeEndpoints(val$finalRequest);
    }
    catch (Exception ex)
    {
      if (val$asyncHandler != null) {
        val$asyncHandler.onError(ex);
      }
      throw ex;
    }
    if (val$asyncHandler != null) {
      val$asyncHandler.onSuccess(val$finalRequest, result);
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */