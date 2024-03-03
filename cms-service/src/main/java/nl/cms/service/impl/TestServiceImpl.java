package nl.cms.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import nl.cms.domain.capacity.Test;
import nl.cms.repository.TestRepository;
import nl.cms.service.TestService;

@ApplicationScoped
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Inject
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public void persist(Test test) {
        testRepository.persist(test);
    }

}
