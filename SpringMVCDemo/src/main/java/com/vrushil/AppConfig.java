package com.vrushil;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({"com.vrushil","com.vrushil.service"})
public class AppConfig {
	
	// This is a configuration classs to make configuration using annotation
	@Bean
	
	public InternalResourceViewResolver viewResolver()
	
	{
		// Using InternalResourceViewResolver we can get rid of the front end file type. We can change the file by just changing the suffix over here
		InternalResourceViewResolver vr= new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/");
		vr.setSuffix(".jsp");
		return vr;
		
	}
}
