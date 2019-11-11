package com.nagarro.nagp.payments.dao;

import java.util.List;

import com.nagarro.nagp.payments.model.Transaction;

/**
 * The Interface ITransactionDAO.
 */
public interface ITransactionDAO {

	void recordTransaction(Transaction transaction);

	List<Transaction> getAccountTransactions(String accountNumber);

}
