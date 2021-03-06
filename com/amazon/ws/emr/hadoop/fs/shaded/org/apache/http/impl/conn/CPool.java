package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedHttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.AbstractConnPool;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.ConnFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.PoolEntryCallback;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Contract(threading=ThreadingBehavior.SAFE)
class CPool
  extends AbstractConnPool<HttpRoute, ManagedHttpClientConnection, CPoolEntry>
{
  private static final AtomicLong COUNTER = new AtomicLong();
  private final Log log = LogFactory.getLog(CPool.class);
  private final long timeToLive;
  private final TimeUnit tunit;
  
  public CPool(ConnFactory<HttpRoute, ManagedHttpClientConnection> connFactory, int defaultMaxPerRoute, int maxTotal, long timeToLive, TimeUnit tunit)
  {
    super(connFactory, defaultMaxPerRoute, maxTotal);
    this.timeToLive = timeToLive;
    this.tunit = tunit;
  }
  
  protected CPoolEntry createEntry(HttpRoute route, ManagedHttpClientConnection conn)
  {
    String id = Long.toString(COUNTER.getAndIncrement());
    return new CPoolEntry(log, id, route, conn, timeToLive, tunit);
  }
  
  protected boolean validate(CPoolEntry entry)
  {
    return !((ManagedHttpClientConnection)entry.getConnection()).isStale();
  }
  
  protected void enumAvailable(PoolEntryCallback<HttpRoute, ManagedHttpClientConnection> callback)
  {
    super.enumAvailable(callback);
  }
  
  protected void enumLeased(PoolEntryCallback<HttpRoute, ManagedHttpClientConnection> callback)
  {
    super.enumLeased(callback);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.CPool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */