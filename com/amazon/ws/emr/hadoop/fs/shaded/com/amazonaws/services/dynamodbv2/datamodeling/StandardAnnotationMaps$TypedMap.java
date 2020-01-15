package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.Map;

abstract class StandardAnnotationMaps$TypedMap<T>
  extends StandardAnnotationMaps.AbstractAnnotationMap
{
  private final Class<T> targetType;
  
  private StandardAnnotationMaps$TypedMap(Class<T> targetType)
  {
    super(null);
    this.targetType = targetType;
  }
  
  final Class<T> targetType()
  {
    return targetType;
  }
  
  public DynamoDBMapperFieldModel.DynamoDBAttributeType attributeType()
  {
    DynamoDBTyped annotation = (DynamoDBTyped)actualOf(DynamoDBTyped.class);
    if (annotation != null) {
      return annotation.value();
    }
    return null;
  }
  
  public <S> DynamoDBTypeConverter<S, T> typeConverter()
  {
    Annotation annotation = (Annotation)StandardAnnotationMaps.AbstractAnnotationMap.access$400(this).get(DynamoDBTypeConverted.class);
    if (annotation != null)
    {
      DynamoDBTypeConverted converted = (DynamoDBTypeConverted)actualOf(DynamoDBTypeConverted.class);
      annotation = converted == annotation ? null : annotation;
      return (DynamoDBTypeConverter)StandardAnnotationMaps.access$500(converted.converter(), targetType, annotation);
    }
    return null;
  }
  
  public DynamoDBAutoGenerator<T> autoGenerator()
  {
    Annotation annotation = (Annotation)StandardAnnotationMaps.AbstractAnnotationMap.access$400(this).get(DynamoDBAutoGenerated.class);
    if (annotation != null)
    {
      DynamoDBAutoGenerated generated = (DynamoDBAutoGenerated)actualOf(DynamoDBAutoGenerated.class);
      annotation = generated == annotation ? null : annotation;
      DynamoDBAutoGenerator<T> generator = (DynamoDBAutoGenerator)StandardAnnotationMaps.access$500(generated.generator(), targetType, annotation);
      if ((generator.getGenerateStrategy() == DynamoDBAutoGenerateStrategy.CREATE) && (targetType.isPrimitive())) {
        throw new DynamoDBMappingException("type [" + targetType + "] is not supported for auto-generation; primitives are not allowed when auto-generate strategy is CREATE");
      }
      return generator;
    }
    return null;
  }
  
  public Map<String, String> attributes()
  {
    Map<String, String> attributes = new LinkedHashMap();
    for (DynamoDBAttribute a : ((DynamoDBFlattened)actualOf(DynamoDBFlattened.class)).attributes())
    {
      if ((a.mappedBy().isEmpty()) || (a.attributeName().isEmpty())) {
        throw new DynamoDBMappingException("@DynamoDBFlattened must specify mappedBy and attributeName");
      }
      if (attributes.put(a.mappedBy(), a.attributeName()) != null) {
        throw new DynamoDBMappingException("@DynamoDBFlattened must not duplicate mappedBy=" + a.mappedBy());
      }
    }
    if (attributes.isEmpty()) {
      throw new DynamoDBMappingException("@DynamoDBFlattened must specify one or more attributes");
    }
    return attributes;
  }
  
  public boolean flattened()
  {
    return actualOf(DynamoDBFlattened.class) != null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardAnnotationMaps.TypedMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */