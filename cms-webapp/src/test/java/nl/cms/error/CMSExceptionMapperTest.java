package nl.cms.error;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
@Tag("integration")
@TestHTTPEndpoint(CMSExceptionResource.class)
class CMSExceptionMapperTest {

    @Test
    @DisplayName("Should display general error with exception message")
    void shouldReturnGeneralExceptionAPICall() {
        given()
            .accept(ContentType.JSON)
            .when()
            .get("/cms-exception")
            .then()
            .statusCode(BAD_REQUEST.getStatusCode())
            .contentType(ContentType.JSON)
            .body("message", equalTo("Example message"));
    }
}
