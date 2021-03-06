package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.OperationInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.OperationInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.Protocol;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkJsonProtocolFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListSecurityConfigurationsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;

@SdkInternalApi
public class ListSecurityConfigurationsRequestProtocolMarshaller
  implements Marshaller<Request<ListSecurityConfigurationsRequest>, ListSecurityConfigurationsRequest>
{
  private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().protocol(Protocol.AWS_JSON).requestUri("/")
    .httpMethodName(HttpMethodName.POST).hasExplicitPayloadMember(false).hasPayloadMembers(true)
    .operationIdentifier("ElasticMapReduce.ListSecurityConfigurations").serviceName("AmazonElasticMapReduce").build();
  private final SdkJsonProtocolFactory protocolFactory;
  
  public ListSecurityConfigurationsRequestProtocolMarshaller(SdkJsonProtocolFactory protocolFactory)
  {
    this.protocolFactory = protocolFactory;
  }
  
  public Request<ListSecurityConfigurationsRequest> marshall(ListSecurityConfigurationsRequest listSecurityConfigurationsRequest)
  {
    if (listSecurityConfigurationsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      ProtocolRequestMarshaller<ListSecurityConfigurationsRequest> protocolMarshaller = protocolFactory.createProtocolMarshaller(SDK_OPERATION_BINDING, listSecurityConfigurationsRequest);
      
      protocolMarshaller.startMarshalling();
      ListSecurityConfigurationsRequestMarshaller.getInstance().marshall(listSecurityConfigurationsRequest, protocolMarshaller);
      return protocolMarshaller.finishMarshalling();
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListSecurityConfigurationsRequestProtocolMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */