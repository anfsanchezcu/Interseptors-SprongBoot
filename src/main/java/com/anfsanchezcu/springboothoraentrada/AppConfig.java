package com.anfsanchezcu.springboothoraentrada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class AppConfig implements WebMvcConfigurer{

  @Autowired
  @Qualifier("calendarInterseptor")
  private HandlerInterceptor calendarInterseptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(calendarInterseptor).addPathPatterns("/foo");
  }
  
}
