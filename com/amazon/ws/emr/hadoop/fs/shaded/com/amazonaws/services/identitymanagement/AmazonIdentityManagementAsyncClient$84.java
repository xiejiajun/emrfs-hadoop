package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListGroupPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListGroupPoliciesResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$84
  implements Callable<ListGroupPoliciesResult>
{
  AmazonIdentityManagementAsyncClient$84(AmazonIdentityManagementAsyncClient this$0, ListGroupPoliciesRequest paramListGroupPoliciesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListGroupPoliciesResult call()
    throws Exception
  {
    ListGroupPoliciesResult result = null;
    try
    {
      result = this$0.executeListGroupPolicies(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.84
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */