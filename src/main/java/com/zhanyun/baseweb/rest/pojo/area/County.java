package com.zhanyun.baseweb.rest.pojo.area;


import org.apache.commons.lang3.StringUtils;

import com.zhanyun.baseweb.entity.AreaEntity;

public class County implements Comparable<County> {
	/**
	 * ID
	 */
	private String serialNumber;
	
	/**
	 * 区县编码
	 */
	private String code;
	/**
	 * 区县名称
	 */
	private String name;
	
	
	/**
	 * 城市编码
	 */
	private String cityCode;
	
	
	
	public String getCityCode() {
		return cityCode;
	}


	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}


	public County(AreaEntity entity) {
		this.serialNumber = entity.getId().toString();
		this.code =entity.getCode();
		this.name =entity.getName();
		this.cityCode = entity.getCityEntity().getCode();
		
	}
	
	public AreaEntity retriveRawEntity() {
		AreaEntity newEntity = new AreaEntity();
		if (!StringUtils.isNumeric(this.getSerialNumber())) {
			//抛异常 暂抛出 OtherWebException
			//throw new OtherWebException("创建过程产生异常:" + e.getMessage() + ";返回异常码再约定!",500);
			return newEntity;
		}
		newEntity.setId(Long.getLong(this.getSerialNumber()));
		//newEntity.setCityCode(this.getCityCode());
		newEntity.setCode(this.getCode());
		newEntity.setName(this.getName());
		return  newEntity;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int compareTo(County o) {
		return this.getCode().compareTo(o.getCode());
	}

	
}
