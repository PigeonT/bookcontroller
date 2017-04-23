package de.pigeon.manager;


import de.pigeon.model.Book;

public final class BookManager extends AbsManager<Book> {

    public BookManager(String file, Class<?> entity) {
        super(file, entity);
    }
}
