package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ObjectUtils;

public class ToStringBuilder
  implements Builder<String>
{
  private static volatile ToStringStyle defaultStyle = ToStringStyle.DEFAULT_STYLE;
  private final StringBuffer buffer;
  private final Object object;
  private final ToStringStyle style;
  
  public static ToStringStyle getDefaultStyle()
  {
    return defaultStyle;
  }
  
  public static void setDefaultStyle(ToStringStyle style)
  {
    if (style == null) {
      throw new IllegalArgumentException("The style must not be null");
    }
    defaultStyle = style;
  }
  
  public static String reflectionToString(Object object)
  {
    return ReflectionToStringBuilder.toString(object);
  }
  
  public static String reflectionToString(Object object, ToStringStyle style)
  {
    return ReflectionToStringBuilder.toString(object, style);
  }
  
  public static String reflectionToString(Object object, ToStringStyle style, boolean outputTransients)
  {
    return ReflectionToStringBuilder.toString(object, style, outputTransients, false, null);
  }
  
  public static <T> String reflectionToString(T object, ToStringStyle style, boolean outputTransients, Class<? super T> reflectUpToClass)
  {
    return ReflectionToStringBuilder.toString(object, style, outputTransients, false, reflectUpToClass);
  }
  
  public ToStringBuilder(Object object)
  {
    this(object, null, null);
  }
  
  public ToStringBuilder(Object object, ToStringStyle style)
  {
    this(object, style, null);
  }
  
  public ToStringBuilder(Object object, ToStringStyle style, StringBuffer buffer)
  {
    if (style == null) {
      style = getDefaultStyle();
    }
    if (buffer == null) {
      buffer = new StringBuffer(512);
    }
    this.buffer = buffer;
    this.style = style;
    this.object = object;
    
    style.appendStart(buffer, object);
  }
  
  public ToStringBuilder append(boolean value)
  {
    style.append(buffer, null, value);
    return this;
  }
  
  public ToStringBuilder append(boolean[] array)
  {
    style.append(buffer, null, array, null);
    return this;
  }
  
  public ToStringBuilder append(byte value)
  {
    style.append(buffer, null, value);
    return this;
  }
  
  public ToStringBuilder append(byte[] array)
  {
    style.append(buffer, null, array, null);
    return this;
  }
  
  public ToStringBuilder append(char value)
  {
    style.append(buffer, null, value);
    return this;
  }
  
  public ToStringBuilder append(char[] array)
  {
    style.append(buffer, null, array, null);
    return this;
  }
  
  public ToStringBuilder append(double value)
  {
    style.append(buffer, null, value);
    return this;
  }
  
  public ToStringBuilder append(double[] array)
  {
    style.append(buffer, null, array, null);
    return this;
  }
  
  public ToStringBuilder append(float value)
  {
    style.append(buffer, null, value);
    return this;
  }
  
  public ToStringBuilder append(float[] array)
  {
    style.append(buffer, null, array, null);
    return this;
  }
  
  public ToStringBuilder append(int value)
  {
    style.append(buffer, null, value);
    return this;
  }
  
  public ToStringBuilder append(int[] array)
  {
    style.append(buffer, null, array, null);
    return this;
  }
  
  public ToStringBuilder append(long value)
  {
    style.append(buffer, null, value);
    return this;
  }
  
  public ToStringBuilder append(long[] array)
  {
    style.append(buffer, null, array, null);
    return this;
  }
  
  public ToStringBuilder append(Object obj)
  {
    style.append(buffer, null, obj, null);
    return this;
  }
  
  public ToStringBuilder append(Object[] array)
  {
    style.append(buffer, null, array, null);
    return this;
  }
  
  public ToStringBuilder append(short value)
  {
    style.append(buffer, null, value);
    return this;
  }
  
  public ToStringBuilder append(short[] array)
  {
    style.append(buffer, null, array, null);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, boolean value)
  {
    style.append(buffer, fieldName, value);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, boolean[] array)
  {
    style.append(buffer, fieldName, array, null);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, boolean[] array, boolean fullDetail)
  {
    style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
    return this;
  }
  
  public ToStringBuilder append(String fieldName, byte value)
  {
    style.append(buffer, fieldName, value);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, byte[] array)
  {
    style.append(buffer, fieldName, array, null);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, byte[] array, boolean fullDetail)
  {
    style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
    return this;
  }
  
  public ToStringBuilder append(String fieldName, char value)
  {
    style.append(buffer, fieldName, value);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, char[] array)
  {
    style.append(buffer, fieldName, array, null);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, char[] array, boolean fullDetail)
  {
    style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
    return this;
  }
  
  public ToStringBuilder append(String fieldName, double value)
  {
    style.append(buffer, fieldName, value);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, double[] array)
  {
    style.append(buffer, fieldName, array, null);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, double[] array, boolean fullDetail)
  {
    style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
    return this;
  }
  
  public ToStringBuilder append(String fieldName, float value)
  {
    style.append(buffer, fieldName, value);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, float[] array)
  {
    style.append(buffer, fieldName, array, null);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, float[] array, boolean fullDetail)
  {
    style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
    return this;
  }
  
  public ToStringBuilder append(String fieldName, int value)
  {
    style.append(buffer, fieldName, value);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, int[] array)
  {
    style.append(buffer, fieldName, array, null);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, int[] array, boolean fullDetail)
  {
    style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
    return this;
  }
  
  public ToStringBuilder append(String fieldName, long value)
  {
    style.append(buffer, fieldName, value);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, long[] array)
  {
    style.append(buffer, fieldName, array, null);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, long[] array, boolean fullDetail)
  {
    style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
    return this;
  }
  
  public ToStringBuilder append(String fieldName, Object obj)
  {
    style.append(buffer, fieldName, obj, null);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, Object obj, boolean fullDetail)
  {
    style.append(buffer, fieldName, obj, Boolean.valueOf(fullDetail));
    return this;
  }
  
  public ToStringBuilder append(String fieldName, Object[] array)
  {
    style.append(buffer, fieldName, array, null);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, Object[] array, boolean fullDetail)
  {
    style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
    return this;
  }
  
  public ToStringBuilder append(String fieldName, short value)
  {
    style.append(buffer, fieldName, value);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, short[] array)
  {
    style.append(buffer, fieldName, array, null);
    return this;
  }
  
  public ToStringBuilder append(String fieldName, short[] array, boolean fullDetail)
  {
    style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
    return this;
  }
  
  public ToStringBuilder appendAsObjectToString(Object srcObject)
  {
    ObjectUtils.identityToString(getStringBuffer(), srcObject);
    return this;
  }
  
  public ToStringBuilder appendSuper(String superToString)
  {
    if (superToString != null) {
      style.appendSuper(buffer, superToString);
    }
    return this;
  }
  
  public ToStringBuilder appendToString(String toString)
  {
    if (toString != null) {
      style.appendToString(buffer, toString);
    }
    return this;
  }
  
  public Object getObject()
  {
    return object;
  }
  
  public StringBuffer getStringBuffer()
  {
    return buffer;
  }
  
  public ToStringStyle getStyle()
  {
    return style;
  }
  
  public String toString()
  {
    if (getObject() == null) {
      getStringBuffer().append(getStyle().getNullText());
    } else {
      style.appendEnd(getStringBuffer(), getObject());
    }
    return getStringBuffer().toString();
  }
  
  public String build()
  {
    return toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.builder.ToStringBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */