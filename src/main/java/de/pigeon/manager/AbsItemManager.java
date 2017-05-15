package de.pigeon.manager;


import de.pigeon.model.ItemEntity;
import de.pigeon.utils.CSVParser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

//显示命名为AbstractItemManager,Abs歧义
public abstract class AbsItemManager<T extends ItemEntity> implements ItemManager<T> {
    protected String fileName = null;
    protected Class<?> entity;
    protected Collection<T> collection = null;

    protected AbsItemManager(String file, Class<?> entity) {
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
    public
    T searchWithISBN(String ISBN) {
        Optional<?> op = collection.stream().filter(p -> p.getISBN().equals(ISBN)).findFirst();
        return (T) (op.isPresent() ? op.get() : null);
    }

    @Override
    public Collection<T> searchWithAuthor(Collection<String> emails) {
        Collection<T> d = new ArrayList<>();
        emails.stream().forEach(e -> {
            for (T t : collection) {
                if (t.getAuthor().equals(e)) {
                    d.add(t);
                }
            }
        });
        return d;
    }

    @Override
    public Collection<?> sortWithTitle() {
        Collection<?> cc = getAll();
        return cc.stream().sorted((p1, p2) -> {
            ItemEntity b1 = (ItemEntity) p1;
            ItemEntity b2 = (ItemEntity) p2;
            return b1.getTitle().compareTo(b2.getTitle());
        }).collect(Collectors.toList());
    }
}
