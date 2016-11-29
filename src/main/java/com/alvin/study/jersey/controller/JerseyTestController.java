package com.alvin.study.jersey.controller;

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

import com.alvin.study.jersey.bean.Person;

@Path("api")
public class JerseyTestController {
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
}
