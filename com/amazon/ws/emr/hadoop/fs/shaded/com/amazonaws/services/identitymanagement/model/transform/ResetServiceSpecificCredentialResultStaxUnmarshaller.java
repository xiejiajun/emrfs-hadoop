package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ResetServiceSpecificCredentialResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class ResetServiceSpecificCredentialResultStaxUnmarshaller
  implements Unmarshaller<ResetServiceSpecificCredentialResult, StaxUnmarshallerContext>
{
  private static ResetServiceSpecificCredentialResultStaxUnmarshaller instance;
  
  public ResetServiceSpecificCredentialResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ResetServiceSpecificCredentialResult resetServiceSpecificCredentialResult = new ResetServiceSpecificCredentialResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return resetServiceSpecificCredentialResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("ServiceSpecificCredential", targetDepth)) {
          resetServiceSpecificCredentialResult.setServiceSpecificCredential(ServiceSpecificCredentialStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return resetServiceSpecificCredentialResult;
      }
    }
  }
  
  public static ResetServiceSpecificCredentialResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ResetServiceSpecificCredentialResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ResetServiceSpecificCredentialResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */