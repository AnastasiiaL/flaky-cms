package nl.cms.infra.database.repository;

import static nl.cms.mocks.TestMocks.TEST_1;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import jakarta.inject.Inject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@Tag("integration")
class CapacityTestRepositoryDBTest extends BaseRepositoryTest {

    @Inject
    TestRepositoryDB repository;

    @Test
    @TestTransaction
    @DisplayName("Should persist a new TestRecord")
    void persistNewTest() {
        repository.persist(TEST_1);
        checkTest(TEST_1, TEST_1);
    }

    private static void checkTest(nl.cms.domain.capacity.Test expected, nl.cms.domain.capacity.Test actual) {
        assertEquals(expected.date(), actual.date());
        checkTestNumber(expected.numberTen(), actual.numberTen());
        checkTestNumber(expected.numberTwenty(), actual.numberTwenty());
    }

    private static void checkTestNumber(nl.cms.domain.capacity.Test.Capacity actual, nl.cms.domain.capacity.Test.Capacity expected) {
        assertThat(actual.number(), comparesEqualTo(expected.number()));
        assertThat(actual.foo(), comparesEqualTo(expected.foo()));
        assertThat(actual.bar(), comparesEqualTo(expected.bar()));
    }
}
