package com.zhanyun.baseweb.rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhanyun.baseweb.rest.pojo.area.County;
import com.zhanyun.baseweb.rest.pojo.city.City;
import com.zhanyun.baseweb.rest.pojo.province.Province;
import com.zhanyun.baseweb.rest.util.ResponseData;
import com.zhanyun.baseweb.service.AreaService;


@Component
@Path("/countryarea")
public class CountyAreaResource {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private AreaService areaService;
	
	/**
	 * 获取全局所有的省份
	 * @throws Throwable 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/provinces")
	public ResponseData<Object> findAllProvinces()	throws Throwable {
		this.logger.info("findAllProvinces()");
		List<Province> listItems = new ArrayList<Province>();
		ResponseData<Object> rdata = null;
		List<Province> rtnPage = areaService.findAllProvinces();
		rdata = new ResponseData<Object>("1", "获取成功！", true, rtnPage);
		return rdata;
	}
	
	
	/**
	 * 获取全局所有的省份
	 * @throws Throwable 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/provinces/{provinceCode}/citys")
	public ResponseData<Object> findCityByProvince( 
			@PathParam("provinceCode") String provinceCode
			)	throws Throwable {
		this.logger.info("findCityByProvince()");
		//List<Province> listItems = new ArrayList<Province>();
		ResponseData<Object> rdata = null;
		List<City> rtnPage = areaService.findCityByProvince(provinceCode);
		rdata = new ResponseData<Object>("1", "获取成功！", true, rtnPage);
		return rdata;
	}
	
	/**
	 * 获取全局所有的省份
	 * @throws Throwable 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/citys/{cityCode}/countys")
	public ResponseData<Object> findCountyByCity(
			@PathParam("cityCode")  String cityCode
			)	throws Throwable {
		this.logger.info("findCountyByCity()");
		ResponseData<Object> rdata = null;
		List<County> rtnPage = areaService.findAreaByCity(cityCode);
		rdata = new ResponseData<Object>("1", "获取成功！", true, rtnPage);
		return rdata;
	}

}
