package org.gidrevic.lab.util;

public class Pair <T extends Comparable<T>> implements Comparable<Pair<T>> {
    public final T first;
    public final T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair<T> tPair) {
        if (tPair == null) {
            return 1;
        } else if (this.first.equals(tPair.first)) {
            return this.second.compareTo(tPair.second);
        } else {
            return this.first.compareTo(tPair.first);
        }
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", first, second);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;

        Pair<?> pair = (Pair<?>) o;
        return first.equals(pair.first) && second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + second.hashCode();
        return result;
    }
}
