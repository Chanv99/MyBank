package com.chango.myBank;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chango.myBank.dao.AccountHolderDao;
import com.chango.myBank.models.AccountHolder;

@Controller
public class HomeController {
	
	@Autowired
	AccountHolderDao dao;
	
	public static final Logger LOGGER = Logger.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("createAccount")
	public String createAccount(AccountHolder ah,Model m)
	{
		LOGGER.info("create account method called");
		try {
			dao.createAccount(ah);
			m.addAttribute("MSG","Account created Successfully");	
		}
		catch(Exception e)
		{
			LOGGER.error("Erroe while creating new account "+e.getMessage());
		}
		
		return "index";
	}
	
	@RequestMapping("showAllAccountHolders")
	public String getAccountHolders(Model m)
	{
		LOGGER.info("getAccountHolders method called");
		m.addAttribute("result", dao.getAccounts());
		return "resultPage";
	}
	
	@RequestMapping("updateAccount")
	public String updateAccount(AccountHolder ah,Model m)
	{
		dao.updateAccount(ah);
		m.addAttribute("MSG","Updated Successfully");
		return "index";
	}
	
	@RequestMapping("deleteAccount")
	public String deleteAccount(@RequestParam("id") int id, Model m)
	{
		dao.deleteAccount(id);
		m.addAttribute("MSG","Deleted Successfully");
		return "index";
	}
	
	@RequestMapping("search")
	public String search(@RequestParam("keyword") String keyword, Model m)
	{
		m.addAttribute("result",dao.search(keyword));
		return "resultPage";
	}
}
