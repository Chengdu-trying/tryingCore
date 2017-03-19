package com.trying.toBe.core.util;

import java.util.UUID;
import java.util.regex.Pattern;
import org.slf4j.helpers.MessageFormatter;

public class StringUtils
{
  private static final Pattern PATTERN_COMMA = Pattern.compile(",");
  private static final Pattern PATTERN_TAB = Pattern.compile("\\t");
  private static final Pattern PATTERN_V_LINE = Pattern.compile("\\|");
  private static final Pattern PATTERN_SPACE = Pattern.compile("\\s+");

  public static String[] splitByComma(String s)
  {
    return PATTERN_COMMA.split(s);
  }

  public static String[] splitByTab(String s)
  {
    return PATTERN_TAB.split(s);
  }

  public static String[] splitByVLine(String s)
  {
    return PATTERN_V_LINE.split(s);
  }

  public static String[] splitBySpace(String s)
  {
    return PATTERN_SPACE.split(s);
  }

  public static String nullIf(String source, String instead)
  {
    return org.springframework.util.StringUtils.hasText(source) ? source : instead;
  }

  public static String format(String message, Object[] args)
  {
    return MessageFormatter.arrayFormat(message, args).getMessage();
  }

  public static String uuid()
  {
    return UUID.randomUUID().toString().replace("-", "").toUpperCase();
  }

  public static boolean isNotEmpty(String str) {
	// Alibaba dubbo 
	return (str != null) && (str.length() > 0);
  }
}
