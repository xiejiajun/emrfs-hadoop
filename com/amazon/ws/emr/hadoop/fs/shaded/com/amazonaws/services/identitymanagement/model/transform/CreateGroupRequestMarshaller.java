package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class CreateGroupRequestMarshaller
  implements Marshaller<Request<CreateGroupRequest>, CreateGroupRequest>
{
  public Request<CreateGroupRequest> marshall(CreateGroupRequest createGroupRequest)
  {
    if (createGroupRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<CreateGroupRequest> request = new DefaultRequest(createGroupRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "CreateGroup");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (createGroupRequest.getPath() != null) {
      request.addParameter("Path", StringUtils.fromString(createGroupRequest.getPath()));
    }
    if (createGroupRequest.getGroupName() != null) {
      request.addParameter("GroupName", StringUtils.fromString(createGroupRequest.getGroupName()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateGroupRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */