package org.javalord.myspringdocs.user;

import org.javalord.myspringdocs.user.dto.request.CreateUserRequest;
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

}
