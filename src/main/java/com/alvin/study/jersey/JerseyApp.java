package com.alvin.study.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.MvcFeature;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import com.alvin.study.jersey.controller.JerseyTestController;

public class JerseyApp extends ResourceConfig {
	public JerseyApp(){
		register(JerseyTestController.class);
		register(JspMvcFeature.class);
		//should have the /
		property(JspMvcFeature.TEMPLATE_BASE_PATH,"/jsp");
	}
}
