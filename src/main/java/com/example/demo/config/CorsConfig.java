package com.example.demo.config;

import com.example.demo.utility.PropertyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class CorsConfig implements WebMvcConfigurer {

    final private PropertyUtil propertyUtil;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        final String ALLOWED_ORIGINS = propertyUtil.getProperty("allowed_origins");

        registry.addMapping("/**")
                .allowedOrigins(ALLOWED_ORIGINS)
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
