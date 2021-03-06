package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

public class AutoCloseInputStream
  extends ProxyInputStream
{
  public AutoCloseInputStream(InputStream in)
  {
    super(in);
  }
  
  public void close()
    throws IOException
  {
    in.close();
    in = new ClosedInputStream();
  }
  
  protected void afterRead(int n)
    throws IOException
  {
    if (n == -1) {
      close();
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    close();
    super.finalize();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input.AutoCloseInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */