package com.zhanyun.baseweb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="s_area")
public class AreaEntity implements Serializable {


	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@JoinColumn(name = "citycode", referencedColumnName="code")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	private CityEntity cityEntity;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	



	public AreaEntity(){
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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



	public CityEntity getCityEntity() {
		return cityEntity;
	}


	public void setCityEntity(CityEntity cityEntity) {
		this.cityEntity = cityEntity;
	}
	


}
