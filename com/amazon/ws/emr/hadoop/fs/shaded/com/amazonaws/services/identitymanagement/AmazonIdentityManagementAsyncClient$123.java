package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UntagUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UntagUserResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$123
  implements Callable<UntagUserResult>
{
  AmazonIdentityManagementAsyncClient$123(AmazonIdentityManagementAsyncClient this$0, UntagUserRequest paramUntagUserRequest, AsyncHandler paramAsyncHandler) {}
  
  public UntagUserResult call()
    throws Exception
  {
    UntagUserResult result = null;
    try
    {
      result = this$0.executeUntagUser(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.123
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */