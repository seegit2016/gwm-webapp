package com.zhanyun.gwm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
/**
 * Entity implementation class for Entity: GProject
 *
 */
@Entity
@Table(name = "G_PROJECT")
public class GProject implements Serializable {

	private Integer projId;
	private String projName;
	private String projCode;
	private String fundDirection;
	private String projCreator;
	private Date createDate;
	private String projManagerName;
	private Set<GSchool> schools = new HashSet();
		
	
	
	
	private static final long serialVersionUID = 1L;

	public GProject() {
		super();
	}   

	@GeneratedValue
	@Id
	public Integer getProjId() {
		return projId;
	}
	

	public void setProjId(Integer projId) {
		this.projId = projId;
	}
	
	public String getProjCode() {
		return this.projCode;
	}

	
	
	public void setProjCode(String projCode) {
		this.projCode = projCode;
	} 
	


	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getFundDirection() {
		return this.fundDirection;
	}

	public void setFundDirection(String fundDirection) {
		this.fundDirection = fundDirection;
	}   
	public String getProjCreator() {
		return this.projCreator;
	}

	public void setProjCreator(String projCreator) {
		this.projCreator = projCreator;
	}   
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}   
	public String getProjManagerName() {
		return this.projManagerName;
	}

	public void setProjManagerName(String projManagerName) {
		this.projManagerName = projManagerName;
	}
	
	@Override
	public  String toString(){
		return "project code:"+this.projCode+" projec name: "+this.projName +" project CreateDate"+this.getCreateDate();
	}

	@JoinTable(name = "G_Project2School",
			joinColumns = {@JoinColumn(name = "proj_id",referencedColumnName="projId")},
			inverseJoinColumns = {@JoinColumn(name = "school_id",referencedColumnName="schoolId")}
			)
	@ManyToMany
	public Set<GSchool> getSchools() {
		return schools;
	}

	public void setSchools(Set<GSchool> schools) {
		this.schools = schools;
	}
   
}
