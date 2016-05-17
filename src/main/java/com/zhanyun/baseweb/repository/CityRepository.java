package com.zhanyun.baseweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zhanyun.baseweb.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity,Long> {
	
	//根据市编码获取市区对象
	@Query("SELECT p FROM CityEntity p WHERE p.code = :code")
	List<CityEntity> getByCode(@Param("code") String cityCode);
}
