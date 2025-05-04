package Estore;

import java.io.Serializable;


public class Entry implements Serializable {
    private static final long serialVersionUID = 1L;

    private  int id;
    private final String title;
    private final String body;

    public Entry(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}