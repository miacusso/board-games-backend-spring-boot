package com.miacusso.boardgames.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.miacusso.boardgames.interceptors.LoggerInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(new LoggerInterceptor())
			.addPathPatterns("/{game}/players", "/{game}/result-table", "/{game}/winner", "/{game}/delete-result-table");
	}

}
