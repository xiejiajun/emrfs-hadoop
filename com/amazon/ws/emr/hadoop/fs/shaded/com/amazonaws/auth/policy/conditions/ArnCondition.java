package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.conditions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Condition;
import java.util.Arrays;

public class ArnCondition
  extends Condition
{
  public static enum ArnComparisonType
  {
    ArnEquals,  ArnLike,  ArnNotEquals,  ArnNotLike;
    
    private ArnComparisonType() {}
  }
  
  public ArnCondition(ArnComparisonType type, String key, String value)
  {
    this.type = type.toString();
    conditionKey = key;
    values = Arrays.asList(new String[] { value });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.conditions.ArnCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */