package com.nagarro.nagp.payments.validator;

import org.springframework.util.StringUtils;

import com.nagarro.nagp.payments.dto.PaymentRequest;
import com.nagarro.nagp.payments.enums.PaymentAction;
import com.nagarro.nagp.payments.exception.InvalidParameterException;

/**
 * The Class InputValidator.
 */
public class InputValidator {

	private InputValidator() {
		// to prevent Initialization
	}

	/**
	 * Validate request.
	 *
	 * @param request
	 *            the request
	 * @throws InvalidParameterException
	 */
	public static void validateRequest(PaymentRequest request) throws InvalidParameterException {
		if (null == request) {
			throw new InvalidParameterException("input request must not be null", "invalid.request");
		}

		if (null == request.getAction()) {
			throw new InvalidParameterException("Request Action must not be null", "invalid.request.action");
		}

		if (!StringUtils.hasText(request.getSourceAccount())) {
			throw new InvalidParameterException("Source Account number must not be null",
					"invalid.request.sourceAccount");
		}

		if (request.getTransactionAmount() <= 0) {
			throw new InvalidParameterException("Transaction amount must be greater than 0",
					"invalid.request.transactionAmount");
		}

		if (request.getAction().equals(PaymentAction.TRANSFER)
				&& !StringUtils.hasText(request.getDestinationAccount())) {
			throw new InvalidParameterException(
					"Detination Account number must not be null for Request Action = TRANSFER",
					"invalid.request.deatinationAccount");
		}
	}

}
