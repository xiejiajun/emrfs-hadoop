package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.MessageSystemAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SendMessageRequestMarshaller
  implements Marshaller<Request<SendMessageRequest>, SendMessageRequest>
{
  public Request<SendMessageRequest> marshall(SendMessageRequest sendMessageRequest)
  {
    if (sendMessageRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<SendMessageRequest> request = new DefaultRequest(sendMessageRequest, "AmazonSQS");
    request.addParameter("Action", "SendMessage");
    request.addParameter("Version", "2012-11-05");
    request.setHttpMethod(HttpMethodName.POST);
    if (sendMessageRequest.getQueueUrl() != null) {
      request.addParameter("QueueUrl", StringUtils.fromString(sendMessageRequest.getQueueUrl()));
    }
    if (sendMessageRequest.getMessageBody() != null) {
      request.addParameter("MessageBody", StringUtils.fromString(sendMessageRequest.getMessageBody()));
    }
    if (sendMessageRequest.getDelaySeconds() != null) {
      request.addParameter("DelaySeconds", StringUtils.fromInteger(sendMessageRequest.getDelaySeconds()));
    }
    Map<String, MessageAttributeValue> messageAttributes = sendMessageRequest.getMessageAttributes();
    int messageAttributesListIndex = 1;
    for (Map.Entry<String, MessageAttributeValue> entry : messageAttributes.entrySet())
    {
      if (entry.getKey() != null) {
        request.addParameter("MessageAttribute." + messageAttributesListIndex + ".Name", StringUtils.fromString((String)entry.getKey()));
      }
      if (entry.getValue() != null)
      {
        if (((MessageAttributeValue)entry.getValue()).getStringValue() != null) {
          request.addParameter("MessageAttribute." + messageAttributesListIndex + ".Value.StringValue", 
            StringUtils.fromString(((MessageAttributeValue)entry.getValue()).getStringValue()));
        }
        if (((MessageAttributeValue)entry.getValue()).getBinaryValue() != null) {
          request.addParameter("MessageAttribute." + messageAttributesListIndex + ".Value.BinaryValue", 
            StringUtils.fromByteBuffer(((MessageAttributeValue)entry.getValue()).getBinaryValue()));
        }
        int stringListValuesListIndex;
        if ((!((MessageAttributeValue)entry.getValue()).getStringListValues().isEmpty()) || 
          (!((SdkInternalList)((MessageAttributeValue)entry.getValue()).getStringListValues()).isAutoConstruct()))
        {
          SdkInternalList<String> stringListValuesList = (SdkInternalList)((MessageAttributeValue)entry.getValue()).getStringListValues();
          stringListValuesListIndex = 1;
          for (String stringListValuesListValue : stringListValuesList)
          {
            if (stringListValuesListValue != null) {
              request.addParameter("MessageAttribute." + messageAttributesListIndex + ".Value.StringListValue." + stringListValuesListIndex, 
                StringUtils.fromString(stringListValuesListValue));
            }
            stringListValuesListIndex++;
          }
        }
        int binaryListValuesListIndex;
        if ((!((MessageAttributeValue)entry.getValue()).getBinaryListValues().isEmpty()) || 
          (!((SdkInternalList)((MessageAttributeValue)entry.getValue()).getBinaryListValues()).isAutoConstruct()))
        {
          binaryListValuesList = (SdkInternalList)((MessageAttributeValue)entry.getValue()).getBinaryListValues();
          binaryListValuesListIndex = 1;
          for (ByteBuffer binaryListValuesListValue : binaryListValuesList)
          {
            if (binaryListValuesListValue != null) {
              request.addParameter("MessageAttribute." + messageAttributesListIndex + ".Value.BinaryListValue." + binaryListValuesListIndex, 
                StringUtils.fromByteBuffer(binaryListValuesListValue));
            }
            binaryListValuesListIndex++;
          }
        }
        if (((MessageAttributeValue)entry.getValue()).getDataType() != null) {
          request.addParameter("MessageAttribute." + messageAttributesListIndex + ".Value.DataType", 
            StringUtils.fromString(((MessageAttributeValue)entry.getValue()).getDataType()));
        }
      }
      messageAttributesListIndex++;
    }
    SdkInternalList<ByteBuffer> binaryListValuesList;
    Object messageSystemAttributes = sendMessageRequest.getMessageSystemAttributes();
    int messageSystemAttributesListIndex = 1;
    for (Map.Entry<String, MessageSystemAttributeValue> entry : ((Map)messageSystemAttributes).entrySet())
    {
      if (entry.getKey() != null) {
        request.addParameter("MessageSystemAttribute." + messageSystemAttributesListIndex + ".Name", StringUtils.fromString((String)entry.getKey()));
      }
      if (entry.getValue() != null)
      {
        if (((MessageSystemAttributeValue)entry.getValue()).getStringValue() != null) {
          request.addParameter("MessageSystemAttribute." + messageSystemAttributesListIndex + ".Value.StringValue", 
            StringUtils.fromString(((MessageSystemAttributeValue)entry.getValue()).getStringValue()));
        }
        if (((MessageSystemAttributeValue)entry.getValue()).getBinaryValue() != null) {
          request.addParameter("MessageSystemAttribute." + messageSystemAttributesListIndex + ".Value.BinaryValue", 
            StringUtils.fromByteBuffer(((MessageSystemAttributeValue)entry.getValue()).getBinaryValue()));
        }
        int stringListValuesListIndex;
        if ((!((MessageSystemAttributeValue)entry.getValue()).getStringListValues().isEmpty()) || 
          (!((SdkInternalList)((MessageSystemAttributeValue)entry.getValue()).getStringListValues()).isAutoConstruct()))
        {
          Object stringListValuesList = (SdkInternalList)((MessageSystemAttributeValue)entry.getValue()).getStringListValues();
          stringListValuesListIndex = 1;
          for (String stringListValuesListValue : (SdkInternalList)stringListValuesList)
          {
            if (stringListValuesListValue != null) {
              request.addParameter("MessageSystemAttribute." + messageSystemAttributesListIndex + ".Value.StringListValue." + stringListValuesListIndex, 
                StringUtils.fromString(stringListValuesListValue));
            }
            stringListValuesListIndex++;
          }
        }
        int binaryListValuesListIndex;
        if ((!((MessageSystemAttributeValue)entry.getValue()).getBinaryListValues().isEmpty()) || 
          (!((SdkInternalList)((MessageSystemAttributeValue)entry.getValue()).getBinaryListValues()).isAutoConstruct()))
        {
          Object binaryListValuesList = (SdkInternalList)((MessageSystemAttributeValue)entry.getValue()).getBinaryListValues();
          binaryListValuesListIndex = 1;
          for (ByteBuffer binaryListValuesListValue : (SdkInternalList)binaryListValuesList)
          {
            if (binaryListValuesListValue != null) {
              request.addParameter("MessageSystemAttribute." + messageSystemAttributesListIndex + ".Value.BinaryListValue." + binaryListValuesListIndex, 
                StringUtils.fromByteBuffer(binaryListValuesListValue));
            }
            binaryListValuesListIndex++;
          }
        }
        if (((MessageSystemAttributeValue)entry.getValue()).getDataType() != null) {
          request.addParameter("MessageSystemAttribute." + messageSystemAttributesListIndex + ".Value.DataType", 
            StringUtils.fromString(((MessageSystemAttributeValue)entry.getValue()).getDataType()));
        }
      }
      messageSystemAttributesListIndex++;
    }
    if (sendMessageRequest.getMessageDeduplicationId() != null) {
      request.addParameter("MessageDeduplicationId", StringUtils.fromString(sendMessageRequest.getMessageDeduplicationId()));
    }
    if (sendMessageRequest.getMessageGroupId() != null) {
      request.addParameter("MessageGroupId", StringUtils.fromString(sendMessageRequest.getMessageGroupId()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.SendMessageRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */