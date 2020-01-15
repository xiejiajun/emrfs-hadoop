package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal..Gson.Types;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.ConstructorConstructor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.ObjectConstructor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.reflect.TypeToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory
  implements TypeAdapterFactory
{
  private final ConstructorConstructor constructorConstructor;
  
  public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor)
  {
    this.constructorConstructor = constructorConstructor;
  }
  
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken)
  {
    Type type = typeToken.getType();
    
    Class<? super T> rawType = typeToken.getRawType();
    if (!Collection.class.isAssignableFrom(rawType)) {
      return null;
    }
    Type elementType = .Gson.Types.getCollectionElementType(type, rawType);
    TypeAdapter<?> elementTypeAdapter = gson.getAdapter(TypeToken.get(elementType));
    ObjectConstructor<T> constructor = constructorConstructor.get(typeToken);
    
    TypeAdapter<T> result = new Adapter(gson, elementType, elementTypeAdapter, constructor);
    return result;
  }
  
  private static final class Adapter<E>
    extends TypeAdapter<Collection<E>>
  {
    private final TypeAdapter<E> elementTypeAdapter;
    private final ObjectConstructor<? extends Collection<E>> constructor;
    
    public Adapter(Gson context, Type elementType, TypeAdapter<E> elementTypeAdapter, ObjectConstructor<? extends Collection<E>> constructor)
    {
      this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper(context, elementTypeAdapter, elementType);
      
      this.constructor = constructor;
    }
    
    public Collection<E> read(JsonReader in)
      throws IOException
    {
      if (in.peek() == JsonToken.NULL)
      {
        in.nextNull();
        return null;
      }
      Collection<E> collection = (Collection)constructor.construct();
      in.beginArray();
      while (in.hasNext())
      {
        E instance = elementTypeAdapter.read(in);
        collection.add(instance);
      }
      in.endArray();
      return collection;
    }
    
    public void write(JsonWriter out, Collection<E> collection)
      throws IOException
    {
      if (collection == null)
      {
        out.nullValue();
        return;
      }
      out.beginArray();
      for (E element : collection) {
        elementTypeAdapter.write(out, element);
      }
      out.endArray();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.CollectionTypeAdapterFactory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */