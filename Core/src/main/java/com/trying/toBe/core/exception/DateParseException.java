package com.trying.toBe.core.exception;

public class DateParseException extends RuntimeException
{
  private static final long serialVersionUID = 4727819380287187682L;

  public DateParseException()
  {
  }

  public DateParseException(String message)
  {
    super(message);
  }

  public DateParseException(String message, Throwable cause) {
    super(message, cause);
  }

  public DateParseException(Throwable cause) {
    super(cause);
  }
}