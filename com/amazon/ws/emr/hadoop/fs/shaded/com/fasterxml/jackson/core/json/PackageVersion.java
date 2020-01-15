package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Versioned;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.VersionUtil;

public final class PackageVersion
  implements Versioned
{
  public static final Version VERSION = VersionUtil.parseVersion("2.6.7", "com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core", "jackson-core");
  
  public Version version()
  {
    return VERSION;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.PackageVersion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */