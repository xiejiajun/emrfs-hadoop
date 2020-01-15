package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpConnectionMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.OperatedClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@Deprecated
public abstract class AbstractClientConnAdapter
  implements ManagedClientConnection, HttpContext
{
  private final ClientConnectionManager connManager;
  private volatile OperatedClientConnection wrappedConnection;
  private volatile boolean markedReusable;
  private volatile boolean released;
  private volatile long duration;
  
  protected AbstractClientConnAdapter(ClientConnectionManager mgr, OperatedClientConnection conn)
  {
    connManager = mgr;
    wrappedConnection = conn;
    markedReusable = false;
    released = false;
    duration = Long.MAX_VALUE;
  }
  
  protected synchronized void detach()
  {
    wrappedConnection = null;
    duration = Long.MAX_VALUE;
  }
  
  protected OperatedClientConnection getWrappedConnection()
  {
    return wrappedConnection;
  }
  
  protected ClientConnectionManager getManager()
  {
    return connManager;
  }
  
  @Deprecated
  protected final void assertNotAborted()
    throws InterruptedIOException
  {
    if (isReleased()) {
      throw new InterruptedIOException("Connection has been shut down");
    }
  }
  
  protected boolean isReleased()
  {
    return released;
  }
  
  protected final void assertValid(OperatedClientConnection wrappedConn)
    throws ConnectionShutdownException
  {
    if ((isReleased()) || (wrappedConn == null)) {
      throw new ConnectionShutdownException();
    }
  }
  
  public boolean isOpen()
  {
    OperatedClientConnection conn = getWrappedConnection();
    if (conn == null) {
      return false;
    }
    return conn.isOpen();
  }
  
  public boolean isStale()
  {
    if (isReleased()) {
      return true;
    }
    OperatedClientConnection conn = getWrappedConnection();
    if (conn == null) {
      return true;
    }
    return conn.isStale();
  }
  
  public void setSocketTimeout(int timeout)
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    conn.setSocketTimeout(timeout);
  }
  
  public int getSocketTimeout()
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    return conn.getSocketTimeout();
  }
  
  public HttpConnectionMetrics getMetrics()
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    return conn.getMetrics();
  }
  
  public void flush()
    throws IOException
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    conn.flush();
  }
  
  public boolean isResponseAvailable(int timeout)
    throws IOException
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    return conn.isResponseAvailable(timeout);
  }
  
  public void receiveResponseEntity(HttpResponse response)
    throws HttpException, IOException
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    unmarkReusable();
    conn.receiveResponseEntity(response);
  }
  
  public HttpResponse receiveResponseHeader()
    throws HttpException, IOException
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    unmarkReusable();
    return conn.receiveResponseHeader();
  }
  
  public void sendRequestEntity(HttpEntityEnclosingRequest request)
    throws HttpException, IOException
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    unmarkReusable();
    conn.sendRequestEntity(request);
  }
  
  public void sendRequestHeader(HttpRequest request)
    throws HttpException, IOException
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    unmarkReusable();
    conn.sendRequestHeader(request);
  }
  
  public InetAddress getLocalAddress()
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    return conn.getLocalAddress();
  }
  
  public int getLocalPort()
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    return conn.getLocalPort();
  }
  
  public InetAddress getRemoteAddress()
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    return conn.getRemoteAddress();
  }
  
  public int getRemotePort()
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    return conn.getRemotePort();
  }
  
  public boolean isSecure()
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    return conn.isSecure();
  }
  
  public void bind(Socket socket)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public Socket getSocket()
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    if (!isOpen()) {
      return null;
    }
    return conn.getSocket();
  }
  
  public SSLSession getSSLSession()
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    if (!isOpen()) {
      return null;
    }
    SSLSession result = null;
    Socket sock = conn.getSocket();
    if ((sock instanceof SSLSocket)) {
      result = ((SSLSocket)sock).getSession();
    }
    return result;
  }
  
  public void markReusable()
  {
    markedReusable = true;
  }
  
  public void unmarkReusable()
  {
    markedReusable = false;
  }
  
  public boolean isMarkedReusable()
  {
    return markedReusable;
  }
  
  public void setIdleDuration(long duration, TimeUnit unit)
  {
    if (duration > 0L) {
      this.duration = unit.toMillis(duration);
    } else {
      this.duration = -1L;
    }
  }
  
  public synchronized void releaseConnection()
  {
    if (released) {
      return;
    }
    released = true;
    connManager.releaseConnection(this, duration, TimeUnit.MILLISECONDS);
  }
  
  public synchronized void abortConnection()
  {
    if (released) {
      return;
    }
    released = true;
    unmarkReusable();
    try
    {
      shutdown();
    }
    catch (IOException ignore) {}
    connManager.releaseConnection(this, duration, TimeUnit.MILLISECONDS);
  }
  
  public Object getAttribute(String id)
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    if ((conn instanceof HttpContext)) {
      return ((HttpContext)conn).getAttribute(id);
    }
    return null;
  }
  
  public Object removeAttribute(String id)
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    if ((conn instanceof HttpContext)) {
      return ((HttpContext)conn).removeAttribute(id);
    }
    return null;
  }
  
  public void setAttribute(String id, Object obj)
  {
    OperatedClientConnection conn = getWrappedConnection();
    assertValid(conn);
    if ((conn instanceof HttpContext)) {
      ((HttpContext)conn).setAttribute(id, obj);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.AbstractClientConnAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */