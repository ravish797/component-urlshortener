package com.infobip.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infobip.bean.Account;
import com.infobip.repository.AccountRepository;
import com.infobip.reposne.RestApiResponse;
import com.infobip.service.AccountService;
@RestController
@RequestMapping("/api")
public class AccountController 
{
	@Autowired
	AccountService accountService;
	
	@Autowired
	AccountRepository accountRepository;
	
	/**
     * This API will add the account details
     *
     * @return RestApiResponse
     */
	@RequestMapping(value="/account",produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	public RestApiResponse addAccount(@RequestBody Account account)
	{
		return accountService.addAccount(account);
	}
}
