package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DisableAlarmActionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class DisableAlarmActionsRequestMarshaller
  implements Marshaller<Request<DisableAlarmActionsRequest>, DisableAlarmActionsRequest>
{
  public Request<DisableAlarmActionsRequest> marshall(DisableAlarmActionsRequest disableAlarmActionsRequest)
  {
    if (disableAlarmActionsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DisableAlarmActionsRequest> request = new DefaultRequest(disableAlarmActionsRequest, "AmazonCloudWatch");
    request.addParameter("Action", "DisableAlarmActions");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    int alarmNamesListIndex;
    if ((!disableAlarmActionsRequest.getAlarmNames().isEmpty()) || 
      (!((SdkInternalList)disableAlarmActionsRequest.getAlarmNames()).isAutoConstruct()))
    {
      SdkInternalList<String> alarmNamesList = (SdkInternalList)disableAlarmActionsRequest.getAlarmNames();
      alarmNamesListIndex = 1;
      for (String alarmNamesListValue : alarmNamesList)
      {
        if (alarmNamesListValue != null) {
          request.addParameter("AlarmNames.member." + alarmNamesListIndex, StringUtils.fromString(alarmNamesListValue));
        }
        alarmNamesListIndex++;
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DisableAlarmActionsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */