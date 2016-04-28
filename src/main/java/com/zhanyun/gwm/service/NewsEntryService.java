package com.zhanyun.gwm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanyun.gwm.entity.NewsEntry;
import com.zhanyun.gwm.repository.NewsEntryRepository;


@Service
public class NewsEntryService {
  @Autowired
  private NewsEntryRepository newsEntryRepository;  
  
  public List<NewsEntry> findAll(){
	  return newsEntryRepository.findAll();
  }
}
