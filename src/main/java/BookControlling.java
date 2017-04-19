package main.java;

import main.java.manager.BookManager;

import java.io.IOException;
import java.util.Scanner;

public final class BookControlling {
    public static void main(String[] args) {
        try {
            new BookControlling().start();
        } catch (IOException e) {
            System.err.println(e);
            System.exit(255);
        }
    }

    private void start() throws IOException {
        initCLI();
    }

    private void initCLI() throws IOException {

        System.out.println("Welcome to book store: choose your item: ");
        System.out.println("1. Show all books/magazins with details");
        System.out.println("2. Search book/managin with ISBN");
        System.out.println("3. Search book/magazin with author name");
        System.out.println("4. Search book/magazin with titel");
        System.out.println("enter q for quit");

        Scanner scanner = new Scanner(System.in);
        String s;

        while(!(s = scanner.next()).equals("q")) {
            switch (s) {
                case "1" :
                    System.out.println("Show all books/magazins with details");
                    showAllBooksAndMagazins();
                    break;
                default:
                    System.out.println("invalid input command");
                    break;
            }
        }
        System.out.println("bye bye <3");
        scanner.close();
    }

    private void showAllBooksAndMagazins() {
        System.out.println(BookManager.showAllBooks());
        System.out.println(BookManager.showAllMagazins());
    }
}
