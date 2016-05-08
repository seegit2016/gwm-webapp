package com.zhanyun.gwm.rest.pojo.project;

import java.util.ArrayList;
import java.util.List;

/**
 * 立项中项目对象集合对象(分页处理)
 * @author Administrator
 *
 */
public class DraftedProjectList {
	private int pageindex = 0 ; 	//默认为第一页
	private int pagesize = 10;		//默认每页10行
	private int totalPrjsCount = 0;	//总项目对象个数
	private int totalPagesCount = 0;//总列表页数
	private String queryid = "";	//当前列表查询唯一ID（UUID），一般为第一次查询时由前台传入
	private List<DraftedProject> curPageListData = new ArrayList<DraftedProject>();//当前返回页项目对象集合

	public DraftedProjectList(String queryid, int pageindex, int pagesize,
			int totalPrjsCount, int totalPagesCount,
			List<DraftedProject> curPageListData) {
		this.queryid = queryid;
		this.pageindex = pageindex;
		this.pagesize = pagesize;
		this.totalPrjsCount = totalPrjsCount;
		this.totalPagesCount = totalPagesCount;
		this.curPageListData = curPageListData;
	}
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalPrjsCount() {
		return totalPrjsCount;
	}
	public void setTotalPrjsCount(int totalPrjsCount) {
		this.totalPrjsCount = totalPrjsCount;
	}
	public int getTotalPagesCount() {
		return totalPagesCount;
	}
	public void setTotalPagesCount(int totalPagesCount) {
		this.totalPagesCount = totalPagesCount;
	}
	public String getQueryid() {
		return queryid;
	}
	public void setQueryid(String queryid) {
		this.queryid = queryid;
	}
	public List<DraftedProject> getCurPageListData() {
		return curPageListData;
	}
	public void setCurPageListData(List<DraftedProject> curPageListData) {
		this.curPageListData = curPageListData;
	}
}
