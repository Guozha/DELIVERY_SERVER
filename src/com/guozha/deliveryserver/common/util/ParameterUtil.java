package com.guozha.deliveryserver.common.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ibm.icu.math.BigDecimal;
import com.ibm.icu.text.DecimalFormat;
import com.ibm.icu.text.SimpleDateFormat;

public class ParameterUtil {
	
	/**
	 * 数据库列数据缓存
	 */
	private static Map<String,Map<String,String>> columnCache = new HashMap<String, Map<String, String>>();
	
	/**
	 * 常量数据缓存
	 */
	private static Map<String, Map<String, String>> constantCache = new HashMap<String, Map<String,String>>();
	
	/**
	 * 系统所有RESOURCE_URL的缓存
	 */
	private static Set<String> resurceUrlSet = new HashSet<String>();
	
	
	/**
	 * 缓存列数据
	 * @param cacheColumnDef 缓存列的定义
	 * @param refColumnVal 参考列的值
	 * @param cacheColumnVal 缓存列的值
	 */
	public static void cacheColumnData(String cacheColumnDef,String refColumnVal,String cacheColumnVal){
		if(!columnCache.containsKey(cacheColumnDef)){
			Map<String, String> map = new LinkedHashMap<String, String>();
			map.put(refColumnVal, cacheColumnVal);
			columnCache.put(cacheColumnDef, map);
		}else{
			Map<String, String> map = columnCache.get(cacheColumnDef);
			map.put(refColumnVal, cacheColumnVal);
		}
	}
	
	public static void cacheResourceUrl(String resourceUrl){
		if(!StringUtils.isBlank(resourceUrl)){
			resurceUrlSet.add(resourceUrl);
		}
	}
	
	public static Set<String> getResurceUrlSet() {
		return resurceUrlSet;
	}

	/**
	 * 获取缓存的列数据
	 * @param cacheColumnDef
	 * @param refColumnVal
	 * @return
	 */
	public static String getColumnValue(String cacheColumnDef,String refColumnVal){
		if(!columnCache.containsKey(cacheColumnDef)) return null;
		Map<String, String> map = columnCache.get(cacheColumnDef);
		if(!map.containsKey(refColumnVal)) return null;
		return map.get(refColumnVal);
	}
	
	public static Map<String, String> getColumnMapByColumnDef(String columnDef){
		if(!columnCache.containsKey(columnDef)) return new HashMap<String, String>();
		return columnCache.get(columnDef);
	}
	
	/**
	 * 缓存常量数据
	 * @param constantDef
	 * @param constantValue
	 * @param constantName
	 */
	public static void cacheConstantData(String constantDef,String constantValue,String constantName){
		if(!constantCache.containsKey(constantDef)){
			Map<String, String> map = new LinkedHashMap<String, String>();
			map.put(constantValue, constantName);
			constantCache.put(constantDef, map);
		}else{
			Map<String, String> map = constantCache.get(constantDef);
			map.put(constantValue, constantName);
		}
	}
	
	/**
	 * 获取常量名
	 * @param constantDef
	 * @param constantValue
	 * @return
	 */
	public static String getConstantName(String constantDef,String constantValue){
		if(!constantCache.containsKey(constantDef)) return null;
		Map<String, String> map = constantCache.get(constantDef);
		if(!map.containsKey(constantValue)) return null;
		return map.get(constantValue);
	}
	
	
	public static Map<String, String> getConstantMap(String constantDef){
		if(!constantCache.containsKey(constantDef)) return new HashMap<String, String>();
		return constantCache.get(constantDef);
	}
	

	public static Map<String, String> getColumnMap(String columnDef){
		if(!columnCache.containsKey(columnDef)) return new HashMap<String, String>();
		return columnCache.get(columnDef);
	}

	public static Map<String, Map<String, String>> getColumnCache() {
		return columnCache;
	}

	public static Map<String, Map<String, String>> getConstantCache() {
		return constantCache;
	}
	
	public static String fromF2YForShow(String f){
		String y = "0.00";
		if(StringUtils.isBlank(f)) return y;
		BigDecimal d1 = new BigDecimal(f).setScale(2);
		BigDecimal d2 = d1.divide(new BigDecimal(100));
		double value = d2.doubleValue();
		return new DecimalFormat("#,##0.00").format(value);
	}
	
	public static String fromF2YForShow(Integer f){
		return fromF2YForShow(String.valueOf(f));
	}
	
	public static String fromF2Y(String f){
		String y = "0.00";
		if(StringUtils.isBlank(f)) return y;
		BigDecimal d1 = new BigDecimal(f).setScale(2);
		BigDecimal d2 = d1.divide(new BigDecimal(100));
		double value = d2.doubleValue();
		return new DecimalFormat("#0.00").format(value);
	}
	
	public static String formatWeight(String f){
		String y = "0.00";
		if(StringUtils.isBlank(f)) return y;
		double value = Double.parseDouble(f);
		return new DecimalFormat("#0.00").format(value);
	}
	
	public static String formatVolume(String f){
		String y = "0.000000";
		if(StringUtils.isBlank(f)) return y;
		double value = Double.parseDouble(f);
		return new DecimalFormat("#0.000000").format(value);
	}
	
	public static String fromF2Y(Integer f){
		return fromF2Y(String.valueOf(f));
	}
	
	public static String fromY2F(String y){
		String f = "0";
		if(StringUtils.isBlank(y)) return f;
		BigDecimal d1 = new BigDecimal(y);
		BigDecimal d2 = d1.multiply(new BigDecimal(100));
		double value = d2.doubleValue();
		return new DecimalFormat("#0").format(value);
	}
	
	public static String fromY2F(Double y){
		return fromY2F(String.valueOf(y));
	}
	
	public static String getTodayDate(){
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	public static String substring(String str){
		String result = "";
		if(str.length()>15){
			result = str.substring(0, 15)+"...";
		}else{
			result = str;
		}
		return result;
	}
	
}
