package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScheme;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthState;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.RedirectException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.RedirectStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.config.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.CloseableHttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpExecutionAware;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.HttpClientContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils.URIUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoutePlanner;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class RedirectExec
  implements ClientExecChain
{
  private final Log log = LogFactory.getLog(getClass());
  private final ClientExecChain requestExecutor;
  private final RedirectStrategy redirectStrategy;
  private final HttpRoutePlanner routePlanner;
  
  public RedirectExec(ClientExecChain requestExecutor, HttpRoutePlanner routePlanner, RedirectStrategy redirectStrategy)
  {
    Args.notNull(requestExecutor, "HTTP client request executor");
    Args.notNull(routePlanner, "HTTP route planner");
    Args.notNull(redirectStrategy, "HTTP redirect strategy");
    this.requestExecutor = requestExecutor;
    this.routePlanner = routePlanner;
    this.redirectStrategy = redirectStrategy;
  }
  
  public CloseableHttpResponse execute(HttpRoute route, HttpRequestWrapper request, HttpClientContext context, HttpExecutionAware execAware)
    throws IOException, HttpException
  {
    Args.notNull(route, "HTTP route");
    Args.notNull(request, "HTTP request");
    Args.notNull(context, "HTTP context");
    
    List<URI> redirectLocations = context.getRedirectLocations();
    if (redirectLocations != null) {
      redirectLocations.clear();
    }
    RequestConfig config = context.getRequestConfig();
    int maxRedirects = config.getMaxRedirects() > 0 ? config.getMaxRedirects() : 50;
    HttpRoute currentRoute = route;
    HttpRequestWrapper currentRequest = request;
    int redirectCount = 0;
    for (;;)
    {
      CloseableHttpResponse response = requestExecutor.execute(currentRoute, currentRequest, context, execAware);
      try
      {
        if ((config.isRedirectsEnabled()) && (redirectStrategy.isRedirected(currentRequest.getOriginal(), response, context)))
        {
          if (redirectCount >= maxRedirects) {
            throw new RedirectException("Maximum redirects (" + maxRedirects + ") exceeded");
          }
          redirectCount++;
          
          HttpRequest redirect = redirectStrategy.getRedirect(currentRequest.getOriginal(), response, context);
          if (!redirect.headerIterator().hasNext())
          {
            HttpRequest original = request.getOriginal();
            redirect.setHeaders(original.getAllHeaders());
          }
          currentRequest = HttpRequestWrapper.wrap(redirect);
          if ((currentRequest instanceof HttpEntityEnclosingRequest)) {
            RequestEntityProxy.enhance((HttpEntityEnclosingRequest)currentRequest);
          }
          URI uri = currentRequest.getURI();
          HttpHost newTarget = URIUtils.extractHost(uri);
          if (newTarget == null) {
            throw new ProtocolException("Redirect URI does not specify a valid host name: " + uri);
          }
          if (!currentRoute.getTargetHost().equals(newTarget))
          {
            AuthState targetAuthState = context.getTargetAuthState();
            if (targetAuthState != null)
            {
              log.debug("Resetting target auth state");
              targetAuthState.reset();
            }
            AuthState proxyAuthState = context.getProxyAuthState();
            if (proxyAuthState != null)
            {
              AuthScheme authScheme = proxyAuthState.getAuthScheme();
              if ((authScheme != null) && (authScheme.isConnectionBased()))
              {
                log.debug("Resetting proxy auth state");
                proxyAuthState.reset();
              }
            }
          }
          currentRoute = routePlanner.determineRoute(newTarget, currentRequest, context);
          if (log.isDebugEnabled()) {
            log.debug("Redirecting to '" + uri + "' via " + currentRoute);
          }
          EntityUtils.consume(response.getEntity());
          response.close();
        }
        else
        {
          return response;
        }
      }
      catch (RuntimeException ex)
      {
        response.close();
        throw ex;
      }
      catch (IOException ex)
      {
        response.close();
        throw ex;
      }
      catch (HttpException ex)
      {
        try
        {
          EntityUtils.consume(response.getEntity());
        }
        catch (IOException ioex)
        {
          log.debug("I/O error while releasing connection", ioex);
        }
        finally
        {
          response.close();
        }
        throw ex;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain.RedirectExec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */