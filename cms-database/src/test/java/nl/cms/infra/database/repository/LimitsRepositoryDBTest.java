package nl.cms.infra.database.repository;

import static nl.cms.mocks.LimitsMock.LIMITS;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.inject.Inject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import nl.cms.domain.atoms.ImmutableRate;
import nl.cms.domain.config.ImmutableLimits;
import nl.cms.domain.config.ImmutableNumberLimits;
import nl.cms.domain.config.Limits;
import nl.cms.domain.exceptions.CMSException;

@QuarkusTest
@Tag("integration")
class LimitsRepositoryDBTest extends BaseRepositoryTest {

    @Inject
    LimitsRepositoryDB repository;

    @Test
    @TestTransaction
    @DisplayName("Should retrieve the most recent Limits.")
    void retrievalTest() {
        LocalDate testMonth = LocalDate.of(2023,12,1);
        Limits technicalLimits = repository.findByEffectiveMonth(testMonth);
        assertEquals(LIMITS.effective(), technicalLimits.effective());
    }

    @Test
    @TestTransaction
    @DisplayName("Should throw an exception for retrieval when the date is invalid.")
    void retrievalExceptionTest() {
        LocalDate testMonth = LocalDate.of(2000, 1, 1);
        Throwable exception = assertThrows(CMSException.class, () -> repository.findByEffectiveMonth(testMonth));
        assertEquals(String.format("No Limits found for effective month %s.", testMonth), exception.getMessage());
    }

    @Test
    @TestTransaction
    @DisplayName("Should successfully save new values of Limits")
    void save() {
        LocalDate testDate = LIMITS.effective().plusMonths(60);
        Limits update = ImmutableLimits
                .copyOf(LIMITS)
                .withEffective(testDate)
                .withNumberTen(ImmutableNumberLimits.copyOf(LIMITS.numberTen())
                        .withUp(ImmutableRate.of(BigDecimal.valueOf(13.2)))
                );
        assertDoesNotThrow(() -> repository.persist(update));
    }
}
