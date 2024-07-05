package com.example.Banking.DTO;

import lombok.Data;

@Data

public class AccountDTO {
	
	private long id;
	private String username;
	private Double balance;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public AccountDTO(long id, String username, Double balance) {
		super();
		this.id = id;
		this.username = username;
		this.balance = balance;
	}
	
	public AccountDTO() {
		
	}
	
	
	
	

}
