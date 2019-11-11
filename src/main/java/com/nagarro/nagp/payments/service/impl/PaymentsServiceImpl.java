package com.nagarro.nagp.payments.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.payments.client.UserClient;
import com.nagarro.nagp.payments.dao.ITransactionDAO;
import com.nagarro.nagp.payments.dto.PaymentDTO;
import com.nagarro.nagp.payments.dto.PaymentRequest;
import com.nagarro.nagp.payments.dto.user.AccountDTO;
import com.nagarro.nagp.payments.dto.user.UpdateAccountRequest;
import com.nagarro.nagp.payments.model.Transaction;
import com.nagarro.nagp.payments.service.IPaymentsService;

@Service
public class PaymentsServiceImpl implements IPaymentsService {

	@Autowired
	private ITransactionDAO transactionDAO;

	/** The user client. */
	@Autowired
	private UserClient userClient;

	@Override
	public void recordTransaction(PaymentRequest request) {

		AccountDTO account = this.userClient.getAccount(request.getSourceAccount());
		UpdateAccountRequest updateAccountRequest = new UpdateAccountRequest();
		long oldBalance = account.getBalance();
		long newBalance = 0L;

		Transaction transaction = new Transaction();
		transaction.setAccountNumber(request.getSourceAccount());
		transaction.setTransactionAmount(request.getTransactionAmount());
		transaction.setOldBalance(oldBalance);
		transaction.setAction(request.getAction());

		switch (request.getAction()) {
		case DEPOSIT:
			newBalance = oldBalance + request.getTransactionAmount();
			break;
		case WITHDRAW:
			newBalance = oldBalance - request.getTransactionAmount();
			break;
		case TRANSFER:
			transaction.setDestinationAccount(request.getDestinationAccount());
			newBalance = oldBalance - request.getTransactionAmount();
			break;
		default:
			// DO nothing
		}

		this.transactionDAO.recordTransaction(transaction);
		updateAccountRequest.setBalance(newBalance);
		this.userClient.updateAccountDetails(request.getSourceAccount(), updateAccountRequest);

	}

	@Override
	public List<PaymentDTO> getAccountTransactions(final String accountNumber) {
		List<Transaction> transactions = this.transactionDAO.getAccountTransactions(accountNumber);
		List<PaymentDTO> response = new ArrayList<>();

		transactions.forEach(t -> {
			response.add(transformTransactionToDTO(t));
		});

		return response;
	}

	private PaymentDTO transformTransactionToDTO(final Transaction transaction) {
		PaymentDTO retVal = new PaymentDTO();
		retVal.setAction(transaction.getAction());
		retVal.setTransactionAmount(transaction.getTransactionAmount());
		retVal.setSourceAccount(transaction.getAccountNumber());
		retVal.setDestinationAccount(transaction.getDestinationAccount());
		retVal.setOldBalance(transaction.getOldBalance());
		retVal.setTransactionTime(transaction.getCreatedOn());

		switch (transaction.getAction()) {
		case DEPOSIT:
			retVal.setNewBalance(transaction.getOldBalance() + transaction.getTransactionAmount());
			break;
		case TRANSFER:
		case WITHDRAW:
			retVal.setNewBalance(transaction.getOldBalance() + transaction.getTransactionAmount());
			break;
		default:
			break;
		}

		return retVal;
	}

}
