package com.example.memos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.memos.platform.logging.LoggingHttpRequestInterceptor;


@SpringBootApplication
public class MemosApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(MemosApplication.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods(HttpMethod.GET.name(), 
												  HttpMethod.PUT.name(),
												  HttpMethod.DELETE.name(),
												  HttpMethod.POST.name(),
												  HttpMethod.OPTIONS.name())
								.allowedOrigins("*")
								.allowCredentials(true);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {		
		registry.addInterceptor(new LoggingHttpRequestInterceptor());
	}

}

