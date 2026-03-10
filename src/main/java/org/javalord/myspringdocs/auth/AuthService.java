package org.javalord.myspringdocs.auth;

import org.javalord.myspringdocs.auth.request.AuthRequest;
import org.javalord.myspringdocs.auth.response.AuthResponse;

public interface AuthService {

    AuthResponse login(AuthRequest request);

}
