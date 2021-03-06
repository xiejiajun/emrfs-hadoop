package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.ConvergenceException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxIterationsExceededException;

public abstract class ContinuedFraction
{
  private static final double DEFAULT_EPSILON = 1.0E-8D;
  
  protected abstract double getA(int paramInt, double paramDouble);
  
  protected abstract double getB(int paramInt, double paramDouble);
  
  public double evaluate(double x)
    throws MathException
  {
    return evaluate(x, 1.0E-8D, Integer.MAX_VALUE);
  }
  
  public double evaluate(double x, double epsilon)
    throws MathException
  {
    return evaluate(x, epsilon, Integer.MAX_VALUE);
  }
  
  public double evaluate(double x, int maxIterations)
    throws MathException
  {
    return evaluate(x, 1.0E-8D, maxIterations);
  }
  
  public double evaluate(double x, double epsilon, int maxIterations)
    throws MathException
  {
    double p0 = 1.0D;
    double p1 = getA(0, x);
    double q0 = 0.0D;
    double q1 = 1.0D;
    double c = p1 / q1;
    int n = 0;
    double relativeError = Double.MAX_VALUE;
    while ((n < maxIterations) && (relativeError > epsilon))
    {
      n++;
      double a = getA(n, x);
      double b = getB(n, x);
      double p2 = a * p1 + b * p0;
      double q2 = a * q1 + b * q0;
      boolean infinite = false;
      if ((Double.isInfinite(p2)) || (Double.isInfinite(q2)))
      {
        double scaleFactor = 1.0D;
        double lastScaleFactor = 1.0D;
        int maxPower = 5;
        double scale = Math.max(a, b);
        if (scale <= 0.0D) {
          throw new ConvergenceException("Continued fraction convergents diverged to +/- infinity for value {0}", new Object[] { Double.valueOf(x) });
        }
        infinite = true;
        for (int i = 0; i < 5; i++)
        {
          lastScaleFactor = scaleFactor;
          scaleFactor *= scale;
          if ((a != 0.0D) && (a > b))
          {
            p2 = p1 / lastScaleFactor + b / scaleFactor * p0;
            q2 = q1 / lastScaleFactor + b / scaleFactor * q0;
          }
          else if (b != 0.0D)
          {
            p2 = a / scaleFactor * p1 + p0 / lastScaleFactor;
            q2 = a / scaleFactor * q1 + q0 / lastScaleFactor;
          }
          infinite = (Double.isInfinite(p2)) || (Double.isInfinite(q2));
          if (!infinite) {
            break;
          }
        }
      }
      if (infinite) {
        throw new ConvergenceException("Continued fraction convergents diverged to +/- infinity for value {0}", new Object[] { Double.valueOf(x) });
      }
      double r = p2 / q2;
      if (Double.isNaN(r)) {
        throw new ConvergenceException("Continued fraction diverged to NaN for value {0}", new Object[] { Double.valueOf(x) });
      }
      relativeError = Math.abs(r / c - 1.0D);
      
      c = p2 / q2;
      p0 = p1;
      p1 = p2;
      q0 = q1;
      q1 = q2;
    }
    if (n >= maxIterations) {
      throw new MaxIterationsExceededException(maxIterations, "Continued fraction convergents failed to converge for value {0}", new Object[] { Double.valueOf(x) });
    }
    return c;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.ContinuedFraction
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */