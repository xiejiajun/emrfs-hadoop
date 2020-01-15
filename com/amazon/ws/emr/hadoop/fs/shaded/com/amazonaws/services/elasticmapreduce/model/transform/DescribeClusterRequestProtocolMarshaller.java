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
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeClusterRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;

@SdkInternalApi
public class DescribeClusterRequestProtocolMarshaller
  implements Marshaller<Request<DescribeClusterRequest>, DescribeClusterRequest>
{
  private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().protocol(Protocol.AWS_JSON).requestUri("/")
    .httpMethodName(HttpMethodName.POST).hasExplicitPayloadMember(false).hasPayloadMembers(true)
    .operationIdentifier("ElasticMapReduce.DescribeCluster").serviceName("AmazonElasticMapReduce").build();
  private final SdkJsonProtocolFactory protocolFactory;
  
  public DescribeClusterRequestProtocolMarshaller(SdkJsonProtocolFactory protocolFactory)
  {
    this.protocolFactory = protocolFactory;
  }
  
  public Request<DescribeClusterRequest> marshall(DescribeClusterRequest describeClusterRequest)
  {
    if (describeClusterRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      ProtocolRequestMarshaller<DescribeClusterRequest> protocolMarshaller = protocolFactory.createProtocolMarshaller(SDK_OPERATION_BINDING, describeClusterRequest);
      
      protocolMarshaller.startMarshalling();
      DescribeClusterRequestMarshaller.getInstance().marshall(describeClusterRequest, protocolMarshaller);
      return protocolMarshaller.finishMarshalling();
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.DescribeClusterRequestProtocolMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */