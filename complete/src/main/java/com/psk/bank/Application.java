package com.psk.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"hello", "com.psk.bank"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
      return (container -> {
           //route all errors towards /error .
           final ErrorPage errorPage=new ErrorPage("/error");
           container.addErrorPages(errorPage);
      });
   }

}
