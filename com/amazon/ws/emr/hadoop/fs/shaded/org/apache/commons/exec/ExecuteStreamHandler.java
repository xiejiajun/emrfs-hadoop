package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface ExecuteStreamHandler
{
  public abstract void setProcessInputStream(OutputStream paramOutputStream)
    throws IOException;
  
  public abstract void setProcessErrorStream(InputStream paramInputStream)
    throws IOException;
  
  public abstract void setProcessOutputStream(InputStream paramInputStream)
    throws IOException;
  
  public abstract void start()
    throws IOException;
  
  public abstract void stop()
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.ExecuteStreamHandler
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */