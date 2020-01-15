package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetGroupPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetGroupPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$61
  implements Callable<GetGroupPolicyResult>
{
  AmazonIdentityManagementAsyncClient$61(AmazonIdentityManagementAsyncClient this$0, GetGroupPolicyRequest paramGetGroupPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetGroupPolicyResult call()
    throws Exception
  {
    GetGroupPolicyResult result = null;
    try
    {
      result = this$0.executeGetGroupPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.61
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */