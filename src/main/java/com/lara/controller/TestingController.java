package com.lara.controller;

import java.net.URI;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lara.Account;
import com.lara.dao.AccountRepository;

@RestController
@RequestMapping("/testing")
public class TestingController {

	@Autowired
	private AccountRepository accountRepository;
	
	@PostMapping("/save")
	public ResponseEntity<Object> insertAccout(@RequestBody Account saveAccount) {
	 this.accountRepository.save(saveAccount);
	 URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveAccount.getAccountNo()).toUri();  
	 return ResponseEntity.created(location).build();
	
	}
	
	@GetMapping("/save/{id}")
	public Account retriveUser(@PathVariable String id) {
		Account accout = accountRepository.findOne(id);
		
		return accout;
	} 
	
	@GetMapping("/save/{id}{brName}")
	public Account retriveUser1(@PathVariable String id,@PathVariable String brName)  
	{  
	return accountRepository.findOne(id,brName);  
	}  
}
