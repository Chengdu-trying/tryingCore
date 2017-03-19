package com.trying.toBe.core.web.action;

import java.util.HashMap;
import java.util.Map;

public class BaseResult {

	private boolean result = true;

	private String message = "";
	private Map<String, Object> body = new HashMap();

	public boolean isResult() {
		return this.result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getBody() {
		return this.body;
	}

	public void setBody(Map<String, Object> body) {
		this.body = body;
	}
}
