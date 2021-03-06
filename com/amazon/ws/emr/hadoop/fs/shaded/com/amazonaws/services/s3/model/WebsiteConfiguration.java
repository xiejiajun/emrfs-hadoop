package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class WebsiteConfiguration
  implements Serializable
{
  private String indexDocumentSuffix;
  private String errorDocument;
  private String redirectAllRequestsTo;
  private List<RoutingRule> routingRules = new LinkedList();
  
  public void setIndexDocumentSuffix(String indexDocumentSuffix)
  {
    this.indexDocumentSuffix = indexDocumentSuffix;
  }
  
  public String getIndexDocumentSuffix()
  {
    return indexDocumentSuffix;
  }
  
  public WebsiteConfiguration withIndexDocumentSuffix(String indexDocumentSuffix)
  {
    this.indexDocumentSuffix = indexDocumentSuffix;
    return this;
  }
  
  public void setErrorDocument(String errorDocument)
  {
    this.errorDocument = errorDocument;
  }
  
  public String getErrorDocument()
  {
    return errorDocument;
  }
  
  public WebsiteConfiguration witherrorDocument(String errorDocument)
  {
    this.errorDocument = errorDocument;
    return this;
  }
  
  public void setRedirectAllRequestsTo(String redirectAllRequestsTo)
  {
    this.redirectAllRequestsTo = redirectAllRequestsTo;
  }
  
  public String getRedirectAllRequestsTo()
  {
    return redirectAllRequestsTo;
  }
  
  public WebsiteConfiguration withRedirectAllRequestsTo(String redirectAllRequestsTo)
  {
    this.redirectAllRequestsTo = redirectAllRequestsTo;
    return this;
  }
  
  public void setRoutingRules(List<RoutingRule> routingRules)
  {
    this.routingRules = routingRules;
  }
  
  public List<RoutingRule> getRoutingRule()
  {
    return routingRules;
  }
  
  public WebsiteConfiguration withRoutingRule(List<RoutingRule> routingRules)
  {
    this.routingRules = routingRules;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.WebsiteConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */