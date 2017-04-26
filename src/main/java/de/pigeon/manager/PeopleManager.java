package de.pigeon.manager;

import de.pigeon.model.People;
import de.pigeon.utils.CSVParser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public final class PeopleManager implements Manager<People> {
    private final String fileName;
    private Collection<People> collection = null;

    public PeopleManager(String fileName) {
        this.fileName = fileName;
        init();
    }

    private void init() {
        collection = CSVParser.BuildEntity(People.class, fileName);
    }

    public Collection<String> getAllPeopleWithEmail(String lastName) {
        Collection<String> d = new ArrayList<>();
        collection.stream()
                .forEach(p -> {
                    if(p.getNachName().toLowerCase().contains(lastName.toLowerCase()))
                        d.add(p.getEmail());
                });
        return d;

    }
}
