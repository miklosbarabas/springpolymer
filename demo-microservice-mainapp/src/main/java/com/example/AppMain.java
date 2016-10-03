package com.example;

/**
 * Created by Miklos Barabas on 22/09/2016.
 */

import org.apache.curator.test.TestingServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class AppMain {

    @Bean
    TestingServer testingServer() throws Exception {
        return new TestingServer(2181);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(AppMain.class);
        app.run(args);
    }

    /* UNCOMMENT THE CODE ABOVE & JettyHttp2Customizer TO ENABLE HTTP2 */
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


