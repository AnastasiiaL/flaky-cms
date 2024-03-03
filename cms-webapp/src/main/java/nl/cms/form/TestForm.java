package nl.cms.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import jakarta.validation.constraints.NotNull;

import nl.cms.domain.atoms.ImmutablePower;
import nl.cms.domain.capacity.ImmutableCapacity;
import nl.cms.domain.capacity.ImmutableTest;
import nl.cms.domain.capacity.Test;
import nl.cms.domain.enums.UNumber;
import nl.cms.domain.exceptions.CMSException;

public class TestForm {

    public Long id;

    @NotNull(message = "Effective from is required")
    public LocalDate effectiveFrom;

    public BigDecimal foo10;

    public BigDecimal foo20;

    public BigDecimal bar10;

    public BigDecimal bar20;

    public static Test toDomain(TestForm form) {
        try {
            return ImmutableTest.builder()
                .date(form.effectiveFrom)
                .numberTen(ImmutableCapacity.builder()
                    .number(UNumber.TEN)
                    .bar(ImmutablePower.of(form.bar10))
                    .foo(ImmutablePower.of(form.foo10))
                    .build())
                .numberTwenty(ImmutableCapacity.builder()
                    .number(UNumber.TWENTY)
                    .bar(ImmutablePower.of(form.bar20))
                    .foo(ImmutablePower.of(form.foo20))
                    .build())
                .id(Optional.ofNullable(form.id))
                .build();
        } catch (Exception e) {
            throw new CMSException(e.getMessage());
        }
    }
}
