package com.zhanyun.baseweb.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhanyun.baseweb.entity.AreaEntity;
import com.zhanyun.baseweb.entity.CityEntity;
import com.zhanyun.baseweb.entity.ProvinceEntity;
import com.zhanyun.baseweb.repository.AreaRepository;
import com.zhanyun.baseweb.repository.CityRepository;
import com.zhanyun.baseweb.repository.ProvinceRepository;
import com.zhanyun.baseweb.rest.pojo.area.County;
import com.zhanyun.baseweb.rest.pojo.city.City;
import com.zhanyun.baseweb.rest.pojo.province.Province;


@Service
public class AreaService {
	@Autowired
	private AreaRepository areaRepository;

	@Autowired
	private CityRepository cityRepository;
	
	
	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Transactional
	public List<County> findAllCountys() throws Throwable {
		List<AreaEntity> allAreaEntity = new ArrayList<AreaEntity>();
		List<County> rtnOBJs = new ArrayList<County>();
		try {
			allAreaEntity = areaRepository.findAll();
			if (allAreaEntity == null || allAreaEntity.size() == 0) {
				//临时测试修正
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Throwable(e.getMessage());
		}
		
		if (allAreaEntity == null || allAreaEntity.size() == 0) {
			return rtnOBJs;
		}
		for (AreaEntity item : allAreaEntity) {
			County pojo = new County(item);
			rtnOBJs.add(pojo);
		}
		
		Collections.sort(rtnOBJs);
		return rtnOBJs;
	}
	
	@Transactional
	public List<Province> findAllProvinces() throws Throwable {
		List<ProvinceEntity> allProvinceEntity = new ArrayList<ProvinceEntity>();
		List<Province> rtnOBJs = new ArrayList<Province>();
		try {
			allProvinceEntity = provinceRepository.findAll();
			if (allProvinceEntity == null || allProvinceEntity.size() == 0) {
				//临时测试修正
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Throwable(e.getMessage());
		}
		
		if (allProvinceEntity == null || allProvinceEntity.size() == 0) {
			return rtnOBJs;
		}
		for (ProvinceEntity item : allProvinceEntity) {
			Province pojo = new Province(item);
			rtnOBJs.add(pojo);
		}
		
		Collections.sort(rtnOBJs);
		return rtnOBJs;
	}
	
	@Transactional
	public List<City> findAllCitys() throws Throwable{
		List<CityEntity> allCityEntity = new ArrayList<CityEntity>();
		List<City> rtnOBJs = new ArrayList<City>();
		try {
			allCityEntity = cityRepository.findAll();
			if (allCityEntity == null || allCityEntity.size() == 0) {
				//临时测试修正
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Throwable(e.getMessage());
		}
		
		if (allCityEntity == null || allCityEntity.size() == 0) {
			return rtnOBJs;
		}
		for (CityEntity item : allCityEntity) {
			City pojo = new City(item);
			rtnOBJs.add(pojo);
		}
		
		Collections.sort(rtnOBJs);
		return rtnOBJs;
	}
	
	@Transactional
	public List<City> findCityByProvince(String provinceCode){
		List<ProvinceEntity> entitys = provinceRepository.getByCode(provinceCode);
		List<City> citys = new ArrayList<City>();
		ProvinceEntity entity = null;
				
		if (entitys != null && entitys.size()>0){
			entity = entitys.get(0);
		}else return citys;
		
		for (CityEntity item : entity.getCitys()) {
			City pojo = new City(item);
			citys.add(pojo);
		}
		Collections.sort(citys);
		return citys;
	}
	
	@Transactional
	public List<County> findAreaByCity(String cityCode){
		List<CityEntity> entitys = cityRepository.getByCode(cityCode);
		List<County> countys = new ArrayList<County>();
		CityEntity entity = null;
				
		if (entitys != null && entitys.size()>0){
			entity = entitys.get(0);
		}else return countys;
		
		for (AreaEntity item : entity.getAreas()) {
			County pojo = new County(item);
			countys.add(pojo);
		}
		Collections.sort(countys);
		return countys;
	}
}
