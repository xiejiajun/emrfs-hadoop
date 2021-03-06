package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UntagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UntagResourceResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$38
  implements Callable<UntagResourceResult>
{
  AWSKMSAsyncClient$38(AWSKMSAsyncClient this$0, UntagResourceRequest paramUntagResourceRequest, AsyncHandler paramAsyncHandler) {}
  
  public UntagResourceResult call()
    throws Exception
  {
    UntagResourceResult result = null;
    try
    {
      result = this$0.executeUntagResource(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.38
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */