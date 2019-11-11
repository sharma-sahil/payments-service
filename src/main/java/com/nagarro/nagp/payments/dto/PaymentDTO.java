package com.nagarro.nagp.payments.dto;

import java.time.LocalDateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class PaymentDTO.
 */
public class PaymentDTO extends PaymentRequest {

	/** The transaction time. */
	private LocalDateTime transactionTime;

	/** The old balance. */
	private long oldBalance;

	/** The new balance. */
	private long newBalance;

	/**
	 * Instantiates a new payment DTO.
	 */
	public PaymentDTO() {
	}

	/**
	 * Gets the transaction time.
	 *
	 * @return the transaction time
	 */
	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}

	/**
	 * Sets the transaction time.
	 *
	 * @param transactionTime
	 *            the new transaction time
	 */
	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
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
	 * Gets the new balance.
	 *
	 * @return the new balance
	 */
	public long getNewBalance() {
		return newBalance;
	}

	/**
	 * Sets the new balance.
	 *
	 * @param newBalance
	 *            the new new balance
	 */
	public void setNewBalance(long newBalance) {
		this.newBalance = newBalance;
	}

}
