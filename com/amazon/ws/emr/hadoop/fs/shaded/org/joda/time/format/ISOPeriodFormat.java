package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

public class ISOPeriodFormat
{
  private static PeriodFormatter cStandard;
  private static PeriodFormatter cAlternate;
  private static PeriodFormatter cAlternateExtended;
  private static PeriodFormatter cAlternateWithWeeks;
  private static PeriodFormatter cAlternateExtendedWihWeeks;
  
  public static PeriodFormatter standard()
  {
    if (cStandard == null) {
      cStandard = new PeriodFormatterBuilder().appendLiteral("P").appendYears().appendSuffix("Y").appendMonths().appendSuffix("M").appendWeeks().appendSuffix("W").appendDays().appendSuffix("D").appendSeparatorIfFieldsAfter("T").appendHours().appendSuffix("H").appendMinutes().appendSuffix("M").appendSecondsWithOptionalMillis().appendSuffix("S").toFormatter();
    }
    return cStandard;
  }
  
  public static PeriodFormatter alternate()
  {
    if (cAlternate == null) {
      cAlternate = new PeriodFormatterBuilder().appendLiteral("P").printZeroAlways().minimumPrintedDigits(4).appendYears().minimumPrintedDigits(2).appendMonths().appendDays().appendSeparatorIfFieldsAfter("T").appendHours().appendMinutes().appendSecondsWithOptionalMillis().toFormatter();
    }
    return cAlternate;
  }
  
  public static PeriodFormatter alternateExtended()
  {
    if (cAlternateExtended == null) {
      cAlternateExtended = new PeriodFormatterBuilder().appendLiteral("P").printZeroAlways().minimumPrintedDigits(4).appendYears().appendSeparator("-").minimumPrintedDigits(2).appendMonths().appendSeparator("-").appendDays().appendSeparatorIfFieldsAfter("T").appendHours().appendSeparator(":").appendMinutes().appendSeparator(":").appendSecondsWithOptionalMillis().toFormatter();
    }
    return cAlternateExtended;
  }
  
  public static PeriodFormatter alternateWithWeeks()
  {
    if (cAlternateWithWeeks == null) {
      cAlternateWithWeeks = new PeriodFormatterBuilder().appendLiteral("P").printZeroAlways().minimumPrintedDigits(4).appendYears().minimumPrintedDigits(2).appendPrefix("W").appendWeeks().appendDays().appendSeparatorIfFieldsAfter("T").appendHours().appendMinutes().appendSecondsWithOptionalMillis().toFormatter();
    }
    return cAlternateWithWeeks;
  }
  
  public static PeriodFormatter alternateExtendedWithWeeks()
  {
    if (cAlternateExtendedWihWeeks == null) {
      cAlternateExtendedWihWeeks = new PeriodFormatterBuilder().appendLiteral("P").printZeroAlways().minimumPrintedDigits(4).appendYears().appendSeparator("-").minimumPrintedDigits(2).appendPrefix("W").appendWeeks().appendSeparator("-").appendDays().appendSeparatorIfFieldsAfter("T").appendHours().appendSeparator(":").appendMinutes().appendSeparator(":").appendSecondsWithOptionalMillis().toFormatter();
    }
    return cAlternateExtendedWihWeeks;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISOPeriodFormat
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */