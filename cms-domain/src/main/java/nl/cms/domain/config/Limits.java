package nl.cms.domain.config;

import java.time.LocalDate;

import nl.cms.annotations.Staged;
import nl.cms.annotations.Wrapped;
import nl.cms.domain.atoms.Rate;
import nl.cms.domain.atoms.Threshold;
import nl.cms.domain.c.CType;
import nl.cms.domain.enums.UNumber;

@Staged
public interface Limits {

    LocalDate effective();

    CTypeThreshold thresholdB();

    CTypeThreshold thresholdC();

    CTypeThreshold thresholdD();

    CTypeThreshold thresholdE();

    CTypeThreshold thresholdF();

    CTypeThreshold thresholdG();

    CTypeThreshold thresholdH();

    CTypeThreshold thresholdI();

    CTypeThreshold thresholdJ();

    CTypeThreshold thresholdK();

    NumberLimits numberTen();

    NumberLimits numberTwenty();

    @Wrapped
    public interface CTypeThreshold {
        CType curveType();
        Threshold threshold();
    }

    @Staged
    interface NumberLimits {

        UNumber number();

        Rate up();

        Rate down();

        }
}
