package com.zhanyun.gwm.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhanyun.baseweb.rest.pojo.area.County;
import com.zhanyun.baseweb.service.AreaService;
import com.zhanyun.gwm.entity.GProject;
import com.zhanyun.gwm.entity.GSchool;
import com.zhanyun.gwm.entity.GSupervise;
import com.zhanyun.gwm.entity.ProjectEntity;
import com.zhanyun.gwm.repository.GProjectRepository;
import com.zhanyun.gwm.repository.GSchoolRepository;
import com.zhanyun.gwm.repository.ProjectRepository;
import com.zhanyun.gwm.rest.pojo.project.DraftedProject;
import com.zhanyun.gwm.service.GProjectService;
import com.zhanyun.gwm.service.GSchoolService;
import com.zhanyun.gwm.service.GSuperviseService;
import com.zhanyun.gwm.service.ProjectService;


public class gwmTest {

	private ApplicationContext ctx= null;
	private DataSource datasource = null;
	private GProjectService gProjectService;
	private GSuperviseService gSuperviseService;
	private GSchoolService gSchoolService;
	private ProjectService projectService;
	
	private GProjectRepository gProjectRepository;
	private GSchoolRepository gSchoolRepository;
	private ProjectRepository projectRepository;
	private AreaService areaService;
	
	
	{
		ctx = new ClassPathXmlApplicationContext("context.xml");
		gProjectService = ctx.getBean(GProjectService.class);
		gProjectRepository = ctx.getBean(GProjectRepository.class);
		
		gSuperviseService = ctx.getBean(GSuperviseService.class);
		
		gSchoolRepository = ctx.getBean(GSchoolRepository.class);
		gSchoolService = ctx.getBean(GSchoolService.class);
		
		projectService = ctx.getBean(ProjectService.class);
		projectRepository = ctx.getBean(ProjectRepository.class);
		areaService = ctx.getBean(AreaService.class);
		
		
	}
	
	/*
	
	@Test
	public void testDataSource() throws SQLException {
		datasource = ctx.getBean(DataSource.class);
		System.out.println(datasource.getConnection());
	}
	
	@Test
	public void testGetProjByName(){
		List<GProject> lst =  gProjectService.getProjByName("AA");
		System.out.println(lst.toString());
	}
	
	@Test
	public void testSave(){
		List<GProject> gProjects = new ArrayList();
		
		for(int i = 'A'; i <= 'Z'; i++){
			GProject gProject = new GProject();
			
			gProject.setProjName("新1001夜"+(char)i + "" + (char)i+"项目");
			gProject.setProjCode("PX1001-"+(char)i);
			
			gProject.setFundDirection("新1001夜");
			gProject.setProjCreator((char)i + "" + (char)i+"" + (char)i);
			gProject.setProjManagerName((char)i + "" + (char)i+"" + (char)i); 
			gProject.setCreateDate(new Date());
			
			gProjects.add(gProject);
		}
		
		gProjectService.saveGProjects(gProjects);
	}
	
	
	@Test
	public void testGetSchool(){
		gProjectService.getProjById(1);
	}
	
	@Test
	public void testSaveSupervise(){
		GSupervise supervise = new GSupervise();
		GProject gProject = gProjectRepository.getOne(1);
		GSchool gSchool = gSchoolRepository.getOne(1);
		supervise.setProject(gProject);
		supervise.setSchool(gSchool);
		supervise.setSpvisOrgName("歌路营");
		supervise.setSpvisPerson("刘建康");
		GSupervise  gSupervise= gSuperviseService.save(supervise);
		System.out.println(gSupervise.getSpvisId());
	}
	
	@Test
	public void testGetSchoolSupervise(){
		GSchool gSchool = gSchoolService.getSingelSchool(1);
		//System.out.println(gSchool.getSupervises().size());

	}*/

