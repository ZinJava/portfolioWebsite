package zinjava.madisonportfolio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("portfolio");
		registry.addViewController("/portfolio").setViewName("portfolio");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/contact").setViewName("contact");
	}
}
