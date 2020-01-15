package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.EbsBlockDevice;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class EbsBlockDeviceJsonUnmarshaller
  implements Unmarshaller<EbsBlockDevice, JsonUnmarshallerContext>
{
  private static EbsBlockDeviceJsonUnmarshaller instance;
  
  public EbsBlockDevice unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    EbsBlockDevice ebsBlockDevice = new EbsBlockDevice();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return null;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("VolumeSpecification", targetDepth))
        {
          context.nextToken();
          ebsBlockDevice.setVolumeSpecification(VolumeSpecificationJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Device", targetDepth))
        {
          context.nextToken();
          ebsBlockDevice.setDevice((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
      }
      else
      {
        if (((token == JsonToken.END_ARRAY) || (token == JsonToken.END_OBJECT)) && 
          ((context.getLastParsedParentElement() == null) || (context.getLastParsedParentElement().equals(currentParentElement))) && 
          (context.getCurrentDepth() <= originalDepth)) {
          break;
        }
      }
      token = context.nextToken();
    }
    return ebsBlockDevice;
  }
  
  public static EbsBlockDeviceJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new EbsBlockDeviceJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.EbsBlockDeviceJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */