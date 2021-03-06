package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayEntity
  extends AbstractHttpEntity
  implements Cloneable
{
  @Deprecated
  protected final byte[] content;
  private final byte[] b;
  private final int off;
  private final int len;
  
  public ByteArrayEntity(byte[] b, ContentType contentType)
  {
    Args.notNull(b, "Source byte array");
    content = b;
    this.b = b;
    off = 0;
    len = this.b.length;
    if (contentType != null) {
      setContentType(contentType.toString());
    }
  }
  
  public ByteArrayEntity(byte[] b, int off, int len, ContentType contentType)
  {
    Args.notNull(b, "Source byte array");
    if ((off < 0) || (off > b.length) || (len < 0) || (off + len < 0) || (off + len > b.length)) {
      throw new IndexOutOfBoundsException("off: " + off + " len: " + len + " b.length: " + b.length);
    }
    content = b;
    this.b = b;
    this.off = off;
    this.len = len;
    if (contentType != null) {
      setContentType(contentType.toString());
    }
  }
  
  public ByteArrayEntity(byte[] b)
  {
    this(b, null);
  }
  
  public ByteArrayEntity(byte[] b, int off, int len)
  {
    this(b, off, len, null);
  }
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public long getContentLength()
  {
    return len;
  }
  
  public InputStream getContent()
  {
    return new ByteArrayInputStream(b, off, len);
  }
  
  public void writeTo(OutputStream outstream)
    throws IOException
  {
    Args.notNull(outstream, "Output stream");
    outstream.write(b, off, len);
    outstream.flush();
  }
  
  public boolean isStreaming()
  {
    return false;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ByteArrayEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */