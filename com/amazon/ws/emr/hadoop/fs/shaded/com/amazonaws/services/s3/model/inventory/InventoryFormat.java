package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory;

public enum InventoryFormat
{
  CSV("CSV"),  ORC("ORC"),  Parquet("Parquet");
  
  private final String format;
  
  private InventoryFormat(String format)
  {
    this.format = format;
  }
  
  public String toString()
  {
    return format;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryFormat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */