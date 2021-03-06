package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.MapperFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.Annotated;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.NamedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.IndexedStringListSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.IteratorSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.StringCollectionSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.AtomicReferenceSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.BooleanSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.ByteBufferSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.CollectionSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.EnumSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.EnumSetSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.InetAddressSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.InetSocketAddressSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.IterableSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.NumberSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdJdkSerializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ArrayType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.CollectionType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.MapLikeType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.MapType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ReferenceType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ClassUtil;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.Converter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasicSerializerFactory
  extends SerializerFactory
  implements Serializable
{
  protected static final HashMap<String, JsonSerializer<?>> _concrete = new HashMap();
  protected static final HashMap<String, Class<? extends JsonSerializer<?>>> _concreteLazy = new HashMap();
  protected final SerializerFactoryConfig _factoryConfig;
  
  static
  {
    _concrete.put(String.class.getName(), new StringSerializer());
    ToStringSerializer sls = ToStringSerializer.instance;
    _concrete.put(StringBuffer.class.getName(), sls);
    _concrete.put(StringBuilder.class.getName(), sls);
    _concrete.put(Character.class.getName(), sls);
    _concrete.put(Character.TYPE.getName(), sls);
    
    NumberSerializers.addAll(_concrete);
    _concrete.put(Boolean.TYPE.getName(), new BooleanSerializer(true));
    _concrete.put(Boolean.class.getName(), new BooleanSerializer(false));
    
    _concrete.put(BigInteger.class.getName(), new NumberSerializer(BigInteger.class));
    _concrete.put(BigDecimal.class.getName(), new NumberSerializer(BigDecimal.class));
    
    _concrete.put(Calendar.class.getName(), CalendarSerializer.instance);
    _concrete.put(Date.class.getName(), DateSerializer.instance);
    for (Map.Entry<Class<?>, Object> en : StdJdkSerializers.all())
    {
      Object value = en.getValue();
      if ((value instanceof JsonSerializer))
      {
        _concrete.put(((Class)en.getKey()).getName(), (JsonSerializer)value);
      }
      else if ((value instanceof Class))
      {
        Class<? extends JsonSerializer<?>> cls = (Class)value;
        _concreteLazy.put(((Class)en.getKey()).getName(), cls);
      }
      else
      {
        throw new IllegalStateException("Internal error: unrecognized value of type " + en.getClass().getName());
      }
    }
    _concreteLazy.put(TokenBuffer.class.getName(), TokenBufferSerializer.class);
  }
  
  protected BasicSerializerFactory(SerializerFactoryConfig config)
  {
    _factoryConfig = (config == null ? new SerializerFactoryConfig() : config);
  }
  
  public SerializerFactoryConfig getFactoryConfig()
  {
    return _factoryConfig;
  }
  
  public final SerializerFactory withAdditionalSerializers(Serializers additional)
  {
    return withConfig(_factoryConfig.withAdditionalSerializers(additional));
  }
  
  public final SerializerFactory withAdditionalKeySerializers(Serializers additional)
  {
    return withConfig(_factoryConfig.withAdditionalKeySerializers(additional));
  }
  
  public final SerializerFactory withSerializerModifier(BeanSerializerModifier modifier)
  {
    return withConfig(_factoryConfig.withSerializerModifier(modifier));
  }
  
  public JsonSerializer<Object> createKeySerializer(SerializationConfig config, JavaType keyType, JsonSerializer<Object> defaultImpl)
  {
    BeanDescription beanDesc = config.introspectClassAnnotations(keyType.getRawClass());
    JsonSerializer<?> ser = null;
    if (_factoryConfig.hasKeySerializers()) {
      for (Serializers serializers : _factoryConfig.keySerializers())
      {
        ser = serializers.findSerializer(config, keyType, beanDesc);
        if (ser != null) {
          break;
        }
      }
    }
    if (ser == null)
    {
      ser = defaultImpl;
      if (ser == null)
      {
        ser = StdKeySerializers.getStdKeySerializer(config, keyType.getRawClass(), false);
        if (ser == null)
        {
          beanDesc = config.introspect(keyType);
          AnnotatedMethod am = beanDesc.findJsonValueMethod();
          if (am != null)
          {
            Class<?> rawType = am.getRawReturnType();
            JsonSerializer<?> delegate = StdKeySerializers.getStdKeySerializer(config, rawType, true);
            
            Method m = am.getAnnotated();
            if (config.canOverrideAccessModifiers()) {
              ClassUtil.checkAndFixAccess(m);
            }
            ser = new JsonValueSerializer(m, delegate);
          }
          else
          {
            ser = StdKeySerializers.getFallbackKeySerializer(config, keyType.getRawClass());
          }
        }
      }
    }
    if (_factoryConfig.hasSerializerModifiers()) {
      for (BeanSerializerModifier mod : _factoryConfig.serializerModifiers()) {
        ser = mod.modifyKeySerializer(config, keyType, beanDesc, ser);
      }
    }
    return ser;
  }
  
  public TypeSerializer createTypeSerializer(SerializationConfig config, JavaType baseType)
  {
    BeanDescription bean = config.introspectClassAnnotations(baseType.getRawClass());
    AnnotatedClass ac = bean.getClassInfo();
    AnnotationIntrospector ai = config.getAnnotationIntrospector();
    TypeResolverBuilder<?> b = ai.findTypeResolver(config, ac, baseType);
    
    Collection<NamedType> subtypes = null;
    if (b == null) {
      b = config.getDefaultTyper(baseType);
    } else {
      subtypes = config.getSubtypeResolver().collectAndResolveSubtypesByClass(config, ac);
    }
    if (b == null) {
      return null;
    }
    return b.buildTypeSerializer(config, baseType, subtypes);
  }
  
  protected final JsonSerializer<?> findSerializerByLookup(JavaType type, SerializationConfig config, BeanDescription beanDesc, boolean staticTyping)
  {
    Class<?> raw = type.getRawClass();
    String clsName = raw.getName();
    if ((type.isReferenceType()) && 
      (type.isTypeOrSubTypeOf(AtomicReference.class))) {
      return new AtomicReferenceSerializer((ReferenceType)type);
    }
    JsonSerializer<?> ser = (JsonSerializer)_concrete.get(clsName);
    if (ser == null)
    {
      Class<? extends JsonSerializer<?>> serClass = (Class)_concreteLazy.get(clsName);
      if (serClass != null) {
        try
        {
          return (JsonSerializer)serClass.newInstance();
        }
        catch (Exception e)
        {
          throw new IllegalStateException("Failed to instantiate standard serializer (of type " + serClass.getName() + "): " + e.getMessage(), e);
        }
      }
    }
    return ser;
  }
  
  protected final JsonSerializer<?> findSerializerByAnnotations(SerializerProvider prov, JavaType type, BeanDescription beanDesc)
    throws JsonMappingException
  {
    Class<?> raw = type.getRawClass();
    if (JsonSerializable.class.isAssignableFrom(raw)) {
      return SerializableSerializer.instance;
    }
    AnnotatedMethod valueMethod = beanDesc.findJsonValueMethod();
    if (valueMethod != null)
    {
      Method m = valueMethod.getAnnotated();
      if (prov.canOverrideAccessModifiers()) {
        ClassUtil.checkAndFixAccess(m);
      }
      JsonSerializer<Object> ser = findSerializerFromAnnotation(prov, valueMethod);
      return new JsonValueSerializer(m, ser);
    }
    return null;
  }
  
  protected final JsonSerializer<?> findSerializerByPrimaryType(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping)
    throws JsonMappingException
  {
    Class<?> raw = type.getRawClass();
    
    JsonSerializer<?> ser = findOptionalStdSerializer(prov, type, beanDesc, staticTyping);
    if (ser != null) {
      return ser;
    }
    if (Calendar.class.isAssignableFrom(raw)) {
      return CalendarSerializer.instance;
    }
    if (Date.class.isAssignableFrom(raw)) {
      return DateSerializer.instance;
    }
    if (Map.Entry.class.isAssignableFrom(raw))
    {
      JavaType kt = type.containedType(0);
      if (kt == null) {
        kt = TypeFactory.unknownType();
      }
      JavaType vt = type.containedType(1);
      if (vt == null) {
        vt = TypeFactory.unknownType();
      }
      return buildMapEntrySerializer(prov.getConfig(), type, beanDesc, staticTyping, kt, vt);
    }
    if (ByteBuffer.class.isAssignableFrom(raw)) {
      return new ByteBufferSerializer();
    }
    if (InetAddress.class.isAssignableFrom(raw)) {
      return new InetAddressSerializer();
    }
    if (InetSocketAddress.class.isAssignableFrom(raw)) {
      return new InetSocketAddressSerializer();
    }
    if (TimeZone.class.isAssignableFrom(raw)) {
      return new TimeZoneSerializer();
    }
    if (Charset.class.isAssignableFrom(raw)) {
      return ToStringSerializer.instance;
    }
    if (Number.class.isAssignableFrom(raw))
    {
      JsonFormat.Value format = beanDesc.findExpectedFormat(null);
      if (format != null) {
        switch (format.getShape())
        {
        case STRING: 
          return ToStringSerializer.instance;
        case OBJECT: 
        case ARRAY: 
          return null;
        }
      }
      return NumberSerializer.instance;
    }
    if (Enum.class.isAssignableFrom(raw)) {
      return buildEnumSerializer(prov.getConfig(), type, beanDesc);
    }
    return null;
  }
  
  protected JsonSerializer<?> findOptionalStdSerializer(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping)
    throws JsonMappingException
  {
    return OptionalHandlerFactory.instance.findSerializer(prov.getConfig(), type, beanDesc);
  }
  
  protected final JsonSerializer<?> findSerializerByAddonType(SerializationConfig config, JavaType javaType, BeanDescription beanDesc, boolean staticTyping)
    throws JsonMappingException
  {
    Class<?> type = javaType.getRawClass();
    if (Iterator.class.isAssignableFrom(type))
    {
      JavaType[] params = config.getTypeFactory().findTypeParameters(javaType, Iterator.class);
      JavaType vt = (params == null) || (params.length != 1) ? TypeFactory.unknownType() : params[0];
      
      return buildIteratorSerializer(config, javaType, beanDesc, staticTyping, vt);
    }
    if (Iterable.class.isAssignableFrom(type))
    {
      JavaType[] params = config.getTypeFactory().findTypeParameters(javaType, Iterable.class);
      JavaType vt = (params == null) || (params.length != 1) ? TypeFactory.unknownType() : params[0];
      
      return buildIterableSerializer(config, javaType, beanDesc, staticTyping, vt);
    }
    if (CharSequence.class.isAssignableFrom(type)) {
      return ToStringSerializer.instance;
    }
    return null;
  }
  
  protected JsonSerializer<Object> findSerializerFromAnnotation(SerializerProvider prov, Annotated a)
    throws JsonMappingException
  {
    Object serDef = prov.getAnnotationIntrospector().findSerializer(a);
    if (serDef == null) {
      return null;
    }
    JsonSerializer<Object> ser = prov.serializerInstance(a, serDef);
    
    return findConvertingSerializer(prov, a, ser);
  }
  
  protected JsonSerializer<?> findConvertingSerializer(SerializerProvider prov, Annotated a, JsonSerializer<?> ser)
    throws JsonMappingException
  {
    Converter<Object, Object> conv = findConverter(prov, a);
    if (conv == null) {
      return ser;
    }
    JavaType delegateType = conv.getOutputType(prov.getTypeFactory());
    return new StdDelegatingSerializer(conv, delegateType, ser);
  }
  
  protected Converter<Object, Object> findConverter(SerializerProvider prov, Annotated a)
    throws JsonMappingException
  {
    Object convDef = prov.getAnnotationIntrospector().findSerializationConverter(a);
    if (convDef == null) {
      return null;
    }
    return prov.converterInstance(a, convDef);
  }
  
  protected JsonSerializer<?> buildContainerSerializer(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping)
    throws JsonMappingException
  {
    SerializationConfig config = prov.getConfig();
    if ((!staticTyping) && (type.useStaticType()) && (
      (!type.isContainerType()) || (type.getContentType().getRawClass() != Object.class))) {
      staticTyping = true;
    }
    JavaType elementType = type.getContentType();
    TypeSerializer elementTypeSerializer = createTypeSerializer(config, elementType);
    if (elementTypeSerializer != null) {
      staticTyping = false;
    }
    JsonSerializer<Object> elementValueSerializer = _findContentSerializer(prov, beanDesc.getClassInfo());
    if (type.isMapLikeType())
    {
      MapLikeType mlt = (MapLikeType)type;
      
      JsonSerializer<Object> keySerializer = _findKeySerializer(prov, beanDesc.getClassInfo());
      if (mlt.isTrueMapType()) {
        return buildMapSerializer(prov, (MapType)mlt, beanDesc, staticTyping, keySerializer, elementTypeSerializer, elementValueSerializer);
      }
      JsonSerializer<?> ser = null;
      MapLikeType mlType = (MapLikeType)type;
      for (Serializers serializers : customSerializers())
      {
        ser = serializers.findMapLikeSerializer(config, mlType, beanDesc, keySerializer, elementTypeSerializer, elementValueSerializer);
        if (ser != null) {
          break;
        }
      }
      if (ser == null) {
        ser = findSerializerByAnnotations(prov, type, beanDesc);
      }
      if ((ser != null) && 
        (_factoryConfig.hasSerializerModifiers())) {
        for (BeanSerializerModifier mod : _factoryConfig.serializerModifiers()) {
          ser = mod.modifyMapLikeSerializer(config, mlType, beanDesc, ser);
        }
      }
      return ser;
    }
    if (type.isCollectionLikeType())
    {
      CollectionLikeType clt = (CollectionLikeType)type;
      if (clt.isTrueCollectionType()) {
        return buildCollectionSerializer(prov, (CollectionType)clt, beanDesc, staticTyping, elementTypeSerializer, elementValueSerializer);
      }
      JsonSerializer<?> ser = null;
      CollectionLikeType clType = (CollectionLikeType)type;
      for (Serializers serializers : customSerializers())
      {
        ser = serializers.findCollectionLikeSerializer(config, clType, beanDesc, elementTypeSerializer, elementValueSerializer);
        if (ser != null) {
          break;
        }
      }
      if (ser == null) {
        ser = findSerializerByAnnotations(prov, type, beanDesc);
      }
      if ((ser != null) && 
        (_factoryConfig.hasSerializerModifiers())) {
        for (BeanSerializerModifier mod : _factoryConfig.serializerModifiers()) {
          ser = mod.modifyCollectionLikeSerializer(config, clType, beanDesc, ser);
        }
      }
      return ser;
    }
    if (type.isArrayType()) {
      return buildArraySerializer(prov, (ArrayType)type, beanDesc, staticTyping, elementTypeSerializer, elementValueSerializer);
    }
    return null;
  }
  
  protected JsonSerializer<?> buildCollectionSerializer(SerializerProvider prov, CollectionType type, BeanDescription beanDesc, boolean staticTyping, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer)
    throws JsonMappingException
  {
    SerializationConfig config = prov.getConfig();
    JsonSerializer<?> ser = null;
    for (Serializers serializers : customSerializers())
    {
      ser = serializers.findCollectionSerializer(config, type, beanDesc, elementTypeSerializer, elementValueSerializer);
      if (ser != null) {
        break;
      }
    }
    if (ser == null)
    {
      ser = findSerializerByAnnotations(prov, type, beanDesc);
      if (ser == null)
      {
        JsonFormat.Value format = beanDesc.findExpectedFormat(null);
        if ((format != null) && (format.getShape() == JsonFormat.Shape.OBJECT)) {
          return null;
        }
        Class<?> raw = type.getRawClass();
        if (EnumSet.class.isAssignableFrom(raw))
        {
          JavaType enumType = type.getContentType();
          if (!enumType.isEnumType()) {
            enumType = null;
          }
          ser = buildEnumSetSerializer(enumType);
        }
        else
        {
          Class<?> elementRaw = type.getContentType().getRawClass();
          if (isIndexedList(raw))
          {
            if (elementRaw == String.class)
            {
              if ((elementValueSerializer == null) || (ClassUtil.isJacksonStdImpl(elementValueSerializer))) {
                ser = IndexedStringListSerializer.instance;
              }
            }
            else {
              ser = buildIndexedListSerializer(type.getContentType(), staticTyping, elementTypeSerializer, elementValueSerializer);
            }
          }
          else if (elementRaw == String.class) {
            if ((elementValueSerializer == null) || (ClassUtil.isJacksonStdImpl(elementValueSerializer))) {
              ser = StringCollectionSerializer.instance;
            }
          }
          if (ser == null) {
            ser = buildCollectionSerializer(type.getContentType(), staticTyping, elementTypeSerializer, elementValueSerializer);
          }
        }
      }
    }
    if (_factoryConfig.hasSerializerModifiers()) {
      for (BeanSerializerModifier mod : _factoryConfig.serializerModifiers()) {
        ser = mod.modifyCollectionSerializer(config, type, beanDesc, ser);
      }
    }
    return ser;
  }
  
  protected boolean isIndexedList(Class<?> cls)
  {
    return RandomAccess.class.isAssignableFrom(cls);
  }
  
  public ContainerSerializer<?> buildIndexedListSerializer(JavaType elemType, boolean staticTyping, TypeSerializer vts, JsonSerializer<Object> valueSerializer)
  {
    return new IndexedListSerializer(elemType, staticTyping, vts, valueSerializer);
  }
  
  public ContainerSerializer<?> buildCollectionSerializer(JavaType elemType, boolean staticTyping, TypeSerializer vts, JsonSerializer<Object> valueSerializer)
  {
    return new CollectionSerializer(elemType, staticTyping, vts, valueSerializer);
  }
  
  public JsonSerializer<?> buildEnumSetSerializer(JavaType enumType)
  {
    return new EnumSetSerializer(enumType);
  }
  
  protected JsonSerializer<?> buildMapSerializer(SerializerProvider prov, MapType type, BeanDescription beanDesc, boolean staticTyping, JsonSerializer<Object> keySerializer, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer)
    throws JsonMappingException
  {
    SerializationConfig config = prov.getConfig();
    JsonSerializer<?> ser = null;
    for (Serializers serializers : customSerializers())
    {
      ser = serializers.findMapSerializer(config, type, beanDesc, keySerializer, elementTypeSerializer, elementValueSerializer);
      if (ser != null) {
        break;
      }
    }
    if (ser == null)
    {
      ser = findSerializerByAnnotations(prov, type, beanDesc);
      if (ser == null)
      {
        Object filterId = findFilterId(config, beanDesc);
        AnnotationIntrospector ai = config.getAnnotationIntrospector();
        MapSerializer mapSer = MapSerializer.construct(ai.findPropertiesToIgnore(beanDesc.getClassInfo(), true), type, staticTyping, elementTypeSerializer, keySerializer, elementValueSerializer, filterId);
        
        Object suppressableValue = findSuppressableContentValue(config, type.getContentType(), beanDesc);
        if (suppressableValue != null) {
          mapSer = mapSer.withContentInclusion(suppressableValue);
        }
        ser = mapSer;
      }
    }
    if (_factoryConfig.hasSerializerModifiers()) {
      for (BeanSerializerModifier mod : _factoryConfig.serializerModifiers()) {
        ser = mod.modifyMapSerializer(config, type, beanDesc, ser);
      }
    }
    return ser;
  }
  
  protected Object findSuppressableContentValue(SerializationConfig config, JavaType contentType, BeanDescription beanDesc)
    throws JsonMappingException
  {
    JsonInclude.Include incl = beanDesc.findSerializationInclusionForContent(null);
    if (incl != null)
    {
      switch (incl)
      {
      case NON_DEFAULT: 
        incl = JsonInclude.Include.NON_EMPTY;
        break;
      }
      return incl;
    }
    return null;
  }
  
  protected JsonSerializer<?> buildArraySerializer(SerializerProvider prov, ArrayType type, BeanDescription beanDesc, boolean staticTyping, TypeSerializer elementTypeSerializer, JsonSerializer<Object> elementValueSerializer)
    throws JsonMappingException
  {
    SerializationConfig config = prov.getConfig();
    JsonSerializer<?> ser = null;
    for (Serializers serializers : customSerializers())
    {
      ser = serializers.findArraySerializer(config, type, beanDesc, elementTypeSerializer, elementValueSerializer);
      if (ser != null) {
        break;
      }
    }
    if (ser == null)
    {
      Class<?> raw = type.getRawClass();
      if ((elementValueSerializer == null) || (ClassUtil.isJacksonStdImpl(elementValueSerializer))) {
        if (String[].class == raw) {
          ser = StringArraySerializer.instance;
        } else {
          ser = StdArraySerializers.findStandardImpl(raw);
        }
      }
      if (ser == null) {
        ser = new ObjectArraySerializer(type.getContentType(), staticTyping, elementTypeSerializer, elementValueSerializer);
      }
    }
    if (_factoryConfig.hasSerializerModifiers()) {
      for (BeanSerializerModifier mod : _factoryConfig.serializerModifiers()) {
        ser = mod.modifyArraySerializer(config, type, beanDesc, ser);
      }
    }
    return ser;
  }
  
  protected JsonSerializer<?> buildIteratorSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc, boolean staticTyping, JavaType valueType)
    throws JsonMappingException
  {
    return new IteratorSerializer(valueType, staticTyping, createTypeSerializer(config, valueType));
  }
  
  @Deprecated
  protected JsonSerializer<?> buildIteratorSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc, boolean staticTyping)
    throws JsonMappingException
  {
    JavaType[] params = config.getTypeFactory().findTypeParameters(type, Iterator.class);
    JavaType vt = (params == null) || (params.length != 1) ? TypeFactory.unknownType() : params[0];
    
    return buildIteratorSerializer(config, type, beanDesc, staticTyping, vt);
  }
  
  protected JsonSerializer<?> buildIterableSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc, boolean staticTyping, JavaType valueType)
    throws JsonMappingException
  {
    return new IterableSerializer(valueType, staticTyping, createTypeSerializer(config, valueType));
  }
  
  @Deprecated
  protected JsonSerializer<?> buildIterableSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc, boolean staticTyping)
    throws JsonMappingException
  {
    JavaType[] params = config.getTypeFactory().findTypeParameters(type, Iterable.class);
    JavaType vt = (params == null) || (params.length != 1) ? TypeFactory.unknownType() : params[0];
    
    return buildIterableSerializer(config, type, beanDesc, staticTyping, vt);
  }
  
  protected JsonSerializer<?> buildMapEntrySerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc, boolean staticTyping, JavaType keyType, JavaType valueType)
    throws JsonMappingException
  {
    return new MapEntrySerializer(valueType, keyType, valueType, staticTyping, createTypeSerializer(config, valueType), null);
  }
  
  protected JsonSerializer<?> buildEnumSerializer(SerializationConfig config, JavaType type, BeanDescription beanDesc)
    throws JsonMappingException
  {
    JsonFormat.Value format = beanDesc.findExpectedFormat(null);
    if ((format != null) && (format.getShape() == JsonFormat.Shape.OBJECT))
    {
      ((BasicBeanDescription)beanDesc).removeProperty("declaringClass");
      
      return null;
    }
    Class<Enum<?>> enumClass = type.getRawClass();
    JsonSerializer<?> ser = EnumSerializer.construct(enumClass, config, beanDesc, format);
    if (_factoryConfig.hasSerializerModifiers()) {
      for (BeanSerializerModifier mod : _factoryConfig.serializerModifiers()) {
        ser = mod.modifyEnumSerializer(config, type, beanDesc, ser);
      }
    }
    return ser;
  }
  
  protected <T extends JavaType> T modifyTypeByAnnotation(SerializationConfig config, Annotated a, T type)
  {
    Class<?> superclass = config.getAnnotationIntrospector().findSerializationType(a);
    if (superclass != null) {
      try
      {
        type = type.widenBy(superclass);
      }
      catch (IllegalArgumentException iae)
      {
        throw new IllegalArgumentException("Failed to widen type " + type + " with concrete-type annotation (value " + superclass.getName() + "), method '" + a.getName() + "': " + iae.getMessage());
      }
    }
    return modifySecondaryTypesByAnnotation(config, a, type);
  }
  
  protected static <T extends JavaType> T modifySecondaryTypesByAnnotation(SerializationConfig config, Annotated a, T type)
  {
    AnnotationIntrospector intr = config.getAnnotationIntrospector();
    if (type.isContainerType())
    {
      Class<?> keyClass = intr.findSerializationKeyType(a, type.getKeyType());
      if (keyClass != null)
      {
        if (!(type instanceof MapType)) {
          throw new IllegalArgumentException("Illegal key-type annotation: type " + type + " is not a Map type");
        }
        try
        {
          type = ((MapType)type).widenKey(keyClass);
        }
        catch (IllegalArgumentException iae)
        {
          throw new IllegalArgumentException("Failed to narrow key type " + type + " with key-type annotation (" + keyClass.getName() + "): " + iae.getMessage());
        }
      }
      Class<?> cc = intr.findSerializationContentType(a, type.getContentType());
      if (cc != null) {
        try
        {
          type = type.widenContentsBy(cc);
        }
        catch (IllegalArgumentException iae)
        {
          throw new IllegalArgumentException("Failed to narrow content type " + type + " with content-type annotation (" + cc.getName() + "): " + iae.getMessage());
        }
      }
    }
    return type;
  }
  
  protected JsonSerializer<Object> _findKeySerializer(SerializerProvider prov, Annotated a)
    throws JsonMappingException
  {
    AnnotationIntrospector intr = prov.getAnnotationIntrospector();
    Object serDef = intr.findKeySerializer(a);
    if (serDef != null) {
      return prov.serializerInstance(a, serDef);
    }
    return null;
  }
  
  protected JsonSerializer<Object> _findContentSerializer(SerializerProvider prov, Annotated a)
    throws JsonMappingException
  {
    AnnotationIntrospector intr = prov.getAnnotationIntrospector();
    Object serDef = intr.findContentSerializer(a);
    if (serDef != null) {
      return prov.serializerInstance(a, serDef);
    }
    return null;
  }
  
  protected Object findFilterId(SerializationConfig config, BeanDescription beanDesc)
  {
    return config.getAnnotationIntrospector().findFilterId(beanDesc.getClassInfo());
  }
  
  protected boolean usesStaticTyping(SerializationConfig config, BeanDescription beanDesc, TypeSerializer typeSer)
  {
    if (typeSer != null) {
      return false;
    }
    AnnotationIntrospector intr = config.getAnnotationIntrospector();
    JsonSerialize.Typing t = intr.findSerializationTyping(beanDesc.getClassInfo());
    if ((t != null) && (t != JsonSerialize.Typing.DEFAULT_TYPING)) {
      return t == JsonSerialize.Typing.STATIC;
    }
    return config.isEnabled(MapperFeature.USE_STATIC_TYPING);
  }
  
  protected Class<?> _verifyAsClass(Object src, String methodName, Class<?> noneClass)
  {
    if (src == null) {
      return null;
    }
    if (!(src instanceof Class)) {
      throw new IllegalStateException("AnnotationIntrospector." + methodName + "() returned value of type " + src.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
    }
    Class<?> cls = (Class)src;
    if ((cls == noneClass) || (ClassUtil.isBogusClass(cls))) {
      return null;
    }
    return cls;
  }
  
  public abstract SerializerFactory withConfig(SerializerFactoryConfig paramSerializerFactoryConfig);
  
  public abstract JsonSerializer<Object> createSerializer(SerializerProvider paramSerializerProvider, JavaType paramJavaType)
    throws JsonMappingException;
  
  protected abstract Iterable<Serializers> customSerializers();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BasicSerializerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */