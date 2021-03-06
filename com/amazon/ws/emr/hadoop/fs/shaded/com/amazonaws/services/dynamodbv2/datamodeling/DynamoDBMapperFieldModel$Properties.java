package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeyType;
import java.util.List;
import java.util.Map;

abstract interface DynamoDBMapperFieldModel$Properties<V>
{
  public abstract String attributeName();
  
  public abstract KeyType keyType();
  
  public abstract boolean versioned();
  
  public abstract Map<KeyType, List<String>> globalSecondaryIndexNames();
  
  public abstract List<String> localSecondaryIndexNames();
  
  public abstract DynamoDBAutoGenerator<V> autoGenerator();
  
  public static final class Immutable<V>
    implements DynamoDBMapperFieldModel.Properties<V>
  {
    private final String attributeName;
    private final KeyType keyType;
    private final boolean versioned;
    private final Map<KeyType, List<String>> globalSecondaryIndexNames;
    private final List<String> localSecondaryIndexNames;
    private final DynamoDBAutoGenerator<V> autoGenerator;
    
    public Immutable(DynamoDBMapperFieldModel.Properties<V> properties)
    {
      attributeName = properties.attributeName();
      keyType = properties.keyType();
      versioned = properties.versioned();
      globalSecondaryIndexNames = properties.globalSecondaryIndexNames();
      localSecondaryIndexNames = properties.localSecondaryIndexNames();
      autoGenerator = properties.autoGenerator();
    }
    
    public final String attributeName()
    {
      return attributeName;
    }
    
    public final KeyType keyType()
    {
      return keyType;
    }
    
    public final boolean versioned()
    {
      return versioned;
    }
    
    public final Map<KeyType, List<String>> globalSecondaryIndexNames()
    {
      return globalSecondaryIndexNames;
    }
    
    public final List<String> localSecondaryIndexNames()
    {
      return localSecondaryIndexNames;
    }
    
    public final DynamoDBAutoGenerator<V> autoGenerator()
    {
      return autoGenerator;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.Properties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */