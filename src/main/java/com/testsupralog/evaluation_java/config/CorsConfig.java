package com.testsupralog.evaluation_java.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Autorise toutes les origines
        config.addAllowedMethod("*"); // Autorise toutes les méthodes HTTP (GET, POST, etc.)
        config.addAllowedHeader("*"); // Autorise tous les en-têtes
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}