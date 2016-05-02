package com.zhanyun.gwm.rest.pojo.common;
import java.util.Map;


public class EnumType implements Comparable<EnumType>{
	/**
	 * 名称(一般与属性名相同)
	 */
	private String name;
	/**
	 * 描述说明
	 */
	private String description;
	/**
	 * 枚举值
	 */
	private Map<String/*枚举值*/,String/*枚举值描述*/> enumValues; 
	
	/**
	 * 构造函数1
	 */
	public EnumType(){}
	
	/**
	 * 构造函数2
	 * @param name
	 * @param description
	 * @param enumValues
	 */
	public EnumType(String name,String description,Map<String/*枚举值*/,String/*枚举值描述*/> enumValues){
		this.name = name;
		this.description = description;
		this.enumValues = enumValues;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public int compareTo(EnumType arg0) {
		return this.getName().compareTo(arg0.getName());
	}

	public Map<String,String> getEnumValues() {
		return enumValues;
	}

	public void setEnumValues(Map<String,String> enumValues) {
		this.enumValues = enumValues;
	} 
	
	@Override
	public String toString() {
		return super.toString();
	}
}
