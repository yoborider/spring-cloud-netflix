package com.thales.techaway.netflixstack.apigateway;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public GlobalFilter customFilter(){
        return new CustomGlobalFilter();
    }
}
