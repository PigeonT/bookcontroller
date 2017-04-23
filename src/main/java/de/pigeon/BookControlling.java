package de.pigeon;

import de.pigeon.manager.BookManager;
import de.pigeon.manager.MagazinManager;
import de.pigeon.model.Book;
import de.pigeon.model.Entity;
import de.pigeon.model.Magazin;

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

public final class BookControlling {
    private final BookManager bm = new BookManager("data/buecher.csv", Book.class);
    private final MagazinManager mm = new MagazinManager("data/zeitschriften.csv", Magazin.class);

    public static void main(String[] args) {
        try {
            new BookControlling().start();
        } catch (Throwable e) {
            System.err.println(e.toString());
            System.exit(255);
        }
    }

    private void start() throws IOException {
        config();
        initCLI();
    }

    private void config() {

    }

    private void initCLI() throws IOException {

        System.out.println("Welcome to book store: choose your item: ");
        System.out.println("1. Show all books with details");
        System.out.println("2. Show all magazins with details");
        System.out.println("3. Search book/managin with ISBN");
        System.out.println("4. Search book/magazin with author name");
        System.out.println("5. Search book/magazin with titel");
        System.out.println("enter q for quit");


        try (Scanner scanner = new Scanner(System.in)) {
            String s;
            while (scanner.hasNext() && !(s = scanner.next()).equals("q")) {
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
                        System.out.println("search with ISBN:");
                        searchWithISBN();
                        break;
                    default:
                        System.out.println("invalid input command");
                        break;
                }
            }
            System.out.println("bye bye <3");
        }
    }

    private void searchWithISBN() {
        try(Scanner isbnscanner = new Scanner(System.in)) {
            String isbn = isbnscanner.nextLine();
            Book b = bm.searchWithISBN(isbn);
            if(b != null) {
                showResult(b);
            } else {
                System.out.println("no such book");
            }
        }
    }

    private Collection<?> getAllBooks() {
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
