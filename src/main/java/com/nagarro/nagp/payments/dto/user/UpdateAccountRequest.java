package com.nagarro.nagp.payments.dto.user;

import com.nagarro.nagp.payments.enums.user.UpdateAccountAction;

/**
 * The Class UpdateAccountRequest.
 */
public class UpdateAccountRequest {

	/** The action. */
	private UpdateAccountAction action;

	/** The branch. */
	private String branch;

	/** The balance. */
	private Long balance;

	/**
	 * Instantiates a new update account request.
	 */
	public UpdateAccountRequest() {
	}

	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public UpdateAccountAction getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 *
	 * @param action
	 *            the new action
	 */
	public void setAction(UpdateAccountAction action) {
		this.action = action;
	}

	/**
	 * Gets the branch.
	 *
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * Sets the branch.
	 *
	 * @param branch
	 *            the new branch
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * Gets the balance.
	 *
	 * @return the balance
	 */
	public Long getBalance() {
		return balance;
	}

	/**
	 * Sets the balance.
	 *
	 * @param balance
	 *            the new balance
	 */
	public void setBalance(Long balance) {
		this.balance = balance;
	}

}
