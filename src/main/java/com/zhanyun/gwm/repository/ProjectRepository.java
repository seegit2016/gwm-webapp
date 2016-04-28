package com.zhanyun.gwm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zhanyun.gwm.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, String> {
	//根据项目名称模糊查询项目信息
	@Query("SELECT p FROM Project p WHERE p.oid = :projid")
	List<Project> getProjById(@Param("projid") String projid);
}
