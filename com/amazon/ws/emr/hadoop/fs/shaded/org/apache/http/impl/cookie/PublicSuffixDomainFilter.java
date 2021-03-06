package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.util.PublicSuffixList;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.util.PublicSuffixMatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CommonCookieAttributeHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.Cookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.CookieOrigin;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.MalformedCookieException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.SetCookie;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class PublicSuffixDomainFilter
  implements CommonCookieAttributeHandler
{
  private final CommonCookieAttributeHandler handler;
  private final PublicSuffixMatcher publicSuffixMatcher;
  private final Map<String, Boolean> localDomainMap;
  
  private static Map<String, Boolean> createLocalDomainMap()
  {
    ConcurrentHashMap<String, Boolean> map = new ConcurrentHashMap();
    map.put(".localhost.", Boolean.TRUE);
    map.put(".test.", Boolean.TRUE);
    map.put(".local.", Boolean.TRUE);
    map.put(".local", Boolean.TRUE);
    map.put(".localdomain", Boolean.TRUE);
    return map;
  }
  
  public PublicSuffixDomainFilter(CommonCookieAttributeHandler handler, PublicSuffixMatcher publicSuffixMatcher)
  {
    this.handler = ((CommonCookieAttributeHandler)Args.notNull(handler, "Cookie handler"));
    this.publicSuffixMatcher = ((PublicSuffixMatcher)Args.notNull(publicSuffixMatcher, "Public suffix matcher"));
    localDomainMap = createLocalDomainMap();
  }
  
  public PublicSuffixDomainFilter(CommonCookieAttributeHandler handler, PublicSuffixList suffixList)
  {
    Args.notNull(handler, "Cookie handler");
    Args.notNull(suffixList, "Public suffix list");
    this.handler = handler;
    publicSuffixMatcher = new PublicSuffixMatcher(suffixList.getRules(), suffixList.getExceptions());
    localDomainMap = createLocalDomainMap();
  }
  
  public boolean match(Cookie cookie, CookieOrigin origin)
  {
    String host = cookie.getDomain();
    int i = host.indexOf('.');
    if (i >= 0)
    {
      String domain = host.substring(i);
      if ((!localDomainMap.containsKey(domain)) && 
        (publicSuffixMatcher.matches(host))) {
        return false;
      }
    }
    else if ((!host.equalsIgnoreCase(origin.getHost())) && 
      (publicSuffixMatcher.matches(host)))
    {
      return false;
    }
    return handler.match(cookie, origin);
  }
  
  public void parse(SetCookie cookie, String value)
    throws MalformedCookieException
  {
    handler.parse(cookie, value);
  }
  
  public void validate(Cookie cookie, CookieOrigin origin)
    throws MalformedCookieException
  {
    handler.validate(cookie, origin);
  }
  
  public String getAttributeName()
  {
    return handler.getAttributeName();
  }
  
  public static CommonCookieAttributeHandler decorate(CommonCookieAttributeHandler handler, PublicSuffixMatcher publicSuffixMatcher)
  {
    Args.notNull(handler, "Cookie attribute handler");
    return publicSuffixMatcher != null ? new PublicSuffixDomainFilter(handler, publicSuffixMatcher) : handler;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.cookie.PublicSuffixDomainFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */