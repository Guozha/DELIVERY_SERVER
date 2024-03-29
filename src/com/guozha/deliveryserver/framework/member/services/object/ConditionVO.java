/**
 * 
 */
package com.guozha.deliveryserver.framework.member.services.object;

import java.util.Date;

import com.guozha.deliveryserver.framework.enums.AccessLevel;

/**
 * @author peng.shi
 *
 */
public class ConditionVO
{
	private Date startInsertTime;
	private Date endInsertTime;
	private String username;
	private String email;
	private AccessLevel accessLevel;
	public Date getStartInsertTime()
	{
		return startInsertTime;
	}
	public void setStartInsertTime(Date startInsertTime)
	{
		this.startInsertTime = startInsertTime;
	}
	public Date getEndInsertTime()
	{
		return endInsertTime;
	}
	public void setEndInsertTime(Date endInsertTime)
	{
		this.endInsertTime = endInsertTime;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public AccessLevel getAccessLevel()
	{
		return accessLevel;
	}
	public void setAccessLevel(AccessLevel accessLevel)
	{
		this.accessLevel = accessLevel;
	}
	
}
