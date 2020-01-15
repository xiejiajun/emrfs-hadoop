package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Endpoint;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class EndpointJsonUnmarshaller
  implements Unmarshaller<Endpoint, JsonUnmarshallerContext>
{
  private static EndpointJsonUnmarshaller instance;
  
  public Endpoint unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    Endpoint endpoint = new Endpoint();
    
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
        if (context.testExpression("Address", targetDepth))
        {
          context.nextToken();
          endpoint.setAddress((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CachePeriodInMinutes", targetDepth))
        {
          context.nextToken();
          endpoint.setCachePeriodInMinutes((Long)context.getUnmarshaller(Long.class).unmarshall(context));
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
    return endpoint;
  }
  
  public static EndpointJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new EndpointJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.EndpointJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */