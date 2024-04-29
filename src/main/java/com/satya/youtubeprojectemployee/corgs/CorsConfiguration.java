package com.satya.youtubeprojectemployee.corgs;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000") // Adjust as needed
            .allowedMethods("GET", "POST", "PUT", "DELETE") // Adjust as needed
            .allowedHeaders("*"); // Adjust as needed
    }
}

