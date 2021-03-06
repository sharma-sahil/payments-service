package com.nagarro.nagp.payments.dao.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.nagarro.nagp.payments.dao.ITransactionDAO;
import com.nagarro.nagp.payments.model.Transaction;
import com.nagarro.nagp.payments.service.impl.PaymentsServiceImpl;

/**
 * The Class TransactionDAOImpl.
 */
@Component
public class TransactionDAOImpl implements ITransactionDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentsServiceImpl.class);

	private static List<Transaction> transactions = new ArrayList<>();

	@Override
	public void recordTransaction(Transaction transaction) {
		transaction.setTransactionId(getNewTransactionId());
		transaction.setCreatedOn(LocalDateTime.now());
		transactions.add(transaction);
		LOGGER.info("Added a new transaction with ID: {}", transaction.getTransactionId());
	}

	@Override
	public List<Transaction> getAccountTransactions(String accountNumber) {
		return transactions.stream().filter(t -> t.getAccountNumber().equalsIgnoreCase(accountNumber))
				.collect(Collectors.toList());
	}

	private long getNewTransactionId() {
		long paymentID = 1L;
		if (null != transactions && transactions.size() > 0) {
			paymentID = transactions.get(transactions.size() - 1).getTransactionId() + 1;
		}

		return paymentID;
	}

}
