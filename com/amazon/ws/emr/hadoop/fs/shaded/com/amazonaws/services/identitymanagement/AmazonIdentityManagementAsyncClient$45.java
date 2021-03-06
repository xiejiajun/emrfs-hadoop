package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteVirtualMFADeviceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteVirtualMFADeviceResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$45
  implements Callable<DeleteVirtualMFADeviceResult>
{
  AmazonIdentityManagementAsyncClient$45(AmazonIdentityManagementAsyncClient this$0, DeleteVirtualMFADeviceRequest paramDeleteVirtualMFADeviceRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteVirtualMFADeviceResult call()
    throws Exception
  {
    DeleteVirtualMFADeviceResult result = null;
    try
    {
      result = this$0.executeDeleteVirtualMFADevice(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.45
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */