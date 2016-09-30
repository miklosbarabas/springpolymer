package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;

/**
 * Created by barabasm on 30/09/2016.
 */
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
				.addResourceHandler("/**")
				.addResourceLocations("/resources/static/","classpath:/static/")
		//		.setCachePeriod(3600)
				.resourceChain(true)
				.addResolver(new PathResourceResolver());

		registry
				.addResourceHandler("/bower_components/**")
				.addResourceLocations("/resources/static/bower_components/","classpath:/static/bower_components/")
				//		.setCachePeriod(3600)
				.resourceChain(true)
				.addResolver(new PathResourceResolver());

	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("http://localhost:8080")
				.allowedMethods("GET", "PUT", "DELETE")
				.allowedHeaders("header1", "header2", "header3")
				.exposedHeaders("header1", "header2")
				.allowCredentials(false).maxAge(3600);
	}
}
