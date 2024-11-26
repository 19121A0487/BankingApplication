package com.example.Banking.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Banking.DTO.AccountDTO;
import com.example.Banking.DTO.AccountMapper;
import com.example.Banking.Repo.AccountRepo;
import com.example.Banking.entity.Account;
import com.example.Banking.service.AccountService;



@Service
public class AccountServiceImpl implements AccountService{
	
	private AccountRepo accountRepo;

	public AccountServiceImpl(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	@Override
	public AccountDTO createAccount(AccountDTO accountDTO) {
		
		Account account=AccountMapper.mapToAccount(accountDTO);
		Account saveAccount =accountRepo.save(account);
		
		
		return AccountMapper.mapToAccountDTO(saveAccount);
	}

	@Override
	public AccountDTO getAccountById(Long id) {
		
		Account account =accountRepo.findById(id).orElseThrow(()->new RuntimeException("no account exist"));
		
		return AccountMapper.mapToAccountDTO(account);
	}

	public AccountDTO depositAmount(Long id, double amount) {
		 
		Account account =accountRepo.findById(id).orElseThrow(()->new RuntimeException("no account exist"));
		
		
		 Double total=account.getBalance()+amount;
		 
		 account.setBalance(total);
		 Account savedAccount =accountRepo.save(account);
		 
		 return AccountMapper.mapToAccountDTO(savedAccount);
	}

	@Override
	public AccountDTO withdraw(Long id, double amount) {
		
		Account account=accountRepo.findById(id).orElseThrow(()->new RuntimeException("No account found"));
		
		Double total=account.getBalance()-amount;
		account.setBalance(total);
		
		Account savedAccount =accountRepo.save(account);
		
		return AccountMapper.mapToAccountDTO(savedAccount);
	}

	@Override
	public List<AccountDTO> getAllAccounts() {
		
		List<Account> accounts=accountRepo.findAll();
		
		return accounts.stream().map((account)->AccountMapper.mapToAccountDTO(account)).collect(Collectors.toList());
	
	}

	public void deleteAccount(Long id) {

		Account account=accountRepo.findById(id).orElseThrow(()->new RuntimeException("No account found"));
		
		accountRepo.deleteById(id);
		
		
	}

	

}
