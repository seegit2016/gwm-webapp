package com.zhanyun.baseweb.rest.pojo.province;

import org.apache.commons.lang3.StringUtils;

import com.zhanyun.baseweb.entity.ProvinceEntity;

public class Province implements Comparable<Province> {

	/**
	 * ID
	 */
	private String serialNumber;
	
	/**
	 * 省编码
	 */
	private String code;
	/**
	 * 省名称
	 */
	private String name;
	
	
	
	
	
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


	public Province(ProvinceEntity entity) {
		this.serialNumber = entity.getId().toString();
		this.code =entity.getCode();
		this.name =entity.getName();
	}
	
	public ProvinceEntity retriveRawEntity() {
		ProvinceEntity newEntity = new ProvinceEntity();
		if (!StringUtils.isNumeric(this.getSerialNumber())) {
			//抛异常 暂抛出 OtherWebException
			//throw new OtherWebException("创建过程产生异常:" + e.getMessage() + ";返回异常码再约定!",500);
			return newEntity;
		}
		newEntity.setId(Long.getLong(this.getSerialNumber()));
		newEntity.setCode(this.getCode());
		newEntity.setName(this.getName());
		return  newEntity;
	}




	@Override
	public int compareTo(Province o) {
		// TODO Auto-generated method stub
		return this.getCode().compareTo(o.getCode());
	}

}
