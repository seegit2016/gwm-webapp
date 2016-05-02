package com.zhanyun.gwm.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHH");//暂默认规则
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
		ProjectEntity newEntity = draftedProject.getRawEntity();
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
		ProjectEntity updateEntity = draftedProject.getRawEntity();
		updateEntity = this.save(updateEntity);
		draftedProject = new DraftedProject(updateEntity);
		return draftedProject;
	}
	
}
