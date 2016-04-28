package com.zhanyun.gwm.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: GSupervise
 *
 */
@Table(name = "G_Supervise")
@Entity

public class GSupervise implements Serializable {

	   
	
	private Integer spvisId;
	private String spvisOrgName;
	private String spvisPerson;
	private GProject project;
	private GSchool school;
	
	private static final long serialVersionUID = 1L;

	public GSupervise() {
		super();
	}  
	
	@GeneratedValue
	@Id
	public Integer getSpvisId() {
		return this.spvisId;
	}

	public void setSpvisId(Integer spvisId) {
		this.spvisId = spvisId;
	}   
	public String getSpvisOrgName() {
		return this.spvisOrgName;
	}

	public void setSpvisOrgName(String spvisOrgName) {
		this.spvisOrgName = spvisOrgName;
	}   
	public String getSpvisPerson() {
		return this.spvisPerson;
	}

	public void setSpvisPerson(String spvisPerson) {
		this.spvisPerson = spvisPerson;
	}
	
	@JoinColumn(name = "proj_id")
	@ManyToOne
	public GProject getProject() {
		return project;
	}

	public void setProject(GProject project) {
		this.project = project;
	}

	@JoinColumn(name = "school_id")
	@ManyToOne
	public GSchool getSchool() {
		return school;
	}

	public void setSchool(GSchool school) {
		this.school = school;
	}

}
