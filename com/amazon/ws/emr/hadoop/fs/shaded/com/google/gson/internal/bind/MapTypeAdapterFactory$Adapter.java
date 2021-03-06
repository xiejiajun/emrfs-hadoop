package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonElement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonPrimitive;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonSyntaxException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.JsonReaderInternalAccess;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.ObjectConstructor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.Streams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class MapTypeAdapterFactory$Adapter<K, V>
  extends TypeAdapter<Map<K, V>>
{
  private final TypeAdapter<K> keyTypeAdapter;
  private final TypeAdapter<V> valueTypeAdapter;
  private final ObjectConstructor<? extends Map<K, V>> constructor;
  
  public MapTypeAdapterFactory$Adapter(Gson arg1, Type context, TypeAdapter<K> keyType, Type keyTypeAdapter, TypeAdapter<V> valueType, ObjectConstructor<? extends Map<K, V>> valueTypeAdapter)
  {
    this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper(context, keyTypeAdapter, keyType);
    
    this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper(context, valueTypeAdapter, valueType);
    
    this.constructor = constructor;
  }
  
  public Map<K, V> read(JsonReader in)
    throws IOException
  {
    JsonToken peek = in.peek();
    if (peek == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    Map<K, V> map = (Map)constructor.construct();
    if (peek == JsonToken.BEGIN_ARRAY)
    {
      in.beginArray();
      while (in.hasNext())
      {
        in.beginArray();
        K key = keyTypeAdapter.read(in);
        V value = valueTypeAdapter.read(in);
        V replaced = map.put(key, value);
        if (replaced != null) {
          throw new JsonSyntaxException("duplicate key: " + key);
        }
        in.endArray();
      }
      in.endArray();
    }
    else
    {
      in.beginObject();
      while (in.hasNext())
      {
        JsonReaderInternalAccess.INSTANCE.promoteNameToValue(in);
        K key = keyTypeAdapter.read(in);
        V value = valueTypeAdapter.read(in);
        V replaced = map.put(key, value);
        if (replaced != null) {
          throw new JsonSyntaxException("duplicate key: " + key);
        }
      }
      in.endObject();
    }
    return map;
  }
  
  public void write(JsonWriter out, Map<K, V> map)
    throws IOException
  {
    if (map == null)
    {
      out.nullValue();
      return;
    }
    if (!MapTypeAdapterFactory.access$000(this$0))
    {
      out.beginObject();
      for (Map.Entry<K, V> entry : map.entrySet())
      {
        out.name(String.valueOf(entry.getKey()));
        valueTypeAdapter.write(out, entry.getValue());
      }
      out.endObject();
      return;
    }
    boolean hasComplexKeys = false;
    List<JsonElement> keys = new ArrayList(map.size());
    
    List<V> values = new ArrayList(map.size());
    for (Map.Entry<K, V> entry : map.entrySet())
    {
      JsonElement keyElement = keyTypeAdapter.toJsonTree(entry.getKey());
      keys.add(keyElement);
      values.add(entry.getValue());
      hasComplexKeys |= ((keyElement.isJsonArray()) || (keyElement.isJsonObject()));
    }
    if (hasComplexKeys)
    {
      out.beginArray();
      for (int i = 0; i < keys.size(); i++)
      {
        out.beginArray();
        Streams.write((JsonElement)keys.get(i), out);
        valueTypeAdapter.write(out, values.get(i));
        out.endArray();
      }
      out.endArray();
    }
    else
    {
      out.beginObject();
      for (int i = 0; i < keys.size(); i++)
      {
        JsonElement keyElement = (JsonElement)keys.get(i);
        out.name(keyToString(keyElement));
        valueTypeAdapter.write(out, values.get(i));
      }
      out.endObject();
    }
  }
  
  private String keyToString(JsonElement keyElement)
  {
    if (keyElement.isJsonPrimitive())
    {
      JsonPrimitive primitive = keyElement.getAsJsonPrimitive();
      if (primitive.isNumber()) {
        return String.valueOf(primitive.getAsNumber());
      }
      if (primitive.isBoolean()) {
        return Boolean.toString(primitive.getAsBoolean());
      }
      if (primitive.isString()) {
        return primitive.getAsString();
      }
      throw new AssertionError();
    }
    if (keyElement.isJsonNull()) {
      return "null";
    }
    throw new AssertionError();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.MapTypeAdapterFactory.Adapter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */