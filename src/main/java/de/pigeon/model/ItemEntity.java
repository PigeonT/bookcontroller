package de.pigeon.model;

public abstract class ItemEntity implements Entity {
    protected String title;
    protected String IBSN;
    protected String author;

    public String getTitle() {
        return this.title;
    }

    public String getISBN() {
        return this.IBSN;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Book)) return false;
        Book b = (Book) obj;
        return this.hashCode() == b.hashCode();
    }
}
