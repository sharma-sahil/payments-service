package com.nagarro.nagp.payments.exception;

/**
 * The Class TransactionException.
 */
public class TransactionException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4487190720124165712L;

	/** The error code. */
	private String errorCode;

	public TransactionException(final String message) {
		super(message);
	}

	public TransactionException(final String message, final String errorCode) {
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
	public TransactionException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public TransactionException(final String message, final Throwable cause, final String errorCode) {
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
