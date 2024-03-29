package com.guozha.deliveryserver.dal.common.sequence.dao;

import com.guozha.deliveryserver.dal.object.AbstractDO;

/**
 * <strong>DalSequenceDO</strong><br>
 * <br> 
 * <strong>Create on : 2012-2-8<br></strong>
 * <p>
 * <strong>Copyright (C) Ecointel Software Co.,Ltd.<br></strong>
 * <p>
 * @author peng.shi peng.shi@ecointel.com.cn<br>
 * @version <strong>ecointel-epp v1.0.0</strong><br>
 */
public class DalSequenceDO extends AbstractDO {

	private static final long serialVersionUID = 5556648098703289022L;
	
	private String sequenceKey;
	private long sequenceValue;

	public String getSequenceKey() {
		return sequenceKey;
	}

	public void setSequenceKey(String sequenceKey) {
		this.sequenceKey = sequenceKey;
	}

	public long getSequenceValue() {
		return sequenceValue;
	}

	public void setSequenceValue(long sequenceValue) {
		this.sequenceValue = sequenceValue;
	}

}
