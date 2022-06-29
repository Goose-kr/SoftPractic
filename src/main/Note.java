package main;
import java.time.Instant;

public class Note {
    String name;
    String text;
    String author;
    Instant creationDate;

    public Note(String name, String text) {
        this.name = name;
        this.text = text;

        author = null;
        creationDate = Instant.now();

    }

    public String getName() {
        return this.name;
    }

    public String getText() {
        return this.text;
    }
}

