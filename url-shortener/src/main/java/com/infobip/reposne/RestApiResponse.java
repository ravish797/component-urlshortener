package com.infobip.reposne;

import org.springframework.stereotype.Service;

@Service
public class RestApiResponse 
{

	private boolean success;
	private String description;
	private Object data;
	
	public boolean isSuccess() 
	{
		return success;
	}
	public void setSuccess(boolean success) 
	{
		this.success = success;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public  Object getData() 
	{
		return data;
	}
	public void setData(Object data) 
	{
		this.data = data;
	}
	
	public void clear()
	{
		this.setSuccess(false);
		this.setDescription(null);
		this.setData(null);
	}
	
}
