package nl.cms.infra.database.repository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.TransactionManager;

import org.flywaydb.core.Flyway;

abstract class BaseRepositoryTest {

    @Inject
    Flyway flyway;

    @Inject
    TransactionManager transactionManager;

    @Inject
    EntityManager entityManager;
}
