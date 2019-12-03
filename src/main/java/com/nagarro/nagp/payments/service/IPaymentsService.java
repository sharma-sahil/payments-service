package com.nagarro.nagp.payments.service;

import java.util.List;

import com.nagarro.nagp.payments.dto.PaymentDTO;
import com.nagarro.nagp.payments.dto.PaymentRequest;
import com.nagarro.nagp.payments.exception.TransactionException;

/**
 * The Interface IPaymentsService.
 */
public interface IPaymentsService {

	/**
	 * Record transaction.
	 *
	 * @param request
	 *            the request
	 * @throws TransactionException
	 *             the transaction exception
	 */
	void recordTransaction(PaymentRequest request) throws TransactionException;

	/**
	 * Gets the account transactions.
	 *
	 * @param accountNumber
	 *            the account number
	 * @return the account transactions
	 */
	List<PaymentDTO> getAccountTransactions(String accountNumber);

}
