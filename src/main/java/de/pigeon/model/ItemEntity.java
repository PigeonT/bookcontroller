package de.pigeon.model;

public abstract class ItemEntity implements Entity {
    protected String title;
    //typo ISBN
    protected String IBSN;
    protected String author;

    public String getTitle() {
        return this.title;
    }

    //这里的get方法又没有拼写错误了,考虑用ide生成getter然后在把ISBN大写
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
