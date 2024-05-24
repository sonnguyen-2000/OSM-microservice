package com.codegym.cglmsapigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ApiGatewayConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("cg-lms-user-service", r -> r.path("/api/users/**")
                        .uri("lb://cg-lms-user-service"))
                .route("cg-lms-auth-service", r-> r.path("/api/auth/**")
                        .uri("lb://cg-lms-auth-service"))
                .route("cg-lms-order-service", r-> r.path("/api/orders/**")
                        .uri("lb://cg-lms-order-service"))
                .route("cg-lms-order-item-service", r-> r.path("/api/order-items/**")
                        .uri("lb://cg-lms-order-item-service"))
                .route("cg-lms-product-service", r-> r.path("/api/products/**")
                        .uri("lb://cg-lms-products-service"))
                .build();
    }
}
