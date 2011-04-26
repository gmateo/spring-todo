/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cloudfoundry.runtime.env.ApplicationInstanceInfo;
import org.cloudfoundry.runtime.env.CloudEnvironment;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.ConfigurableWebApplicationContext;

/**
 * Initializer class invoked by Spring framework when the web app initializes.
 * This class checks to see if a Cloud Environment is available and sets the
 * application profiles (default or cloud) as appropriate. These profiles define
 * the dataSource for local or cloud deployments.
 * 
 * @author david@davidsalter.co.uk
 * 
 */
public class Initializer implements
		ApplicationContextInitializer<ConfigurableWebApplicationContext> {

	protected final Log logger = LogFactory.getLog(getClass());

	public void initialize(ConfigurableWebApplicationContext ctx) {
		ConfigurableEnvironment environment = ctx.getEnvironment();

		ApplicationInstanceInfo instanceInfo = new CloudEnvironment()
				.getInstanceInfo();
		if (instanceInfo == null) {
			// We are running locally.
			logger.info("Setting default profile.");
			environment.setActiveProfiles("default");
		} else {
			// We are running in the cloud.
			logger.info("Setting cloud profile.");
			environment.setActiveProfiles("cloud");
		}
	}
}
