package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListOpenIDConnectProvidersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListOpenIDConnectProvidersResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$90
  implements Callable<ListOpenIDConnectProvidersResult>
{
  AmazonIdentityManagementAsyncClient$90(AmazonIdentityManagementAsyncClient this$0, ListOpenIDConnectProvidersRequest paramListOpenIDConnectProvidersRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListOpenIDConnectProvidersResult call()
    throws Exception
  {
    ListOpenIDConnectProvidersResult result = null;
    try
    {
      result = this$0.executeListOpenIDConnectProviders(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.90
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */