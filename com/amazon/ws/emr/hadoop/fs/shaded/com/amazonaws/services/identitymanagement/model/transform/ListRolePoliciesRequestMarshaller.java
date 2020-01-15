package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListRolePoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListRolePoliciesRequestMarshaller
  implements Marshaller<Request<ListRolePoliciesRequest>, ListRolePoliciesRequest>
{
  public Request<ListRolePoliciesRequest> marshall(ListRolePoliciesRequest listRolePoliciesRequest)
  {
    if (listRolePoliciesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListRolePoliciesRequest> request = new DefaultRequest(listRolePoliciesRequest, "AmazonIdentityManagement");
    request.addParameter("Action", "ListRolePolicies");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listRolePoliciesRequest.getRoleName() != null) {
      request.addParameter("RoleName", StringUtils.fromString(listRolePoliciesRequest.getRoleName()));
    }
    if (listRolePoliciesRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listRolePoliciesRequest.getMarker()));
    }
    if (listRolePoliciesRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listRolePoliciesRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListRolePoliciesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */