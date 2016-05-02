package com.ibm.smart.pluggable.root.config;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.ibm.smart.pluggable.servlet.config.CSOBBPMServletConfig;

/**
 * Replacement of web.xml. The class has to directly implement WebApplicationInitializer due the bug in weblogic
 * @author Martin Vanek
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebAppConfig extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { CSOBBPMServiceConfig.class };
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { CSOBBPMServletConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		 return new String[]{"/"};
	}
	
	@Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
	    registration.setInitParameter("dispatchOptionsRequest", "true");
	}

	@Override
	protected Filter[] getServletFilters() {
	    CharacterEncodingFilter charFilter = new CharacterEncodingFilter();
	    charFilter.setEncoding("UTF-8");
	    charFilter.setForceEncoding(true);
	    return new Filter[] { new HiddenHttpMethodFilter(), charFilter,
	        new HttpPutFormContentFilter() };
	}

}
