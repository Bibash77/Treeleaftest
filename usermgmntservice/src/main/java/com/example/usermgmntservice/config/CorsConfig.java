package com.example.usermgmntservice.config;

import com.memo.config.NoteWebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.server.WebFilter;

@Configuration
@Slf4j
public class CorsConfig {


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOriginPattern("*"); // Allow all origins (use specific origins in production)
        corsConfig.addAllowedMethod("*");       // Allow all HTTP methods
        corsConfig.addAllowedHeader("*");       // Allow all headers
        corsConfig.setAllowCredentials(true);   // Allow credentials (cookies, authorization headers)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig); // Apply CORS configuration to all endpoints
        return source;
    }


    @Bean
    public WebFilter noteWebFilter() {
        return new NoteWebFilter();
    }

}