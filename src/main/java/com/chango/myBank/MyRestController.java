package com.chango.myBank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chango.myBank.dao.AccountHolderDao;
import com.chango.myBank.models.AccountHolder;

@RestController
public class MyRestController {
	
	@Autowired
	AccountHolderDao dao;
	
	@RequestMapping("accountHolder")
	@ResponseBody
	public List<AccountHolder> getAccountHolders()
	{
		List<AccountHolder> accountHolders = dao.getAccounts();
		return accountHolders;
	}
	
	@GetMapping("accountHolder/{id}")
	@ResponseBody
	public AccountHolder getAccountHolder(@PathVariable("id") int id)
	{
		
		return dao.getAccountHolder(id);
	}
	
	@GetMapping("saveAccountHolderData")
	@ResponseBody
	public void saveAccountHolderData(AccountHolder ah)
	{
		dao.createAccount(ah);
	}
	
	@PostMapping("getAccountHolderData")
	@ResponseBody
	public List<AccountHolder> getAccountHolderData()
	{
		return dao.getAccounts();
	}
}
