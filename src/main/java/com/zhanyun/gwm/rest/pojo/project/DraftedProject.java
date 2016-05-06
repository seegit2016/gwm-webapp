package com.zhanyun.gwm.rest.pojo.project;
import java.util.Date;

import com.zhanyun.gwm.entity.ProjectEntity;

/**
 * 立项中项目Json传递对象(列表与表单共用)
 * 注：约定Restful服务接口传输的json对象结构与实际数据库表结构为不同视图(屏蔽实际DB结构)
 * @author IBM
 *
 */
public class DraftedProject implements Comparable<DraftedProject>{
	/**
	 * 对象OID
	 */
	private String oid;
	/**
	 * 项目编码
	 */
	private String code;
	/**
	 * 项目名称
	 */
	private String name;
	/**
	 * 资助方向
	 */
	private String direction = "新1001夜"; //新1001夜/机构发展/其它/...
	/**
	 * 执行阶段
	 */
	private String projectPhase = "立项";	//默认
	/**
	 * 立项人
	 */
	private String promoter;
	/**
	 * 立项时间
	 */
	private Date promoteTime;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 项目资助人(可多个,显示名称，逗号分开)
	 */
	private String  imburseUnits;
	/**
	 * 预计资助金额
	 */
	private float planImburseFundSum;
	/**
	 * 预计开始日期
	 */
	private Date planStartDate;
	/**
	 * 预计结束日期
	 */
	private Date planEndDate;
	/**
	 * 预计资助学校总数(所)
	 */
	private int planImburseSchoolSum;
	/**
	 * 预期达成目标
	 */
	private String planGoal;
	
	/**
	 * 构造函数
	 */
	public DraftedProject() {
	}

	public DraftedProject(ProjectEntity entity) {
		this.oid = entity.getOid() ;
		this.code = entity.getCode() ;
		this.name = entity.getName() ;
		this.direction = entity.getDirection() ;
		this.projectPhase = entity.getProjectPhase() ;
		this.promoter = entity.getPromoter() ;
		this.promoteTime = entity.getPromoteTime() ;
		this.creator = entity.getCreator() ;
		this.createTime = entity.getCreateTime() ;
		this.imburseUnits = entity.getImburseUnits() ;
		this.planImburseFundSum = entity.getPlanImburseFundSum() ;
		this.planStartDate = entity.getPlanStartDate() ;
		this.planEndDate = entity.getPlanEndDate() ;
		this.planImburseSchoolSum = entity.getPlanImburseSchoolSum() ;
		this.planGoal = entity.getPlanGoal();
	}

	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getProjectPhase() {
		return projectPhase;
	}
	public void setProjectPhase(String projectPhase) {
		this.projectPhase = projectPhase;
	}
	public String getPromoter() {
		return promoter;
	}
	public void setPromoter(String promoter) {
		this.promoter = promoter;
	}
	public Date getPromoteTime() {
		return promoteTime;
	}
	public void setPromoteTime(Date promoteTime) {
		this.promoteTime = promoteTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getImburseUnits() {
		return imburseUnits;
	}
	public void setImburseUnits(String imburseUnits) {
		this.imburseUnits = imburseUnits;
	}
	public float getPlanImburseFundSum() {
		return planImburseFundSum;
	}
	public void setPlanImburseFundSum(float planImburseFundSum) {
		this.planImburseFundSum = planImburseFundSum;
	}
	public Date getPlanStartDate() {
		return planStartDate;
	}
	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}
	public Date getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}
	public int getPlanImburseSchoolSum() {
		return planImburseSchoolSum;
	}
	public void setPlanImburseSchoolSum(int planImburseSchoolSum) {
		this.planImburseSchoolSum = planImburseSchoolSum;
	}
	public String getPlanGoal() {
		return planGoal;
	}
	public void setPlanGoal(String planGoal) {
		this.planGoal = planGoal;
	}

	/**
	 * 暂默认按照项目编号排序
	 */
	public int compareTo(DraftedProject arg0) {
		return this.getCode().compareTo(arg0.getCode());
	}

	public ProjectEntity retriveRawEntity() {
		ProjectEntity entity = new ProjectEntity();
		entity.setOid(this.oid) ;
		entity.setCode(this.code) ;
		entity.setName(this.name) ;
		entity.setDirection(this.direction) ;
		entity.setProjectPhase(this.projectPhase) ;
		entity.setPromoter(this.promoter) ;
		entity.setPromoteTime(this.promoteTime) ;
		entity.setCreator(this.creator) ;
		entity.setCreateTime(this.createTime) ;
		entity.setImburseUnits(this.imburseUnits) ;
		entity.setPlanImburseFundSum(this.planImburseFundSum) ;
		entity.setPlanStartDate(this.planStartDate) ;
		entity.setPlanEndDate(this.planEndDate) ;
		entity.setPlanImburseSchoolSum(this.planImburseSchoolSum) ;
		entity.setPlanGoal(this.planGoal);
		return entity;
	}
}