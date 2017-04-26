package de.pigeon.model;

public final class Book extends ItemEntity {

    private String kurzbeschreibung;

    private Book() {
    }

    public Book(String title, String IBSN, String author, String kurzbeschreibung) {
        this.title = title;
        this.IBSN = IBSN;
        this.author = author;
        this.kurzbeschreibung = kurzbeschreibung;
    }

    public String getKurzbeschreibung() {
        return kurzbeschreibung;
    }

    @Override
    public String toString() {
        return "title: " + title + "\n"
                + "isbn: " + IBSN + "\n"
                + "author: " + author + "\n"
                + "kurzbeschreibung: " + kurzbeschreibung;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = hash * 17 + title.hashCode();
        hash = hash * 17 + IBSN.hashCode();
        hash = hash * 17 + author.hashCode();
        hash = hash * 17 + kurzbeschreibung.hashCode();
        return hash;
    }

}
