package com.zhanyun.gwm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zhanyun.gwm.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, String> {
	//根据项目名称模糊查询项目信息
	@Query("SELECT p FROM ProjectEntity p WHERE p.oid = :projid")
	List<ProjectEntity> getProjById(@Param("projid") String projid);
	
	@Query("SELECT p FROM ProjectEntity p WHERE p.projectPhase = '立项'")
	List<ProjectEntity> findAllDraftedProjects();
}
