package org.javalord.myspringdocs.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Endpoints for auth requests")
public class AuthController {

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
    public ResponseEntity<?>  login() {


        return ResponseEntity.ok().build();
    }


}
