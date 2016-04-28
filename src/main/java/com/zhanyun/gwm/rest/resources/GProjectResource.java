package com.zhanyun.gwm.rest.resources;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhanyun.gwm.JsonViews;
import com.zhanyun.gwm.entity.GProject;
import com.zhanyun.gwm.repository.GProjectRepository;
import com.zhanyun.gwm.service.GProjectService;


@Component
@Path("/gproject")
public class GProjectResource {

	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private GProjectService gProjectService;
	
	@Autowired
	private GProjectRepository gProjectRepository;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String list() throws JsonGenerationException, JsonMappingException, IOException
	{
		this.logger.info("list()");

		ObjectWriter viewWriter;
/*		if (this.isAdmin()) {
			viewWriter = this.mapper.writerWithView(JsonViews.Admin.class);
		} else {
			viewWriter = this.mapper.writerWithView(JsonViews.User.class);
		}*/
		
		viewWriter = this.mapper.writerWithView(JsonViews.Admin.class);
		List<GProject> allEntries = this.gProjectRepository.findAll();

		return viewWriter.writeValueAsString(allEntries);
	}
}
