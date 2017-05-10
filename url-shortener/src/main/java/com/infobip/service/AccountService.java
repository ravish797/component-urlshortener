package com.infobip.service;

import com.infobip.bean.Account;
import com.infobip.reposne.RestApiResponse;

public interface AccountService 
{
	public RestApiResponse addAccount(Account account);
	
	public Account getAccountById(String accountId);
}
