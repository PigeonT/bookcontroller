package de.pigeon.manager;

import de.pigeon.model.Book;
import de.pigeon.model.Magazin;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AbsItemManagerTest {
    public static final BookItemManager bookManager = new BookItemManager("data/buecher.csv", Book.class);
    private final MagazinItemManager managinManager = new MagazinItemManager("data/zeitschriften.csv", Magazin.class);

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
                , bookManager.searchWithISBN("5554-5545-4518").getAuthor());
    }

    @Test
    public void testSearchWithAuthor() throws Exception {
        List<?> books = (List<Book>) bookManager.searchWithAuthor(
                new PeopleManager("data/autoren.csv")
                        .getAllPeopleWithEmail("Walter"));
        Book d = (Book) books.get(1);
        assertEquals("Should get 2 book items", 2, books.size());
        assertEquals("Second book of Walter ISBN should be 1215-4545-5895"
                , "1215-4545-5895"
                , d.getISBN());
        List<?> magazins = (List<Magazin>) managinManager.searchWithAuthor(
                new PeopleManager("data/autoren.csv")
                        .getAllPeopleWithEmail("Walter"));
        Magazin dd = (Magazin) magazins.get(0);
        assertEquals("Should get 2 magazin items", 2, magazins.size());
        assertEquals("First magazin of Walter ISBN should be 5454-5587-3210"
                , "5454-5587-3210"
                , dd.getISBN());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testSortWithTitle() throws Exception {
        List<Book> sortedBooks = (List<Book>) bookManager.sortWithTitle();
        assertEquals("Fouth book of sorted ISBN should be 1024-5245-8584"
                , "1024-5245-8584"
                , sortedBooks.get(3).getISBN());
        List<Magazin> sortedMagazin = (List<Magazin>) managinManager.sortWithTitle();
        assertEquals("Second book of sorted ISBN should be 2365-8745-7854"
                , "2365-8745-7854"
                , sortedMagazin.get(1).getISBN());
    }
}