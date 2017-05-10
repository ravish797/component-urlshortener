package com.infobip.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infobip.bean.UrlDetail;
import com.infobip.reposne.RestApiResponse;
import com.infobip.service.UrlDetailService;
import com.infobip.utils.AuthenticalUser;

@RestController
@RequestMapping(value="/api")
public class UrlDetailController 
{
	@Autowired
	UrlDetailService urlDetailService;
	
	@Autowired
	AuthenticalUser authetication;

	/**
     * This API will add the url details
     *
     * @return RestApiResponse
     */
	@RequestMapping(value="/register",produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	public RestApiResponse addUrlDetails(@RequestHeader String id,@RequestHeader String pwd,
			@RequestBody UrlDetail urlDetails)
	{
		authetication.authenticateUser(id, pwd);
		return urlDetailService.addDetails(urlDetails);
	}
	/**
     * This API will return the url details specific to a particular account
     * 
     * @return RestApiResponse
     */
	@RequestMapping(value="/statistic/{accountId}",produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET)
	public RestApiResponse getStatistics(@RequestHeader String id,@RequestHeader String pwd,
			@PathVariable String accountId)
	{
		authetication.authenticateUser(id, pwd);
		return urlDetailService.getStatistics(accountId);
	}
}
