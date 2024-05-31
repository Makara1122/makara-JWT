package com.example.makarajwt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@OpenAPIDefinition(
        info = @Info(
                title = "Makara Do the Thing that he love.",
                version = "1.0",
                description = "Makara 2024",
                contact = @Contact(
                        name = "Makara",
                        email = "Makara@gmail.com"

                ),
                termsOfService = "http://swagger.io/terms/",
                license = @io.swagger.v3.oas.annotations.info.License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),
        security = @SecurityRequirement(name = "bearerAuth")
)

@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)


@EnableElasticsearchRepositories(basePackages = "com.example.makarajwt.feature.elastic")
@EnableJpaRepositories(basePackages =
        {"com.example.makarajwt.feature.user",
         "com.example.makarajwt.feature.role",
         "com.example.makarajwt.feature.authority",
         "com.example.makarajwt.feature.author",
         "com.example.makarajwt.feature.content",})



public class MakaraJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(MakaraJwtApplication.class, args);
    }

}
