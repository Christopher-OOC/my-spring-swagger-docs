package org.javalord.myspringdocs.auth.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javalord.myspringdocs.auth.AuthService;
import org.javalord.myspringdocs.auth.request.AuthRequest;
import org.javalord.myspringdocs.auth.response.AuthResponse;
import org.javalord.myspringdocs.exception.BusinessException;
import org.javalord.myspringdocs.user.User;
import org.javalord.myspringdocs.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BusinessException("USER_NOT_FOUND"));

        return null;
    }
}
