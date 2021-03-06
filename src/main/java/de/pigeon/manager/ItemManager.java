package de.pigeon.manager;

import de.pigeon.model.Entity;
import de.pigeon.model.ItemEntity;

import java.util.Collection;

public interface ItemManager<T extends ItemEntity> extends Manager<ItemEntity>{
    Collection<T> getAll();

    T searchWithISBN(String ISBN);

    Collection<?> searchWithAuthor(Collection<String> emails);

    Collection<?> sortWithTitle();
}
