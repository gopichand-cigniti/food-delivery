package com.birdSong.cloudgateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gateWayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/login/**")
                        .uri("lb://login-service"))
                .route(r -> r.path("/common/**")
                        .uri("lb://common-service"))
                .route(r -> r.path("/academic/**")
                        .uri("lb://academic-service"))
                .route(r -> r.path("/att/**")
                        .uri("lb://attendance-service"))
                .route(r -> r.path("/finance/**")
                        .uri("lb://finance-service"))
                .route(r -> r.path("/students/**")
                        .uri("lb://students-service"))
                 .build();
    }
}
