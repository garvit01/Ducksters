package com.atd.duckstersService;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.atd.duckstersService.filter.AesFilter;
import com.atd.duckstersService.filter.JwtFilter;
import com.atd.duckstersService.service.RequestLogService;

@SpringBootApplication(scanBasePackages = { "com.atd.duckstersService" })
public class DuckstersServiceApplication {

	// @Bean
	// public FilterRegistrationBean<Filter> jwtFilter() {
	// final FilterRegistrationBean<Filter> registrationBean = new
	// FilterRegistrationBean<>();
	// registrationBean.setFilter(new JwtFilter());
	// registrationBean.addUrlPatterns("/api/*");
	//
	// return registrationBean;
	// }

	@Autowired
	private RequestLogService requestLogService;

	@Bean
	public FilterRegistrationBean<Filter> aesFilter() {
		final FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new AesFilter(requestLogService));
		registrationBean.addUrlPatterns("/api/*");

		return registrationBean;
	}

	public static void main(String args[]) {
		SpringApplication.run(DuckstersServiceApplication.class, args);
	}

}
