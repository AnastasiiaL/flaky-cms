package nl.cms.infra.database.repository;

import static jakarta.transaction.Transactional.TxType.MANDATORY;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;

import nl.cms.domain.capacity.Test;
import nl.cms.domain.exceptions.StorageException;
import nl.cms.infra.database.envers.CMSRepository;
import nl.cms.infra.database.record.TestRecord;
import nl.cms.repository.TestRepository;

@ApplicationScoped
public class TestRepositoryDB implements
        CMSRepository<TestRecord>,
        TestRepository {

    private final EntityManager entityManager;

    public TestRepositoryDB(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(MANDATORY)
    public void persist(Test test) {
        try {
            entityManager.merge(test.id()
                .map(capId -> TestRecord.fromDomainWithId(test, findById(capId)))
                .orElse(TestRecord.fromDomain(test)));
        } catch (PersistenceException e) {
            throw new StorageException(e);
        }
    }
}
