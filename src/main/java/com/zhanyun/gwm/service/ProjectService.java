package com.zhanyun.gwm.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhanyun.gwm.entity.Project;
import com.zhanyun.gwm.repository.ProjectRepository;


@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Transactional
	public Project save(Project newproj){
		return projectRepository.save(newproj);
	}
	
	@Transactional
	public void delete(String oid){
		projectRepository.delete(oid);
	}
	
	@Transactional
	public Project getOne(String oid){
		List<Project> projLst =  projectRepository.getProjById(oid);
		if (projLst == null || projLst.size() == 0) 
			return null;
		return projLst.get(0);
					
	}
	
}
