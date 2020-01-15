package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;

final class SubjectName
{
  static final int DNS = 2;
  static final int IP = 7;
  private final String value;
  private final int type;
  
  static SubjectName IP(String value)
  {
    return new SubjectName(value, 7);
  }
  
  static SubjectName DNS(String value)
  {
    return new SubjectName(value, 2);
  }
  
  SubjectName(String value, int type)
  {
    this.value = ((String)Args.notNull(value, "Value"));
    this.type = Args.positive(type, "Type");
  }
  
  public int getType()
  {
    return type;
  }
  
  public String getValue()
  {
    return value;
  }
  
  public String toString()
  {
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.SubjectName
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */