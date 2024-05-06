package org.gidrevic.lab.util;

import java.util.Optional;
import java.util.function.Predicate;

public interface Owner <ID, T extends Indexable<ID>> {
    Optional<T> getById(ID id);

    void add(T item) throws DuplicateException;

    void remove(T item) throws NotFoundException;

    void removeById(ID id) throws NotFoundException;

    Optional<T> find(Predicate<T>... conditions);
}
