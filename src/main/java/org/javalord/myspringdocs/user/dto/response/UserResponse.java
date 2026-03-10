package org.javalord.myspringdocs.user.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "UserResponse")
public class UserResponse {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "test@test.com")
    private String email;

    @Schema(example = "test123@")
    private String password;

    @Schema(example = "John")
    private String firstName;

    @Schema(example = "Doe")
    private String lastName;
}
