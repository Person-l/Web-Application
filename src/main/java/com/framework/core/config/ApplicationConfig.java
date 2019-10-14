package com.framework.core.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletProperties;

import com.framework.core.config.filters.AuthenticationFilter;

@ApplicationPath("/api")
public class ApplicationConfig extends ResourceConfig {
	public ApplicationConfig() {
		packages("com.framework.core.services");
		/* filters */
		register(AuthenticationFilter.class);
		property(ServerProperties.TRACING, "ALL");
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}
}
