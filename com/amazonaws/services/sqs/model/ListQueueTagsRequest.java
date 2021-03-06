package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListQueueTagsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String queueUrl;
  
  public ListQueueTagsRequest() {}
  
  public ListQueueTagsRequest(String queueUrl)
  {
    setQueueUrl(queueUrl);
  }
  
  public void setQueueUrl(String queueUrl)
  {
    this.queueUrl = queueUrl;
  }
  
  public String getQueueUrl()
  {
    return queueUrl;
  }
  
  public ListQueueTagsRequest withQueueUrl(String queueUrl)
  {
    setQueueUrl(queueUrl);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getQueueUrl() != null) {
      sb.append("QueueUrl: ").append(getQueueUrl());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof ListQueueTagsRequest)) {
      return false;
    }
    ListQueueTagsRequest other = (ListQueueTagsRequest)obj;
    if (((other.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQueueUrl() != null) && (!other.getQueueUrl().equals(getQueueUrl()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getQueueUrl() == null ? 0 : getQueueUrl().hashCode());
    return hashCode;
  }
  
  public ListQueueTagsRequest clone()
  {
    return (ListQueueTagsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.ListQueueTagsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */