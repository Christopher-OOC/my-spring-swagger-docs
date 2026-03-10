package org.javalord.myspringdocs.auth.response;

import lombok.Data;

@Data
public class AuthResponse {

    private String accessToken;
    private String refreshToken;
    private String tokenType;

}
