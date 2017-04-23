package de.pigeon.utils;


import de.pigeon.model.Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

public class CSVParser {
    @SuppressWarnings("unchecked")
    public static <T extends Entity> Collection<T> BuildEntity(Class<?> entityClass, String file) {
        Collection<T> entityList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            //skip title
            br.readLine();

            br.lines().forEach(s -> {

                Field[] fields = entityClass.getDeclaredFields();
                String[] values = s.split(";");
                try {
                    Constructor<?> cc = entityClass.getDeclaredConstructor();
                    cc.setAccessible(true);
                    T entity = (T) cc.newInstance();

                    for (int i = 0; i < fields.length; i++) {
                        fields[i].setAccessible(true);
                        fields[i].set(entity, values[i]);
                    }
                    entityList.add(entity);
                } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return entityList;
    }
}
