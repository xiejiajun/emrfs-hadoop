package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.OperationInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.OperationInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.Protocol;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolRequestMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.SdkJsonProtocolFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;

@SdkInternalApi
public class DescribeGlobalTableRequestProtocolMarshaller
  implements Marshaller<Request<DescribeGlobalTableRequest>, DescribeGlobalTableRequest>
{
  private static final OperationInfo SDK_OPERATION_BINDING = OperationInfo.builder().protocol(Protocol.AWS_JSON).requestUri("/")
    .httpMethodName(HttpMethodName.POST).hasExplicitPayloadMember(false).hasPayloadMembers(true)
    .operationIdentifier("DynamoDB_20120810.DescribeGlobalTable").serviceName("AmazonDynamoDBv2").build();
  private final SdkJsonProtocolFactory protocolFactory;
  
  public DescribeGlobalTableRequestProtocolMarshaller(SdkJsonProtocolFactory protocolFactory)
  {
    this.protocolFactory = protocolFactory;
  }
  
  public Request<DescribeGlobalTableRequest> marshall(DescribeGlobalTableRequest describeGlobalTableRequest)
  {
    if (describeGlobalTableRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      ProtocolRequestMarshaller<DescribeGlobalTableRequest> protocolMarshaller = protocolFactory.createProtocolMarshaller(SDK_OPERATION_BINDING, describeGlobalTableRequest);
      
      protocolMarshaller.startMarshalling();
      DescribeGlobalTableRequestMarshaller.getInstance().marshall(describeGlobalTableRequest, protocolMarshaller);
      return protocolMarshaller.finishMarshalling();
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableRequestProtocolMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */