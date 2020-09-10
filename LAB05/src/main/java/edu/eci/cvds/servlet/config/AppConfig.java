package edu.eci.cvds.servlet.config;

import lodsve.web.webservice.EnableWebService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * .
 *
 * @author Leonardo y Camilo
 */
@Configuration
@EnableWebService
@ComponentScan(value = {"edu.eci.cvds.servlet.service"})
@ImportResource({"classpath*:/META-INF/spring/*.xml"})
public class AppConfig {

}