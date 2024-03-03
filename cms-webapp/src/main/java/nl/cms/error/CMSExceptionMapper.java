package nl.cms.error;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import io.quarkus.logging.Log;
import nl.cms.domain.exceptions.CMSException;
import nl.cms.view.ErrorMessage;

@Provider
public class CMSExceptionMapper implements ExceptionMapper<CMSException> {

    @Context
    HttpHeaders headers;

    @Override
    public Response toResponse(CMSException exception) {
        String cause = "CMS application error";
        Log.debug(cause, exception);

        if (headers.getAcceptableMediaTypes().contains(MediaType.TEXT_HTML_TYPE)) {
            return Response.status(Response.Status.OK).type(MediaType.TEXT_HTML_TYPE).build();
        } else {
            ErrorMessage error = ErrorMessage.of(exception.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(error).type(MediaType.APPLICATION_JSON_TYPE).build();
        }
    }
}
