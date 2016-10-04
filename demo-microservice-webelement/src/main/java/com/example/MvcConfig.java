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

    private static final String[] RESOURCE_LOCATIONS = { "/static/", "classpath:/static/" };

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
				.addResourceHandler("/**")
				.addResourceLocations(RESOURCE_LOCATIONS)
		//		.setCachePeriod(3600)
				.resourceChain(true)
				.addResolver(new PathResourceResolver());

	}

	/* THIS IS UNNECESSARY, IF USING ZUUL PROXY */
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//				.allowedOrigins("http://localhost:8080")
//				.allowedMethods("GET", "PUT", "DELETE")
//				.allowedHeaders("header1", "header2", "header3")
//				.exposedHeaders("header1", "header2")
//				.allowCredentials(false).maxAge(3600);
//	}
}