	@Test
	public void testCreateNewProj() throws ParseException {
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse("2016-08-08 12:10:12");
		Date date2 = sdf.parse("2016-10-08 12:10:12"); 
		
		Project newProject = new Project();
		newProject.setCode("2016005");
		newProject.setName("2016为爱走一夜");
		newProject.setDirection("新1001夜");
		newProject.setProjectPhase("立项");
		
		newProject.setPromoter("梅D");
		newProject.setPromoteTime(new Date());
		newProject.setCreator("梅D");
		newProject.setCreateTime(new Date());
		
		newProject.setImburseUnits("香港为普顾问有限责任公司,北京京华公益事业基金会,北京感恩公益基金会");
		newProject.setPlanImburseFundSum(4);
		newProject.setPlanStartDate(date);
		newProject.setPlanEndDate(date2);
		newProject.setPlanImburseSchoolSum(6);
		newProject.setPlanGoal("为了让更多学校的孩子能够听到睡前故事，歌路营发起“为爱走一夜”公益募捐活动，号召人们用健康运动的方式领略北京城的优美夜景。同时筹集善款为更多的寄宿学校的孩子送上睡前故事，用善款购买喇叭安装在宿舍里面，用于为孩子们播放睡前故事，为学校老师购买电子刊物和在线培训课程，为当地老师提供睡前故事材料");
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse("2016-05-08 12:10:12");
		Date date2 = sdf.parse("2016-12-08 12:10:12"); 
		
		Project newProject = new Project();
		newProject.setCode("2016002");
		newProject.setName("2016新1001夜");
		newProject.setDirection("新1001夜");
		newProject.setProjectPhase("立项");
		
		newProject.setPromoter("梅D");
		newProject.setPromoteTime(new Date());
		newProject.setCreator("梅D");
		newProject.setCreateTime(new Date());
		
		newProject.setImburseUnits("张小杰,刘凯,北京感恩公益基金会");
		newProject.setPlanImburseFundSum(5);
		newProject.setPlanStartDate(date);
		newProject.setPlanEndDate(date2);
		newProject.setPlanImburseSchoolSum(2);
		newProject.setPlanGoal("4C即Class、Campus、Community、City的首字母缩写。它象征着班级融入、校园融入、社区融入和城市融入");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse("2016-03-08 12:10:12");
		Date date2 = sdf.parse("2016-11-08 12:10:12"); 
		
		Project newProject = new Project();
		newProject.setCode("2016003");
		newProject.setName("2016新1001夜");
		newProject.setDirection("机构发展");
		newProject.setProjectPhase("立项");
		
		newProject.setPromoter("张胜");
		newProject.setPromoteTime(new Date());
		newProject.setCreator("张胜");
		newProject.setCreateTime(new Date());
		
		newProject.setImburseUnits("伍子胥,振文,北京感恩公益基金会");
		newProject.setPlanImburseFundSum(6);
		newProject.setPlanStartDate(date);
		newProject.setPlanEndDate(date2);
		newProject.setPlanImburseSchoolSum(2);
		newProject.setPlanGoal("“新一千零一夜睡前故事”项目开展以来，深受学校老师与孩子的好评。青海一所学校的喇叭坏了，孩子们缠着老师要听故事，老师索性自己拿起故事书，为孩子们念了整整一星期！");
		*/
		//ProjectEntity savedProject = projectService.getOne("402881e75442a39a015442a3a2760000");
		//savedProject.setName("2016创▪可乐");
		//projectService.save(savedProject);
		
		//System.out.println(savedProject.getName());
		
/*		projectService.save(newProject);
		System.out.println(newProject.getName());*/
	}
	
	@Test
	public void deleteNewProj() {
		//projectService.delete("402881e75442c80b015442c812cb0000");
	}
	
	@Test
	public void testFindAllDraftedProjects() throws Throwable{
/*		String condition = "code=2016001||name=2016创▪可乐";
		Boolean createByMe = true;
		
	   List<DraftedProject> aa = projectService.findAllDraftedProjects(condition, createByMe);
	  System.out.println(aa.size());
	  */
/*	  List<County> aa = areaService.findAreaByCity("110100");
	  System.out.println(aa.size());*/
		
	}
	
	
	
	
}
