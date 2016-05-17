package com.zhanyun.baseweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zhanyun.baseweb.entity.ProvinceEntity;


public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {
	//根据省编码获取省份对象
	@Query("SELECT p FROM ProvinceEntity p WHERE p.code = :code")
	List<ProvinceEntity> getByCode(@Param("code") String code);
}
