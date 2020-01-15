package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.FunctionEvaluationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxIterationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.UnivariateRealFunction;

public class BrentSolver
  extends UnivariateRealSolverImpl
{
  public static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6D;
  public static final int DEFAULT_MAXIMUM_ITERATIONS = 100;
  private static final String NON_BRACKETING_MESSAGE = "function values at endpoints do not have different signs.  Endpoints: [{0}, {1}], Values: [{2}, {3}]";
  private static final long serialVersionUID = 7694577816772532779L;
  
  @Deprecated
  public BrentSolver(UnivariateRealFunction f)
  {
    super(f, 100, 1.0E-6D);
  }
  
  public BrentSolver()
  {
    super(100, 1.0E-6D);
  }
  
  public BrentSolver(double absoluteAccuracy)
  {
    super(100, absoluteAccuracy);
  }
  
  public BrentSolver(int maximumIterations, double absoluteAccuracy)
  {
    super(maximumIterations, absoluteAccuracy);
  }
  
  @Deprecated
  public double solve(double min, double max)
    throws MaxIterationsExceededException, FunctionEvaluationException
  {
    return solve(f, min, max);
  }
  
  @Deprecated
  public double solve(double min, double max, double initial)
    throws MaxIterationsExceededException, FunctionEvaluationException
  {
    return solve(f, min, max, initial);
  }
  
  public double solve(UnivariateRealFunction f, double min, double max, double initial)
    throws MaxIterationsExceededException, FunctionEvaluationException
  {
    clearResult();
    if ((initial < min) || (initial > max)) {
      throw MathRuntimeException.createIllegalArgumentException("invalid interval, initial value parameters:  lower={0}, initial={1}, upper={2}", new Object[] { Double.valueOf(min), Double.valueOf(initial), Double.valueOf(max) });
    }
    double yInitial = f.value(initial);
    if (Math.abs(yInitial) <= functionValueAccuracy)
    {
      setResult(initial, 0);
      return result;
    }
    double yMin = f.value(min);
    if (Math.abs(yMin) <= functionValueAccuracy)
    {
      setResult(min, 0);
      return result;
    }
    if (yInitial * yMin < 0.0D) {
      return solve(f, min, yMin, initial, yInitial, min, yMin);
    }
    double yMax = f.value(max);
    if (Math.abs(yMax) <= functionValueAccuracy)
    {
      setResult(max, 0);
      return result;
    }
    if (yInitial * yMax < 0.0D) {
      return solve(f, initial, yInitial, max, yMax, initial, yInitial);
    }
    throw MathRuntimeException.createIllegalArgumentException("function values at endpoints do not have different signs.  Endpoints: [{0}, {1}], Values: [{2}, {3}]", new Object[] { Double.valueOf(min), Double.valueOf(max), Double.valueOf(yMin), Double.valueOf(yMax) });
  }
  
  public double solve(UnivariateRealFunction f, double min, double max)
    throws MaxIterationsExceededException, FunctionEvaluationException
  {
    clearResult();
    verifyInterval(min, max);
    
    double ret = NaN.0D;
    
    double yMin = f.value(min);
    double yMax = f.value(max);
    
    double sign = yMin * yMax;
    if (sign > 0.0D)
    {
      if (Math.abs(yMin) <= functionValueAccuracy)
      {
        setResult(min, 0);
        ret = min;
      }
      else if (Math.abs(yMax) <= functionValueAccuracy)
      {
        setResult(max, 0);
        ret = max;
      }
      else
      {
        throw MathRuntimeException.createIllegalArgumentException("function values at endpoints do not have different signs.  Endpoints: [{0}, {1}], Values: [{2}, {3}]", new Object[] { Double.valueOf(min), Double.valueOf(max), Double.valueOf(yMin), Double.valueOf(yMax) });
      }
    }
    else if (sign < 0.0D) {
      ret = solve(f, min, yMin, max, yMax, min, yMin);
    } else if (yMin == 0.0D) {
      ret = min;
    } else {
      ret = max;
    }
    return ret;
  }
  
  private double solve(UnivariateRealFunction f, double x0, double y0, double x1, double y1, double x2, double y2)
    throws MaxIterationsExceededException, FunctionEvaluationException
  {
    double delta = x1 - x0;
    double oldDelta = delta;
    
    int i = 0;
    while (i < maximalIterationCount)
    {
      if (Math.abs(y2) < Math.abs(y1))
      {
        x0 = x1;
        x1 = x2;
        x2 = x0;
        y0 = y1;
        y1 = y2;
        y2 = y0;
      }
      if (Math.abs(y1) <= functionValueAccuracy)
      {
        setResult(x1, i);
        return result;
      }
      double dx = x2 - x1;
      double tolerance = Math.max(relativeAccuracy * Math.abs(x1), absoluteAccuracy);
      if (Math.abs(dx) <= tolerance)
      {
        setResult(x1, i);
        return result;
      }
      if ((Math.abs(oldDelta) < tolerance) || (Math.abs(y0) <= Math.abs(y1)))
      {
        delta = 0.5D * dx;
        oldDelta = delta;
      }
      else
      {
        double r3 = y1 / y0;
        double p1;
        double p;
        double p1;
        if (x0 == x2)
        {
          double p = dx * r3;
          p1 = 1.0D - r3;
        }
        else
        {
          double r1 = y0 / y2;
          double r2 = y1 / y2;
          p = r3 * (dx * r1 * (r1 - r2) - (x1 - x0) * (r2 - 1.0D));
          p1 = (r1 - 1.0D) * (r2 - 1.0D) * (r3 - 1.0D);
        }
        if (p > 0.0D) {
          p1 = -p1;
        } else {
          p = -p;
        }
        if ((2.0D * p >= 1.5D * dx * p1 - Math.abs(tolerance * p1)) || (p >= Math.abs(0.5D * oldDelta * p1)))
        {
          delta = 0.5D * dx;
          oldDelta = delta;
        }
        else
        {
          oldDelta = delta;
          delta = p / p1;
        }
      }
      x0 = x1;
      y0 = y1;
      if (Math.abs(delta) > tolerance) {
        x1 += delta;
      } else if (dx > 0.0D) {
        x1 += 0.5D * tolerance;
      } else if (dx <= 0.0D) {
        x1 -= 0.5D * tolerance;
      }
      y1 = f.value(x1);
      if ((y1 > 0.0D ? 1 : 0) == (y2 > 0.0D ? 1 : 0))
      {
        x2 = x0;
        y2 = y0;
        delta = x1 - x0;
        oldDelta = delta;
      }
      i++;
    }
    throw new MaxIterationsExceededException(maximalIterationCount);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.solvers.BrentSolver
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */