package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserPermissionsBoundaryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteUserPermissionsBoundaryRequestMarshaller
  implements Marshaller<Request<DeleteUserPermissionsBoundaryRequest>, DeleteUserPermissionsBoundaryRequest>
{
  public Request<DeleteUserPermissionsBoundaryRequest> marshall(DeleteUserPermissionsBoundaryRequest deleteUserPermissionsBoundaryRequest)
  {
    if (deleteUserPermissionsBoundaryRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteUserPermissionsBoundaryRequest> request = new DefaultRequest(deleteUserPermissionsBoundaryRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "DeleteUserPermissionsBoundary");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteUserPermissionsBoundaryRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(deleteUserPermissionsBoundaryRequest.getUserName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteUserPermissionsBoundaryRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */