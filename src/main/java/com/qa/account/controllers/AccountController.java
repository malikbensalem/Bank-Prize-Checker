package com.qa.account.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.account.entities.Account;
import com.qa.account.services.AccountService;

public class AccountController {

	private AccountService service;

	public AccountController(AccountService service, RestTemplateBuilder rest) {
		this.service = service;
	}

	@PostMapping(value = "/register")
	public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
		return this.service.addAccount(account);
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Account>> getAccounts() {
		return service.getAccounts();
	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {
		return this.service.getAccount(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteAccount(@PathVariable("id") Long id) {
		return this.service.deleteAccount(id);
	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateAccount(@RequestBody Account account, @PathParam("id") Long id) {
		return this.service.updateAccount(account, id);
	}
}
