package com.example.Banking.controller;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Banking.DTO.AccountDTO;
import com.example.Banking.service.AccountService;

import jakarta.persistence.Id;

@RestController
@RequestMapping("/api/accounts")
public class HomeController {
	
	private AccountService accountService;

	public HomeController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	
	@GetMapping("/sri")
	public String hello() {
		
		return "hello";
	}
	
	
//	add account restAPI
	@PostMapping
	public ResponseEntity< AccountDTO> addAccount(@RequestBody AccountDTO accountDTO){
		return new ResponseEntity<>(accountService.createAccount(accountDTO),HttpStatus.CREATED);
	}
	
	
//	get account by id
	@GetMapping("{id}")
	
	public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){
		AccountDTO accountDTO=accountService.getAccountById(id);
		return ResponseEntity.ok(accountDTO) ;
		
	}
	
//	deposit REST API
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDTO> depositAmount(@PathVariable Long id,@RequestBody Map<String, Double> req){
		
		Double amount=req.get("amount");
		AccountDTO accountDTO=accountService.depositAmount(id, amount);
		return ResponseEntity.ok(accountDTO);
		
	}
	
	@PutMapping("{id}/withdraw")
	public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id,@RequestBody Map<String, Double> req){
		
		Double amount=req.get("amount");
		AccountDTO accountDTO=accountService.withdraw(id, amount);
		
		return ResponseEntity.ok(accountDTO);
	}
	
//	get all accounts REST API
	@GetMapping("/")
	public ResponseEntity<List<AccountDTO>> getAllAccounts(){
		
		List<AccountDTO> accounts=accountService.getAllAccounts();
		return ResponseEntity.ok(accounts);
		
	}
	
//	delete account REST APL
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account is deleted..");
	}
}
