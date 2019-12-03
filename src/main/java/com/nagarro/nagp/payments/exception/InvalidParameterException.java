package com.nagarro.nagp.payments.exception;

/**
 * The Class InvalidParametreException.
 */
public class InvalidParameterException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6598649084980762817L;

	/** The error code. */
	private String errorCode;

	/**
	 * Instantiates a new invalid paramtere exception.
	 *
	 * @param message
	 *            the message
	 */
	public InvalidParameterException(final String message) {
		super(message);
	}

	public InvalidParameterException(final String message, final String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * Instantiates a new invalid paramtere exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public InvalidParameterException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public InvalidParameterException(final String message, final Throwable cause, final String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public String getErrorCode() {
		return this.errorCode;
	}

	/**
	 * Sets the error code.
	 *
	 * @param errorCode
	 *            the new error code
	 */
	public void setErrorCode(final String errorCode) {
		this.errorCode = errorCode;
	}

}
