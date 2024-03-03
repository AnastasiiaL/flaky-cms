package nl.cms.mocks;

import java.math.BigDecimal;
import java.time.LocalDate;

import nl.cms.domain.atoms.ImmutablePower;
import nl.cms.domain.capacity.ImmutableCapacity;
import nl.cms.domain.capacity.ImmutableTest;
import nl.cms.domain.capacity.Test;
import nl.cms.domain.enums.UNumber;

public class TestMocks {

    public static final Test TEST_1 = ImmutableTest.builder()
        .date(LocalDate.of(2018, 5, 28))
        .numberTen(ImmutableCapacity.builder()
            .number(UNumber.TEN)
            .bar(ImmutablePower.of(BigDecimal.valueOf(223.619)))
            .foo(ImmutablePower.of(BigDecimal.valueOf(439.779)))
            .build())
        .numberTwenty(ImmutableCapacity.builder()
            .number(UNumber.TWENTY)
            .bar(ImmutablePower.of(BigDecimal.valueOf(228.093)))
            .foo(ImmutablePower.of(BigDecimal.valueOf(426.543)))
            .build())
        .build();

    public static final Test TEST_2 = ImmutableTest.builder()
        .date(LocalDate.of(2019, 6, 10))
            .numberTen(ImmutableCapacity.builder()
            .number(UNumber.TEN)
            .bar(ImmutablePower.of(BigDecimal.valueOf(213.519)))
            .foo(ImmutablePower.of(BigDecimal.valueOf(469.879)))
            .build())
        .numberTwenty(ImmutableCapacity.builder()
            .number(UNumber.TWENTY)
            .bar(ImmutablePower.of(BigDecimal.valueOf(230.093)))
            .foo(ImmutablePower.of(BigDecimal.valueOf(426.503)))
            .build())
        .build();

    public static final Test TEST_3 = ImmutableTest.builder()
        .date(LocalDate.of(2019, 7, 3))
            .numberTen(ImmutableCapacity.builder()
            .number(UNumber.TEN)
            .bar(ImmutablePower.of(BigDecimal.valueOf(255.519)))
            .foo(ImmutablePower.of(BigDecimal.valueOf(469.579)))
            .build())
        .numberTwenty(ImmutableCapacity.builder()
            .number(UNumber.TWENTY)
            .bar(ImmutablePower.of(BigDecimal.valueOf(232.293)))
            .foo(ImmutablePower.of(BigDecimal.valueOf(423.303)))
            .build())
        .build();
}
