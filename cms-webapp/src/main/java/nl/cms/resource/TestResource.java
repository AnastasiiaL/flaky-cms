package nl.cms.resource;

import static nl.cms.application.ApplicationEndpoints.TEST_URL;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import nl.cms.form.TestForm;
import nl.cms.service.TestService;

@ApplicationScoped
@Path(TEST_URL)
public class TestResource {

    private final TestService testService;

    public TestResource(TestService testService) {
        this.testService = testService;
    }

    @GET
    @Transactional
    @Produces(MediaType.TEXT_HTML)
    public Response getTests() {
        return Response.ok().type("text/html").build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postTest(@NotNull @Valid TestForm testForm) {

        testService.persist(TestForm.toDomain(testForm));
        return Response.ok().build();
    }
}
