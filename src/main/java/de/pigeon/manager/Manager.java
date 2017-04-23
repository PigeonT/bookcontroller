package de.pigeon.manager;

import java.util.Collection;

public interface Manager<T> {
    Collection<T> getAll();

    T searchWithISBN(String ISBN);

    Collection<T> searchWithAuthor();

    Collection<T> searchWithTitle();
}
