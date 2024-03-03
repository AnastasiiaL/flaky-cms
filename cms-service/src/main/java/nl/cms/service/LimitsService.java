package nl.cms.service;

import java.time.LocalDate;

import nl.cms.domain.config.Limits;

public interface LimitsService {

    void persist(Limits limits);

    Limits findByEffectiveMonth(LocalDate effective);
}
