package com.chango.myBank;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class LoggingAspect {
	public static final Logger LOGGER = Logger.getLogger(HomeController.class);
	public void log()
	{
		System.out.println("getAccountHolders method is called from account Holder");
	}
}
