package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetBucketEncryptionRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String bucketName;
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public GetBucketEncryptionRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBucketName() != null) {
      sb.append("BucketName: ").append(getBucketName()).append(",");
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
    if (!(obj instanceof GetBucketEncryptionRequest)) {
      return false;
    }
    GetBucketEncryptionRequest other = (GetBucketEncryptionRequest)obj;
    if (((other.getBucketName() == null ? 1 : 0) ^ (getBucketName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBucketName() != null) && (!other.getBucketName().equals(getBucketName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getBucketName() == null ? 0 : getBucketName().hashCode());
    return hashCode;
  }
  
  public GetBucketEncryptionRequest clone()
  {
    return (GetBucketEncryptionRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketEncryptionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */