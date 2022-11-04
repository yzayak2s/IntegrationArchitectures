package de.hbrs.ia;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi salesmenApi() {
        return GroupedOpenApi.builder()
                .group("springshop-salesmen")
                .pathsToMatch("/salesmen/**")
                .build();
    }
}
