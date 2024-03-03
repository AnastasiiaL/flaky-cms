package nl.cms.infra.database.record;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;

import org.hibernate.envers.Audited;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import nl.cms.domain.atoms.*;
import nl.cms.domain.c.CType;
import nl.cms.domain.config.*;
import nl.cms.domain.config.Limits;
import nl.cms.domain.enums.UNumber;
import nl.cms.infra.database.CMSTable;

@Entity
@Audited(withModifiedFlag = true)
@Table(name = CMSTable.LIMITS, uniqueConstraints = {@UniqueConstraint(columnNames = {"effective"})})
public class LimitsRecord extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public LocalDate effective;

    @Column(nullable = false, columnDefinition = "INT")
    public Integer thresholdB;

    @Column(nullable = false, columnDefinition = "INT")
    public Integer thresholdC;

    @Column(nullable = false, columnDefinition = "INT")
    public Integer thresholdD;

    @Column(nullable = false, columnDefinition = "INT")
    public Integer thresholdE;

    @Column(nullable = false, columnDefinition = "INT")
    public Integer thresholdF;

    @Column(nullable = false, columnDefinition = "INT")
    public Integer thresholdG;

    @Column(nullable = false, columnDefinition = "INT")
    public Integer thresholdH;

    @Column(nullable = false, columnDefinition = "INT")
    public Integer thresholdI;

    @Column(nullable = false, columnDefinition = "INT")
    public Integer thresholdJ;

    @Column(nullable = false, columnDefinition = "INT")
    public Integer thresholdK;

    @Column(nullable = false, columnDefinition = "NUMERIC(15,9)")
    public BigDecimal bar1;

    @Column(nullable = false, columnDefinition = "NUMERIC(15,9)")
    public BigDecimal bar2;

    @Column(nullable = false, columnDefinition = "NUMERIC(15,9)")
    public BigDecimal bar3;

    @Column(nullable = false, columnDefinition = "NUMERIC(15,9)")
    public BigDecimal bar4;

    public static LimitsRecord fromDomain(Limits limits) {
        return fromDomainWithId(limits, new LimitsRecord());
    }

    public static LimitsRecord fromDomainWithId(Limits limits, LimitsRecord limitsRecord) {
        limitsRecord.effective = limits.effective();
        limitsRecord.thresholdB = limits.thresholdB().threshold().value();
        limitsRecord.thresholdC = limits.thresholdC().threshold().value();
        limitsRecord.thresholdD = limits.thresholdD().threshold().value();
        limitsRecord.thresholdE = limits.thresholdE().threshold().value();
        limitsRecord.thresholdF = limits.thresholdF().threshold().value();
        limitsRecord.thresholdG = limits.thresholdG().threshold().value();
        limitsRecord.thresholdH = limits.thresholdH().threshold().value();
        limitsRecord.thresholdI = limits.thresholdI().threshold().value();
        limitsRecord.thresholdJ = limits.thresholdJ().threshold().value();
        limitsRecord.thresholdK = limits.thresholdK().threshold().value();
        limitsRecord.bar1 = limits.numberTen().up().value();
        limitsRecord.bar2 = limits.numberTen().down().value();
        limitsRecord.bar3 = limits.numberTwenty().up().value();
        limitsRecord.bar4 = limits.numberTwenty().down().value();
        return limitsRecord;
    }

    public static Limits toDomain(LimitsRecord limitsRecord) {
        return ImmutableLimits.builder()
                .effective(limitsRecord.effective)
                .thresholdB(ImmutableCTypeThreshold.of(CType.B, ImmutableThreshold.of(limitsRecord.thresholdB)))
                .thresholdC(ImmutableCTypeThreshold.of(CType.C, ImmutableThreshold.of(limitsRecord.thresholdC)))
                .thresholdD(ImmutableCTypeThreshold.of(CType.D, ImmutableThreshold.of(limitsRecord.thresholdD)))
                .thresholdE(ImmutableCTypeThreshold.of(CType.E, ImmutableThreshold.of(limitsRecord.thresholdE)))
                .thresholdF(ImmutableCTypeThreshold.of(CType.F, ImmutableThreshold.of(limitsRecord.thresholdF)))
                .thresholdG(ImmutableCTypeThreshold.of(CType.G, ImmutableThreshold.of(limitsRecord.thresholdG)))
                .thresholdH(ImmutableCTypeThreshold.of(CType.H, ImmutableThreshold.of(limitsRecord.thresholdH)))
                .thresholdI(ImmutableCTypeThreshold.of(CType.I, ImmutableThreshold.of(limitsRecord.thresholdI)))
                .thresholdJ(ImmutableCTypeThreshold.of(CType.J, ImmutableThreshold.of(limitsRecord.thresholdJ)))
                .thresholdK(ImmutableCTypeThreshold.of(CType.K, ImmutableThreshold.of(limitsRecord.thresholdK)))
                .numberTen(ImmutableNumberLimits.builder()
                        .number(UNumber.TEN)
                        .up(ImmutableRate.of(limitsRecord.bar1))
                        .down(ImmutableRate.of(limitsRecord.bar2))
                        .build())
                .numberTwenty(ImmutableNumberLimits.builder()
                        .number(UNumber.TWENTY)
                        .up(ImmutableRate.of(limitsRecord.bar3))
                        .down(ImmutableRate.of(limitsRecord.bar4))
                        .build())
                .build();
    }
}
