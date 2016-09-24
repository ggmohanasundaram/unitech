package org.com.unitech.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by MohanDivya on 9/24/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.com.unitech")
public class ApplicationConfig {
}
