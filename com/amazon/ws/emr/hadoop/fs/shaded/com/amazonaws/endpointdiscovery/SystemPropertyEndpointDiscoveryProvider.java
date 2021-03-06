package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery;

public class SystemPropertyEndpointDiscoveryProvider
  implements EndpointDiscoveryProvider
{
  public Boolean endpointDiscoveryEnabled()
  {
    Boolean endpointDiscoveryEnabled = null;
    
    String endpointDiscoveryEnabledString = System.getProperty("AWS_ENABLE_ENDPOINT_DISCOVERY");
    if (endpointDiscoveryEnabledString != null) {
      try
      {
        endpointDiscoveryEnabled = Boolean.valueOf(Boolean.parseBoolean(endpointDiscoveryEnabledString));
      }
      catch (Exception e)
      {
        throw new RuntimeException("Unable to parse environment variable AWS_ENABLE_ENDPOINT_DISCOVERY");
      }
    }
    return endpointDiscoveryEnabled;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery.SystemPropertyEndpointDiscoveryProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */