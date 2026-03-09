package org.javalord.myspringdocs.user.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateUserRequest {

    @Schema(example = "test@test.com")
    private String email;

    @Schema(example = "test123@")
    private String password;

    @Schema(example = "John")
    private String firstName;

    @Schema(example = "Doe")
    private String lastName;

}
