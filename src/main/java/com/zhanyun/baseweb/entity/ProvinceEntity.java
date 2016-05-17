package com.zhanyun.baseweb.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="s_province")
public class ProvinceEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProvinceEntity(){
		super();
	}

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, length = 16, nullable = false)
	private String code;

	@Column(length = 80, nullable = false)
	private String name;
	
	//@JoinColumn(name = "provincecode")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "province")
	private List<CityEntity> citys;

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
	

	public List<CityEntity> getCitys() {
		return citys;
	}

	public void setCitys(List<CityEntity> citys) {
		this.citys = citys;
	}
	
	public CityEntity addCity(CityEntity city) {
		getCitys().add(city);
		city.setProvince(this);

		return city;
	}

	public CityEntity removeSCity(CityEntity city) {
		getCitys().remove(city);
		city.setProvince(null);

		return city;
	}
	
}
