package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

class CacheBuilderSpec$MaximumSizeParser
  extends CacheBuilderSpec.LongParser
{
  protected void parseLong(CacheBuilderSpec spec, long value)
  {
    Preconditions.checkArgument(maximumSize == null, "maximum size was already set to ", new Object[] { maximumSize });
    
    Preconditions.checkArgument(maximumWeight == null, "maximum weight was already set to ", new Object[] { maximumWeight });
    
    maximumSize = Long.valueOf(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilderSpec.MaximumSizeParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */