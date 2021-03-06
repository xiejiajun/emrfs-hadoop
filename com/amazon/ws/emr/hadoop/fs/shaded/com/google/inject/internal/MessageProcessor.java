package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Guice;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Message;
import java.util.logging.Level;
import java.util.logging.Logger;

final class MessageProcessor
  extends AbstractProcessor
{
  private static final Logger logger = Logger.getLogger(Guice.class.getName());
  
  MessageProcessor(Errors errors)
  {
    super(errors);
  }
  
  public Boolean visit(Message message)
  {
    if (message.getCause() != null)
    {
      String rootMessage = getRootMessage(message.getCause());
      logger.log(Level.INFO, "An exception was caught and reported. Message: " + rootMessage, message.getCause());
    }
    errors.addMessage(message);
    return Boolean.valueOf(true);
  }
  
  public static String getRootMessage(Throwable t)
  {
    Throwable cause = t.getCause();
    return cause == null ? t.toString() : getRootMessage(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.MessageProcessor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */