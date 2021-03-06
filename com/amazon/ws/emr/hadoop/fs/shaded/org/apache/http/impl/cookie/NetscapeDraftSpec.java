package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.FormattedHeader;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Obsolete;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieOrigin;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BufferedHeader;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.ParserCursor;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.List;

@Obsolete
@Contract(threading=ThreadingBehavior.SAFE)
public class NetscapeDraftSpec
  extends CookieSpecBase
{
  protected static final String EXPIRES_PATTERN = "EEE, dd-MMM-yy HH:mm:ss z";
  
  public NetscapeDraftSpec(String[] datepatterns)
  {
    super(new CommonCookieAttributeHandler[] { new BasicPathHandler(), new NetscapeDomainHandler(), new BasicSecureHandler(), new BasicCommentHandler(), new BasicExpiresHandler(new String[] { datepatterns != null ? (String[])datepatterns.clone() : "EEE, dd-MMM-yy HH:mm:ss z" }) });
  }
  
  NetscapeDraftSpec(CommonCookieAttributeHandler... handlers)
  {
    super(handlers);
  }
  
  public NetscapeDraftSpec()
  {
    this((String[])null);
  }
  
  public List<Cookie> parse(Header header, CookieOrigin origin)
    throws MalformedCookieException
  {
    Args.notNull(header, "Header");
    Args.notNull(origin, "Cookie origin");
    if (!header.getName().equalsIgnoreCase("Set-Cookie")) {
      throw new MalformedCookieException("Unrecognized cookie header '" + header.toString() + "'");
    }
    NetscapeDraftHeaderParser parser = NetscapeDraftHeaderParser.DEFAULT;
    ParserCursor cursor;
    CharArrayBuffer buffer;
    ParserCursor cursor;
    if ((header instanceof FormattedHeader))
    {
      CharArrayBuffer buffer = ((FormattedHeader)header).getBuffer();
      cursor = new ParserCursor(((FormattedHeader)header).getValuePos(), buffer.length());
    }
    else
    {
      String s = header.getValue();
      if (s == null) {
        throw new MalformedCookieException("Header value is null");
      }
      buffer = new CharArrayBuffer(s.length());
      buffer.append(s);
      cursor = new ParserCursor(0, buffer.length());
    }
    return parse(new HeaderElement[] { parser.parseHeader(buffer, cursor) }, origin);
  }
  
  public List<Header> formatCookies(List<Cookie> cookies)
  {
    Args.notEmpty(cookies, "List of cookies");
    CharArrayBuffer buffer = new CharArrayBuffer(20 * cookies.size());
    buffer.append("Cookie");
    buffer.append(": ");
    for (int i = 0; i < cookies.size(); i++)
    {
      Cookie cookie = (Cookie)cookies.get(i);
      if (i > 0) {
        buffer.append("; ");
      }
      buffer.append(cookie.getName());
      String s = cookie.getValue();
      if (s != null)
      {
        buffer.append("=");
        buffer.append(s);
      }
    }
    List<Header> headers = new ArrayList(1);
    headers.add(new BufferedHeader(buffer));
    return headers;
  }
  
  public int getVersion()
  {
    return 0;
  }
  
  public Header getVersionHeader()
  {
    return null;
  }
  
  public String toString()
  {
    return "netscape";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.NetscapeDraftSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */