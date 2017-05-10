package com.infobip.exception;

public class UrlShortenerException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	
	private String messageKey;

	public UrlShortenerException(String messageKey, Throwable cause) 
	{
		super(messageKey, cause);
		this.messageKey = messageKey;
	}

	public UrlShortenerException(String messageKey) 
	{
		super(messageKey);
		this.messageKey = messageKey;
	}
}
