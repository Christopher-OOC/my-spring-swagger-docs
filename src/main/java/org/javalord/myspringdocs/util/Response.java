package org.javalord.myspringdocs.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "Response")
public class Response<T> {

    @Schema(defaultValue = "SUCCESS", allowableValues = {"SUCCESS", "ERROR"})
    protected ResponseType status;

    @Schema(example = "Operation successful")
    protected String message;

    protected T data;

    protected LocalDateTime timestamp;

    protected Response() {

    }

    public Response(ResponseType status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }
}
