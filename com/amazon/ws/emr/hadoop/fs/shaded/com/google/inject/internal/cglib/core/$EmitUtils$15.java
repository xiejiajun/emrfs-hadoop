package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

final class $EmitUtils$15
  implements .Transformer
{
  private final .EmitUtils.ParameterTyper val$typer;
  private final int val$j;
  
  $EmitUtils$15(.EmitUtils.ParameterTyper paramParameterTyper, int paramInt)
  {
    val$typer = paramParameterTyper;val$j = paramInt;
  }
  
  public Object transform(Object value)
  {
    return .TypeUtils.emulateClassGetName(val$typer.getParameterTypes((.MethodInfo)value)[val$j]);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils.15
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */