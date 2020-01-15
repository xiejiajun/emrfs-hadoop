package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AutoScalingPolicyStatus;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class AutoScalingPolicyStatusJsonUnmarshaller
  implements Unmarshaller<AutoScalingPolicyStatus, JsonUnmarshallerContext>
{
  private static AutoScalingPolicyStatusJsonUnmarshaller instance;
  
  public AutoScalingPolicyStatus unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AutoScalingPolicyStatus autoScalingPolicyStatus = new AutoScalingPolicyStatus();
    
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
        if (context.testExpression("State", targetDepth))
        {
          context.nextToken();
          autoScalingPolicyStatus.setState((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("StateChangeReason", targetDepth))
        {
          context.nextToken();
          autoScalingPolicyStatus.setStateChangeReason(AutoScalingPolicyStateChangeReasonJsonUnmarshaller.getInstance().unmarshall(context));
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
    return autoScalingPolicyStatus;
  }
  
  public static AutoScalingPolicyStatusJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AutoScalingPolicyStatusJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AutoScalingPolicyStatusJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */