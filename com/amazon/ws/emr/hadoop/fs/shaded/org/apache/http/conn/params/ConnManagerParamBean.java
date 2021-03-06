package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.params;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpAbstractParamBean;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;

@Deprecated
public class ConnManagerParamBean
  extends HttpAbstractParamBean
{
  public ConnManagerParamBean(HttpParams params)
  {
    super(params);
  }
  
  public void setTimeout(long timeout)
  {
    params.setLongParameter("http.conn-manager.timeout", timeout);
  }
  
  public void setMaxTotalConnections(int maxConnections)
  {
    params.setIntParameter("http.conn-manager.max-total", maxConnections);
  }
  
  public void setConnectionsPerRoute(ConnPerRouteBean connPerRoute)
  {
    params.setParameter("http.conn-manager.max-per-route", connPerRoute);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.params.ConnManagerParamBean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */