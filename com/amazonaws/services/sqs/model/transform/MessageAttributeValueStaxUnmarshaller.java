package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.ByteBufferStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import java.nio.ByteBuffer;
import javax.xml.stream.events.XMLEvent;

public class MessageAttributeValueStaxUnmarshaller
  implements Unmarshaller<MessageAttributeValue, StaxUnmarshallerContext>
{
  private static MessageAttributeValueStaxUnmarshaller instance;
  
  public MessageAttributeValue unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    MessageAttributeValue messageAttributeValue = new MessageAttributeValue();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return messageAttributeValue;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("StringValue", targetDepth)) {
          messageAttributeValue.setStringValue(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("BinaryValue", targetDepth)) {
          messageAttributeValue.setBinaryValue(SimpleTypeStaxUnmarshallers.ByteBufferStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("StringListValue", targetDepth)) {
          messageAttributeValue.withStringListValues(new String[] { SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("BinaryListValue", targetDepth)) {
          messageAttributeValue.withBinaryListValues(new ByteBuffer[] { SimpleTypeStaxUnmarshallers.ByteBufferStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("DataType", targetDepth)) {
          messageAttributeValue.setDataType(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return messageAttributeValue;
      }
    }
  }
  
  public static MessageAttributeValueStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new MessageAttributeValueStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.MessageAttributeValueStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */