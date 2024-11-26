package com.example.Banking.service;

import java.util.List;

import com.example.Banking.DTO.AccountDTO;

public interface AccountService {
	
	AccountDTO createAccount(AccountDTO accountDTO);

	AccountDTO getAccountById(Long id);
	
	AccountDTO depositAmount(Long id,double amount);

	AccountDTO withdraw(Long id,double amount);
	
	List<AccountDTO> getAllAccounts();
	
	void deleteAccount(Long id);
}
