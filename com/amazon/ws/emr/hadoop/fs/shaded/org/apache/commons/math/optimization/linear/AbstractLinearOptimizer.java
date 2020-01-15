package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.linear;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MaxIterationsExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.GoalType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.OptimizationException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.RealPointValuePair;
import java.util.Collection;

public abstract class AbstractLinearOptimizer
  implements LinearOptimizer
{
  public static final int DEFAULT_MAX_ITERATIONS = 100;
  protected LinearObjectiveFunction function;
  protected Collection<LinearConstraint> linearConstraints;
  protected GoalType goal;
  protected boolean nonNegative;
  private int maxIterations;
  private int iterations;
  
  protected AbstractLinearOptimizer()
  {
    setMaxIterations(100);
  }
  
  public void setMaxIterations(int maxIterations)
  {
    this.maxIterations = maxIterations;
  }
  
  public int getMaxIterations()
  {
    return maxIterations;
  }
  
  public int getIterations()
  {
    return iterations;
  }
  
  protected void incrementIterationsCounter()
    throws OptimizationException
  {
    if (++iterations > maxIterations) {
      throw new OptimizationException(new MaxIterationsExceededException(maxIterations));
    }
  }
  
  public RealPointValuePair optimize(LinearObjectiveFunction f, Collection<LinearConstraint> constraints, GoalType goalType, boolean restrictToNonNegative)
    throws OptimizationException
  {
    function = f;
    linearConstraints = constraints;
    goal = goalType;
    nonNegative = restrictToNonNegative;
    
    iterations = 0;
    
    return doOptimize();
  }
  
  protected abstract RealPointValuePair doOptimize()
    throws OptimizationException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.linear.AbstractLinearOptimizer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */