package nl.cms.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

import nl.cms.domain.atoms.ImmutableRate;
import nl.cms.domain.atoms.ImmutableThreshold;
import nl.cms.domain.c.CType;
import nl.cms.domain.config.*;
import nl.cms.domain.config.Limits;
import nl.cms.domain.enums.UNumber;
import nl.cms.domain.exceptions.CMSException;

public class LimitsForm {

    @NotNull(message = "Effective month is required")
    public LocalDate effective;

    public Integer thresholdB;

    public Integer thresholdC;

    public Integer thresholdD;

    public Integer thresholdE;

    public Integer thresholdF;

    public Integer thresholdG;

    public Integer thresholdH;

    public Integer thresholdI;

    public Integer thresholdJ;

    public Integer thresholdK;

    public BigDecimal bar1;

    public BigDecimal bar2;

    public BigDecimal bar3;

    public BigDecimal bar4;

    public static Limits toDomain(LimitsForm form) {
        try {
            return ImmutableLimits.builder()
                    .effective(form.effective)
                    .thresholdB(ImmutableCTypeThreshold.of(CType.B, ImmutableThreshold.of(form.thresholdB)))
                    .thresholdC(ImmutableCTypeThreshold.of(CType.C, ImmutableThreshold.of(form.thresholdC)))
                    .thresholdD(ImmutableCTypeThreshold.of(CType.D, ImmutableThreshold.of(form.thresholdD)))
                    .thresholdE(ImmutableCTypeThreshold.of(CType.E, ImmutableThreshold.of(form.thresholdE)))
                    .thresholdF(ImmutableCTypeThreshold.of(CType.F, ImmutableThreshold.of(form.thresholdF)))
                    .thresholdG(ImmutableCTypeThreshold.of(CType.G, ImmutableThreshold.of(form.thresholdG)))
                    .thresholdH(ImmutableCTypeThreshold.of(CType.H, ImmutableThreshold.of(form.thresholdH)))
                    .thresholdI(ImmutableCTypeThreshold.of(CType.I, ImmutableThreshold.of(form.thresholdI)))
                    .thresholdJ(ImmutableCTypeThreshold.of(CType.J, ImmutableThreshold.of(form.thresholdJ)))
                    .thresholdK(ImmutableCTypeThreshold.of(CType.K, ImmutableThreshold.of(form.thresholdK)))
                    .numberTen(ImmutableNumberLimits.builder()
                            .number(UNumber.TEN)
                            .up(ImmutableRate.of(form.bar1))
                            .down(ImmutableRate.of(form.bar2))
                            .build())
                    .numberTwenty(ImmutableNumberLimits.builder()
                            .number(UNumber.TWENTY)
                            .up(ImmutableRate.of(form.bar3))
                            .down(ImmutableRate.of(form.bar4))
                            .build())
                    .build();
        } catch (Exception e) {
            throw new CMSException(e.getMessage());
        }
    }
}
