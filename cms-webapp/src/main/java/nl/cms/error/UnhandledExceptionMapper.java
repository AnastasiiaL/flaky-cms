package nl.cms.error;

import static jakarta.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import io.quarkus.logging.Log;
import nl.cms.view.ErrorMessage;

@Provider
public class UnhandledExceptionMapper implements ExceptionMapper<Exception> {

    @Context
    HttpHeaders headers;

    @Override
    public Response toResponse(Exception exception) {
        String cause = "Internal Server Error";
        Log.error(cause, exception);

        Response.ResponseBuilder response = Response.status(INTERNAL_SERVER_ERROR);
        if (headers.getAcceptableMediaTypes().contains(MediaType.TEXT_HTML_TYPE)) {
            return response.type(MediaType.TEXT_HTML_TYPE).build();
        } else {
            ErrorMessage error = ErrorMessage.of(cause);
            return response.entity(error).type(MediaType.APPLICATION_JSON_TYPE).build();
        }
    }
}
