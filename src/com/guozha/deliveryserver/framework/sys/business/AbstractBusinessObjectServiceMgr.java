package com.guozha.deliveryserver.framework.sys.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.guozha.deliveryserver.cache.CacheManager;
import com.guozha.deliveryserver.cache.CacheManagerFactory;
import com.guozha.deliveryserver.cache.CacheUtils;
import com.guozha.deliveryserver.framework.config.AppConfiguration;

/**
 * <strong>AbsBusinessObjectServiceMgr</strong><br>
 * <br> 
 * <strong>Create on : 2011-12-31<br></strong>
 * <p>
 * <strong>Copyright (C) Ecointel Software Co.,Ltd.<br></strong>
 * <p>
 * @author peng.shi peng.shi@ecointel.com.cn<br>
 * @version <strong>Ecointel v1.0.0</strong><br>
 */
public abstract class AbstractBusinessObjectServiceMgr implements BusinessObjectServiceMgr {

	protected static Log log = null;

	public AbstractBusinessObjectServiceMgr() {
		log = LogFactory.getLog(this.getClass());
	}
	
	public CacheManager getMemCacheManager()
	{
		CacheManager cm = CacheManagerFactory.getInstance().getMemCacheManager();
		if (cm == null) {
			throw new ExceptionInInitializerError("Cache Manager Initial Error,Please Check cache config.");
		}
		return cm;
	}

	/* (non-Javadoc)
	 * @see cn.com.ecointel.roomyi.framework.sys.business.BusinessObjectServiceMgr#setInCache(cn.com.ecointel.roomyi.framework.sys.business.BusinessObject)
	 */
	@Override
	public <T extends BusinessObject> void setInCache(T t)
	{
		Assert.notNull(t);
		this.getMemCacheManager().set(CacheUtils.keyOfClass(t.getClass(), t.getId()),t);
	}

	/* (non-Javadoc)
	 * @see cn.com.ecointel.roomyi.framework.sys.business.BusinessObjectServiceMgr#deleteFromCache(cn.com.ecointel.roomyi.framework.sys.business.BusinessObject)
	 */
	@Override
	public <T extends BusinessObject> void deleteFromCache(T t)
	{
		Assert.notNull(t);
		AssertUtils.notNewBusinessObject(t);
		this.getMemCacheManager().delete(CacheUtils.keyOfObject(t, t.getId()));
	}

	/* (non-Javadoc)
	 * @see cn.com.ecointel.roomyi.framework.sys.business.BusinessObjectServiceMgr#getFromCache(java.lang.Class, java.io.Serializable)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T extends BusinessObject> T getFromCache(Class<T> clazz, Serializable id)
	{
		Assert.notNull(clazz);
		Assert.notNull(id);
		BusinessObject obj = (BusinessObject)this.getMemCacheManager().get(CacheUtils.keyOfClass(clazz, id));
		return (T)obj;
	}

	/* (non-Javadoc)
	 * @see cn.com.ecointel.roomyi.framework.sys.business.BusinessObjectServiceMgr#filterNewBusinessObject(java.util.List)
	 */
	@Override
	public <T extends BusinessObject> Set<T> filterNewBusinessObject(List<T> ts)
	{
		if (CollectionUtils.isEmpty(ts))
		{
			return null;
		}
		Set<T> set = new HashSet<T>();
		for (T t : ts) 
		{
			if (!t.isNew())
			{
				set.add(t);
			}
		}
		return set;
	}

	/* (non-Javadoc)
	 * @see cn.com.ecointel.roomyi.framework.sys.business.BusinessObjectServiceMgr#filterNotNewBusinessObject(java.util.List)
	 */
	@Override
	public <T extends BusinessObject> Set<T> filterNotNewBusinessObject(List<T> ts)
	{
		if (CollectionUtils.isEmpty(ts))
		{
			return null;
		}
		Set<T> set = new HashSet<T>();
		for (T t : ts) 
		{
			if (t.isNew())
			{
				set.add(t);
			}
		}
		return set;
	}

	@Override
	public <T extends BusinessObject> List<java.io.Serializable> businessObject2Ids(List<T> bos)
	{
		if (!CollectionUtils.isEmpty(bos))
		{
			List<java.io.Serializable> ids = new ArrayList<java.io.Serializable>();
			for (T bo :bos)
			{
				if (!bo.isNew())
				{
					ids.add(bo.getId());
				}
			}
			return ids;
		}
		return null;
	}
	
	protected AppConfiguration getAppConfig() {
		return AppConfiguration.getInstance();
	}
}
