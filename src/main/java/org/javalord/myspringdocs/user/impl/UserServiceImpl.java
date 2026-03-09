package org.javalord.myspringdocs.user.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javalord.myspringdocs.user.User;
import org.javalord.myspringdocs.user.UserMapper;
import org.javalord.myspringdocs.user.UserRepository;
import org.javalord.myspringdocs.user.UserService;
import org.javalord.myspringdocs.user.dto.request.CreateUserRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void createUser(CreateUserRequest request) {
        User user = userMapper.createRequestToUser(request);
        // todo encrypt password
        user.setPassword(request.getPassword());

        User saved = userRepository.save(user);
        log.info("Created user {}", saved);
    }
}
