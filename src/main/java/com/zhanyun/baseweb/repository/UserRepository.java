package com.zhanyun.baseweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zhanyun.baseweb.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//根据项目名称模糊查询项目信息
	@Query("SELECT u FROM User u WHERE u.name = :name")
	List<User> getUserByName(@Param("name") String name);
}
