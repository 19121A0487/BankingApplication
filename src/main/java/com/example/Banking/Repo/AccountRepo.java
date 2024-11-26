package com.example.Banking.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Banking.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long>{

}
