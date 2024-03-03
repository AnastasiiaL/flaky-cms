package nl.cms.infra.database.repository;

import static jakarta.transaction.Transactional.TxType.MANDATORY;

import java.time.LocalDate;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;

import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import nl.cms.domain.config.Limits;
import nl.cms.domain.exceptions.CMSException;
import nl.cms.domain.exceptions.StorageException;
import nl.cms.infra.database.envers.CMSRepository;
import nl.cms.infra.database.record.LimitsRecord;
import nl.cms.repository.LimitsRepository;

@ApplicationScoped
public class LimitsRepositoryDB implements
        CMSRepository<LimitsRecord>,
        LimitsRepository {

    private static final Sort SORTING = Sort.descending("effective");

    @Override
    @Transactional(MANDATORY)
    public void persist(Limits limits) {
        try {
            Parameters parameters = Parameters.with("effective", limits.effective());
            find("effective <= :effective", SORTING, parameters).firstResultOptional().ifPresentOrElse(
                    limitsRecord -> {
                        if (limitsRecord.effective.equals(limits.effective())) {
                            persist(LimitsRecord.fromDomainWithId(limits, limitsRecord));
                        } else {
                            persist(LimitsRecord.fromDomain(limits));
                        }
                    },
                    () -> {
                        throw new CMSException(String.format("Could not persist Limits for effective month %s.", limits.effective()));
                    });
        } catch (PersistenceException e) {
            throw new StorageException(e);
        }
    }

    @Override
    @Transactional(MANDATORY)
    public Limits findByEffectiveMonth(LocalDate effective) {
        Parameters parameters = Parameters.with("effective", effective);
        return find("effective <= :effective", SORTING, parameters)
                .firstResultOptional()
                .map(LimitsRecord::toDomain)
                .orElseThrow(() -> new CMSException(String.format("No Limits found for effective month %s.", effective)));
    }
}
