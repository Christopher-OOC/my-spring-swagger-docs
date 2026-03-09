package org.javalord.myspringdocs.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.javalord.myspringdocs.user.dto.request.CreateUserRequest;
import org.javalord.myspringdocs.user.dto.response.Response;
import org.javalord.myspringdocs.user.dto.response.ResponseType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User", description = "User api info")
public class UserController {

    private final UserService userService;

    @Operation(
            summary = "Create new user",
            description = "Endpoint to create a new user"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "400",
                    description = "User created successfully",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = User.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content()
            )
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Response<String>> createUser(@RequestBody @Valid CreateUserRequest request) {
        userService.createUser(request);

        Response<String> response = new Response<>(
                ResponseType.SUCCESS,
                "User created successfully",
                "User created successfully"
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



}
