package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

public enum DataKeySpec
{
  AES_256("AES_256"),  AES_128("AES_128");
  
  private String value;
  
  private DataKeySpec(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static DataKeySpec fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (DataKeySpec enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DataKeySpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */