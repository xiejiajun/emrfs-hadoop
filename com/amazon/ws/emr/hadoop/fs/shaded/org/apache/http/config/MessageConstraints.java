package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

public class MessageConstraints
  implements Cloneable
{
  public static final MessageConstraints DEFAULT = new Builder().build();
  private final int maxLineLength;
  private final int maxHeaderCount;
  
  MessageConstraints(int maxLineLength, int maxHeaderCount)
  {
    this.maxLineLength = maxLineLength;
    this.maxHeaderCount = maxHeaderCount;
  }
  
  public int getMaxLineLength()
  {
    return maxLineLength;
  }
  
  public int getMaxHeaderCount()
  {
    return maxHeaderCount;
  }
  
  protected MessageConstraints clone()
    throws CloneNotSupportedException
  {
    return (MessageConstraints)super.clone();
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append("[maxLineLength=").append(maxLineLength).append(", maxHeaderCount=").append(maxHeaderCount).append("]");
    
    return builder.toString();
  }
  
  public static MessageConstraints lineLen(int max)
  {
    return new MessageConstraints(Args.notNegative(max, "Max line length"), -1);
  }
  
  public static Builder custom()
  {
    return new Builder();
  }
  
  public static Builder copy(MessageConstraints config)
  {
    Args.notNull(config, "Message constraints");
    return new Builder().setMaxHeaderCount(config.getMaxHeaderCount()).setMaxLineLength(config.getMaxLineLength());
  }
  
  public static class Builder
  {
    private int maxLineLength;
    private int maxHeaderCount;
    
    Builder()
    {
      maxLineLength = -1;
      maxHeaderCount = -1;
    }
    
    public Builder setMaxLineLength(int maxLineLength)
    {
      this.maxLineLength = maxLineLength;
      return this;
    }
    
    public Builder setMaxHeaderCount(int maxHeaderCount)
    {
      this.maxHeaderCount = maxHeaderCount;
      return this;
    }
    
    public MessageConstraints build()
    {
      return new MessageConstraints(maxLineLength, maxHeaderCount);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.MessageConstraints
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */