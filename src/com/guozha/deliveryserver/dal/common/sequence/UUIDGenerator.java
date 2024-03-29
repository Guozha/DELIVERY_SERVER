package com.guozha.deliveryserver.dal.common.sequence;

import java.util.UUID;

/**
 * <strong>UUIDGenerator</strong><br>
 * <br> 
 * <strong>Create on : 2012-2-8<br></strong>
 * <p>
 * <strong>Copyright (C) Ecointel Software Co.,Ltd.<br></strong>
 * <p>
 * @author peng.shi peng.shi@ecointel.com.cn<br>
 * @version <strong>ecointel-epp v1.0.0</strong><br>
 */
public class UUIDGenerator {
	
	public static String nextId() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
}
