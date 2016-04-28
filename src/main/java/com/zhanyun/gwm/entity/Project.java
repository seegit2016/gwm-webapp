package com.zhanyun.gwm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 立项中项目
 * @author IBM
 *
 */

@Entity
@Table(name = "B_PROJECT")
public class Project {

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
	private String imburseUnits;
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
	public Project() {
	}
	

	@GenericGenerator(name = "generator", strategy = "uuid.hex")  
	@GeneratedValue(generator = "generator")  
	@Column(name = "oid", length = 40)  
	@Id
	public String getOid() {
		return oid;
	}


	public void setOid(String oid) {
		this.oid = oid;
	}

	@Column(unique = true, length = 100, nullable = false)
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

	@Column(length = 400)
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 100)
	public String getDirection() {
		return direction;
	}

	
	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Column(length = 40)
	public String getProjectPhase() {
		return projectPhase;
	}

	
	public void setProjectPhase(String projectPhase) {
		this.projectPhase = projectPhase;
	}

	@Column(length = 40)
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

	@Column(length = 40)
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

	@Column(length = 2000)
	public String getPlanGoal() {
		return planGoal;
	}


	public void setPlanGoal(String planGoal) {
		this.planGoal = planGoal;
	}

	@Column(length = 1000)
	public String getImburseUnits() {
		return imburseUnits;
	}


	public void setImburseUnits(String imburseUnits) {
		this.imburseUnits = imburseUnits;
	}
	
	
	
}
