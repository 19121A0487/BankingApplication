package com.example.Banking.DTO;

import com.example.Banking.entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDTO accountDTO) {
		
		Account account=new Account(accountDTO.getId(),accountDTO.getUsername(),
				accountDTO.getBalance()
				);
		return account;
	}
	
	public static AccountDTO mapToAccountDTO(Account account) {
		AccountDTO accountDTO=new AccountDTO(
				account.getId(),
				account.getUsername(),
				account.getBalance()
				);
		return accountDTO;
	}
	
	
}
