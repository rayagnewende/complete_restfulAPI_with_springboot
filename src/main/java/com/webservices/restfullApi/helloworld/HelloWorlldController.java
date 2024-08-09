package com.webservices.restfullApi.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorlldController {
	
	private MessageSource messageSource ; 
	

	public HelloWorlldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}




	@GetMapping("/test")
	public String internationalisation(){
		
		
		Locale  locale = LocaleContextHolder.getLocale(); 
		
		return messageSource.getMessage("good.morning", null, "Default Message", locale ); 
	}
	 
	

}
