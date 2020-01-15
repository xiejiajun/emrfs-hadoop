package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3;

public class NotImplementedException
  extends UnsupportedOperationException
{
  private static final long serialVersionUID = 20131021L;
  private final String code;
  
  public NotImplementedException(String message)
  {
    this(message, (String)null);
  }
  
  public NotImplementedException(Throwable cause)
  {
    this(cause, null);
  }
  
  public NotImplementedException(String message, Throwable cause)
  {
    this(message, cause, null);
  }
  
  public NotImplementedException(String message, String code)
  {
    super(message);
    this.code = code;
  }
  
  public NotImplementedException(Throwable cause, String code)
  {
    super(cause);
    this.code = code;
  }
  
  public NotImplementedException(String message, Throwable cause, String code)
  {
    super(message, cause);
    this.code = code;
  }
  
  public String getCode()
  {
    return code;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.NotImplementedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */