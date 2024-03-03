package nl.cms.domain.atoms;

import java.math.BigDecimal;

import org.immutables.value.Value;

import nl.cms.annotations.Wrapped;
import nl.cms.domain.exceptions.ValueException;

@Wrapped
public interface Rate extends NumericAtom {

    @Value.Check
    default void validate() {
        if (value().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValueException("Rate should be above zero");
        }
    }
}
