package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteGroupPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteGroupPolicyResultStaxUnmarshaller
  implements Unmarshaller<DeleteGroupPolicyResult, StaxUnmarshallerContext>
{
  private static DeleteGroupPolicyResultStaxUnmarshaller instance;
  
  public DeleteGroupPolicyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteGroupPolicyResult deleteGroupPolicyResult = new DeleteGroupPolicyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteGroupPolicyResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteGroupPolicyResult;
        }
      }
    }
  }
  
  public static DeleteGroupPolicyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteGroupPolicyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteGroupPolicyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */