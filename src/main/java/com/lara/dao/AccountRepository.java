package com.lara.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lara.Account;

@Repository
public class AccountRepository {

	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	
	 
		public List<Account> retrieveAccount()  {
			String sql = "SELECT * FROM account"; 
	        List<Account> students = jdbcTemplate.query(sql,
	                BeanPropertyRowMapper.newInstance(Account.class));
			return students;
			
		}


		public void save(Account saveAccount) {
			String query = "insert into account (ACCOUNT_NO,BRANCH_NAME,BALANCE) values (?,?,?)";
			jdbcTemplate.update(query, saveAccount.getAccountNo(),saveAccount.getBranchName(),saveAccount.getBalance());	
		}


		public void updateAccount(Account updateAccount) {
			String updateQuery = "UPDATE account SET branch_name = ?,balance = ? WHERE account_no = ?";
			jdbcTemplate.update(updateQuery, updateAccount.getBranchName(),updateAccount.getBalance(),updateAccount.getAccountNo());
			
		}


		public void deleteAcoount(String accountNo) {
			String deleteQuery = "DELETE FROM account  where account_no = ?";
			jdbcTemplate.update(deleteQuery, accountNo);
			
		}


		public List<String> getBranchNameList() {
			String sql = "SELECT branch_name FROM account"; 
	        List<String> students = jdbcTemplate.queryForList(sql,String.class);
			return students;
		}
		
		public List<Long> getBalanceList() {
			String sql = "SELECT balance FROM account"; 
	        List<Long> students = jdbcTemplate.queryForList(sql,Long.class);
			return students;
		}


		public Account findOne(String id) {
			String sql = "SELECT * FROM account where ACCOUNT_NO = ?"; 
			Account acc =  jdbcTemplate.queryForObject(sql,  new Object[] {id}, new BeanPropertyRowMapper<Account>(Account.class));
			return acc;
		}


		public Account findOne(String id, String brName) {
			String sql = "SELECT * FROM account where ACCOUNT_NO = ? and BRANCH_NAME = ?"; 
			Account acc =  jdbcTemplate.queryForObject(sql,  new Object[] {id,brName}, new BeanPropertyRowMapper<Account>(Account.class));
			return acc;
		}
}
