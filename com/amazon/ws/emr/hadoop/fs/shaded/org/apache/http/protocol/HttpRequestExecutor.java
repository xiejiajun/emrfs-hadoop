package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class HttpRequestExecutor
{
  public static final int DEFAULT_WAIT_FOR_CONTINUE = 3000;
  private final int waitForContinue;
  
  public HttpRequestExecutor(int waitForContinue)
  {
    this.waitForContinue = Args.positive(waitForContinue, "Wait for continue time");
  }
  
  public HttpRequestExecutor()
  {
    this(3000);
  }
  
  protected boolean canResponseHaveBody(HttpRequest request, HttpResponse response)
  {
    if ("HEAD".equalsIgnoreCase(request.getRequestLine().getMethod())) {
      return false;
    }
    int status = response.getStatusLine().getStatusCode();
    return (status >= 200) && (status != 204) && (status != 304) && (status != 205);
  }
  
  public HttpResponse execute(HttpRequest request, HttpClientConnection conn, HttpContext context)
    throws IOException, HttpException
  {
    Args.notNull(request, "HTTP request");
    Args.notNull(conn, "Client connection");
    Args.notNull(context, "HTTP context");
    try
    {
      HttpResponse response = doSendRequest(request, conn, context);
      if (response == null) {}
      return doReceiveResponse(request, conn, context);
    }
    catch (IOException ex)
    {
      closeConnection(conn);
      throw ex;
    }
    catch (HttpException ex)
    {
      closeConnection(conn);
      throw ex;
    }
    catch (RuntimeException ex)
    {
      closeConnection(conn);
      throw ex;
    }
  }
  
  private static void closeConnection(HttpClientConnection conn)
  {
    try
    {
      conn.close();
    }
    catch (IOException ignore) {}
  }
  
  public void preProcess(HttpRequest request, HttpProcessor processor, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    Args.notNull(processor, "HTTP processor");
    Args.notNull(context, "HTTP context");
    context.setAttribute("http.request", request);
    processor.process(request, context);
  }
  
  protected HttpResponse doSendRequest(HttpRequest request, HttpClientConnection conn, HttpContext context)
    throws IOException, HttpException
  {
    Args.notNull(request, "HTTP request");
    Args.notNull(conn, "Client connection");
    Args.notNull(context, "HTTP context");
    
    HttpResponse response = null;
    
    context.setAttribute("http.connection", conn);
    context.setAttribute("http.request_sent", Boolean.FALSE);
    
    conn.sendRequestHeader(request);
    if ((request instanceof HttpEntityEnclosingRequest))
    {
      boolean sendentity = true;
      ProtocolVersion ver = request.getRequestLine().getProtocolVersion();
      if ((((HttpEntityEnclosingRequest)request).expectContinue()) && (!ver.lessEquals(HttpVersion.HTTP_1_0)))
      {
        conn.flush();
        if (conn.isResponseAvailable(waitForContinue))
        {
          response = conn.receiveResponseHeader();
          if (canResponseHaveBody(request, response)) {
            conn.receiveResponseEntity(response);
          }
          int status = response.getStatusLine().getStatusCode();
          if (status < 200)
          {
            if (status != 100) {
              throw new ProtocolException("Unexpected response: " + response.getStatusLine());
            }
            response = null;
          }
          else
          {
            sendentity = false;
          }
        }
      }
      if (sendentity) {
        conn.sendRequestEntity((HttpEntityEnclosingRequest)request);
      }
    }
    conn.flush();
    context.setAttribute("http.request_sent", Boolean.TRUE);
    return response;
  }
  
  protected HttpResponse doReceiveResponse(HttpRequest request, HttpClientConnection conn, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(request, "HTTP request");
    Args.notNull(conn, "Client connection");
    Args.notNull(context, "HTTP context");
    HttpResponse response = null;
    int statusCode = 0;
    while ((response == null) || (statusCode < 200))
    {
      response = conn.receiveResponseHeader();
      if (canResponseHaveBody(request, response)) {
        conn.receiveResponseEntity(response);
      }
      statusCode = response.getStatusLine().getStatusCode();
    }
    return response;
  }
  
  public void postProcess(HttpResponse response, HttpProcessor processor, HttpContext context)
    throws HttpException, IOException
  {
    Args.notNull(response, "HTTP response");
    Args.notNull(processor, "HTTP processor");
    Args.notNull(context, "HTTP context");
    context.setAttribute("http.response", response);
    processor.process(response, context);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpRequestExecutor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */