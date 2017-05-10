package com.infobip.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class UrlShortenerUtils 
{
	public String getPassword()
	{
		String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder sb = new StringBuilder();
		Random rnd = new Random();
		while (sb.length() < 8) 
		{
			int index = (int) (rnd.nextFloat() * sb.length());
			sb.append(chars.charAt(index));
		}
		String pwd = sb.toString();
		return pwd;
    }
	
	public String getRandomString(int length)
	{
		String chars = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		Random rnd = new Random();
		while (sb.length() < length) 
		{
			int index = (int) (rnd.nextFloat() * sb.length());
			sb.append(chars.charAt(index));
		}
		String pwd = sb.toString();
		return pwd;
    }
}
