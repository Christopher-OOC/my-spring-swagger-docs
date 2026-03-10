package org.javalord.myspringdocs.user;

import org.javalord.myspringdocs.user.dto.request.CreateUserRequest;
import org.javalord.myspringdocs.user.dto.response.UserResponse;

public interface UserService {


    void createUser(CreateUserRequest request);

    UserResponse findById(long userId);
}
