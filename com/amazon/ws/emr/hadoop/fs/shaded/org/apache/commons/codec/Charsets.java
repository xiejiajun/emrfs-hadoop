package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec;

import java.nio.charset.Charset;

public class Charsets
{
  public static Charset toCharset(Charset charset)
  {
    return charset == null ? Charset.defaultCharset() : charset;
  }
  
  public static Charset toCharset(String charset)
  {
    return charset == null ? Charset.defaultCharset() : Charset.forName(charset);
  }
  
  @Deprecated
  public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
  @Deprecated
  public static final Charset US_ASCII = Charset.forName("US-ASCII");
  @Deprecated
  public static final Charset UTF_16 = Charset.forName("UTF-16");
  @Deprecated
  public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
  @Deprecated
  public static final Charset UTF_16LE = Charset.forName("UTF-16LE");
  @Deprecated
  public static final Charset UTF_8 = Charset.forName("UTF-8");
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.Charsets
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */