package com.infobip.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infobip.bean.Account;
import com.infobip.exception.UrlShortenerException;
import com.infobip.service.AccountService;

@Component
public class AuthenticalUser 
{
	@Autowired
	AccountService accountService;
	
	public void authenticateUser(String accountId,String password)
	{
		Account account = accountService.getAccountById(accountId);
		
		if(account!=null)
		{
			if(!account.getPassword().equals(password))
			{
				throw new UrlShortenerException("User does not exist");
			}
		}
		else
		{
			throw new UrlShortenerException("User does not exist");
		}
	}
}
