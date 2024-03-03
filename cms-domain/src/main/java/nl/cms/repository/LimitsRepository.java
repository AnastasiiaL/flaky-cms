package nl.cms.repository;

import java.time.LocalDate;

import nl.cms.domain.config.Limits;

public interface LimitsRepository {

    void persist(Limits limits);

    Limits findByEffectiveMonth(LocalDate effective);
}
