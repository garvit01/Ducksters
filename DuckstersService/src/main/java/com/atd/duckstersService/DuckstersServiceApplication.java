package com.atd.duckstersService;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.atd.duckstersService"}) 
public class DuckstersServiceApplication {

//	@Bean
//	public FilterRegistrationBean<Filter> jwtFilter() {
//		final FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
//		registrationBean.setFilter(new JwtFilter());
//		registrationBean.addUrlPatterns("/api/*");
//
//		return registrationBean;
//	}
	

	public static void main(String args[]) {
		SpringApplication.run(DuckstersServiceApplication.class, args);
	}

}
