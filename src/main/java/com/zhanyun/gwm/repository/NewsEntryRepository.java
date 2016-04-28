package com.zhanyun.gwm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zhanyun.gwm.entity.NewsEntry;


public interface NewsEntryRepository extends JpaRepository<NewsEntry, Long> {

}
