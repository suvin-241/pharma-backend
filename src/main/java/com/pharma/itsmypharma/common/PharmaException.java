package com.pharma.itsmypharma.common;

import java.util.List;

public class PharmaException extends Exception {

	private static final long serialVersionUID = 1L;

	public PharmaException() {

	}

	/** The error code. */
	private String errorCode;

	/** The error msg. */
	private String errorMsg;

	/** The fatal error */
	private boolean isFatal;

	private List<String> errorList;

	/**
	 * 
	 * 
	 * @param errorMessage the error message
	 */
	public PharmaException(String errorMessage) {
		super(errorMessage);
		this.errorMsg = errorMessage;
	}

	public PharmaException(List<String> errorList) {

		this.errorList = errorList;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	/**
	 * 
	 * 
	 * @param errorMessage the error message
	 * @param cause        the cause
	 */
	public PharmaException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
		this.errorMsg = errorMessage;
	}

	/**
	 * 
	 * 
	 * @param throwable the throwable
	 */
	public PharmaException(Throwable throwable) {
		super(throwable);
	}

	/**
	 * Gets the error code.
	 * 
	 * @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 * 
	 * @param errorCode the new error code
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets the error msg.
	 * 
	 * @return the error msg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * Sets the error msg.
	 * 
	 * @param errorMsg the new error msg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * Gets the isFatal
	 * 
	 * @return the fatal
	 */
	public boolean isFatal() {
		return isFatal;
	}

	/**
	 * Sets isFatal
	 * 
	 * @param isFatal - boolean
	 */
	public void setFatal(boolean isFatal) {
		this.isFatal = isFatal;
	}

}
