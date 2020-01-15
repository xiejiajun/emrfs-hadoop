package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchResult;
import java.util.concurrent.Callable;

class AmazonSQSAsyncClient$17
  implements Callable<SendMessageBatchResult>
{
  AmazonSQSAsyncClient$17(AmazonSQSAsyncClient this$0, SendMessageBatchRequest paramSendMessageBatchRequest, AsyncHandler paramAsyncHandler) {}
  
  public SendMessageBatchResult call()
    throws Exception
  {
    SendMessageBatchResult result = null;
    try
    {
      result = this$0.executeSendMessageBatch(val$finalRequest);
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
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient.17
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */