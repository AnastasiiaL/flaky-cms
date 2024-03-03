package nl.cms.error;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import nl.cms.domain.exceptions.CMSException;

@Path("/exception-mapper")
@Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
@ApplicationScoped
public class CMSExceptionResource {

    @GET
    @Path("/cms-exception")
    public Response cmsException() {
        throw new CMSException("Example message");
    }
}
