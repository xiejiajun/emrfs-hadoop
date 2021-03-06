package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.special.Gamma;
import java.io.Serializable;

public class GammaDistributionImpl
  extends AbstractContinuousDistribution
  implements GammaDistribution, Serializable
{
  public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9D;
  private static final long serialVersionUID = -3239549463135430361L;
  private double alpha;
  private double beta;
  private final double solverAbsoluteAccuracy;
  
  public GammaDistributionImpl(double alpha, double beta)
  {
    this(alpha, beta, 1.0E-9D);
  }
  
  public GammaDistributionImpl(double alpha, double beta, double inverseCumAccuracy)
  {
    setAlphaInternal(alpha);
    setBetaInternal(beta);
    solverAbsoluteAccuracy = inverseCumAccuracy;
  }
  
  public double cumulativeProbability(double x)
    throws MathException
  {
    double ret;
    double ret;
    if (x <= 0.0D) {
      ret = 0.0D;
    } else {
      ret = Gamma.regularizedGammaP(alpha, x / beta);
    }
    return ret;
  }
  
  public double inverseCumulativeProbability(double p)
    throws MathException
  {
    if (p == 0.0D) {
      return 0.0D;
    }
    if (p == 1.0D) {
      return Double.POSITIVE_INFINITY;
    }
    return super.inverseCumulativeProbability(p);
  }
  
  @Deprecated
  public void setAlpha(double alpha)
  {
    setAlphaInternal(alpha);
  }
  
  private void setAlphaInternal(double newAlpha)
  {
    if (newAlpha <= 0.0D) {
      throw MathRuntimeException.createIllegalArgumentException("alpha must be positive ({0})", new Object[] { Double.valueOf(newAlpha) });
    }
    alpha = newAlpha;
  }
  
  public double getAlpha()
  {
    return alpha;
  }
  
  @Deprecated
  public void setBeta(double newBeta)
  {
    setBetaInternal(newBeta);
  }
  
  private void setBetaInternal(double newBeta)
  {
    if (newBeta <= 0.0D) {
      throw MathRuntimeException.createIllegalArgumentException("beta must be positive ({0})", new Object[] { Double.valueOf(newBeta) });
    }
    beta = newBeta;
  }
  
  public double getBeta()
  {
    return beta;
  }
  
  public double density(double x)
  {
    if (x < 0.0D) {
      return 0.0D;
    }
    return Math.pow(x / beta, alpha - 1.0D) / beta * Math.exp(-x / beta) / Math.exp(Gamma.logGamma(alpha));
  }
  
  /**
   * @deprecated
   */
  public double density(Double x)
  {
    return density(x.doubleValue());
  }
  
  protected double getDomainLowerBound(double p)
  {
    return Double.MIN_VALUE;
  }
  
  protected double getDomainUpperBound(double p)
  {
    double ret;
    double ret;
    if (p < 0.5D) {
      ret = alpha * beta;
    } else {
      ret = Double.MAX_VALUE;
    }
    return ret;
  }
  
  protected double getInitialDomain(double p)
  {
    double ret;
    double ret;
    if (p < 0.5D) {
      ret = alpha * beta * 0.5D;
    } else {
      ret = alpha * beta;
    }
    return ret;
  }
  
  protected double getSolverAbsoluteAccuracy()
  {
    return solverAbsoluteAccuracy;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.distribution.GammaDistributionImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */