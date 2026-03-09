package org.javalord.myspringdocs.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "My open api docs",
        description = "This is my open api docs test i really like it so much.",
        termsOfService = "https://github.com/Christopher-OOC",
        contact = @Contact(email = "olojedechristopher24@gmail.com", name = "Olojede Olamide")
))
public class OpenApiConfig {



}
