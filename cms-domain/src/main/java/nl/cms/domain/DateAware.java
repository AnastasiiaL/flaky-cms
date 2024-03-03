package nl.cms.domain;

import java.time.LocalDate;

public interface DateAware<T extends DateAware<T>> extends Comparable<T> {

    LocalDate date();

    @Override
    default int compareTo(T other) {
        return date().compareTo(other.date());
    }
}
