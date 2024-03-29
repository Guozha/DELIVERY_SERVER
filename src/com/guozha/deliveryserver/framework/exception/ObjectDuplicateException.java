package com.guozha.deliveryserver.framework.exception;

import com.guozha.deliveryserver.framework.sys.exception.ServiceException;

/**
 * <strong>ObjectDuplicateException</strong><br>
 * <br> 
 * <strong>Create on : 2012-2-8<br></strong>
 * <p>
 * <strong>Copyright (C) Ecointel Software Co.,Ltd.<br></strong>
 * <p>
 * @author peng.shi peng.shi@ecointel.com.cn<br>
 * @version <strong>ecointel-epp v1.0.0</strong><br>
 */
public class ObjectDuplicateException extends ServiceException {

	private static final long serialVersionUID = 2446921528880894125L;

	public ObjectDuplicateException() {
		super();
	}

	public ObjectDuplicateException(String message) {
		super(message);
	}

	public ObjectDuplicateException(Throwable cause) {
		super(cause);
	}

	public ObjectDuplicateException(String message, Throwable cause) {
		super(message, cause);
	}

}
