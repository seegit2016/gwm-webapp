package com.zhanyun.gwm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhanyun.gwm.entity.GSchool;
import com.zhanyun.gwm.repository.GSchoolRepository;


@Service
public class GSchoolService {

	@Autowired
	private GSchoolRepository gSchoolRepository;
	
	@Transactional
	public GSchool getSingelSchool(Integer id){
		GSchool school =  gSchoolRepository.getOne(id);
		System.out.println(school.getSupervises().size());
		return school;
	}
}
