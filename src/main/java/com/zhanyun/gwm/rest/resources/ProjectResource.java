package com.zhanyun.gwm.rest.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanyun.baseweb.exception.BaseWebException;
import com.zhanyun.baseweb.exception.IOWebException;
import com.zhanyun.baseweb.exception.OtherWebException;
import com.zhanyun.baseweb.rest.util.ResponseData;
import com.zhanyun.gwm.entity.Project;
import com.zhanyun.gwm.repository.ProjectRepository;
import com.zhanyun.gwm.service.ProjectService;

@Component
@Path("/draftedprojects")
public class ProjectResource {

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
	public ResponseData list()
			throws JsonGenerationException, JsonMappingException, IOException {
		this.logger.info("getAllDraftedProjectObjects()");
		List<Project> listItems = new ArrayList<Project>();
		listItems = projectRepository.findAll();
		
		ResponseData<List<Project>> rdata = new ResponseData<List<Project>>("1","获取成功！",true,listItems);
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
	public ResponseData getDraftedProjectObject(@PathParam("oid") String oid) {
		this.logger.info("getDraftedProjectObject(oid)");
/*		if (oid == null)
			return new ResponseData<Object>("-1","获取失败,查询条件为空",false,null);*/
		Project formOBJ =null;
		ResponseData<Project> rdata = null;
		try {
			formOBJ = projectService.getOne(oid);
			//System.out.println(formOBJ.getName());
			if (formOBJ==null)
				rdata = new ResponseData<Project>("-1","获取失败！",false,null);
			else rdata = new ResponseData<Project>("1","获取成功！",true,formOBJ);
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
	public ResponseData create(Project newProject) {
		this.logger.info("createProject(): " + newProject);
		Project savedProject = null;
		try {
			if (newProject == null) {
				throw new IOWebException("创建过程产生异常;返回异常码再约定!");
			}
			savedProject = projectService.save(newProject);
		} catch (Throwable e) {
			this.logger.error(e.getMessage());
			e.printStackTrace();
			if (e instanceof BaseWebException) {
				throw (BaseWebException)e;
			}else {
				throw new OtherWebException("创建过程产生异常:" + e.getMessage() + ";返回异常码再约定!",500);
			}
		}
		
		return new ResponseData<Project>("1","创建成功！",true,savedProject);
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
	public ResponseData update(@PathParam("oid") String oid, Project projectOBJ) {
		this.logger.info("update(oid): " + projectOBJ);
		try {
			if (projectOBJ == null) {
				throw new IOWebException("更新过程产生异常;返回异常码再约定!");
			}
			projectService.save(projectOBJ);
		} catch (Throwable e) {
			this.logger.error(e.getMessage());
			e.printStackTrace();
			if (e instanceof BaseWebException) {
				throw (BaseWebException)e;
			}else {
				throw new OtherWebException("更新过程产生异常:" + e.getMessage() + ";返回异常码再约定!",500);
			}
		}
		return new ResponseData<Project>("1","更新成功！",true,projectOBJ);
	}

	/**
	 * 删除项目对象
	 * @param oid
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{oid}")
	@ResponseBody
	public ResponseData delete(@PathParam("oid") String oid) throws BaseWebException {
		this.logger.info("deleteProject(oid)");
		try {
			projectService.delete(oid);
		} catch (Throwable e) {
			this.logger.error(e.getMessage());
			e.printStackTrace();
			throw new OtherWebException("删除过程产生异常:" + e.getMessage() + ";返回异常码再约定!",500);
		}
		return new ResponseData<Object>("1","删除成功！",true,null);
	}
	
}
