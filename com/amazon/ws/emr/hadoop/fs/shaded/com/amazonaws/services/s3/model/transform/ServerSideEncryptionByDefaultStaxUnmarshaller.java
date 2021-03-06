package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ServerSideEncryptionByDefault;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

class ServerSideEncryptionByDefaultStaxUnmarshaller
  implements Unmarshaller<ServerSideEncryptionByDefault, StaxUnmarshallerContext>
{
  private static final ServerSideEncryptionByDefaultStaxUnmarshaller instance = new ServerSideEncryptionByDefaultStaxUnmarshaller();
  
  public static ServerSideEncryptionByDefaultStaxUnmarshaller getInstance()
  {
    return instance;
  }
  
  public ServerSideEncryptionByDefault unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    ServerSideEncryptionByDefault sseByDefault = new ServerSideEncryptionByDefault();
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return sseByDefault;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("SSEAlgorithm", targetDepth)) {
          sseByDefault.setSSEAlgorithm(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("KMSMasterKeyID", targetDepth)) {
          sseByDefault.setKMSMasterKeyID(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth))
      {
        return sseByDefault;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.ServerSideEncryptionByDefaultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */