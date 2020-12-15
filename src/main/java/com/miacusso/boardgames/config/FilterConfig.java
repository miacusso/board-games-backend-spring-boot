package com.miacusso.boardgames.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.miacusso.boardgames.filters.LowerCaseFilter;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<LowerCaseFilter> registrationBean() {
		FilterRegistrationBean<LowerCaseFilter> filterRegistrationBean = new FilterRegistrationBean<LowerCaseFilter>();
		filterRegistrationBean.setFilter(new LowerCaseFilter());
		//filterRegistrationBean.addUrlPatterns("^/[0-9]/players$", "^/[0-9]/result-table$");
		return filterRegistrationBean;
	}

}
