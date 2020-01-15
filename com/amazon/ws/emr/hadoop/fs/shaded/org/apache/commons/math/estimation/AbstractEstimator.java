package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.estimation;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.DecompositionSolver;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.InvalidMatrixException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.LUDecompositionImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.MatrixUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.linear.RealMatrix;
import java.util.Arrays;

@Deprecated
public abstract class AbstractEstimator
  implements Estimator
{
  public static final int DEFAULT_MAX_COST_EVALUATIONS = 100;
  protected WeightedMeasurement[] measurements;
  protected EstimatedParameter[] parameters;
  protected double[] jacobian;
  protected int cols;
  protected int rows;
  protected double[] residuals;
  protected double cost;
  private int maxCostEval;
  private int costEvaluations;
  private int jacobianEvaluations;
  
  protected AbstractEstimator()
  {
    setMaxCostEval(100);
  }
  
  public final void setMaxCostEval(int maxCostEval)
  {
    this.maxCostEval = maxCostEval;
  }
  
  public final int getCostEvaluations()
  {
    return costEvaluations;
  }
  
  public final int getJacobianEvaluations()
  {
    return jacobianEvaluations;
  }
  
  protected void updateJacobian()
  {
    incrementJacobianEvaluationsCounter();
    Arrays.fill(jacobian, 0.0D);
    int index = 0;
    for (int i = 0; i < rows; i++)
    {
      WeightedMeasurement wm = measurements[i];
      double factor = -Math.sqrt(wm.getWeight());
      for (int j = 0; j < cols; j++) {
        jacobian[(index++)] = (factor * wm.getPartial(parameters[j]));
      }
    }
  }
  
  protected final void incrementJacobianEvaluationsCounter()
  {
    jacobianEvaluations += 1;
  }
  
  protected void updateResidualsAndCost()
    throws EstimationException
  {
    if (++costEvaluations > maxCostEval) {
      throw new EstimationException("maximal number of evaluations exceeded ({0})", new Object[] { Integer.valueOf(maxCostEval) });
    }
    cost = 0.0D;
    int index = 0;
    for (int i = 0; i < rows; index += cols)
    {
      WeightedMeasurement wm = measurements[i];
      double residual = wm.getResidual();
      residuals[i] = (Math.sqrt(wm.getWeight()) * residual);
      cost += wm.getWeight() * residual * residual;i++;
    }
    cost = Math.sqrt(cost);
  }
  
  public double getRMS(EstimationProblem problem)
  {
    WeightedMeasurement[] wm = problem.getMeasurements();
    double criterion = 0.0D;
    for (int i = 0; i < wm.length; i++)
    {
      double residual = wm[i].getResidual();
      criterion += wm[i].getWeight() * residual * residual;
    }
    return Math.sqrt(criterion / wm.length);
  }
  
  public double getChiSquare(EstimationProblem problem)
  {
    WeightedMeasurement[] wm = problem.getMeasurements();
    double chiSquare = 0.0D;
    for (int i = 0; i < wm.length; i++)
    {
      double residual = wm[i].getResidual();
      chiSquare += residual * residual / wm[i].getWeight();
    }
    return chiSquare;
  }
  
  public double[][] getCovariances(EstimationProblem problem)
    throws EstimationException
  {
    updateJacobian();
    
    int n = problem.getMeasurements().length;
    int m = problem.getUnboundParameters().length;
    int max = m * n;
    double[][] jTj = new double[m][m];
    for (int i = 0; i < m; i++) {
      for (int j = i; j < m; j++)
      {
        double sum = 0.0D;
        for (int k = 0; k < max; k += m) {
          sum += jacobian[(k + i)] * jacobian[(k + j)];
        }
        jTj[i][j] = sum;
        jTj[j][i] = sum;
      }
    }
    try
    {
      RealMatrix inverse = new LUDecompositionImpl(MatrixUtils.createRealMatrix(jTj)).getSolver().getInverse();
      
      return inverse.getData();
    }
    catch (InvalidMatrixException ime)
    {
      throw new EstimationException("unable to compute covariances: singular problem", new Object[0]);
    }
  }
  
  public double[] guessParametersErrors(EstimationProblem problem)
    throws EstimationException
  {
    int m = problem.getMeasurements().length;
    int p = problem.getUnboundParameters().length;
    if (m <= p) {
      throw new EstimationException("no degrees of freedom ({0} measurements, {1} parameters)", new Object[] { Integer.valueOf(m), Integer.valueOf(p) });
    }
    double[] errors = new double[problem.getUnboundParameters().length];
    double c = Math.sqrt(getChiSquare(problem) / (m - p));
    double[][] covar = getCovariances(problem);
    for (int i = 0; i < errors.length; i++) {
      errors[i] = (Math.sqrt(covar[i][i]) * c);
    }
    return errors;
  }
  
  protected void initializeEstimate(EstimationProblem problem)
  {
    costEvaluations = 0;
    jacobianEvaluations = 0;
    
    measurements = problem.getMeasurements();
    parameters = problem.getUnboundParameters();
    
    rows = measurements.length;
    cols = parameters.length;
    jacobian = new double[rows * cols];
    residuals = new double[rows];
    
    cost = Double.POSITIVE_INFINITY;
  }
  
  public abstract void estimate(EstimationProblem paramEstimationProblem)
    throws EstimationException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.estimation.AbstractEstimator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */