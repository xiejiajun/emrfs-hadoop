package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.math.BigInteger;
import java.util.Arrays;

public final class DynamoDBVersioned$Generator<T>
  extends DynamoDBAutoGenerator.AbstractGenerator<T>
{
  private final Sequence<T> sequence;
  
  public DynamoDBVersioned$Generator(Class<T> targetType, DynamoDBVersioned annotation)
  {
    super(DynamoDBAutoGenerateStrategy.ALWAYS);
    sequence = Sequences.of(targetType);
  }
  
  public final T generate(T currentValue)
  {
    return (T)(currentValue == null ? sequence.init() : sequence.next(currentValue));
  }
  
  private static enum Sequences
  {
    BIG_INTEGER(StandardTypeConverters.Scalar.BIG_INTEGER, new DynamoDBVersioned.Generator.Sequence()),  BYTE(StandardTypeConverters.Scalar.BYTE, new DynamoDBVersioned.Generator.Sequence()),  INTEGER(StandardTypeConverters.Scalar.INTEGER, new DynamoDBVersioned.Generator.Sequence()),  LONG(StandardTypeConverters.Scalar.LONG, new DynamoDBVersioned.Generator.Sequence()),  SHORT(StandardTypeConverters.Scalar.SHORT, new DynamoDBVersioned.Generator.Sequence());
    
    private final DynamoDBVersioned.Generator.Sequence<?> sequence;
    private final StandardTypeConverters.Scalar scalar;
    
    private Sequences(StandardTypeConverters.Scalar scalar, DynamoDBVersioned.Generator.Sequence<?> sequence)
    {
      this.sequence = sequence;
      this.scalar = scalar;
    }
    
    private static final <T> DynamoDBVersioned.Generator.Sequence<T> of(Class<T> targetType)
    {
      for (Sequences s : ) {
        if (scalar.is(targetType)) {
          return sequence;
        }
      }
      throw new DynamoDBMappingException("type [" + targetType + "] is not supported; allowed only " + Arrays.toString(values()));
    }
  }
  
  static abstract interface Sequence<T>
  {
    public abstract T init();
    
    public abstract T next(T paramT);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBVersioned.Generator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */