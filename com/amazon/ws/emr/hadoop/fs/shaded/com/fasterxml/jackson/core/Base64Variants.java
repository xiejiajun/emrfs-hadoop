package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

public final class Base64Variants
{
  static final String STD_BASE64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
  public static final Base64Variant MIME = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
  public static final Base64Variant MIME_NO_LINEFEEDS = new Base64Variant(MIME, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
  public static final Base64Variant PEM = new Base64Variant(MIME, "PEM", true, '=', 64);
  public static final Base64Variant MODIFIED_FOR_URL;
  
  static
  {
    StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
    
    sb.setCharAt(sb.indexOf("+"), '-');
    sb.setCharAt(sb.indexOf("/"), '_');
    
    MODIFIED_FOR_URL = new Base64Variant("MODIFIED-FOR-URL", sb.toString(), false, '\000', Integer.MAX_VALUE);
  }
  
  public static Base64Variant getDefaultVariant()
  {
    return MIME_NO_LINEFEEDS;
  }
  
  public static Base64Variant valueOf(String name)
    throws IllegalArgumentException
  {
    if (MIME_name.equals(name)) {
      return MIME;
    }
    if (MIME_NO_LINEFEEDS_name.equals(name)) {
      return MIME_NO_LINEFEEDS;
    }
    if (PEM_name.equals(name)) {
      return PEM;
    }
    if (MODIFIED_FOR_URL_name.equals(name)) {
      return MODIFIED_FOR_URL;
    }
    if (name == null) {
      name = "<null>";
    } else {
      name = "'" + name + "'";
    }
    throw new IllegalArgumentException("No Base64Variant with name " + name);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variants
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */