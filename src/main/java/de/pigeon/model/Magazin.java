package de.pigeon.model;

//typo 所有的magazin都拼写错误magazine,如果德语是这样的话也得改,应该考虑标准英语命名
public final class Magazin extends ItemEntity {
    private String erscheinungsdatum;

    private Magazin() {
    }

    public Magazin(String title, String ISBN, String autoren, String erscheinungsdatum) {
        this.title = title;
        this.IBSN = ISBN;
        this.author = autoren;
        this.erscheinungsdatum = erscheinungsdatum;
    }

    public String getErscheinungsdatum() {
        return erscheinungsdatum;
    }

    @Override
    public String toString() {
        return "title: " + title + "\n"
                + "isbn: " + IBSN + "\n"
                + "author: " + author + "\n"
                + "erscheinungsdatum: " + erscheinungsdatum;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = hash * 17 + title.hashCode();
        hash = hash * 17 + IBSN.hashCode();
        hash = hash * 17 + author.hashCode();
        hash = hash * 17 + erscheinungsdatum.hashCode();
        return hash;
    }

}
