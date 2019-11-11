package com.nagarro.nagp.payments.client;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nagarro.nagp.payments.dto.user.AccountDTO;
import com.nagarro.nagp.payments.dto.user.UpdateAccountRequest;
import com.nagarro.nagp.payments.dto.user.UserDTO;

@Component
@RibbonClient(name = "user-service")
@FeignClient(name = "api-gateway")
public interface UserClient {

	/**
	 * Gets the user.
	 *
	 * @param id
	 *            the id
	 * @return the user
	 */
	@GetMapping(value = "/user-service/user/{id}")
	public UserDTO getUser(@PathVariable("id") final long id);

	/**
	 * Gets the user.
	 *
	 * @param id
	 *            the id
	 * @return the user
	 */
	@GetMapping(value = "/user-service/user")
	public List<UserDTO> getAllUser();

	/**
	 * Gets the user.
	 *
	 * @param id
	 *            the id
	 * @return the user
	 */
	@GetMapping(value = "/user-service/user/{id}/accounts")
	public List<AccountDTO> getUserAccounts(@PathVariable("id") final long id);

	/**
	 * Update account details.
	 *
	 * @param accountNumber
	 *            the account number
	 * @param request
	 *            the request
	 * @return the account DTO
	 */
	@PutMapping(value = "/user-service/accounts/{accountNumber}")
	public AccountDTO updateAccountDetails(@PathVariable("accountNumber") final String accountNumber,
			@RequestBody UpdateAccountRequest request);

	/**
	 * Gets the account.
	 *
	 * @param accountNumber
	 *            the account number
	 * @return the account
	 */
	@GetMapping(value = "/user-service/accounts/{accountNumber}")
	public AccountDTO getAccount(@PathVariable("accountNumber") final String accountNumber);

}
