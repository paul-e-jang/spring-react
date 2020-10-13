package bashpound.marketplace.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
//  postman yark 등 사용시 접근 불가처리되므로 주석처리 중.
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//        .allowedMethods("HEAD","GET","POST","PUT","DELETE","PATCH","OPTIONS")
//        .allowedOrigins("http://127.0.0.1:3000")
//        .allowedOrigins("http://localhost:3000")
//        .allowedOrigins("http://127.0.0.1:8090")
//        .allowedOrigins("http://localhost:8090");
//	}
}
