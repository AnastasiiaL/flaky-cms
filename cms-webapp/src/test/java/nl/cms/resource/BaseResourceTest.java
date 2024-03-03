package nl.cms.resource;

import jakarta.inject.Inject;
import jakarta.transaction.TransactionManager;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseResourceTest {

    @Inject
    Flyway flyway;

    @Inject
    TransactionManager transactionManager;

    @AfterAll
    public void resetDB() {
        flyway.clean();
        flyway.migrate();
    }
}
