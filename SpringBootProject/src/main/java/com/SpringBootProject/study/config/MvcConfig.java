package com.SpringBootProject.study.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter  {
	
	@Override
	public void configureHandlerExceptionResolvers(
			List<HandlerExceptionResolver> exceptionResolvers) {
		super.configureHandlerExceptionResolvers(exceptionResolvers);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new ProjectInterceptor());
	}
	
	
	@Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }
 
    @Override
    public void configureMessageConverters(
    		List<HttpMessageConverter<?>> converters) {
    	super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }
 
    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/login").setViewName("login");
    	registry.addViewController("/loginFailed").setViewName("exceptionPage/loginError");
    	registry.addViewController("/pageNotFound").setViewName("exceptionPage/pageNotFound");
    	registry.addViewController("/pageNoAccess").setViewName("exceptionPage/page403");
    	registry.addViewController("/pageInnerException").setViewName("exceptionPage/page500");
    }
	
	
}
