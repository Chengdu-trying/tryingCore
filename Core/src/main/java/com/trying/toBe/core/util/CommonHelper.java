package com.trying.toBe.core.util;

import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;

import com.google.common.base.Joiner;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;

public final class CommonHelper
{
  private static Joiner joiner = Joiner.on(",");

  public static String analyzeClientIpAddress(HttpServletRequest request)
  {
    String ip = request.getHeader("x-forwarded-for");
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getHeader("HTTP_CLIENT_IP");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getHeader("HTTP_X_FORWARDED_FOR");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getRemoteAddr();
    }
    return ip;
  }

  public static boolean requestIsAjax(HttpServletRequest request)
  {
    return (request.getHeader("X-Requested-With") != null) && ("XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
  }

  public static String printRequestParameter(ActionInvocation invocation)
  {
    ActionContext ctx = invocation.getInvocationContext();
    HttpServletRequest request = (HttpServletRequest)ctx.get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");

    String actionName = invocation.getAction().getClass().getName();
    String actionMethodName = invocation.getProxy().getMethod();

    StringBuffer log = new StringBuffer();
    log.append("\nClassName:" + actionName + "\n");
    log.append("MethodName:" + actionMethodName + "\n");

    Map<String,Object[]> params = request.getParameterMap();
    if (!params.isEmpty()) {
      log.append("↓↓↓↓↓↓↓↓请求参数列表↓↓↓↓↓↓↓↓↓↓\n");
      for (Map.Entry<String,Object[]> e : params.entrySet()) {
        log.append((String)e.getKey() + " = " + joiner.join((Object[])e.getValue()) + "\n");
      }
      log.append("↑↑↑↑↑↑↑↑请求参数列表↑↑↑↑↑↑↑↑↑↑\n");
    }
    return log.toString();
  }
}
