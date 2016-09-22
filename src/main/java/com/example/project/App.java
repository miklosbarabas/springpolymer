package com.example.project;

/**
 * Created by Miklos barabas on 22/09/2016.
 */

import org.apache.coyote.http2.Http2Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // == @Configuration @EnableAutoConfiguration @ComponentScan
public class App {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(App.class);
        //app.setShowBanner(false);
        tomcatCustomizer();
        TomcatHTTP2.tomcatCustomizer();
        app.run(args);

    }

    @Bean
    public static EmbeddedServletContainerCustomizer tomcatCustomizer() {
        return (container) -> {
            if (container instanceof TomcatEmbeddedServletContainerFactory) {
                ((TomcatEmbeddedServletContainerFactory) container)
                        .addConnectorCustomizers((connector) -> connector.addUpgradeProtocol(new Http2Protocol()));
            }
        };
    }


}


