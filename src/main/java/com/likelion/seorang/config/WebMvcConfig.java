package com.likelion.seorang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해 CORS 설정 적용
                .allowedOrigins("http://localhost:3000") // 허용할 Origin 설정
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE", "HEAD") // 허용할 HTTP 메서드 설정
                .allowedHeaders("*"); // 허용할 요청 헤더 설정
//                .allowCredentials(true); // 인증 정보 허용 여부
    }
}
