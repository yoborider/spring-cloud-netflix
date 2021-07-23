package com.thales.techaway.netflixstack.apigateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class CustomGlobalFilter implements GlobalFilter, Ordered {
    private static Logger log = LoggerFactory.getLogger(CustomGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // Cf §16.6 Ref Doc Spring Cloud Gateway
        log.info(String.format("custom global filter",exchange.getRequest().getMethod()));
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
