package de.pigeon;

import de.pigeon.manager.BookItemManager;
import de.pigeon.manager.MagazinItemManager;
import de.pigeon.manager.PeopleManager;
import de.pigeon.model.Book;
import de.pigeon.model.ItemEntity;
import de.pigeon.model.Magazin;

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

public final class BookControlling {
    private final BookItemManager bm = new BookItemManager("data/buecher.csv", Book.class);
    private final MagazinItemManager mm = new MagazinItemManager("data/zeitschriften.csv", Magazin.class);
    private final PeopleManager pm = new PeopleManager("data/autoren.csv");
    private final Scanner scanner;

    public static void main(String[] args) {
        try {
            new BookControlling().start();
        } catch (Throwable e) {
            System.err.println(e.toString());
            System.exit(255);
        }
    }

    public BookControlling() {
        scanner = new Scanner(System.in);
    }

    private void start() throws IOException {
        config();
        initCLI();
    }

    private void config() {

    }

    private void initCLI() throws IOException {

        showInfo();

        try {
            String s;
            while (!(s = scanner.next()).equals("q")) {
                switch (s) {
                    case "1":
                        System.out.println("Show all books with details");
                        showResult(getAllBooks());
                        break;
                    case "2":
                        System.out.println("Show all magazins with details");
                        showResult(getAllMagazins());
                        break;
                    case "3":
                        System.out.println("Search with ISBN:");
                        searchWithISBN();
                        break;
                    case "4":
                        System.out.println("Show all books/magazins of author: ");
                        searchWithAuthor();
                        break;
                    case "5":
                        System.out.println("Sort all books with title");
                        showResult(sortAllBooksTitle());
                        break;
                    case "6":
                        System.out.println("Sort all magazins with title");
                        showResult(sortAllMagazinsTitle());
                        break;
                    default:
                        System.out.println("invalid input command");
                        break;
                }
                showInfo();
            }
            System.out.println("bye bye <3");
        } finally {
            scanner.close();
        }
    }

    private void searchWithAuthor() {
        System.out.println("Give the family name of the Author: ");
        String author = scanner.next();
        Collection<?> bc = bm.searchWithAuthor(pm.getAllPeopleWithEmail(author));
        if (bc.size() != 0) {
            showResult(bc);
        } else {
            System.out.println("no such author");
        }
        Collection<?> mc = mm.searchWithAuthor(pm.getAllPeopleWithEmail(author));
        if (mc != null) {
            showResult(mc);
        } else {
            System.out.println("no such author");
        }
    }

    private Collection<?> sortAllMagazinsTitle() {
        return mm.sortWithTitle();
    }

    private Collection<?> sortAllBooksTitle() {
        return bm.sortWithTitle();
    }

    private void showInfo() {
        System.out.println("Welcome to book store: choose your item: ");
        System.out.println("1. Show all books with details");
        System.out.println("2. Show all magazins with details");
        System.out.println("3. Search with ISBN");
        System.out.println("4. Show all books/magazins of author");
        System.out.println("5. Sort all books with titlel");
        System.out.println("6. Sort all magazins with title");
        System.out.println("enter q for quit");
    }

    private void searchWithISBN() {

        String isbn = scanner.next();
        Book b = bm.searchWithISBN(isbn);
        if (b != null) {
            showResult(b);
        } else {
            System.out.println("no such book");
        }
        Magazin m = mm.searchWithISBN(isbn);
        if (m != null) {
            showResult(m);
        } else {
            System.out.println("no such magazin");
        }
    }

    private Collection<? extends ItemEntity> getAllBooks() {
        return bm.getAll();
    }

    private Collection<?> getAllMagazins() {
        return mm.getAll();
    }

    private void showResult(Collection<?> collection) {
        Object[] c = collection.toArray();
        for (int i = 0; i < c.length; i++) {
            System.out.println(i + ": " + c[i].toString());
        }
    }

    private <T> void showResult(T entity) {
        System.out.println(entity);
    }
}
