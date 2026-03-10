package org.javalord.myspringdocs.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.javalord.myspringdocs.auth.request.AuthRequest;
import org.javalord.myspringdocs.auth.response.AuthResponse;
import org.javalord.myspringdocs.util.Response;
import org.javalord.myspringdocs.util.ResponseType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Endpoints for auth requests")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Login with email and password", description = "Login endpoint")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid username or password",
                    ref = "#/components/responses/BadRequest"
            )
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  login(@Valid @RequestBody AuthRequest request) {
        AuthResponse login = authService.login(request);

        Response<AuthResponse> response = new Response<>(
                ResponseType.SUCCESS,
                "Logged in successfully",
                login
        );

        return ResponseEntity.ok(response);
    }
}
