package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteLoginProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class DeleteLoginProfileRequestMarshaller
  implements Marshaller<Request<DeleteLoginProfileRequest>, DeleteLoginProfileRequest>
{
  public Request<DeleteLoginProfileRequest> marshall(DeleteLoginProfileRequest deleteLoginProfileRequest)
  {
    if (deleteLoginProfileRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteLoginProfileRequest> request = new DefaultRequest(deleteLoginProfileRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "DeleteLoginProfile");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteLoginProfileRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(deleteLoginProfileRequest.getUserName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteLoginProfileRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */