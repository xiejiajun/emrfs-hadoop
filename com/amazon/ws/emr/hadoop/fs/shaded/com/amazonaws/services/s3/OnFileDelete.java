package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.FileDeletionEvent;

public abstract interface OnFileDelete
{
  public abstract void onFileDelete(FileDeletionEvent paramFileDeletionEvent);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.OnFileDelete
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */