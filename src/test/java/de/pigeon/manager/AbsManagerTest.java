package de.pigeon.manager;

import de.pigeon.model.Book;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class AbsManagerTest {
    public static final BookManager bookManager = new BookManager("data/buecher.csv", Book.class);

    @Test
    public void testGetAll() throws Exception {
        List<?> books = (List<Book>) bookManager.getAll();
        assertEquals("Should get 8 items", 8, books.size());
        assertEquals("First item should be equal with manually created object"
                    , new Book("Ich helf dir kochen. Das erfolgreiche Universalkochbuch mit gro�em Backteil"
                                , "5554-5545-4518", "pr-walter@optivo.de"
                                , "Auf der Suche nach einem Basiskochbuch steht man heutzutage vor einer F�lle von Alternativen. Es f�llt schwer, daraus die f�r sich passende Mixtur aus Grundlagenwerk und Rezeptesammlung zu finden. Man sollte sich dar�ber im Klaren sein, welchen Schwerpunkt man setzen m�chte oder von welchen Koch- und Backkenntnissen man bereits ausgehen kann.")
                , books.get(0));
    }

    @Test
    public void testSearchWithISBN() throws Exception {
        assertEquals("search ISBN 5554-5545-4518 should return author name pr-walter@optivo.de"
                        , "pr-walter@optivo.de"
                        , bookManager.searchWithISBN("5554-5545-4518").getAutoren());
    }

    @Test
    public void testSearchWithAuthor() throws Exception {

    }

    @Test
    public void testSearchWithTitle() throws Exception {

    }
}