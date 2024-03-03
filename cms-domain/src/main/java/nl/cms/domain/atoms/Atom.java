package nl.cms.domain.atoms;


public sealed interface Atom<T extends Comparable<? super T>> extends Comparable<Atom<T>>
        permits IntegerAtom, LongAtom, NumericAtom {

    T value();

    @Override
    default int compareTo(Atom<T> other) {
        return value().compareTo(other.value());
    }
}
