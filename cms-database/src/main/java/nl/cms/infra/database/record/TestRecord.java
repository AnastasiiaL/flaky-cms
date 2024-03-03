package nl.cms.infra.database.record;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.envers.Audited;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import nl.cms.domain.capacity.Test;
import nl.cms.infra.database.CMSTable;

@Entity
@Audited(withModifiedFlag = true)
@Table(name = CMSTable.TEST)
public class TestRecord extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public LocalDate effective;

    @Column(nullable = false, columnDefinition = "NUMERIC(6,3)")
    public BigDecimal foo10;

    @Column(nullable = false, columnDefinition = "NUMERIC(6,3)")
    public BigDecimal foo20;

    @Column(nullable = false, columnDefinition = "NUMERIC(6,3)")
    public BigDecimal bar10;

    @Column(nullable = false, columnDefinition = "NUMERIC(6,3)")
    public BigDecimal bar20;

    public static TestRecord fromDomain(Test test) {
       return fromDomainWithId(test, new TestRecord());
    }

    public static TestRecord fromDomainWithId(Test test, TestRecord record) {
        record.effective = test.date();
        record.foo10 = test.numberTen().foo().value();
        record.foo20 = test.numberTwenty().foo().value();
        record.bar10 = test.numberTen().bar().value();
        record.bar20 = test.numberTwenty().bar().value();
        return record;
    }
}
