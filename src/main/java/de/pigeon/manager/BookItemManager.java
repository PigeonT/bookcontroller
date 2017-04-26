package de.pigeon.manager;


import de.pigeon.model.Book;

public final class BookItemManager extends AbsItemManager<Book> {

    public BookItemManager(String file, Class<?> entity) {
        super(file, entity);
    }
}
