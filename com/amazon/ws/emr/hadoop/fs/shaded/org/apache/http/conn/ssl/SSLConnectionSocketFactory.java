package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.util.PublicSuffixMatcherLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ssl.SSLContexts;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.security.auth.x500.X500Principal;

@Contract(threading=ThreadingBehavior.SAFE)
public class SSLConnectionSocketFactory
  implements LayeredConnectionSocketFactory
{
  public static final String TLS = "TLS";
  public static final String SSL = "SSL";
  public static final String SSLV2 = "SSLv2";
  @Deprecated
  public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = AllowAllHostnameVerifier.INSTANCE;
  @Deprecated
  public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = BrowserCompatHostnameVerifier.INSTANCE;
  @Deprecated
  public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = StrictHostnameVerifier.INSTANCE;
  private final Log log = LogFactory.getLog(getClass());
  private final SSLSocketFactory socketfactory;
  private final HostnameVerifier hostnameVerifier;
  private final String[] supportedProtocols;
  private final String[] supportedCipherSuites;
  
  public static HostnameVerifier getDefaultHostnameVerifier()
  {
    return new DefaultHostnameVerifier(PublicSuffixMatcherLoader.getDefault());
  }
  
  public static SSLConnectionSocketFactory getSocketFactory()
    throws SSLInitializationException
  {
    return new SSLConnectionSocketFactory(SSLContexts.createDefault(), getDefaultHostnameVerifier());
  }
  
  private static String[] split(String s)
  {
    if (TextUtils.isBlank(s)) {
      return null;
    }
    return s.split(" *, *");
  }
  
  public static SSLConnectionSocketFactory getSystemSocketFactory()
    throws SSLInitializationException
  {
    return new SSLConnectionSocketFactory((SSLSocketFactory)SSLSocketFactory.getDefault(), split(System.getProperty("https.protocols")), split(System.getProperty("https.cipherSuites")), getDefaultHostnameVerifier());
  }
  
  public SSLConnectionSocketFactory(SSLContext sslContext)
  {
    this(sslContext, getDefaultHostnameVerifier());
  }
  
  @Deprecated
  public SSLConnectionSocketFactory(SSLContext sslContext, X509HostnameVerifier hostnameVerifier)
  {
    this(((SSLContext)Args.notNull(sslContext, "SSL context")).getSocketFactory(), null, null, hostnameVerifier);
  }
  
  @Deprecated
  public SSLConnectionSocketFactory(SSLContext sslContext, String[] supportedProtocols, String[] supportedCipherSuites, X509HostnameVerifier hostnameVerifier)
  {
    this(((SSLContext)Args.notNull(sslContext, "SSL context")).getSocketFactory(), supportedProtocols, supportedCipherSuites, hostnameVerifier);
  }
  
  @Deprecated
  public SSLConnectionSocketFactory(SSLSocketFactory socketfactory, X509HostnameVerifier hostnameVerifier)
  {
    this(socketfactory, null, null, hostnameVerifier);
  }
  
  @Deprecated
  public SSLConnectionSocketFactory(SSLSocketFactory socketfactory, String[] supportedProtocols, String[] supportedCipherSuites, X509HostnameVerifier hostnameVerifier)
  {
    this(socketfactory, supportedProtocols, supportedCipherSuites, hostnameVerifier);
  }
  
  public SSLConnectionSocketFactory(SSLContext sslContext, HostnameVerifier hostnameVerifier)
  {
    this(((SSLContext)Args.notNull(sslContext, "SSL context")).getSocketFactory(), null, null, hostnameVerifier);
  }
  
  public SSLConnectionSocketFactory(SSLContext sslContext, String[] supportedProtocols, String[] supportedCipherSuites, HostnameVerifier hostnameVerifier)
  {
    this(((SSLContext)Args.notNull(sslContext, "SSL context")).getSocketFactory(), supportedProtocols, supportedCipherSuites, hostnameVerifier);
  }
  
  public SSLConnectionSocketFactory(SSLSocketFactory socketfactory, HostnameVerifier hostnameVerifier)
  {
    this(socketfactory, null, null, hostnameVerifier);
  }
  
  public SSLConnectionSocketFactory(SSLSocketFactory socketfactory, String[] supportedProtocols, String[] supportedCipherSuites, HostnameVerifier hostnameVerifier)
  {
    this.socketfactory = ((SSLSocketFactory)Args.notNull(socketfactory, "SSL socket factory"));
    this.supportedProtocols = supportedProtocols;
    this.supportedCipherSuites = supportedCipherSuites;
    this.hostnameVerifier = (hostnameVerifier != null ? hostnameVerifier : getDefaultHostnameVerifier());
  }
  
  protected void prepareSocket(SSLSocket socket)
    throws IOException
  {}
  
  public Socket createSocket(HttpContext context)
    throws IOException
  {
    return SocketFactory.getDefault().createSocket();
  }
  
  public Socket connectSocket(int connectTimeout, Socket socket, HttpHost host, InetSocketAddress remoteAddress, InetSocketAddress localAddress, HttpContext context)
    throws IOException
  {
    Args.notNull(host, "HTTP host");
    Args.notNull(remoteAddress, "Remote address");
    Socket sock = socket != null ? socket : createSocket(context);
    if (localAddress != null) {
      sock.bind(localAddress);
    }
    try
    {
      if ((connectTimeout > 0) && (sock.getSoTimeout() == 0)) {
        sock.setSoTimeout(connectTimeout);
      }
      if (log.isDebugEnabled()) {
        log.debug("Connecting socket to " + remoteAddress + " with timeout " + connectTimeout);
      }
      sock.connect(remoteAddress, connectTimeout);
    }
    catch (IOException ex)
    {
      try
      {
        sock.close();
      }
      catch (IOException ignore) {}
      throw ex;
    }
    if ((sock instanceof SSLSocket))
    {
      SSLSocket sslsock = (SSLSocket)sock;
      log.debug("Starting handshake");
      sslsock.startHandshake();
      verifyHostname(sslsock, host.getHostName());
      return sock;
    }
    return createLayeredSocket(sock, host.getHostName(), remoteAddress.getPort(), context);
  }
  
  public Socket createLayeredSocket(Socket socket, String target, int port, HttpContext context)
    throws IOException
  {
    SSLSocket sslsock = (SSLSocket)socketfactory.createSocket(socket, target, port, true);
    if (supportedProtocols != null)
    {
      sslsock.setEnabledProtocols(supportedProtocols);
    }
    else
    {
      String[] allProtocols = sslsock.getEnabledProtocols();
      List<String> enabledProtocols = new ArrayList(allProtocols.length);
      for (String protocol : allProtocols) {
        if (!protocol.startsWith("SSL")) {
          enabledProtocols.add(protocol);
        }
      }
      if (!enabledProtocols.isEmpty()) {
        sslsock.setEnabledProtocols((String[])enabledProtocols.toArray(new String[enabledProtocols.size()]));
      }
    }
    if (supportedCipherSuites != null) {
      sslsock.setEnabledCipherSuites(supportedCipherSuites);
    }
    if (log.isDebugEnabled())
    {
      log.debug("Enabled protocols: " + Arrays.asList(sslsock.getEnabledProtocols()));
      log.debug("Enabled cipher suites:" + Arrays.asList(sslsock.getEnabledCipherSuites()));
    }
    prepareSocket(sslsock);
    log.debug("Starting handshake");
    sslsock.startHandshake();
    verifyHostname(sslsock, target);
    return sslsock;
  }
  
  private void verifyHostname(SSLSocket sslsock, String hostname)
    throws IOException
  {
    try
    {
      SSLSession session = sslsock.getSession();
      if (session == null)
      {
        InputStream in = sslsock.getInputStream();
        in.available();
        
        session = sslsock.getSession();
        if (session == null)
        {
          sslsock.startHandshake();
          session = sslsock.getSession();
        }
      }
      if (session == null) {
        throw new SSLHandshakeException("SSL session not available");
      }
      if (log.isDebugEnabled())
      {
        log.debug("Secure session established");
        log.debug(" negotiated protocol: " + session.getProtocol());
        log.debug(" negotiated cipher suite: " + session.getCipherSuite());
        try
        {
          Certificate[] certs = session.getPeerCertificates();
          X509Certificate x509 = (X509Certificate)certs[0];
          X500Principal peer = x509.getSubjectX500Principal();
          
          log.debug(" peer principal: " + peer.toString());
          Collection<List<?>> altNames1 = x509.getSubjectAlternativeNames();
          if (altNames1 != null)
          {
            List<String> altNames = new ArrayList();
            for (List<?> aC : altNames1) {
              if (!aC.isEmpty()) {
                altNames.add((String)aC.get(1));
              }
            }
            log.debug(" peer alternative names: " + altNames);
          }
          X500Principal issuer = x509.getIssuerX500Principal();
          log.debug(" issuer principal: " + issuer.toString());
          Collection<List<?>> altNames2 = x509.getIssuerAlternativeNames();
          if (altNames2 != null)
          {
            List<String> altNames = new ArrayList();
            for (List<?> aC : altNames2) {
              if (!aC.isEmpty()) {
                altNames.add((String)aC.get(1));
              }
            }
            log.debug(" issuer alternative names: " + altNames);
          }
        }
        catch (Exception ignore) {}
      }
      if (!hostnameVerifier.verify(hostname, session))
      {
        Certificate[] certs = session.getPeerCertificates();
        X509Certificate x509 = (X509Certificate)certs[0];
        List<SubjectName> subjectAlts = DefaultHostnameVerifier.getSubjectAltNames(x509);
        throw new SSLPeerUnverifiedException("Certificate for <" + hostname + "> doesn't match any " + "of the subject alternative names: " + subjectAlts);
      }
    }
    catch (IOException iox)
    {
      try
      {
        sslsock.close();
      }
      catch (Exception x) {}
      throw iox;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.SSLConnectionSocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */