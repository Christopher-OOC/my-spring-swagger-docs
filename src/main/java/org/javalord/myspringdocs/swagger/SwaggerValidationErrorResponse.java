package org.javalord.myspringdocs.swagger;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;
import org.javalord.myspringdocs.util.Response;
import org.javalord.myspringdocs.util.ResponseType;
import org.javalord.myspringdocs.util.ValidationError;

import java.util.List;

@Schema(name = "SwaggerValidationErrorResponse")
@NoArgsConstructor
public class SwaggerValidationErrorResponse extends Response<List<ValidationError>> {

    public SwaggerValidationErrorResponse(ResponseType responseType, String jhshkdjk, List<ValidationError> of) {
        super(responseType, jhshkdjk, of);
    }
}
