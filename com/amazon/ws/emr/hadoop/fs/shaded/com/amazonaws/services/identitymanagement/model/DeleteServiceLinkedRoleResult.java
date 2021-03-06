package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class DeleteServiceLinkedRoleResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String deletionTaskId;
  
  public void setDeletionTaskId(String deletionTaskId)
  {
    this.deletionTaskId = deletionTaskId;
  }
  
  public String getDeletionTaskId()
  {
    return deletionTaskId;
  }
  
  public DeleteServiceLinkedRoleResult withDeletionTaskId(String deletionTaskId)
  {
    setDeletionTaskId(deletionTaskId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDeletionTaskId() != null) {
      sb.append("DeletionTaskId: ").append(getDeletionTaskId());
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
    if (!(obj instanceof DeleteServiceLinkedRoleResult)) {
      return false;
    }
    DeleteServiceLinkedRoleResult other = (DeleteServiceLinkedRoleResult)obj;
    if (((other.getDeletionTaskId() == null ? 1 : 0) ^ (getDeletionTaskId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDeletionTaskId() != null) && (!other.getDeletionTaskId().equals(getDeletionTaskId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getDeletionTaskId() == null ? 0 : getDeletionTaskId().hashCode());
    return hashCode;
  }
  
  public DeleteServiceLinkedRoleResult clone()
  {
    try
    {
      return (DeleteServiceLinkedRoleResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServiceLinkedRoleResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */