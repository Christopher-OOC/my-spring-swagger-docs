package org.javalord.myspringdocs.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "My OpenAPI Docs",
                description = """
                                This is a sample Pet Store Server based on the OpenAPI 3.1 specification.
                             
                                You can find out more about Swagger here:
                                <a href="https://swagger.io" target="_blank">https://swagger.io</a>
                                
                                In the third iteration of the Pet Store, we've switched to a design-first approach.
                                You can help improve the API by making changes to the definition or contributing to the code.
                                
                                Some useful links:
                                
                                - [Pet Store Repository](https://github.com/swagger-api/swagger-petstore)
                                - [OpenAPI Definition](https://github.com/swagger-api/swagger-petstore/blob/master/src/main/resources/openapi.yaml)
                                """,
                termsOfService = "https://github.com/Christopher-OOC",
                contact = @Contact(
                        name = "Olojede Olamide",
                        email = "olojedechristopher24@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://apache.org"
                ),
                version = "1.0.0"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Local development server"
                )
        },
        tags = {
                @Tag(
                        name = "User",
                        description = "APIs for user endpoints"
                ),
                @Tag(
                        name = "Message",
                        description = "APIs for message endpoints"
                )
        }
)
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addResponses("Unauthorized", new ApiResponse().description("Unauthorized"))
                        .addResponses("Forbidden", new ApiResponse().description("Forbidden"))
                        .addResponses("NotFound", new ApiResponse().description("NotFound"))
                        .addResponses("Method not allowed", new ApiResponse().description("Method not allowed"))
                        .addResponses("InternalServerError", new ApiResponse().description("Internal Server Error"))
                );

    }


}
