package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreatePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class CreatePolicyRequestMarshaller
  implements Marshaller<Request<CreatePolicyRequest>, CreatePolicyRequest>
{
  public Request<CreatePolicyRequest> marshall(CreatePolicyRequest createPolicyRequest)
  {
    if (createPolicyRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<CreatePolicyRequest> request = new DefaultRequest(createPolicyRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "CreatePolicy");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (createPolicyRequest.getPolicyName() != null) {
      request.addParameter("PolicyName", StringUtils.fromString(createPolicyRequest.getPolicyName()));
    }
    if (createPolicyRequest.getPath() != null) {
      request.addParameter("Path", StringUtils.fromString(createPolicyRequest.getPath()));
    }
    if (createPolicyRequest.getPolicyDocument() != null) {
      request.addParameter("PolicyDocument", StringUtils.fromString(createPolicyRequest.getPolicyDocument()));
    }
    if (createPolicyRequest.getDescription() != null) {
      request.addParameter("Description", StringUtils.fromString(createPolicyRequest.getDescription()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreatePolicyRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */