package com.atd.duckstersauthentication;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.atd.duckstersauthentication.filter.AesFilter;

@SpringBootApplication
public class DuckstersauthenticationApplication {

	@Bean
	public FilterRegistrationBean<Filter> aesFilter() {
		final FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new AesFilter());
		registrationBean.addUrlPatterns("/api/*");

		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(DuckstersauthenticationApplication.class, args);
	}

}
