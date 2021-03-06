package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

public enum PolicyEvaluationDecisionType
{
  Allowed("allowed"),  ExplicitDeny("explicitDeny"),  ImplicitDeny("implicitDeny");
  
  private String value;
  
  private PolicyEvaluationDecisionType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static PolicyEvaluationDecisionType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (PolicyEvaluationDecisionType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyEvaluationDecisionType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */