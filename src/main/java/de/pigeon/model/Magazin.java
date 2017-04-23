package de.pigeon.model;

public final class Magazin implements Entity {
    private String title;
    private String ISBN;
    private String autoren;
    private String erscheinungsdatum;

    private Magazin(){}

    public Magazin(String title, String ISBN, String autoren, String erscheinungsdatum){
        this.title = title;
        this.ISBN = ISBN;
        this.autoren = autoren;
        this.erscheinungsdatum = erscheinungsdatum;
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

    public String getErscheinungsdatum() {
        return erscheinungsdatum;
    }

    @Override
    public String toString() {
        return "title: " + title + "\n"
                + "isbn: " + ISBN + "\n"
                + "author: " + autoren + "\n"
                + "erscheinungsdatum: " + erscheinungsdatum;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = hash * 17 + title.hashCode();
        hash = hash * 17 + ISBN.hashCode();
        hash = hash * 17 + autoren.hashCode();
        hash = hash * 17 + erscheinungsdatum.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Magazin)) return false;
        Magazin b = (Magazin) obj;
        return this.hashCode() == b.hashCode();
    }


}
