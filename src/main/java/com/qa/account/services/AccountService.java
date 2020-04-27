package com.qa.account.services;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.account.entities.Account;
import com.qa.repo.AccountRepo;

@Service
public class AccountService {
	
	private AccountRepo repo;
	private AccountNumberGeneratorService numGen;
	private PrizeCheckerService prizeGen;
	
	public AccountService(AccountRepo repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<List<Account>> getAccounts() {
		return ResponseEntity.ok(repo.findAll());
	}

	public ResponseEntity<Account> getAccount(Long id) {
		try {
			Account found = repo.findById(id).orElseThrow(() -> new AccountNotFoundException(id.toString()));
			return ResponseEntity.ok(found);
		} catch (AccountNotFoundException anfe) {
			return ResponseEntity.notFound().build();
		}

	}

	public ResponseEntity<Account> addAccount(Account account) {
		account.setAccountNumber(this.numGen.generatorAccountNumber());
		account.setPrize(prizeGen.prizeCheck(account.getAccountNumber()));
		return new ResponseEntity<Account>(this.repo.save(account), HttpStatus.CREATED);
	}

	public ResponseEntity<Object> deleteAccount(Long id) {
		if (accountExists(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	private boolean accountExists(Long id) {
		return repo.findById(id).isPresent();
	}

	public ResponseEntity<Object> updateAccount(Account account, Long id) {
		if (accountExists(id)) {
			Account toUpdate = this.repo.findById(id).get();
			toUpdate.setFirstName(account.getFirstName());
			toUpdate.setLastName(account.getLastName());
			repo.save(account);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	//crud
	
	

}
