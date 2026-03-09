package org.javalord.myspringdocs.user.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserRequest {

    @NotNull(message = "Cannot be null")
    @Schema(example = "test@test.com")
    private String email;

    @NotNull(message = "Cannot be null")
    @Schema(example = "test123@")
    private String password;

    @NotNull(message = "Cannot be null")
    @Schema(example = "John")
    private String firstName;

    @NotNull(message = "Cannot be null")
    @Schema(example = "Doe")
    private String lastName;

}
