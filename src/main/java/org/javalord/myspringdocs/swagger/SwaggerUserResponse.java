package org.javalord.myspringdocs.swagger;


import io.swagger.v3.oas.annotations.media.Schema;
import org.javalord.myspringdocs.util.Response;
import org.javalord.myspringdocs.user.dto.response.UserResponse;

@Schema(name = "SwaggerUserResponse")
public class SwaggerUserResponse extends Response<UserResponse> {
}
