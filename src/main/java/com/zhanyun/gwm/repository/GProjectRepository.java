package com.zhanyun.gwm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zhanyun.gwm.entity.GProject;

public interface GProjectRepository extends JpaRepository<GProject, Integer> {

	//根据项目名称模糊查询项目信息
	@Query("SELECT p FROM GProject p WHERE p.projName like %:projName%")
	List<GProject> getProjByName(@Param("projName") String projName);
	
}
