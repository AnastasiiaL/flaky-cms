package nl.cms.domain.capacity;

import java.util.Optional;

import nl.cms.annotations.Staged;
import nl.cms.domain.DateAware;
import nl.cms.domain.atoms.Power;
import nl.cms.domain.enums.UNumber;

@Staged
public interface Test extends DateAware<Test> {

    Optional<Long> id();

    Capacity numberTen();

    Capacity numberTwenty();

    @Staged
    interface Capacity {

        UNumber number();

        Power bar();

        Power foo();
    }
}
