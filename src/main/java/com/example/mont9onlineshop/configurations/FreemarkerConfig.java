package com.example.mont9onlineshop.configurations;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
;

import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
public class FreemarkerConfig{
    @Bean
    public ResourceBundle bundle() {
        return ResourceBundle.getBundle("messages");
    }
}
