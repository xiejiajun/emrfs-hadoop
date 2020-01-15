package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.MessageConstraints;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedHttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentLengthStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.DefaultBHttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageParserFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.HttpMessageWriterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public class DefaultManagedHttpClientConnection
  extends DefaultBHttpClientConnection
  implements ManagedHttpClientConnection, HttpContext
{
  private final String id;
  private final Map<String, Object> attributes;
  private volatile boolean shutdown;
  
  public DefaultManagedHttpClientConnection(String id, int buffersize, int fragmentSizeHint, CharsetDecoder chardecoder, CharsetEncoder charencoder, MessageConstraints constraints, ContentLengthStrategy incomingContentStrategy, ContentLengthStrategy outgoingContentStrategy, HttpMessageWriterFactory<HttpRequest> requestWriterFactory, HttpMessageParserFactory<HttpResponse> responseParserFactory)
  {
    super(buffersize, fragmentSizeHint, chardecoder, charencoder, constraints, incomingContentStrategy, outgoingContentStrategy, requestWriterFactory, responseParserFactory);
    
    this.id = id;
    attributes = new ConcurrentHashMap();
  }
  
  public DefaultManagedHttpClientConnection(String id, int buffersize)
  {
    this(id, buffersize, buffersize, null, null, null, null, null, null, null);
  }
  
  public String getId()
  {
    return id;
  }
  
  public void shutdown()
    throws IOException
  {
    shutdown = true;
    super.shutdown();
  }
  
  public Object getAttribute(String id)
  {
    return attributes.get(id);
  }
  
  public Object removeAttribute(String id)
  {
    return attributes.remove(id);
  }
  
  public void setAttribute(String id, Object obj)
  {
    attributes.put(id, obj);
  }
  
  public void bind(Socket socket)
    throws IOException
  {
    if (shutdown)
    {
      socket.close();
      
      throw new InterruptedIOException("Connection already shutdown");
    }
    super.bind(socket);
  }
  
  public Socket getSocket()
  {
    return super.getSocket();
  }
  
  public SSLSession getSSLSession()
  {
    Socket socket = super.getSocket();
    if ((socket instanceof SSLSocket)) {
      return ((SSLSocket)socket).getSession();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.DefaultManagedHttpClientConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */