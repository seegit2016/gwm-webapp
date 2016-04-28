package com.zhanyun.gwm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhanyun.gwm.entity.GSupervise;
import com.zhanyun.gwm.repository.GSuperviseRepository;

@Service
public class GSuperviseService {

	@Autowired
	private GSuperviseRepository gSuperviseRepository;
	
	@Transactional
	public GSupervise save(GSupervise entity){
		return gSuperviseRepository.save(entity);
	}
	
}
