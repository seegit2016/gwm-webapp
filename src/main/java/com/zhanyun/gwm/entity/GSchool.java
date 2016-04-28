package com.zhanyun.gwm.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: GSchool
 *
 */

@Entity
@Table(name = "G_School")
public class GSchool implements Serializable {

	private Integer schoolId;
	private String schoolName;
	private String schoolCode;
	private String shoolType;
	private String schoolArea;
	private Integer staySchNum;
	private Set<GSupervise> supervises = new HashSet(); 
	
	
	@OneToMany(mappedBy = "school")
	public Set<GSupervise> getSupervises() {
		return supervises;
	}

	public void setSupervises(Set<GSupervise> supervises) {
		this.supervises = supervises;
	}

	private Set<GProject> projects = new HashSet();
	private static final long serialVersionUID = 1L;

	public GSchool() {
		super();
	}   
	
	@GeneratedValue
	@Id
	public Integer getSchoolId() {
		return this.schoolId;
	}
	
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}   
	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}   
	public String getSchoolCode() {
		return this.schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}   
	public String getShoolType() {
		return this.shoolType;
	}

	public void setShoolType(String shoolType) {
		this.shoolType = shoolType;
	}   
	public String getSchoolArea() {
		return this.schoolArea;
	}

	public void setSchoolArea(String schoolArea) {
		this.schoolArea = schoolArea;
	}   
	public Integer getStaySchNum() {
		return this.staySchNum;
	}

	public void setStaySchNum(Integer staySchNum) {
		this.staySchNum = staySchNum;
	}
	
	
	@ManyToMany(mappedBy = "schools")
	public Set<GProject> getProjects() {
		return projects;
	}
	
	public void setProjects(Set<GProject> projects) {
		this.projects = projects;
	}
   
}
