package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$ListBucketAnalyticsConfigurationUnmarshaller
  implements Unmarshaller<ListBucketAnalyticsConfigurationsResult, InputStream>
{
  public ListBucketAnalyticsConfigurationsResult unmarshall(InputStream in)
    throws Exception
  {
    return new XmlResponsesSaxParser().parseListBucketAnalyticsConfigurationResponse(in).getResult();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.ListBucketAnalyticsConfigurationUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */