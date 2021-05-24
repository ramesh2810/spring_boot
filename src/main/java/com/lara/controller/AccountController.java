package com.lara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lara.Account;
import com.lara.dao.AccountRepository;

@RestController
@RequestMapping("/acc")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping("/account")
	public List<Account>  getAccountList(){
		return this.accountRepository.retrieveAccount();
		
	}
	
	@GetMapping("/String")
	public List<String>  getBranchNameList(){
		return this.accountRepository.getBranchNameList();
		
	}
	
	@GetMapping("/bal")
	public List<Long>  getBalanceList(){
		return this.accountRepository.getBalanceList();
		
	}
	
	@PostMapping("/insert")
	public void insertAccout(@RequestBody Account saveAccount) {
	 this.accountRepository.save(saveAccount);
		
	}
	
	@PutMapping("/update")
	public void updateAccount(@RequestBody Account updateAccount) {
		this.accountRepository.updateAccount(updateAccount);
	}
	
	@DeleteMapping("/delete/{accountNo}")
	public void deleteAcoount(@PathVariable("accountNo") String accountNo) {
		this.accountRepository.deleteAcoount(accountNo);
		
		
	}
	
}
