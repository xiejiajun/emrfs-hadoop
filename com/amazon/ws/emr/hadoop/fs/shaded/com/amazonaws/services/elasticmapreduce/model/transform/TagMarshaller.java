package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Tag;

@SdkInternalApi
public class TagMarshaller
{
  private static final MarshallingInfo<String> KEY_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Key").build();
  private static final MarshallingInfo<String> VALUE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Value").build();
  private static final TagMarshaller instance = new TagMarshaller();
  
  public static TagMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(Tag tag, ProtocolMarshaller protocolMarshaller)
  {
    if (tag == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(tag.getKey(), KEY_BINDING);
      protocolMarshaller.marshall(tag.getValue(), VALUE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.TagMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */