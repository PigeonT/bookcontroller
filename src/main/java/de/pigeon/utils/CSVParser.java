package de.pigeon.utils;


import de.pigeon.model.Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CSVParser {
    @SuppressWarnings("unchecked")
    public static <T extends Entity> Collection<T> BuildEntity(Class<?> entityClass, String file) {
        Collection<T> entityList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            //skip title
            br.readLine();

            br.lines().forEach(s -> {

                Field[] superfields = entityClass.getSuperclass().getDeclaredFields();
                Field[] subfields = entityClass.getDeclaredFields();
                Field[] allfields = merge(superfields, subfields);
                String[] values = s.split(";");
                try {
                    Constructor<?> cc = entityClass.getDeclaredConstructor();
                    cc.setAccessible(true);
                    T entity = (T) cc.newInstance();

                    for (int i = 0; i < allfields.length; i++) {
                        allfields[i].setAccessible(true);
                        allfields[i].set(entity, values[i]);
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

    private static Field[] merge(Field[] superfields, Field[] subfields) {
        List<Field> l1 = new ArrayList<>();
        Field[] returnArray = new Field[subfields.length + superfields.length];
        for(Field f : Arrays.asList(superfields)) {
            l1.add(f);
        }
        for(Field f : Arrays.asList(subfields)) {
            l1.add(f);
        }
        for(int i = 0; i < l1.size(); i++)
        {
            returnArray[i] = l1.get(i);
        }
        return returnArray;
    }
}
