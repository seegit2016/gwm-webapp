package com.zhanyun.gwm.rest.pojo.common;
/**
 * 人员对象 
 * @author Administrator
 *
 */
public class UserObject {
	/**
	 * 对象OID
	 */
	private String oid;
	/**
	 * 人员登录编号
	 */
	private String code;
	/**
	 * 人员(中文)名称
	 */
	private String name;
	/**
	 * 手机号
	 */
	private String mobiletel;
	
	/**
	 * 所属部门
	 */
	private String department;
	
	/**
	 * 所属角色
	 */
	private String roleName;
	
	/**
	 * 构造函数
	 */
	public UserObject(){}
	
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

	public String getMobiletel() {
		return mobiletel;
	}

	public void setMobiletel(String mobiletel) {
		this.mobiletel = mobiletel;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}