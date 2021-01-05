package com.chango.myBank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chango.myBank.dao.AccountHolderDao;
import com.chango.myBank.models.AccountHolder;

@Controller
public class HomeController {
	
	@Autowired
	AccountHolderDao dao;
	
	
	@ModelAttribute
	public void modelData(Model m)
	{
		m.addAttribute("MSG","Account created Successfully");
	}
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("createAccount")
	public String createAccount(AccountHolder ah)
	{
		dao.createAccount(ah);
		return "index";
	}
	
	@RequestMapping("showAllAccountHolders")
	public String getAccountHolders(Model m)
	{
		m.addAttribute("result", dao.getAccounts());
		return "resultPage";
	}
	
	@RequestMapping("updateAccount")
	public String updateAccount(AccountHolder ah,Model m)
	{
		m.addAttribute("MSG","Updated Successfully");
		dao.updateAccount(ah);
		return "index";
	}
	
	@RequestMapping("deleteAccount")
	public String deleteAccount(@RequestParam("id") int id, Model m)
	{
		m.addAttribute("MSG","Deleted Successfully");
		dao.deleteAccount(id);
		return "index";
	}
}
