package nl.cms.service.impl;

import java.time.LocalDate;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import nl.cms.domain.config.Limits;
import nl.cms.repository.LimitsRepository;
import nl.cms.service.LimitsService;

@ApplicationScoped
public class LimitsServiceImpl implements LimitsService {

    private final LimitsRepository limitsRepository;

    @Inject
    public LimitsServiceImpl(LimitsRepository limitsRepository) {
        this.limitsRepository = limitsRepository;
    }

    @Override
    public void persist(Limits limits) {
        limitsRepository.persist(limits);
    }

    @Override
    public Limits findByEffectiveMonth(LocalDate effective) {
        return limitsRepository.findByEffectiveMonth(effective);
    }
}
