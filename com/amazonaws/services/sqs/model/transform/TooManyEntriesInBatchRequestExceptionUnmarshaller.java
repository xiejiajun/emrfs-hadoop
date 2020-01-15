package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazonaws.services.sqs.model.TooManyEntriesInBatchRequestException;
import org.w3c.dom.Node;

public class TooManyEntriesInBatchRequestExceptionUnmarshaller
  extends StandardErrorUnmarshaller
{
  public TooManyEntriesInBatchRequestExceptionUnmarshaller()
  {
    super(TooManyEntriesInBatchRequestException.class);
  }
  
  public AmazonServiceException unmarshall(Node node)
    throws Exception
  {
    String errorCode = parseErrorCode(node);
    if ((errorCode == null) || (!errorCode.equals("AWS.SimpleQueueService.TooManyEntriesInBatchRequest"))) {
      return null;
    }
    TooManyEntriesInBatchRequestException e = (TooManyEntriesInBatchRequestException)super.unmarshall(node);
    
    return e;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.TooManyEntriesInBatchRequestExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */