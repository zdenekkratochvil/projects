package com.ibm.smart.pluggable.servlet.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Main configuration class for smart plugin
 * 
 * @author Zdenek Kratochvil
 *
 */
@EnableWebMvc
@Configuration
@PropertySource({"classpath:csob-bpm-components.properties", "classpath:application.properties"})
@ComponentScan(basePackages = {"cz.csob.bpm.components.fes"})
public class CSOBBPMServletConfig {

}
