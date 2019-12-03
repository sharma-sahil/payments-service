package com.nagarro.nagp.payments.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.payments.client.UserClient;
import com.nagarro.nagp.payments.dao.ITransactionDAO;
import com.nagarro.nagp.payments.dto.PaymentDTO;
import com.nagarro.nagp.payments.dto.PaymentRequest;
import com.nagarro.nagp.payments.dto.user.AccountDTO;
import com.nagarro.nagp.payments.dto.user.UpdateAccountRequest;
import com.nagarro.nagp.payments.enums.user.UpdateAccountAction;
import com.nagarro.nagp.payments.exception.InvalidParameterException;
import com.nagarro.nagp.payments.exception.TransactionException;
import com.nagarro.nagp.payments.model.Transaction;
import com.nagarro.nagp.payments.service.IPaymentsService;

@Service
public class PaymentsServiceImpl implements IPaymentsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentsServiceImpl.class);

	@Autowired
	private ITransactionDAO transactionDAO;

	/** The user client. */
	@Autowired
	private UserClient userClient;

	@Override
	public void recordTransaction(PaymentRequest request) throws TransactionException {

		LOGGER.debug("Adding a new transaction for the account :{} with operation : {}, of amount: {}",
				request.getSourceAccount(), request.getAction(), request.getTransactionAmount());

		AccountDTO sourceAccount = this.userClient.getAccount(request.getSourceAccount());
		long oldBalance = sourceAccount.getBalance();
		long newBalance = 0L;

		Transaction transaction = new Transaction();
		transaction.setAccountNumber(request.getSourceAccount());
		transaction.setTransactionAmount(request.getTransactionAmount());
		transaction.setOldBalance(oldBalance);
		transaction.setAction(request.getAction());

		boolean updateDestinationAccount = false;

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
			updateDestinationAccount = true;
			break;
		default:
			// DO nothing
		}

		// update account balance of source account
		try {
			this.updateAccountBalance(request.getSourceAccount(), newBalance);
		} catch (InvalidParameterException e) {
			LOGGER.error("Exception : {} while updating the account balance of Acc : {}", e.getMessage(),
					request.getSourceAccount());
			throw new TransactionException(e.getMessage(), e, e.getErrorCode());
		}

		// update account balance of destination account
		if (updateDestinationAccount) {
			LOGGER.debug("Updating the balance of destination account:{} after fund transfer of balance: {}",
					request.getSourceAccount(), request.getTransactionAmount());
			AccountDTO destinationAccount = this.userClient.getAccount(request.getSourceAccount());
			try {
				this.updateAccountBalance(request.getDestinationAccount(),
						destinationAccount.getBalance() + request.getTransactionAmount());
			} catch (InvalidParameterException e) {
				LOGGER.error("Exception : {} while updating the account balance of account : {}", e.getMessage(),
						request.getDestinationAccount());
				throw new TransactionException(e.getMessage(), e, e.getErrorCode());
			}

		}

		this.transactionDAO.recordTransaction(transaction);

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

	/**
	 * Update account balance.
	 *
	 * @param accountNumber
	 *            the account number
	 * @param newBalance
	 *            the new balance
	 * @throws InvalidParameterException
	 *             the invalid parameter exception
	 */
	private void updateAccountBalance(final String accountNumber, final long newBalance)
			throws InvalidParameterException {
		LOGGER.debug("Updating account balance of {} to {}", accountNumber, newBalance);
		UpdateAccountRequest updateAccountRequest = new UpdateAccountRequest();
		updateAccountRequest.setBalance(newBalance);
		updateAccountRequest.setAction(UpdateAccountAction.UPDATE_BALANCE);
		this.userClient.updateAccountDetails(accountNumber, updateAccountRequest);
	}

	/**
	 * Transform transaction to DTO.
	 *
	 * @param transaction
	 *            the transaction
	 * @return the payment DTO
	 */
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
			retVal.setNewBalance(transaction.getOldBalance() - transaction.getTransactionAmount());
			break;
		default:
			break;
		}

		return retVal;
	}

}
