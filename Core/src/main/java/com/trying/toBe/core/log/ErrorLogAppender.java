package com.trying.toBe.core.log;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.trying.toBe.core.util.CommonHelper;

public final class ErrorLogAppender
{
  private static final Logger logger = Logger.getLogger(ErrorLogAppender.class);

  public static void error(ActionInvocation invocation, String message) {
    logger.error(CommonHelper.printRequestParameter(invocation));
    logger.error(message);
  }

  public static void error(ActionInvocation invocation, String message, Throwable throwable) {
    logger.error(CommonHelper.printRequestParameter(invocation));
    logger.error(message, throwable);
  }
}
