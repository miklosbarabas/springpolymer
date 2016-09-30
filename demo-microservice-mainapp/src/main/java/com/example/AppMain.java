package com.example;

/**
 * Created by Miklos Barabas on 22/09/2016.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // == @Configuration @EnableAutoConfiguration @ComponentScan
public class AppMain {


    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(AppMain.class);
//        TomcatHTTP2.tomcatCustomizer();
        app.run(args);

    }

//    @Bean
//    public EmbeddedServletContainerCustomizer jettyHttp2Customizer(ServerProperties serverProperties) {
//        return new JettyHttp2Customizer(serverProperties);
//    }

//    @Bean
//    public FilterRegistrationBean pushCacheFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new PushCacheFilter());
//        return registration;
//    }


}


