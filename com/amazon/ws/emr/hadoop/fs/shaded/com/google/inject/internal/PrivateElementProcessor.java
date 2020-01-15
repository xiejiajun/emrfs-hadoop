package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.PrivateElements;
import java.util.List;

final class PrivateElementProcessor
  extends AbstractProcessor
{
  private final List<InjectorShell.Builder> injectorShellBuilders = .Lists.newArrayList();
  
  PrivateElementProcessor(Errors errors)
  {
    super(errors);
  }
  
  public Boolean visit(PrivateElements privateElements)
  {
    InjectorShell.Builder builder = new InjectorShell.Builder().parent(injector).privateElements(privateElements);
    
    injectorShellBuilders.add(builder);
    return Boolean.valueOf(true);
  }
  
  public List<InjectorShell.Builder> getInjectorShellBuilders()
  {
    return injectorShellBuilders;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.PrivateElementProcessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */