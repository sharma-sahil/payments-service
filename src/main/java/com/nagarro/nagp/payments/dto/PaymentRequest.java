package com.nagarro.nagp.payments.dto;

import com.nagarro.nagp.payments.enums.PaymentAction;

/**
 * The Class PaymentRequest.
 */
public class PaymentRequest {

	/** The action. */
	private PaymentAction action;

	/** The source account. */
	private String sourceAccount;

	/** The transaction amount. */
	private long transactionAmount;

	/** The destination account. */
	private String destinationAccount;

	/**
	 * Instantiates a new payment request.
	 */
	public PaymentRequest() {
	}

	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public PaymentAction getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 *
	 * @param action
	 *            the new action
	 */
	public void setAction(PaymentAction action) {
		this.action = action;
	}

	/**
	 * Gets the source account.
	 *
	 * @return the source account
	 */
	public String getSourceAccount() {
		return sourceAccount;
	}

	/**
	 * Sets the source account.
	 *
	 * @param sourceAccount
	 *            the new source account
	 */
	public void setSourceAccount(String sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	/**
	 * Gets the transaction amount.
	 *
	 * @return the transaction amount
	 */
	public long getTransactionAmount() {
		return transactionAmount;
	}

	/**
	 * Sets the transaction amount.
	 *
	 * @param amount
	 *            the new transaction amount
	 */
	public void setTransactionAmount(long amount) {
		this.transactionAmount = amount;
	}

	/**
	 * Gets the destination account.
	 *
	 * @return the destination account
	 */
	public String getDestinationAccount() {
		return destinationAccount;
	}

	/**
	 * Sets the destination account.
	 *
	 * @param destinationAccount
	 *            the new destination account
	 */
	public void setDestinationAccount(String destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

}
