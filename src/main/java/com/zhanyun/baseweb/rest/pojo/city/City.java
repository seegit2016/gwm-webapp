package com.zhanyun.baseweb.rest.pojo.city;

import org.apache.commons.lang3.StringUtils;

import com.zhanyun.baseweb.entity.CityEntity;

public class City implements Comparable<City>  {
	/**
	 * ID
	 */
	private String serialNumber;
	
	/**
	 * 城市编码
	 */
	private String code;
	/**
	 * 城市名称
	 */
	private String name;
	
	/**
	 * 城市编码
	 */
	private String provinceCode;


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


	public String getProvinceCode() {
		return provinceCode;
	}


	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	
	public City(CityEntity entity) {
		this.serialNumber = entity.getId().toString();
		this.code =entity.getCode();
		this.name =entity.getName();
		this.provinceCode = entity.getProvince().getCode() ;
	}
	
	public CityEntity retriveRawEntity() {
		CityEntity newEntity = new CityEntity();
		if (!StringUtils.isNumeric(this.getSerialNumber())) {
			//抛异常 暂抛出 OtherWebException
			//throw new OtherWebException("创建过程产生异常:" + e.getMessage() + ";返回异常码再约定!",500);
			return newEntity;
		}
		newEntity.setId(Long.getLong(this.getSerialNumber()));
		//newEntity.setProvinceCode(this.getProvinceCode());
		newEntity.setCode(this.getCode());
		newEntity.setName(this.getName());
		return  newEntity;
	}

	
	@Override
	public int compareTo(City o) {
		// TODO Auto-generated method stub
		return this.getCode().compareTo(o.getCode());
	}


	
	
	
	
	
	
	
}
