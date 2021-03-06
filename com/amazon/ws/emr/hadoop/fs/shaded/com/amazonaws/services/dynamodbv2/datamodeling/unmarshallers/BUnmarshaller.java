package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;

abstract class BUnmarshaller
  implements ArgumentUnmarshaller
{
  public void typeCheck(AttributeValue value, Method setter)
  {
    if (value.getB() == null) {
      throw new DynamoDBMappingException("Expected B in value " + value + " when invoking " + setter);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.BUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */