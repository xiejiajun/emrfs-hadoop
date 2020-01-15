package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging;

public class LogConfigurationException
  extends RuntimeException
{
  private static final long serialVersionUID = 8486587136871052495L;
  
  public LogConfigurationException() {}
  
  public LogConfigurationException(String message)
  {
    super(message);
  }
  
  public LogConfigurationException(Throwable cause)
  {
    this(cause == null ? null : cause.toString(), cause);
  }
  
  public LogConfigurationException(String message, Throwable cause)
  {
    super(message + " (Caused by " + cause + ")");
    this.cause = cause;
  }
  
  protected Throwable cause = null;
  
  public Throwable getCause()
  {
    return cause;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogConfigurationException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */