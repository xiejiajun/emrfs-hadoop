package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Projection;
import java.util.List;

@SdkInternalApi
public class ProjectionMarshaller
{
  private static final MarshallingInfo<String> PROJECTIONTYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProjectionType").build();
  private static final MarshallingInfo<List> NONKEYATTRIBUTES_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("NonKeyAttributes").build();
  private static final ProjectionMarshaller instance = new ProjectionMarshaller();
  
  public static ProjectionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(Projection projection, ProtocolMarshaller protocolMarshaller)
  {
    if (projection == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(projection.getProjectionType(), PROJECTIONTYPE_BINDING);
      protocolMarshaller.marshall(projection.getNonKeyAttributes(), NONKEYATTRIBUTES_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ProjectionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */