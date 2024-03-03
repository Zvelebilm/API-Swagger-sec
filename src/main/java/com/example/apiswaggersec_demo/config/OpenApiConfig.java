package com.example.apiswaggersec_demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Marek Zvelebil",
                        email = "marek.zvelebil@gmail.com",
                        url = "https://github.com/Zvelebilm"
                ),
                description = "API documentation",
                title = "API",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local server",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApiConfig {
}
