package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSigningCertificatesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListSigningCertificatesRequestMarshaller
  implements Marshaller<Request<ListSigningCertificatesRequest>, ListSigningCertificatesRequest>
{
  public Request<ListSigningCertificatesRequest> marshall(ListSigningCertificatesRequest listSigningCertificatesRequest)
  {
    if (listSigningCertificatesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListSigningCertificatesRequest> request = new DefaultRequest(listSigningCertificatesRequest, "AmazonIdentityManagement");
    
    request.addParameter("Action", "ListSigningCertificates");
    request.addParameter("Version", "2010-05-08");
    request.setHttpMethod(HttpMethodName.POST);
    if (listSigningCertificatesRequest.getUserName() != null) {
      request.addParameter("UserName", StringUtils.fromString(listSigningCertificatesRequest.getUserName()));
    }
    if (listSigningCertificatesRequest.getMarker() != null) {
      request.addParameter("Marker", StringUtils.fromString(listSigningCertificatesRequest.getMarker()));
    }
    if (listSigningCertificatesRequest.getMaxItems() != null) {
      request.addParameter("MaxItems", StringUtils.fromInteger(listSigningCertificatesRequest.getMaxItems()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListSigningCertificatesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */