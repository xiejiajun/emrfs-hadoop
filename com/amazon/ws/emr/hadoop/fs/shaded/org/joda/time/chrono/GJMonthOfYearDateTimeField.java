package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import java.util.Locale;

final class GJMonthOfYearDateTimeField
  extends BasicMonthOfYearDateTimeField
{
  private static final long serialVersionUID = -4748157875845286249L;
  
  GJMonthOfYearDateTimeField(BasicChronology paramBasicChronology)
  {
    super(paramBasicChronology, 2);
  }
  
  public String getAsText(int paramInt, Locale paramLocale)
  {
    return GJLocaleSymbols.forLocale(paramLocale).monthOfYearValueToText(paramInt);
  }
  
  public String getAsShortText(int paramInt, Locale paramLocale)
  {
    return GJLocaleSymbols.forLocale(paramLocale).monthOfYearValueToShortText(paramInt);
  }
  
  protected int convertText(String paramString, Locale paramLocale)
  {
    return GJLocaleSymbols.forLocale(paramLocale).monthOfYearTextToValue(paramString);
  }
  
  public int getMaximumTextLength(Locale paramLocale)
  {
    return GJLocaleSymbols.forLocale(paramLocale).getMonthMaxTextLength();
  }
  
  public int getMaximumShortTextLength(Locale paramLocale)
  {
    return GJLocaleSymbols.forLocale(paramLocale).getMonthMaxShortTextLength();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.GJMonthOfYearDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */