package com.vrushil;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer{
/* This is an initializer class where we need to extend  AbstractAnnotationConfigDispatcherServletInitializer 
 and implement the abstract methods.  getServletMappings is used how to map a url
 
 getServletConfigclass  will have to return the config class. Here the config file is appconfig
*/
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {AppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
