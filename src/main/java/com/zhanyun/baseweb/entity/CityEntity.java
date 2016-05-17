package com.zhanyun.baseweb.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="s_city")
public class CityEntity implements Serializable {

	
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CityEntity(){
		super();
	}
	
	//@JoinColumn(name = "citycode")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cityEntity")
	private Set<AreaEntity> areas = new HashSet<AreaEntity>(); 
	
	@JoinColumn( name="provincecode", referencedColumnName="code")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	private ProvinceEntity province;


	public ProvinceEntity getProvince() {
		return province;
	}

	public void setProvince(ProvinceEntity province) {
		this.province = province;
	}

	

	public Set<AreaEntity> getAreas() {
		return areas;
	}

	public void setAreas(Set<AreaEntity> areas) {
		this.areas = areas;
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

}
