package esprit.tn.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
    @Bean
    public RouteLocator gatewayRoot(RouteLocatorBuilder builder ) {
        return builder.routes()
                .route("training",r->r.path("/trainings/**").uri("lb://TrainingMSProject"))
                .route("feedBack", r -> r.path("/FeedBacks/**").uri("lb://FeedBacks"))
                .route("sujetPfe" , r->r.path("/api/sujets/**").uri("lb://SujetPfe"))
                .route("formation", r -> r.path("/api/formations/**").uri("lb://EMicro"))
                .route("diplome", r -> r.path("/api/diplomes/**").uri("lb://EMicro"))
                .route("candidatures" , r->r.path("/candidatures/**").uri("lb://projetMicroService"))
                .route("event", r -> r.path("/events/**").uri("lb://EventMicro"))

                .build();

    }

}
