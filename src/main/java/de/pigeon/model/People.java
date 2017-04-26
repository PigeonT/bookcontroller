package de.pigeon.model;


public final class People implements Entity {
    private String email;
    private String vorName;
    private String nachName;

    private People() {
    }

    public People(String email, String vorName, String nachName) {
        this.email = email;
        this.vorName = vorName;
        this.nachName = nachName;
    }

    public String getEmail() {
        return email;
    }

    public String getVorName() {
        return vorName;
    }

    public String getNachName() {
        return nachName;
    }
}
