package de.pigeon.manager;

import de.pigeon.model.People;
import de.pigeon.utils.CSVParser;

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
        //stream的用法要加强
        return collection.stream()
                .filter(e -> e.getNachName().toLowerCase().contains(lastName.toLowerCase()))
                .map(e -> e.getEmail()).collect(Collectors.toList());
    }
}
