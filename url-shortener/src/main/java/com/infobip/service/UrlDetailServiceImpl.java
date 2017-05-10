package com.infobip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infobip.bean.UrlDetail;
import com.infobip.exception.UrlShortenerException;
import com.infobip.repository.UrlDetailRepository;
import com.infobip.reposne.RestApiResponse;
import com.infobip.utils.MessageConstants;
import com.infobip.utils.ResponseService;
import com.infobip.utils.UrlShortenerUtils;

@Service
public class UrlDetailServiceImpl implements UrlDetailService
{
	@Autowired
	UrlDetailRepository urlDetailRepository;
	
	@Autowired
	RestApiResponse responseEntity;
	
	@Autowired
	UrlShortenerUtils util;
	
	@Autowired
	AccountService accountService;
	
	/**
     * Add the url details
     *
     * @return RestApiResponse
     */
	public RestApiResponse addDetails(UrlDetail urlDetail) 
	{
		UrlDetail urlDetailEntity=null;
		if (accountService.getAccountById(urlDetail.getAccountId()) != null) 
		{
		String randomString = util.getRandomString(7);
		urlDetail.setShortUrl("http://short.com/"+randomString);
		urlDetailEntity =  urlDetailRepository.save(urlDetail);
		}
		else
		{
			throw new UrlShortenerException(MessageConstants.NOACCOUNT_FOUND);
		}
		return ResponseService.buildResponse(responseEntity,MessageConstants.URL_SAVED, true, urlDetailEntity);
	}
	/**
     * Return the url registered with particular account id
     *
     * @return RestApiResponse
     */
	public RestApiResponse getStatistics(String accountId)
	{
		UrlDetail urlDetailEntity = urlDetailRepository.findOne(accountId);
		String keyMap = urlDetailEntity.getUrl()+": "+urlDetailEntity.getRedirectType();
		
		return ResponseService.buildResponse(responseEntity,MessageConstants.SUCCESS, true, keyMap);
	}
}
