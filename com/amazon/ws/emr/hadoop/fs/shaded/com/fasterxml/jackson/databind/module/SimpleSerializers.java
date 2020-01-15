package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.module;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.Serializers.Base;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ArrayType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ClassKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.CollectionType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.MapLikeType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.MapType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class SimpleSerializers
  extends Serializers.Base
  implements Serializable
{
  private static final long serialVersionUID = 8531646511998456779L;
  protected HashMap<ClassKey, JsonSerializer<?>> _classMappings = null;
  protected HashMap<ClassKey, JsonSerializer<?>> _interfaceMappings = null;
  protected boolean _hasEnumSerializer = false;
  
  public SimpleSerializers() {}
  
  public SimpleSerializers(List<JsonSerializer<?>> sers)
  {
    addSerializers(sers);
  }
  
  public void addSerializer(JsonSerializer<?> ser)
  {
    Class<?> cls = ser.handledType();
    if ((cls == null) || (cls == Object.class)) {
      throw new IllegalArgumentException("JsonSerializer of type " + ser.getClass().getName() + " does not define valid handledType() -- must either register with method that takes type argument " + " or make serializer extend 'com.fasterxml.jackson.databind.ser.std.StdSerializer'");
    }
    _addSerializer(cls, ser);
  }
  
  public <T> void addSerializer(Class<? extends T> type, JsonSerializer<T> ser)
  {
    _addSerializer(type, ser);
  }
  
  public void addSerializers(List<JsonSerializer<?>> sers)
  {
    for (JsonSerializer<?> ser : sers) {
      addSerializer(ser);
    }
  }
  
  public JsonSerializer<?> findSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc)
  {
    Class<?> cls = type.getRawClass();
    ClassKey key = new ClassKey(cls);
    JsonSerializer<?> ser = null;
    if (cls.isInterface())
    {
      if (_interfaceMappings != null)
      {
        ser = (JsonSerializer)_interfaceMappings.get(key);
        if (ser != null) {
          return ser;
        }
      }
    }
    else if (_classMappings != null)
    {
      ser = (JsonSerializer)_classMappings.get(key);
      if (ser != null) {
        return ser;
      }
      if ((_hasEnumSerializer) && (type.isEnumType()))
      {
        key.reset(Enum.class);
        ser = (JsonSerializer)_classMappings.get(key);
        if (ser != null) {
          return ser;
        }
      }
      for (Class<?> curr = cls; curr != null; curr = curr.getSuperclass())
      {
        key.reset(curr);
        ser = (JsonSerializer)_classMappings.get(key);
        if (ser != null) {
          return ser;
        }
      }
    }
    if (_interfaceMappings != null)
    {
      ser = _findInterfaceMapping(cls, key);
      if (ser != null) {
        return ser;
      }
      if (!cls.isInterface()) {
        while ((cls = cls.getSuperclass()) != null)
        {
          ser = _findInterfaceMapping(cls, key);
          if (ser != null) {
            return ser;
          }
        }
      }
    }
    return null;
  }
  
  public JsonSerializer<?> findArraySerializer(SerializationConfig config, ArrayType type, BeanDescription beanDesc, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer)
  {
    return findSerializer(config, type, beanDesc);
  }
  
  public JsonSerializer<?> findCollectionSerializer(SerializationConfig config, CollectionType type, BeanDescription beanDesc, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer)
  {
    return findSerializer(config, type, beanDesc);
  }
  
  public JsonSerializer<?> findCollectionLikeSerializer(SerializationConfig config, CollectionLikeType type, BeanDescription beanDesc, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer)
  {
    return findSerializer(config, type, beanDesc);
  }
  
  public JsonSerializer<?> findMapSerializer(SerializationConfig config, MapType type, BeanDescription beanDesc, JsonSerializer<Object> keySerializer, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer)
  {
    return findSerializer(config, type, beanDesc);
  }
  
  public JsonSerializer<?> findMapLikeSerializer(SerializationConfig config, MapLikeType type, BeanDescription beanDesc, JsonSerializer<Object> keySerializer, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer)
  {
    return findSerializer(config, type, beanDesc);
  }
  
  protected JsonSerializer<?> _findInterfaceMapping(Class<?> cls, ClassKey key)
  {
    for (Class<?> iface : cls.getInterfaces())
    {
      key.reset(iface);
      JsonSerializer<?> ser = (JsonSerializer)_interfaceMappings.get(key);
      if (ser != null) {
        return ser;
      }
      ser = _findInterfaceMapping(iface, key);
      if (ser != null) {
        return ser;
      }
    }
    return null;
  }
  
  protected void _addSerializer(Class<?> cls, JsonSerializer<?> ser)
  {
    ClassKey key = new ClassKey(cls);
    if (cls.isInterface())
    {
      if (_interfaceMappings == null) {
        _interfaceMappings = new HashMap();
      }
      _interfaceMappings.put(key, ser);
    }
    else
    {
      if (_classMappings == null) {
        _classMappings = new HashMap();
      }
      _classMappings.put(key, ser);
      if (cls == Enum.class) {
        _hasEnumSerializer = true;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.module.SimpleSerializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */