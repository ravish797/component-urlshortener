package com.infobip.utils;

import com.infobip.reposne.RestApiResponse;

public class ResponseService 
{
	public static final RestApiResponse buildResponse(RestApiResponse responseEntity,String desc,boolean status,Object data) 
	{
		responseEntity.clear();
		responseEntity.setData(data);
		responseEntity.setDescription(desc);
		responseEntity.setSuccess(status);
		return responseEntity;
	}
}
