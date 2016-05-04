package com.ibm.smart.pluggable.root.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import cz.csob.bpm.components.service.rest.UriComponentsUtils;

/**
 * Main configuration class for smart plugin
 * 
 * @author Zdenek Kratochvil
 *
 */
@Configuration
@PropertySource({"classpath:csob-bpm-components.properties", "classpath:application.properties"})
@ComponentScan(basePackages = {"cz.csob.bpm.components.service"})
public class CSOBBPMServiceConfig {

	@Value("${bpm.url}") private String backendUrl;
	@Value("${csob.bpm.service.url}") private String csobBpmServiceUrl;
	
	@Bean
	public UriComponentsUtils createUriComponentsUtils() {
		UriComponentsUtils utils = new UriComponentsUtils();
		utils.setBackendUrl(backendUrl);
		utils.setBackendUrl(csobBpmServiceUrl);
		return utils;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
