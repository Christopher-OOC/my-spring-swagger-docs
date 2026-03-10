package org.javalord.myspringdocs.user;

import org.javalord.myspringdocs.user.dto.request.CreateUserRequest;
import org.javalord.myspringdocs.user.dto.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User createRequestToUser(CreateUserRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());

        return user;
    }

    public UserResponse mapUserToResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());

        return userResponse;
    }
}
