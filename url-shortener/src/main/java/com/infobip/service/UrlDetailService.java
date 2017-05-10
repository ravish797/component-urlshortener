package com.infobip.service;

import com.infobip.bean.UrlDetail;
import com.infobip.reposne.RestApiResponse;

public interface UrlDetailService 
{
	public RestApiResponse addDetails(UrlDetail urlDetails);
	
	public RestApiResponse getStatistics(String accountId);
}
