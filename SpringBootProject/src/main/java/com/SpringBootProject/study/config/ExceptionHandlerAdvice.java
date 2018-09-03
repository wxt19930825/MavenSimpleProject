package com.SpringBootProject.study.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ModelAndView exception(Exception exception, WebRequest request) {

		ModelAndView modelAndView = new ModelAndView("exceptionPage/page500");
		modelAndView.addObject("errorMessage", exception.getMessage());
		return modelAndView;
	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("msg", "额外信息");
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("id");
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {

			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {

				container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
						"/pageNotFound"));

				container
						.addErrorPages(new ErrorPage(
								HttpStatus.INTERNAL_SERVER_ERROR,
								"/pageInnerException"));

				container.addErrorPages(new ErrorPage(
						java.lang.Throwable.class, "/pageInnerException"));

				container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN,
						"/pageNoAccess"));
				
			}
		};
	}

}
