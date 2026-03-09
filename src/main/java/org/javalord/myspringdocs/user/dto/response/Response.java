package org.javalord.myspringdocs.user.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Response<T> {

    @Schema(defaultValue = "SUCCESS", allowableValues = {"SUCCESS", "ERROR"})
    private ResponseType status;

    @Schema(example = "Operation successful")
    private String message;

    private T data;

    private LocalDateTime timestamp;

    protected Response() {

    }

    public Response(ResponseType status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }
}
