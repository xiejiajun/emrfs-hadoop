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
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListClustersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;

@SdkInternalApi
public class ListClustersRequestProtocolMarshaller
  implements Marshaller<Request<ListClustersRequest>, ListClustersRequest>
{
  private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().protocol(Protocol.AWS_JSON).requestUri("/")
    .httpMethodName(HttpMethodName.POST).hasExplicitPayloadMember(false).hasPayloadMembers(true).operationIdentifier("ElasticMapReduce.ListClusters")
    .serviceName("AmazonElasticMapReduce").build();
  private final SdkJsonProtocolFactory protocolFactory;
  
  public ListClustersRequestProtocolMarshaller(SdkJsonProtocolFactory protocolFactory)
  {
    this.protocolFactory = protocolFactory;
  }
  
  public Request<ListClustersRequest> marshall(ListClustersRequest listClustersRequest)
  {
    if (listClustersRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      ProtocolRequestMarshaller<ListClustersRequest> protocolMarshaller = protocolFactory.createProtocolMarshaller(SDK_OPERATION_BINDING, listClustersRequest);
      
      protocolMarshaller.startMarshalling();
      ListClustersRequestMarshaller.getInstance().marshall(listClustersRequest, protocolMarshaller);
      return protocolMarshaller.finishMarshalling();
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListClustersRequestProtocolMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */