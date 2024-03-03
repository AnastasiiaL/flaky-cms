package nl.cms.resource;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import static org.hamcrest.Matchers.*;

import jakarta.ws.rs.core.MediaType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@Tag("integration")
@TestHTTPEndpoint(LimitsResource.class)
class LimitsResourceTest extends BaseResourceTest {

    @Test
    @DisplayName("Limits - edit unsuccessful because the form is empty")
    void emptyFormTest() {
        given()
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body("{}")
                .post()
                .then()
                .statusCode(BAD_REQUEST.getStatusCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body("message", equalTo("Validation errors, please check your request"))
                .body("errors", not(empty()));
    }
}
