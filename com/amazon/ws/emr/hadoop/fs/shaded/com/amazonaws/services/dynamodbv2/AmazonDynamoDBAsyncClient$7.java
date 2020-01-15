package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$7
  implements Callable<DeleteItemResult>
{
  AmazonDynamoDBAsyncClient$7(AmazonDynamoDBAsyncClient this$0, DeleteItemRequest paramDeleteItemRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteItemResult call()
    throws Exception
  {
    DeleteItemResult result = null;
    try
    {
      result = this$0.executeDeleteItem(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */