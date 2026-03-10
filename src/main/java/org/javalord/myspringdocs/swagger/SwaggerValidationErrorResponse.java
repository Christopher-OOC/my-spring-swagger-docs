package org.javalord.myspringdocs.swagger;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javalord.myspringdocs.util.ResponseType;
import org.javalord.myspringdocs.util.ValidationError;

import java.time.LocalDateTime;
import java.util.List;

@Schema(name = "SwaggerValidationErrorResponse")
@NoArgsConstructor
@Data
public class SwaggerValidationErrorResponse {

    @Schema(example = "ERROR")
    private ResponseType status;

    @Schema(example = "Operation could not complete")
    private String message;

    private List<ValidationError> data;

    private LocalDateTime timestamp;


    public SwaggerValidationErrorResponse(ResponseType status, String message, List<ValidationError> data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }
}