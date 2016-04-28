package com.zhanyun.gwm.entity;

import java.io.Serializable;



import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
/**
 * Entity implementation class for Entity: GPatron
 *
 */

@Table(name="G_Patron")
@Entity
public class GPatron implements Serializable {

	private Integer patronId;
	private String patronCode;
	private String patronName;
	private String patronType;
	private String donateAccount;
	private String payTool;
	private Float donateTotalAmount;
	private Float receiveAmount;
	private String Remark;
	private static final long serialVersionUID = 1L;

	public GPatron() {
		super();
	}
	
	@GeneratedValue
	@Id  
	public Integer getPatronId() {
		return patronId;
	}


	public void setPatronId(Integer patronId) {
		this.patronId = patronId;
	}


	String getPatronCode() {
		return this.patronCode;
	}

	public void setPatronCode(String patronCode) {
		this.patronCode = patronCode;
	}   
	public String getPatronName() {
		return this.patronName;
	}

	public void setPatronName(String patronName) {
		this.patronName = patronName;
	}   
	public String getPatronType() {
		return this.patronType;
	}

	public void setPatronType(String patronType) {
		this.patronType = patronType;
	}   
	public String getDonateAccount() {
		return this.donateAccount;
	}

	public void setDonateAccount(String donateAccount) {
		this.donateAccount = donateAccount;
	}   
	public String getPayTool() {
		return this.payTool;
	}

	public void setPayTool(String payTool) {
		this.payTool = payTool;
	}   
	public Float getDonateTotalAmount() {
		return this.donateTotalAmount;
	}

	public void setDonateTotalAmount(Float donateTotalAmount) {
		this.donateTotalAmount = donateTotalAmount;
	}   
	public Float getReceiveAmount() {
		return this.receiveAmount;
	}

	public void setReceiveAmount(Float receiveAmount) {
		this.receiveAmount = receiveAmount;
	}   
	public String getRemark() {
		return this.Remark;
	}

	public void setRemark(String Remark) {
		this.Remark = Remark;
	}
   
}
