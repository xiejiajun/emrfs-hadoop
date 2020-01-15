package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.OperatedClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.RouteTracker;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Asserts;
import java.io.IOException;
import java.io.InterruptedIOException;

@Deprecated
public abstract class AbstractPoolEntry
{
  protected final ClientConnectionOperator connOperator;
  protected final OperatedClientConnection connection;
  protected volatile HttpRoute route;
  protected volatile Object state;
  protected volatile RouteTracker tracker;
  
  protected AbstractPoolEntry(ClientConnectionOperator connOperator, HttpRoute route)
  {
    Args.notNull(connOperator, "Connection operator");
    this.connOperator = connOperator;
    connection = connOperator.createConnection();
    this.route = route;
    tracker = null;
  }
  
  public Object getState()
  {
    return state;
  }
  
  public void setState(Object state)
  {
    this.state = state;
  }
  
  public void open(HttpRoute route, HttpContext context, HttpParams params)
    throws IOException
  {
    Args.notNull(route, "Route");
    Args.notNull(params, "HTTP parameters");
    if (tracker != null) {
      Asserts.check(!tracker.isConnected(), "Connection already open");
    }
    tracker = new RouteTracker(route);
    HttpHost proxy = route.getProxyHost();
    
    connOperator.openConnection(connection, proxy != null ? proxy : route.getTargetHost(), route.getLocalAddress(), context, params);
    
    RouteTracker localTracker = tracker;
    if (localTracker == null) {
      throw new InterruptedIOException("Request aborted");
    }
    if (proxy == null) {
      localTracker.connectTarget(connection.isSecure());
    } else {
      localTracker.connectProxy(proxy, connection.isSecure());
    }
  }
  
  public void tunnelTarget(boolean secure, HttpParams params)
    throws IOException
  {
    Args.notNull(params, "HTTP parameters");
    Asserts.notNull(tracker, "Route tracker");
    Asserts.check(tracker.isConnected(), "Connection not open");
    Asserts.check(!tracker.isTunnelled(), "Connection is already tunnelled");
    
    connection.update(null, tracker.getTargetHost(), secure, params);
    
    tracker.tunnelTarget(secure);
  }
  
  public void tunnelProxy(HttpHost next, boolean secure, HttpParams params)
    throws IOException
  {
    Args.notNull(next, "Next proxy");
    Args.notNull(params, "Parameters");
    
    Asserts.notNull(tracker, "Route tracker");
    Asserts.check(tracker.isConnected(), "Connection not open");
    
    connection.update(null, next, secure, params);
    tracker.tunnelProxy(next, secure);
  }
  
  public void layerProtocol(HttpContext context, HttpParams params)
    throws IOException
  {
    Args.notNull(params, "HTTP parameters");
    Asserts.notNull(tracker, "Route tracker");
    Asserts.check(tracker.isConnected(), "Connection not open");
    Asserts.check(tracker.isTunnelled(), "Protocol layering without a tunnel not supported");
    Asserts.check(!tracker.isLayered(), "Multiple protocol layering not supported");
    
    HttpHost target = tracker.getTargetHost();
    
    connOperator.updateSecureConnection(connection, target, context, params);
    
    tracker.layerProtocol(connection.isSecure());
  }
  
  protected void shutdownEntry()
  {
    tracker = null;
    state = null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.AbstractPoolEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */