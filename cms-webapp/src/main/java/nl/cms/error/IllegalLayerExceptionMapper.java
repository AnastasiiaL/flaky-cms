package nl.cms.error;

import static jakarta.ws.rs.core.Response.Status.NOT_FOUND;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import io.quarkus.logging.Log;
import nl.cms.domain.exceptions.IllegalLayerException;

@Provider
public class IllegalLayerExceptionMapper implements ExceptionMapper<IllegalLayerException> {

    @Context
    HttpHeaders headers;

    @Override
    public Response toResponse(IllegalLayerException exception) {
        Log.debug("Failed to retrieve layer", exception);
        Response.ResponseBuilder response = Response.status(NOT_FOUND);
        if (headers.getAcceptableMediaTypes().contains(MediaType.TEXT_HTML_TYPE)) {
            return response.type(MediaType.TEXT_HTML_TYPE).build();
        } else {
            return response.type(MediaType.APPLICATION_JSON_TYPE).build();
        }
    }
}
