package com.sarat.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class  SpringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

		@Override
		protected Class<?>[] getRootConfigClasses() {
			return new Class[] { SpringWebMvcConfiguration.class };
		}
	 
		@Override
		protected Class<?>[] getServletConfigClasses() {
			return null;
		}
	 
		@Override
		protected String[] getServletMappings() {
			return new String[] { "/" };
		}

	


}
