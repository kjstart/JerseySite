package com.alvin.study.jersey.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.spi.http.HttpContext;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.MvcFeature;
import org.glassfish.jersey.server.mvc.Viewable;

import com.alvin.study.jersey.bean.Person;

@Path("/")
public class JerseyTestController {

	public JerseyTestController() {
		new ResourceConfig().register(MvcFeature.class).property("jersey.config.server.mvc.templateBasepath",
				"templates");
	}

	@GET
	@Path("hello/{name}")
	public String hello(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@Context HttpContext hc, @PathParam("name") String name, @QueryParam("title") String title) {
		return "Hi, " + title + " " + name;
	}

	@POST
	@Path("json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Person json(Person person, @Context HttpServletRequest request, @Context HttpServletResponse response,
			@Context HttpContext hc) {
		return person;
	}

	@GET
	@Path("jsp_page")
//	@Produces(MediaType.TEXT_HTML)
	public Viewable jsppage(@Context HttpServletRequest request) {
		request.setAttribute("directAttr", "demo");
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("name", "test");
		return new Viewable("/test.jsp", data); 
	}
}
