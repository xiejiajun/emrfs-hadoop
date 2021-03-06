package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.MathRuntimeException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.polynomials.PolynomialFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.polynomials.PolynomialSplineFunction;

public class SplineInterpolator
  implements UnivariateRealInterpolator
{
  public PolynomialSplineFunction interpolate(double[] x, double[] y)
  {
    if (x.length != y.length) {
      throw MathRuntimeException.createIllegalArgumentException("dimension mismatch {0} != {1}", new Object[] { Integer.valueOf(x.length), Integer.valueOf(y.length) });
    }
    if (x.length < 3) {
      throw MathRuntimeException.createIllegalArgumentException("{0} points are required, got only {1}", new Object[] { Integer.valueOf(3), Integer.valueOf(x.length) });
    }
    int n = x.length - 1;
    for (int i = 0; i < n; i++) {
      if (x[i] >= x[(i + 1)]) {
        throw MathRuntimeException.createIllegalArgumentException("points {0} and {1} are not strictly increasing ({2} >= {3})", new Object[] { Integer.valueOf(i), Integer.valueOf(i + 1), Double.valueOf(x[i]), Double.valueOf(x[(i + 1)]) });
      }
    }
    double[] h = new double[n];
    for (int i = 0; i < n; i++) {
      h[i] = (x[(i + 1)] - x[i]);
    }
    double[] mu = new double[n];
    double[] z = new double[n + 1];
    mu[0] = 0.0D;
    z[0] = 0.0D;
    double g = 0.0D;
    for (int i = 1; i < n; i++)
    {
      g = 2.0D * (x[(i + 1)] - x[(i - 1)]) - h[(i - 1)] * mu[(i - 1)];
      h[i] /= g;
      z[i] = ((3.0D * (y[(i + 1)] * h[(i - 1)] - y[i] * (x[(i + 1)] - x[(i - 1)]) + y[(i - 1)] * h[i]) / (h[(i - 1)] * h[i]) - h[(i - 1)] * z[(i - 1)]) / g);
    }
    double[] b = new double[n];
    double[] c = new double[n + 1];
    double[] d = new double[n];
    
    z[n] = 0.0D;
    c[n] = 0.0D;
    for (int j = n - 1; j >= 0; j--)
    {
      z[j] -= mu[j] * c[(j + 1)];
      b[j] = ((y[(j + 1)] - y[j]) / h[j] - h[j] * (c[(j + 1)] + 2.0D * c[j]) / 3.0D);
      d[j] = ((c[(j + 1)] - c[j]) / (3.0D * h[j]));
    }
    PolynomialFunction[] polynomials = new PolynomialFunction[n];
    double[] coefficients = new double[4];
    for (int i = 0; i < n; i++)
    {
      coefficients[0] = y[i];
      coefficients[1] = b[i];
      coefficients[2] = c[i];
      coefficients[3] = d[i];
      polynomials[i] = new PolynomialFunction(coefficients);
    }
    return new PolynomialSplineFunction(x, polynomials);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.analysis.interpolation.SplineInterpolator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */