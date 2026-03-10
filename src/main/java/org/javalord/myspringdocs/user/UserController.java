package org.javalord.myspringdocs.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.javalord.myspringdocs.swagger.SwaggerUserResponse;
import org.javalord.myspringdocs.swagger.SwaggerValidationErrorResponse;
import org.javalord.myspringdocs.user.dto.request.CreateUserRequest;
import org.javalord.myspringdocs.util.Response;
import org.javalord.myspringdocs.util.ResponseType;
import org.javalord.myspringdocs.user.dto.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
                    description = "Bad request",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SwaggerValidationErrorResponse.class)
                    ))
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<String>> createUser(@Valid @RequestBody CreateUserRequest request) {
        userService.createUser(request);

        Response<String> response = new Response<>(
                ResponseType.SUCCESS,
                "User created successfully",
                "User created successfully"
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Get user by ID", description = "Get user by ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get user by ID",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SwaggerUserResponse.class)
                    )
            ),
            @ApiResponse(responseCode = "404", ref = "#/components/responses/NotFound"),
            @ApiResponse(responseCode = "401", ref = "#/components/responses/Unauthorized"),
            @ApiResponse(responseCode = "403", ref = "#/components/responses/Forbidden")
    })
    @GetMapping(value = "/{userId}")
    public ResponseEntity<Response<UserResponse>> getUser(@PathVariable long userId) {
        UserResponse user = userService.findById(userId);

        Response<UserResponse> response = new Response<>(
                ResponseType.SUCCESS,
                "User info retrieved successfully",
                user
        );

        return ResponseEntity.ok(response);
    }
}
