package spittr.config;

import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import application.servlet.SetCodingFilter;

public class SpitterWebInitializer extends 
AbstractAnnotationConfigDispatcherServletInitializer
implements
WebApplicationInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
/*		CharacterEncodingFilter myEncodingFilter=new CharacterEncodingFilter();
		myEncodingFilter.setEncoding(String.valueOf(StandardCharsets.UTF_8));*/		
		return new Filter[] {new SetCodingFilter()};
	}

}
