package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GenericBucketRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  
  public GenericBucketRequest(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  @Deprecated
  public String getBucket()
  {
    return bucketName;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public GenericBucketRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GenericBucketRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */