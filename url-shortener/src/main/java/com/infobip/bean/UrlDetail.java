package com.infobip.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class UrlDetail 
{
	@Id
	private String accountId;
	
	private String url;
	
	private int redirectType;
	
	private String shortUrl;
	

	public String getUrl() 
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public int getRedirectType()
	{
		return redirectType;
	}

	public void setRedirectType(int redirectType) 
	{
		this.redirectType = redirectType;
	}

	public String getAccountId() 
	{
		return accountId;
	}

	public void setAccountId(String accountId) 
	{
		this.accountId = accountId;
	}

	public String getShortUrl() 
	{
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) 
	{
		this.shortUrl = shortUrl;
	}
	
	
}
