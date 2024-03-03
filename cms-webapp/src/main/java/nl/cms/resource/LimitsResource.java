package nl.cms.resource;

import static nl.cms.application.ApplicationEndpoints.LIMITS_URL;

import java.time.LocalDate;
import java.time.ZoneId;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import nl.cms.form.LimitsForm;
import nl.cms.service.LimitsService;

@ApplicationScoped
@Path(LIMITS_URL)
public class LimitsResource {

    private final LimitsService limitsService;

    public LimitsResource(LimitsService limitsService) {
        this.limitsService = limitsService;
    }

    @GET
    @Transactional
    @Produces(MediaType.TEXT_HTML)
    public Response getLimits() {
        LocalDate effective = LocalDate.now(ZoneId.of("Europe/Amsterdam"));
        limitsService.findByEffectiveMonth(effective);

        return Response.ok().type("text/html").build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(@NotNull @Valid LimitsForm limitsForm) {

        limitsService.persist(LimitsForm.toDomain(limitsForm));
        return Response.ok().build();
    }
}
