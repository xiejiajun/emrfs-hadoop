package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLegalHoldResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;

public final class Unmarshallers$GetObjectLegalHoldResultUnmarshaller
  implements Unmarshaller<GetObjectLegalHoldResult, InputStream>
{
  public GetObjectLegalHoldResult unmarshall(InputStream in)
    throws Exception
  {
    return new XmlResponsesSaxParser().parseGetObjectLegalHoldResponse(in).getResult();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.Unmarshallers.GetObjectLegalHoldResultUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */