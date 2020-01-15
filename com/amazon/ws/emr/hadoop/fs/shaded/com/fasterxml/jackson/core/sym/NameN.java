package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym;

import java.util.Arrays;

public final class NameN
  extends Name
{
  private final int q1;
  private final int q2;
  private final int q3;
  private final int q4;
  private final int qlen;
  private final int[] q;
  
  NameN(String name, int hash, int q1, int q2, int q3, int q4, int[] quads, int quadLen)
  {
    super(name, hash);
    this.q1 = q1;
    this.q2 = q2;
    this.q3 = q3;
    this.q4 = q4;
    q = quads;
    qlen = quadLen;
  }
  
  public static NameN construct(String name, int hash, int[] q, int qlen)
  {
    if (qlen < 4) {
      throw new IllegalArgumentException();
    }
    int q1 = q[0];
    int q2 = q[1];
    int q3 = q[2];
    int q4 = q[3];
    
    int rem = qlen - 4;
    int[] buf;
    int[] buf;
    if (rem > 0) {
      buf = Arrays.copyOfRange(q, 4, qlen);
    } else {
      buf = null;
    }
    return new NameN(name, hash, q1, q2, q3, q4, buf, qlen);
  }
  
  public boolean equals(int quad)
  {
    return false;
  }
  
  public boolean equals(int quad1, int quad2)
  {
    return false;
  }
  
  public boolean equals(int quad1, int quad2, int quad3)
  {
    return false;
  }
  
  public boolean equals(int[] quads, int len)
  {
    if (len != qlen) {
      return false;
    }
    if (quads[0] != q1) {
      return false;
    }
    if (quads[1] != q2) {
      return false;
    }
    if (quads[2] != q3) {
      return false;
    }
    if (quads[3] != q4) {
      return false;
    }
    switch (len)
    {
    default: 
      return _equals2(quads);
    case 8: 
      if (quads[7] != q[3]) {
        return false;
      }
    case 7: 
      if (quads[6] != q[2]) {
        return false;
      }
    case 6: 
      if (quads[5] != q[1]) {
        return false;
      }
    case 5: 
      if (quads[4] != q[0]) {
        return false;
      }
      break;
    }
    return true;
  }
  
  private final boolean _equals2(int[] quads)
  {
    int end = qlen - 4;
    for (int i = 0; i < end; i++) {
      if (quads[(i + 4)] != q[i]) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.sym.NameN
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */