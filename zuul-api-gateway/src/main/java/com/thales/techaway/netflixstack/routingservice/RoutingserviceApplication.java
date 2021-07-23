package com.thales.techaway.netflixstack.routingservice;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;


@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class RoutingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutingserviceApplication.class, args);
	}

	private static Logger log = LoggerFactory.getLogger(RoutingserviceApplication.class);

	@Bean
	public ZuulFilter filter(){
		return new ZuulFilter(){
			@Override
			public String filterType() {
				return PRE_TYPE;
			}
			@Override
			public int filterOrder() {
				return DEBUG_FILTER_ORDER;
			}
			@Override
			public boolean shouldFilter() {
				return true;
			}
			@Override
			public Object run() {
				RequestContext context = RequestContext.getCurrentContext();
				HttpServletRequest request = context.getRequest();
				log.info(String.format("Zuul API gateway: %s request to %s",request.getMethod(),request.getRequestURL().toString()));
				return null;
			}
		};
	}
}
