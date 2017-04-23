package de.pigeon.model;

public final class Book implements Entity {

    private String title;
    private String ISBN;
    private String autoren;
    private String kurzbeschreibung;

    private Book(){}

    public Book(String title, String ISBN, String autoren, String kurzbeschreibung){
        this.title = title;
        this.ISBN = ISBN;
        this.autoren = autoren;
        this.kurzbeschreibung = kurzbeschreibung;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAutoren() {
        return autoren;
    }

    public String getKurzbeschreibung() {
        return kurzbeschreibung;
    }

    @Override
    public String toString() {
        return "title: " + title + "\n"
                + "isbn: " + ISBN + "\n"
                + "author: " + autoren + "\n"
                + "kurzbeschreibung: " + kurzbeschreibung;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = hash * 17 + title.hashCode();
        hash = hash * 17 + ISBN.hashCode();
        hash = hash * 17 + autoren.hashCode();
        hash = hash * 17 + kurzbeschreibung.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Book)) return false;
        Book b = (Book) obj;
        return this.hashCode() == b.hashCode();
    }

}
