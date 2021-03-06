package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleetTimeline;
import java.util.Date;

@SdkInternalApi
public class InstanceFleetTimelineMarshaller
{
  private static final MarshallingInfo<Date> CREATIONDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreationDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> READYDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReadyDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> ENDDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EndDateTime").timestampFormat("unixTimestamp").build();
  private static final InstanceFleetTimelineMarshaller instance = new InstanceFleetTimelineMarshaller();
  
  public static InstanceFleetTimelineMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(InstanceFleetTimeline instanceFleetTimeline, ProtocolMarshaller protocolMarshaller)
  {
    if (instanceFleetTimeline == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(instanceFleetTimeline.getCreationDateTime(), CREATIONDATETIME_BINDING);
      protocolMarshaller.marshall(instanceFleetTimeline.getReadyDateTime(), READYDATETIME_BINDING);
      protocolMarshaller.marshall(instanceFleetTimeline.getEndDateTime(), ENDDATETIME_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceFleetTimelineMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */