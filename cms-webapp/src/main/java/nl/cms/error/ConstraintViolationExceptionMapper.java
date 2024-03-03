package nl.cms.error;

import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;

import java.util.List;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import io.quarkus.logging.Log;
import nl.cms.view.ErrorMessage;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Context
    HttpHeaders headers;

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        String cause = "Validation errors, please check your request";
        Log.debug(cause, exception);

        List<String> errors = exception.getConstraintViolations()
            .stream().map(ConstraintViolation::getMessage).toList();
        ErrorMessage error = ErrorMessage.of(cause, errors);

        if (headers.getAcceptableMediaTypes().contains(MediaType.TEXT_HTML_TYPE)) {
            return Response.ok().build();
        } else {
            return Response.status(BAD_REQUEST).entity(error).type(MediaType.APPLICATION_JSON_TYPE).build();
        }
    }
}
