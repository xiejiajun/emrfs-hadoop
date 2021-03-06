package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteGroupResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$26
  implements Callable<DeleteGroupResult>
{
  AmazonIdentityManagementAsyncClient$26(AmazonIdentityManagementAsyncClient this$0, DeleteGroupRequest paramDeleteGroupRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteGroupResult call()
    throws Exception
  {
    DeleteGroupResult result = null;
    try
    {
      result = this$0.executeDeleteGroup(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.26
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */