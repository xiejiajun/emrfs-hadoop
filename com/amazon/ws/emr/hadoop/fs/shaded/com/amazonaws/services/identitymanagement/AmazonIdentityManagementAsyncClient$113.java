package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveUserFromGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveUserFromGroupResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$113
  implements Callable<RemoveUserFromGroupResult>
{
  AmazonIdentityManagementAsyncClient$113(AmazonIdentityManagementAsyncClient this$0, RemoveUserFromGroupRequest paramRemoveUserFromGroupRequest, AsyncHandler paramAsyncHandler) {}
  
  public RemoveUserFromGroupResult call()
    throws Exception
  {
    RemoveUserFromGroupResult result = null;
    try
    {
      result = this$0.executeRemoveUserFromGroup(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.113
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */