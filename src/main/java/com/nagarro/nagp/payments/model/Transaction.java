package com.nagarro.nagp.payments.model;

import java.time.LocalDateTime;

import com.nagarro.nagp.payments.enums.PaymentAction;

/**
 * The Class Transaction.
 */
public class Transaction {

	/** The transaction id. */
	private long transactionId;

	/** The account number. */
	private String accountNumber;

	/** The action. */
	private PaymentAction action;

	/** The old balance. */
	private long oldBalance;

	/** The transaction amount. */
	private long transactionAmount;

	/** The destination account. */
	private String destinationAccount;

	/** The created on. */
	private LocalDateTime createdOn;

	/**
	 * Instantiates a new payment.
	 */
	public Transaction() {
	}

	/**
	 * Gets the transaction id.
	 *
	 * @return the transaction id
	 */
	public long getTransactionId() {
		return transactionId;
	}

	/**
	 * Sets the transaction id.
	 *
	 * @param transactionId
	 *            the new transaction id
	 */
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * Gets the account number.
	 *
	 * @return the account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Sets the account number.
	 *
	 * @param accountNumber
	 *            the new account number
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
	 * Gets the created on.
	 *
	 * @return the created on
	 */
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	/**
	 * Sets the created on.
	 *
	 * @param createdOn
	 *            the new created on
	 */
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * Gets the old balance.
	 *
	 * @return the old balance
	 */
	public long getOldBalance() {
		return oldBalance;
	}

	/**
	 * Sets the old balance.
	 *
	 * @param oldBalance
	 *            the new old balance
	 */
	public void setOldBalance(long oldBalance) {
		this.oldBalance = oldBalance;
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
	 * @param transactionAmount
	 *            the new transaction amount
	 */
	public void setTransactionAmount(long transactionAmount) {
		this.transactionAmount = transactionAmount;
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
