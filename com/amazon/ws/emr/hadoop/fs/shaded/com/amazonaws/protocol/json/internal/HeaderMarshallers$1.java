package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimestampFormat;
import java.util.Date;

final class HeaderMarshallers$1
  extends HeaderMarshallers.SimpleHeaderMarshaller<Date>
{
  HeaderMarshallers$1(ValueToStringConverters.ValueToString converter)
  {
    super(converter, null);
  }
  
  public void marshall(Date val, JsonMarshallerContext context, MarshallingInfo<Date> marshallingInfo)
  {
    TimestampFormat timestampFormat = marshallingInfo.timestampFormat();
    if (TimestampFormat.UNKNOWN.equals(timestampFormat)) {
      timestampFormat = TimestampFormat.ISO_8601;
    }
    context.request().addHeader(marshallingInfo.marshallLocationName(), StringUtils.fromDate(val, timestampFormat.getFormat()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.internal.HeaderMarshallers.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */