package com.trying.toBe.core.exception;

/**
 * 业务断言异常,表示不能满足业务上的要求
 */
public class AssertsException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -2163002864898861130L;
    /** 详细的业务要求错误信息 */
    private String errorMessage;

    /** 用于在日志记录业务断言信息*/
    private String logMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public AssertsException(String errorMessage, String logMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.logMessage = logMessage;
    }

    public AssertsException(String errorMessage, String logMessage, String message) {
        super(message);
        this.errorMessage = errorMessage;
        this.logMessage = logMessage;
    }

    public AssertsException(String errorMessage, String message, Throwable cause) {
        super(message, cause);
        this.errorMessage = errorMessage;
    }

    public AssertsException(String errorMessage, Throwable cause) {
        super(cause);
        this.errorMessage = errorMessage;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }
}

