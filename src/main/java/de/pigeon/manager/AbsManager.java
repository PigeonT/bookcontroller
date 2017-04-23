package de.pigeon.manager;


import com.sun.istack.internal.Nullable;
import de.pigeon.model.Book;
import de.pigeon.model.Entity;
import de.pigeon.utils.CSVParser;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public abstract class AbsManager<T extends Entity> implements Manager<T> {
    protected String fileName = null;
    protected Class<?> entity;
    protected Collection<T> collection = null;

    protected AbsManager(String file, Class<?> entity) {
        this.fileName = file;
        this.entity = entity;
        init();
    }

    private void init() {
        collection = CSVParser.BuildEntity(entity, fileName);
    }

    @Override
    public Collection<T> getAll() {
        return collection;
    }

    @Override
    @SuppressWarnings("unchecked")
    public @Nullable T searchWithISBN(String ISBN) {

        Optional<?> op = collection.stream().filter(p -> {
            Book b = (Book) p;
            return b.getISBN().equals(ISBN);
        }).findFirst();
        Object result =  op.isPresent()? op.get() : null;
        return (T) result;
    }

    @Override
    public Collection<T> searchWithAuthor() {
        return null;
    }

    @Override
    public Collection<T> searchWithTitle() {
        return null;
    }
}
