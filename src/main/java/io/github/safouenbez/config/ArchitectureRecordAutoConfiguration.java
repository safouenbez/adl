package io.github.safouenbez.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import io.github.safouenbez.resource.ArchiRecordResource;
import io.github.safouenbez.service.ArchitectureDRService;

@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties(ArchitectureRecordProperties.class)
public class ArchitectureRecordAutoConfiguration {
	
	/*
	 * @ConditionalOnProperty(name = { "packages" }, prefix = "project.adr")
	 * 
	 * @Profile({ "default","local", "dev", "rci" })
	 */

	@Bean()
	public ArchiRecordResource arRecordResource() {
		return new ArchiRecordResource();
	}
	
	/*
	 * @ConditionalOnMissingBean
	 * 
	 * @ConditionalOnProperty(name = { "packages" }, prefix = "project.adr")
	 */

	@Bean
	public ArchitectureDRService drService() {
		return new ArchitectureDRService();
	}

}
