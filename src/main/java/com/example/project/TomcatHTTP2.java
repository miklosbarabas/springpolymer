package com.example.project;

import org.apache.coyote.http2.Http2Protocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by barabasm on 22/09/2016.
 */
@Component
@ComponentScan
public class TomcatHTTP2 {

	public static EmbeddedServletContainerCustomizer tomcatCustomizer() {
		return (container) -> {
			if (container instanceof TomcatEmbeddedServletContainerFactory) {
				((TomcatEmbeddedServletContainerFactory) container)
						.addConnectorCustomizers((connector) -> connector.addUpgradeProtocol(new Http2Protocol()));
			}
		};
	}

}
