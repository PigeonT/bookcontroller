package main.java.manager;

import java.io.File;
import java.util.Scanner;

public final class BookManager {
    public static final BookManager bm = new BookManager();
    private static final String BOOK_CSV = "data/buecher.csv";
    private BookManager(){}


    public static String showAllBooks() {
        Scanner s = new Scanner(BOOK_CSV);
        s.useDelimiter(";");
        StringBuilder sb = new StringBuilder();
        while(s.hasNext()) {
            sb.append(s.next());
        }
        s.close();
        return sb.toString();
    }

    public static String showAllMagazins() {
        return "";
    }
}
