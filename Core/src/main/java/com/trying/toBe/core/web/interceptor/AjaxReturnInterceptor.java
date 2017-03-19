package com.trying.toBe.core.web.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Value;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.trying.toBe.core.exception.AssertsException;
import com.trying.toBe.core.log.ErrorLogAppender;
import com.trying.toBe.core.util.CommonHelper;
import com.trying.toBe.core.web.action.BaseAction;
import com.trying.toBe.core.web.action.BaseResult;
/**
 * 自定义ajax处理
 */
public class AjaxReturnInterceptor extends AbstractInterceptor {

    @Value("${produce:false}")
    private boolean produce;

    /**
     * 特殊ajax请求匹配字符串
     */
    private static final String PATTERN_SPECIAL_AJAX = "specialAjax";

    /**
     * 系统定义的异步分页请求匹配字符串
     */
    private static final String PATTERN_PAGE_AJAX = "pageAjax";

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String actionName = invocation.getProxy().getActionName();
        if ((actionName.contains(AjaxReturnInterceptor.PATTERN_SPECIAL_AJAX) || actionName.contains(AjaxReturnInterceptor.PATTERN_PAGE_AJAX)) && !invocation.getProxy().getMethod().equals("execute")) {//这里的含义在于struts2中配置使用直接跳转而使用struts默认执行方法
            ActionContext ctx = invocation.getInvocationContext();
            HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
            if (CommonHelper.requestIsAjax(request)) {
                try {
                	 System.err.println(222);
                    return invocation.invoke();
                } catch (Exception ex) {
                    System.err.println(222);
                    if (ex instanceof AssertsException) {//业务日志记录
                        ErrorLogAppender.error(invocation,((AssertsException) ex).getLogMessage());
                    } else {//自定义ajax请求异常日志记录
                        ErrorLogAppender.error(invocation,ex.getMessage(), ex);
                    }
                    if (actionName.contains(AjaxReturnInterceptor.PATTERN_SPECIAL_AJAX)) {
                        //处理自定义ajax异常
                        BaseResult result = ((BaseAction) invocation.getAction()).getResult();
                        result.setResult(false);
                        if (ex instanceof AssertsException) {
                            //如果抛出的异常是自定义断言，则向前台输出断言的提示。
                            result.setMessage(((AssertsException) ex).getErrorMessage());
                        } else {
                            //判断自定义ajax中的其它异常信息
                            if (produce) {
                                result.setMessage("操作失败,请联系管理员.");
                            } else {
                                result.setMessage(ex.getMessage());
                            }
                        }
                        return BaseAction.AJAX;
                    } else if (actionName.contains(AjaxReturnInterceptor.PATTERN_PAGE_AJAX)) {
                        //处理分页查询时候出现的异常
                        return BaseAction.PAGE;
                    }
                }
            }
        }
        return invocation.invoke();
    }

}
