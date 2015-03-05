/**
 * 
 */
package com.guozha.deliveryserver.framework.log;

import com.guozha.deliveryserver.framework.sys.business.BusinessObject;

/**
 * @author peng.shi
 *
 */
public interface AuditLog extends BusinessObject
{
	String getId();
	
	LogType getLogType();
	
}
