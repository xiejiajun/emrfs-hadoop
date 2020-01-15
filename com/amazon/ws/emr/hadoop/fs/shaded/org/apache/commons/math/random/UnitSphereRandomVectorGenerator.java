package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random;

public class UnitSphereRandomVectorGenerator
  implements RandomVectorGenerator
{
  private final RandomGenerator rand;
  private final int dimension;
  
  public UnitSphereRandomVectorGenerator(int dimension, RandomGenerator rand)
  {
    this.dimension = dimension;
    this.rand = rand;
  }
  
  public UnitSphereRandomVectorGenerator(int dimension)
  {
    this(dimension, new MersenneTwister());
  }
  
  public double[] nextVector()
  {
    double[] v = new double[dimension];
    double normSq;
    do
    {
      normSq = 0.0D;
      for (int i = 0; i < dimension; i++)
      {
        double comp = 2.0D * rand.nextDouble() - 1.0D;
        v[i] = comp;
        normSq += comp * comp;
      }
    } while (normSq > 1.0D);
    double f = 1.0D / Math.sqrt(normSq);
    for (int i = 0; i < dimension; i++) {
      v[i] *= f;
    }
    return v;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.random.UnitSphereRandomVectorGenerator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */