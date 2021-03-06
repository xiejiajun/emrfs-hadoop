package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class DescribeGlobalTableSettingsResultJsonUnmarshaller
  implements Unmarshaller<DescribeGlobalTableSettingsResult, JsonUnmarshallerContext>
{
  private static DescribeGlobalTableSettingsResultJsonUnmarshaller instance;
  
  public DescribeGlobalTableSettingsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DescribeGlobalTableSettingsResult describeGlobalTableSettingsResult = new DescribeGlobalTableSettingsResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return describeGlobalTableSettingsResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("GlobalTableName", targetDepth))
        {
          context.nextToken();
          describeGlobalTableSettingsResult.setGlobalTableName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ReplicaSettings", targetDepth))
        {
          context.nextToken();
          describeGlobalTableSettingsResult.setReplicaSettings(new ListUnmarshaller(
            ReplicaSettingsDescriptionJsonUnmarshaller.getInstance()).unmarshall(context));
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
    return describeGlobalTableSettingsResult;
  }
  
  public static DescribeGlobalTableSettingsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DescribeGlobalTableSettingsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableSettingsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */