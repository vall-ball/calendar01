package ru.vallball.calendar01.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

public class SecurityWebApplicationInitializer  extends AbstractSecurityWebApplicationInitializer {

	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
		System.out.print(" beforeSpringSecurityFilterChai");
	    FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
	    characterEncodingFilter.setInitParameter("encoding", "UTF-8");
	    characterEncodingFilter.setInitParameter("forceEncoding", "true");
	    characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
	    }
}
