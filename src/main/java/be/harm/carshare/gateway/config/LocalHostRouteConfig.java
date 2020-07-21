package be.harm.carshare.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalHostRouteConfig {

    @Bean
    public RouteLocator localRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/cars/**")
                        .uri("lb://carshare-carsservice")
                        .id("cars-service"))
                .route(r -> r.path("/reservations/**")
                        .uri("lb://carshare-reservationsservice")
                        .id("reservations-service"))
                .route(r -> r.path("/users/**")
                        .uri("lb://carshare-usersservice")
                        .id("users-service"))
                .build();
    }
}

