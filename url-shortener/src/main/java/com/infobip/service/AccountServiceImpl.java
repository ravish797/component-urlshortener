package com.infobip.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.infobip.bean.Account;
import com.infobip.exception.UrlShortenerException;
import com.infobip.repository.AccountRepository;
import com.infobip.reposne.RestApiResponse;
import com.infobip.utils.MessageConstants;
import com.infobip.utils.ResponseService;
import com.infobip.utils.UrlShortenerUtils;


@Service
public class AccountServiceImpl implements AccountService
{

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	RestApiResponse responseEntity;
	
	@Autowired
	UrlShortenerUtils pwd;
	
	/**
     * Add the account id with auto generated password
     *
     * @return RestApiResponse
     */
	public RestApiResponse addAccount(Account account)
	{
		if(StringUtils.isEmpty(account.getAccountId()))
		{
			throw new UrlShortenerException(MessageConstants.ACCOUNTID_EMPTY);
		}
		if(account!=null)
		{
			List<Account> accountList = accountRepository.findAll();
			Optional<Account> accountExist =accountList.stream().filter
					(accountObj-> accountObj.getAccountId().equals(account.getAccountId())).findAny();
			
			if(accountExist.isPresent())
			{
				responseEntity=ResponseService.buildResponse
						(responseEntity,MessageConstants.ACCOUNTID_EXISTS+account.getAccountId(),true,null);
				return responseEntity;
			}
		}
		account.setPassword(pwd.getPassword());
		Account accountEntity = accountRepository.save(account);
		responseEntity=ResponseService.buildResponse
				(responseEntity,"Account Added",true,accountEntity);
		
		return responseEntity;
	}
	
	/**
     * Returns the account details for particular account id
     *
     * @return RestApiResponse
     */
	public Account getAccountById(String accountId)
	{
		return accountRepository.findOne(accountId);
	}
}
