package com.zhanyun.gwm.rest.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanyun.baseweb.exception.BaseWebException;
import com.zhanyun.baseweb.exception.IOWebException;
import com.zhanyun.baseweb.exception.OtherWebException;
import com.zhanyun.baseweb.rest.util.ResponseData;
import com.zhanyun.gwm.repository.ProjectRepository;
import com.zhanyun.gwm.rest.pojo.project.DraftedProject;
import com.zhanyun.gwm.service.ProjectService;

@Component
@Path("/draftedprojects")
public class DraftedProjects {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired 
	private ProjectRepository projectRepository;
	
	
	/**
	 * 获取所有立项项目库列表中对象集合
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseData<List<DraftedProject>> list()
			throws JsonGenerationException, JsonMappingException, IOException {
		this.logger.info("getAllDraftedProjectObjects()");
		List<DraftedProject> listItems = new ArrayList<DraftedProject>();
		//listItems = projectRepository.findAll();
		listItems = projectService.findAllDraftedProjects();
		ResponseData<List<DraftedProject>> rdata = new ResponseData<List<DraftedProject>>("1","获取成功！",true,listItems);
		return rdata;
	}
	
	/**
	 * 获取所有立项项目库列表中对象集合(带查询条件)
	 * @param queryCondition
	 * @param createByMe
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/query")
	public ResponseData<Object> query(
			@QueryParam("condition") @DefaultValue("") String queryCondition/*编号||名称||资助者||预计达成目标*/,
			@QueryParam("createBySelf") @DefaultValue("") Boolean createByMe,
			@QueryParam("pageindex") @DefaultValue("0") Integer pageindex,
			@QueryParam("pagesize") @DefaultValue("0") Integer pagesize)
			throws JsonGenerationException, JsonMappingException, IOException {
		this.logger.info("getAllDraftedProjectByQuery()");
		List<DraftedProject> listItems = new ArrayList<DraftedProject>();
		ResponseData<Object> rdata = null;
		if ( pagesize==null || pagesize<1) pagesize = 0;
		if ( pageindex==null || pageindex<0) pageindex =0;
		if (pagesize==0){
			listItems = projectService.findAllDraftedProjects(queryCondition,createByMe);
			rdata = new ResponseData<Object>("1", "获取成功！", true, listItems);
		}else {
			Pageable pageable = new PageRequest(pageindex,pagesize);
			Page<DraftedProject> rtnPage = projectService.findAllDraftedProjects(queryCondition,createByMe,pageable);
			rdata = new ResponseData<Object>("1", "获取成功！", true, rtnPage);
		}
		return rdata;
	}
	
	/**
	 * 获取单个项目对象
	 * @param oid
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{oid}")
	public ResponseData<DraftedProject> getDraftedProjectObject(@PathParam("oid") String oid) {
		this.logger.info("getDraftedProjectObject(oid)");
/*		if (oid == null)
			return new ResponseData<Object>("-1","获取失败,查询条件为空",false,null);*/
		DraftedProject formOBJ =null;
		ResponseData<DraftedProject> rdata = null;
		try {
			//formOBJ = projectService.getOne(oid);
			formOBJ = projectService.getOneDraftedProject(oid);
			//System.out.println(formOBJ.getName());
			if (formOBJ==null)
				rdata = new ResponseData<DraftedProject>("-1","获取失败！",false,null);
			else rdata = new ResponseData<DraftedProject>("1","获取成功！",true,formOBJ);
		}catch(Throwable e){
			this.logger.error(e.getMessage());
			e.printStackTrace();
			if (e instanceof BaseWebException) {
				throw (BaseWebException)e;
			}else {
				throw new OtherWebException("获取过程产生异常:" + e.getMessage() + ";返回异常码再约定!",500);
			}
		}
		return rdata;		
	}
	
	/**
	 * 项目对象创建保存
	 * @param newProject
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseData<DraftedProject> create(DraftedProject newProject) {
		this.logger.info("createProject(): " + newProject);
		DraftedProject savedProject = null;
		try {
			if (newProject == null) {
				throw new IOWebException("创建过程产生异常;返回异常码再约定!");
			}
			newProject.setOid("");//修正OID
			savedProject = projectService.saveDraftedProject(newProject);
		} catch (Throwable e) {
			this.logger.error(e.getMessage());
			e.printStackTrace();
			if (e instanceof BaseWebException) {
				throw (BaseWebException)e;
			}else {
				throw new OtherWebException("创建过程产生异常:" + e.getMessage() + ";返回异常码再约定!",500);
			}
		}
		
		return new ResponseData<DraftedProject>("1","创建成功！",true,savedProject);
	}

	/**
	 * 修改项目对象
	 * @param oid
	 * @param projectOBJ
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{oid}")
	public ResponseData<DraftedProject> update(@PathParam("oid") String oid, DraftedProject projectOBJ) {
		this.logger.info("update(oid): " + projectOBJ);
		try {
			if (projectOBJ == null /*|| !projectOBJ.getOid().equals(oid)*/) {
				throw new IOWebException("更新过程产生异常;返回异常码再约定!");
			}
			projectOBJ.setOid(oid);//修正OID
			projectOBJ = projectService.updateDraftedProject(projectOBJ);
		} catch (Throwable e) {
			this.logger.error(e.getMessage());
			e.printStackTrace();
			if (e instanceof BaseWebException) {
				throw (BaseWebException)e;
			}else {
				throw new OtherWebException("更新过程产生异常:" + e.getMessage() + ";返回异常码再约定!",500);
			}
		}
		return new ResponseData<DraftedProject>("1","更新成功！",true,projectOBJ);
	}

	/**
	 * 删除项目对象
	 * @param oid
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{oid}")
	@ResponseBody
	public ResponseData<Object> delete(@PathParam("oid") String oid) throws BaseWebException {
		this.logger.info("deleteProject(oid)");
		try {
			projectService.deleteDraftedProject(oid);
		} catch (Throwable e) {
			this.logger.error(e.getMessage());
			e.printStackTrace();
			throw new OtherWebException("删除过程产生异常:" + e.getMessage() + ";返回异常码再约定!",500);
		}
		return new ResponseData<Object>("1","删除成功！",true,null);
	}
}
