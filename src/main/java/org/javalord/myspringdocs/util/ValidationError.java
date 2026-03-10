package org.javalord.myspringdocs.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(name = "ValidationError")
@NoArgsConstructor
public class ValidationError {

    @Schema(example = "property field", description = "field")
    private String field;

    @Schema(example = "error description", description = "error message")
    private String message;

    public ValidationError(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
