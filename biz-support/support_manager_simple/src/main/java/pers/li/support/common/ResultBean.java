package pers.li.support.common;

import java.io.Serializable;

/**
 *
 *  异步调用结果返回bean：
 *
 */
public class ResultBean<T> implements Serializable{

	private static final long serialVersionUID = -8363923199593511398L;
	private long code;
	private long errorCode;
	private T data;
	private String errorMessage;
	
	public ResultBean(){}

	/**
	 * 接口出现可捕获异常时调用
	 * @param errorCode
	 * @param errorMessage
	 */
	public ResultBean(long errorCode,  String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * 接口正常访问时调用
	 * @param code
	 * @param data
	 */
	public ResultBean(long code,  T data) {
		super();
		this.code = code;
		this.data = data;
	}

	/**
	 * 自定义返回
	 * @param code
	 * @param errorCode
	 * @param data
	 * @param errorMessage
	 */
	public ResultBean(long code, long errorCode, T data, String errorMessage) {
		super();
		this.code = code;
		this.errorCode = errorCode;
		this.data = data;
		this.errorMessage = errorMessage;
	}

	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public long getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(long errorCode) {
		this.errorCode = errorCode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ResultBean [code=" + code + ", errorCode=" + errorCode
				+ ", data=" + data + ", errorMessage=" + errorMessage + "]";
	}

	
}
