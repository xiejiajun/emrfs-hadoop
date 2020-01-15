package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListAttachedGroupPoliciesRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String groupName;
  private String pathPrefix;
  private String marker;
  private Integer maxItems;
  
  public void setGroupName(String groupName)
  {
    this.groupName = groupName;
  }
  
  public String getGroupName()
  {
    return groupName;
  }
  
  public ListAttachedGroupPoliciesRequest withGroupName(String groupName)
  {
    setGroupName(groupName);
    return this;
  }
  
  public void setPathPrefix(String pathPrefix)
  {
    this.pathPrefix = pathPrefix;
  }
  
  public String getPathPrefix()
  {
    return pathPrefix;
  }
  
  public ListAttachedGroupPoliciesRequest withPathPrefix(String pathPrefix)
  {
    setPathPrefix(pathPrefix);
    return this;
  }
  
  public void setMarker(String marker)
  {
    this.marker = marker;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public ListAttachedGroupPoliciesRequest withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public void setMaxItems(Integer maxItems)
  {
    this.maxItems = maxItems;
  }
  
  public Integer getMaxItems()
  {
    return maxItems;
  }
  
  public ListAttachedGroupPoliciesRequest withMaxItems(Integer maxItems)
  {
    setMaxItems(maxItems);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGroupName() != null) {
      sb.append("GroupName: ").append(getGroupName()).append(",");
    }
    if (getPathPrefix() != null) {
      sb.append("PathPrefix: ").append(getPathPrefix()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker()).append(",");
    }
    if (getMaxItems() != null) {
      sb.append("MaxItems: ").append(getMaxItems());
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
    if (!(obj instanceof ListAttachedGroupPoliciesRequest)) {
      return false;
    }
    ListAttachedGroupPoliciesRequest other = (ListAttachedGroupPoliciesRequest)obj;
    if (((other.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGroupName() != null) && (!other.getGroupName().equals(getGroupName()))) {
      return false;
    }
    if (((other.getPathPrefix() == null ? 1 : 0) ^ (getPathPrefix() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPathPrefix() != null) && (!other.getPathPrefix().equals(getPathPrefix()))) {
      return false;
    }
    if (((other.getMarker() == null ? 1 : 0) ^ (getMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarker() != null) && (!other.getMarker().equals(getMarker()))) {
      return false;
    }
    if (((other.getMaxItems() == null ? 1 : 0) ^ (getMaxItems() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaxItems() != null) && (!other.getMaxItems().equals(getMaxItems()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGroupName() == null ? 0 : getGroupName().hashCode());
    hashCode = 31 * hashCode + (getPathPrefix() == null ? 0 : getPathPrefix().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    hashCode = 31 * hashCode + (getMaxItems() == null ? 0 : getMaxItems().hashCode());
    return hashCode;
  }
  
  public ListAttachedGroupPoliciesRequest clone()
  {
    return (ListAttachedGroupPoliciesRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedGroupPoliciesRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */