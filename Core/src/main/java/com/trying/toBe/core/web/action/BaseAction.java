package com.trying.toBe.core.web.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	public static final String AJAX = "ajax";
	public static final String PAGE = "page";
	// protected User userInfo=new User();
	protected Map<String, Date> dateMap = new HashMap();
	protected BaseResult result = new BaseResult();
	protected String random;
	private Date dateTime = new Date();
	protected PageResource pageResource = new PageResource();
	// 默認参数列表
	protected Map<String, String> stringMap = new HashMap<String, String>();

	protected HttpServletRequest request;
	protected HttpSession session;
	protected HttpServletResponse response;
	//時間
	private String dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}
	
	protected HttpServletRequest getHttpServletRequest() {
		return ServletActionContext.getRequest();
	}

	protected void setContextValue(String key, Object obj) {
		getHttpServletRequest().setAttribute(key, obj);
		ServletActionContext.getContext().put(key, obj);
	}

	public Map<String, String> getStringMap() {
		return stringMap;
	}

	public void setStringMap(Map<String, String> stringMap) {
		this.stringMap = stringMap;
	}

	public String getDateFormat() {
		return this.dateFormat;
	}

	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public PageResource getPageResource() {
		return this.pageResource;
	}

	public void setPageResource(PageResource pageResource) {
		this.pageResource = pageResource;
	}

	public Map<String, Date> getDateMap() {
		return this.dateMap;
	}

	public void setDateMap(Map<String, Date> dateMap) {
		this.dateMap = dateMap;
	}

	public BaseResult getResult() {
		return this.result;
	}

	public void setResult(BaseResult result) {
		this.result = result;
	}

	public Map<String, Object> getAjaxResult() {
		return this.result.getBody();
	}

	public String getRandom() {
		return this.random;
	}

	public void setRandom(String random) {
		this.random = random;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
}
