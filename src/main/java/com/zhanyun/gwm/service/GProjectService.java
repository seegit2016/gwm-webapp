package com.zhanyun.gwm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhanyun.gwm.entity.GProject;
import com.zhanyun.gwm.repository.GProjectRepository;


@Service
public class GProjectService {

	@Autowired
	private GProjectRepository gProjectRepository;
	
	public List<GProject> getProjByName(String projName){
		return gProjectRepository.getProjByName(projName);
	}
	
	@Transactional
	public GProject save(GProject gProject){
		return gProjectRepository.saveAndFlush(gProject);
	}
	
	@Transactional
	public void saveGProjects(List<GProject> gProjects){
		gProjectRepository.save(gProjects);
	}
	
	@Transactional
	public void getProjById(Integer id){
		GProject gp1 = gProjectRepository.findOne(id);
		
		System.out.println(gp1.getProjName());
		System.out.println(gp1.getSchools().size());
		
		System.out.println("ssss");
		
	}
	
}
