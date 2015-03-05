/**
 * 
 */
package com.guozha.deliveryserver.framework.log;

import com.guozha.deliveryserver.framework.sys.business.BusinessObject;

/**
 * @author peng.shi
 *
 */
public interface LogType extends BusinessObject
{
	String getId();
	
	String getDefine();
	
	void setDefine();
	
	String getName();
	
	void setName();
	
}
