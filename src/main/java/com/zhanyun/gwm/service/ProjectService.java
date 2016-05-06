package com.zhanyun.gwm.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhanyun.gwm.entity.ProjectEntity;
import com.zhanyun.gwm.repository.ProjectRepository;
import com.zhanyun.gwm.rest.pojo.project.DraftedProject;


@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Transactional
	public ProjectEntity save(ProjectEntity newproj){
		return projectRepository.save(newproj);
	}
	
	@Transactional
	public void delete(String oid){
		projectRepository.delete(oid);
	}
	
	//@Transactional
	public ProjectEntity getOne(String oid){
		List<ProjectEntity> projLst =  projectRepository.getProjById(oid);
		if (projLst == null || projLst.size() == 0) 
			return null;
		return projLst.get(0);		
	}
	
	/**
	 * 获取所有立项中的项目
	 * @return
	 */
	public List<DraftedProject> findAllDraftedProjects() {
		List<ProjectEntity> allDraftedProjectEntity = new ArrayList<ProjectEntity>();
		List<DraftedProject> rtnOBJs = new ArrayList<DraftedProject>();
		try {
			allDraftedProjectEntity = projectRepository.findAllDraftedProjects();
			if (allDraftedProjectEntity == null || allDraftedProjectEntity.size() == 0) {
				//临时测试修正
				allDraftedProjectEntity = projectRepository.findAll();
			}
		} catch (Exception e) {
		}
		if (allDraftedProjectEntity == null || allDraftedProjectEntity.size() == 0) {
			return rtnOBJs;
		}
		for (ProjectEntity item : allDraftedProjectEntity) {
			DraftedProject dProject = new DraftedProject(item);
			rtnOBJs.add(dProject);
		}
		 Collections.sort(rtnOBJs);
		return rtnOBJs;
	}
	
	/**
	 * 获取所有立项中的项目-支持分页
	 * @return
	 */
	public Page<DraftedProject> findAllDraftedProjects(Pageable pageable) {
		Page<ProjectEntity> pageEntity = null;
		List<DraftedProject> rtnOBJs = new ArrayList<DraftedProject>();
		
		
		Specification<ProjectEntity>   specification =  new Specification<ProjectEntity>(){
			@Override
			public Predicate toPredicate(Root<ProjectEntity> root,
					CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
				
				return cb.equal(root.get("projectPhase"), "立项");
			};
		};
			
		try {
			pageEntity = projectRepository.findAll(specification,pageable);
		} catch (Exception e) {
		}
		

		for (ProjectEntity item : pageEntity.getContent()) {
			DraftedProject dProject = new DraftedProject(item);
			rtnOBJs.add(dProject);
		}
		 Collections.sort(rtnOBJs);
		 
		Page<DraftedProject> page = new PageImpl<DraftedProject>(rtnOBJs,pageable,pageEntity.getTotalElements());
		return page;
	}
	/**
	 * 获取符合条件的立项中的项目
	 * @return
	 */
	public List<DraftedProject> findDraftedProjectsByCond(String queryCondition,
			Boolean createByMe) {
		List<ProjectEntity> draftedProjectEntity = new ArrayList<ProjectEntity>();
		List<DraftedProject> rtnOBJs = new ArrayList<DraftedProject>();
		final Map<String,String> conditionMap = new HashMap<String,String>();
		
		if (queryCondition!=null){
			String [] conditionArray =   queryCondition.split("\\|\\|");
			for (String condition : conditionArray) {
				String [] nameAndValue =condition.split("=");
				if (nameAndValue.length==2){
					conditionMap.put(nameAndValue[0], nameAndValue[1]);
				}
			}
		}
		
		final Boolean _createByMe =createByMe;
		
		Specification<ProjectEntity>   specification =  new Specification<ProjectEntity>(){
			@Override
			public Predicate toPredicate(Root<ProjectEntity> root,
					CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Predicate predicate =null;
				Set<String> set = conditionMap.keySet();
				ArrayList<Predicate> predicateArray =  new ArrayList<Predicate>();
				 
				for (String s:set) {
					Path path = root.get(s);
					predicateArray.add(cb.like(path, conditionMap.get(s)));
				}
				Predicate[] arr = new Predicate[predicateArray.size()];
				predicate = cb.and(new Predicate[]{cb.or(predicateArray.toArray(arr)),cb.equal(root.get("projectPhase"), "立项")});
				
				if (_createByMe!=null && _createByMe == true){
					predicate = cb.and(predicate,cb.equal(root.get("creator"), "梅D")) ;
				}
				return predicate;
			}; 
		};
		
		try {
				draftedProjectEntity = projectRepository.findAll(specification);
		} catch (Exception e) {
		}
		
		if (draftedProjectEntity == null || draftedProjectEntity.size() == 0) {
			return rtnOBJs;
		}
		for (ProjectEntity item : draftedProjectEntity) {
			DraftedProject dProject = new DraftedProject(item);
			rtnOBJs.add(dProject);
		}
		 Collections.sort(rtnOBJs);
		return rtnOBJs;
	}
	
	
	
	public Page<DraftedProject> findDraftedProjectsByCond(String queryCondition,
			Boolean createByMe,Pageable pageable) {
		Page<ProjectEntity> pageEntity = null;
		List<DraftedProject> rtnOBJs = new ArrayList<DraftedProject>();
		
		
		
		final Map<String,String> conditionMap = new HashMap<String,String>();
		
		if (queryCondition!=null){
			String [] conditionArray =   queryCondition.split("\\|\\|");
			for (String condition : conditionArray) {
				String [] nameAndValue =condition.split("=");
				if (nameAndValue.length==2){
					conditionMap.put(nameAndValue[0], nameAndValue[1]);
				}
			}
		}
		
		final Boolean _createByMe =createByMe;
		
		Specification<ProjectEntity>   specification =  new Specification<ProjectEntity>(){
			@Override
			public Predicate toPredicate(Root<ProjectEntity> root,
					CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Predicate predicate =null;
				Set<String> set = conditionMap.keySet();
				ArrayList<Predicate> predicateArray =  new ArrayList<Predicate>();
				 
				for (String s:set) {
					Path path = root.get(s);
					predicateArray.add(cb.like(path, conditionMap.get(s)));
				}
				Predicate[] arr = new Predicate[predicateArray.size()];
				predicate = cb.and(new Predicate[]{cb.or(predicateArray.toArray(arr)),cb.equal(root.get("projectPhase"), "立项")});
				
				if (_createByMe!=null && _createByMe == true){
					predicate = cb.and(predicate,cb.equal(root.get("creator"), "梅D")) ;
				}
				return predicate;
			}; 
		};
		
		try {
			pageEntity = projectRepository.findAll(specification,pageable);
		} catch (Exception e) {
		}
		
		for (ProjectEntity item : pageEntity.getContent()) {
			DraftedProject dProject = new DraftedProject(item);
			rtnOBJs.add(dProject);
		}
		 Collections.sort(rtnOBJs);
		 
		Page<DraftedProject> page = new PageImpl<DraftedProject>(rtnOBJs,pageable,pageEntity.getTotalElements());
		return page;
	}
	
	
	public List<DraftedProject> findAllDraftedProjects(String queryCondition,Boolean createByMe) {
		if ((queryCondition == null || queryCondition.length() == 0) && (createByMe == null || createByMe == false) ){
				return this.findAllDraftedProjects();
		} else {
			return this.findDraftedProjectsByCond(queryCondition,createByMe);
		}
	}
	
	public Page<DraftedProject> findAllDraftedProjects(String queryCondition,
			Boolean createByMe,Pageable pageable) {
		if ((queryCondition == null || queryCondition.length() == 0) && (createByMe == null || createByMe == false) ){
			return this.findAllDraftedProjects(pageable);
		} else {
			return this.findDraftedProjectsByCond(queryCondition,createByMe,pageable);
		}
	}
	
	/**
	 * 获取立项中项目
	 * @param oid
	 * @return
	 */
	public DraftedProject getOneDraftedProject(String oid) {
		DraftedProject rtnOBJ = new DraftedProject();
		ProjectEntity entity = this.getOne(oid);
		if (entity != null && entity.getProjectPhase().equals("立项")) {
			rtnOBJ = new DraftedProject(entity);
		}
		return rtnOBJ;
	}
	
	/**
	 * 新建保存立项中项目
	 * @param newProject
	 * @return
	 * @throws Throwable
	 */
	public DraftedProject saveDraftedProject(DraftedProject newProject) throws Throwable {
		DraftedProject draftedProject = new DraftedProject();
		/*newProject.setCode("2016002");
		newProject.setDirection("新1001夜");
		newProject.setProjectPhase("立项");
		newProject.setPromoter("梅D");
		newProject.setPromoteTime(new Date());
		newProject.setCreator("梅D");
		newProject.setCreateTime(new Date());*/
		if (newProject == null || newProject.getDirection() == null
				|| newProject.getDirection().trim().equals("")) {
			throw new Throwable("传入项目数据不完整,或没有指定项目的资助方向,该项目不能成功创建!");
		}
		newProject.setOid("");
		newProject.setProjectPhase("立项");
		String pDirection = newProject.getDirection().trim();
		//产生项目编号
		String pcode = "";
		//得到long类型当前时间
		long l = System.currentTimeMillis();
		//new日期对象
		Date date = new Date(l);
		//转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssFFF");//暂默认规则
		pcode = dateFormat.format(date);
		if (pDirection.equals("新1001夜")) {
			pcode = "1-" + pcode;
		}else {
			pcode = "2-" + pcode;	//暂默认规则
		}
		newProject.setCode(pcode);
		newProject.setCreateTime(date);
		newProject.setPromoteTime(date);
		if (newProject.getCreator() == null || newProject.getCreator().trim().equals("")) {
			newProject.setCreator("梅冬");		//需解决Rest API访问时User信息传递
		}
		if (newProject.getPromoter() == null || newProject.getPromoter().trim().equals("")) {
			newProject.setPromoter("梅冬");		//需解决Rest API访问时User信息传递
		}
		ProjectEntity newEntity = newProject.retriveRawEntity();
		newEntity = this.save(newEntity);
		draftedProject = new DraftedProject(newEntity);
		return draftedProject;
	}
	
	/**
	 * 删除立项中项目
	 * @param oid
	 * @throws Throwable
	 */
	public boolean deleteDraftedProject(String oid) throws Throwable {
		if (oid == null || oid.trim().equals("")) {
			return false;
		}
		ProjectEntity entity = this.getOne(oid);
		if (entity == null || entity.getOid().equals("")) {
			return false;
		}
		if (!entity.getProjectPhase().equals("立项")) {
			throw new Throwable("不能删除非立项中项目!");
		}
		this.delete(oid);
		return true;
	}

	/**
	 * 更新保存立项中项目
	 * @param projectOBJ
	 * @throws Throwable
	 */
	public DraftedProject updateDraftedProject(DraftedProject projectOBJ) throws Throwable  {
		DraftedProject draftedProject = new DraftedProject();
		/*newProject.setCode("2016002");
		newProject.setDirection("新1001夜");
		newProject.setProjectPhase("立项");
		newProject.setPromoter("梅D");
		newProject.setPromoteTime(new Date());
		newProject.setCreator("梅D");
		newProject.setCreateTime(new Date());*/
		if (projectOBJ == null || projectOBJ.getOid() == null
				|| projectOBJ.getOid().trim().equals("")
				|| projectOBJ.getDirection() == null || projectOBJ.getCode().trim().equals("")
				|| projectOBJ.getDirection().trim().equals("")) {
			throw new Throwable("传入项目数据不完整,或没有指定项目的资助方向,该项目不能成功创建!");
		}
		projectOBJ.setProjectPhase("立项");
		String pDirection = projectOBJ.getDirection().trim();
		//产生项目编号
		String pcode = "";
		pcode = projectOBJ.getCode();
		if (pDirection.equals("新1001夜")) {
			pcode = "1-" + pcode.substring(2);
		}else {
			pcode = "2-" + pcode.substring(2);	//暂默认规则
		}
		projectOBJ.setCode(pcode);
		ProjectEntity updateEntity = projectOBJ.retriveRawEntity();
		updateEntity = this.save(updateEntity);
		draftedProject = new DraftedProject(updateEntity);
		return draftedProject;
	}
}
