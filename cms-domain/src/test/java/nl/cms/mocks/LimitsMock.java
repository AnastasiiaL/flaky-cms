package nl.cms.mocks;

import java.math.BigDecimal;
import java.time.LocalDate;

import nl.cms.domain.atoms.ImmutableRate;
import nl.cms.domain.atoms.ImmutableThreshold;
import nl.cms.domain.c.CType;
import nl.cms.domain.config.*;
import nl.cms.domain.config.Limits;
import nl.cms.domain.enums.UNumber;

public class LimitsMock {

    public static final Limits LIMITS = ImmutableLimits.builder()
            .effective(LocalDate.of(2015, 3, 1))
            .thresholdB(ImmutableCTypeThreshold.of(CType.B, ImmutableThreshold.of(32)))
            .thresholdC(ImmutableCTypeThreshold.of(CType.C, ImmutableThreshold.of(32)))
            .thresholdD(ImmutableCTypeThreshold.of(CType.D, ImmutableThreshold.of(160)))
            .thresholdE(ImmutableCTypeThreshold.of(CType.E, ImmutableThreshold.of(320)))
            .thresholdF(ImmutableCTypeThreshold.of(CType.F, ImmutableThreshold.of(321)))
            .thresholdG(ImmutableCTypeThreshold.of(CType.G, ImmutableThreshold.of(0)))
            .thresholdH(ImmutableCTypeThreshold.of(CType.H, ImmutableThreshold.of(1)))
            .thresholdI(ImmutableCTypeThreshold.of(CType.I, ImmutableThreshold.of(2)))
            .thresholdJ(ImmutableCTypeThreshold.of(CType.J, ImmutableThreshold.of(3)))
            .thresholdK(ImmutableCTypeThreshold.of(CType.K, ImmutableThreshold.of(4)))
            .numberTen(ImmutableNumberLimits.builder()
                    .number(UNumber.TEN)
                    .up(ImmutableRate.of(BigDecimal.valueOf(13)))
                    .down(ImmutableRate.of(BigDecimal.valueOf(13)))
                    .build())
            .numberTwenty(ImmutableNumberLimits.builder()
                    .number(UNumber.TWENTY)
                    .up(ImmutableRate.of(BigDecimal.valueOf(13)))
                    .down(ImmutableRate.of(BigDecimal.valueOf(13)))
                    .build())
            .build();
}
