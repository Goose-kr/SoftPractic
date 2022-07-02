package main;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Patient {
    private final String name;
    private int id;
    private final UUID uniqueKey = UUID.randomUUID();
    private int idCounter = 0;


    public synchronized String createID(){
        return String.valueOf(idCounter++);
    }

    private final Instant creationDate;
    private Instant updateDate;

    public Patient(String name) {
        this.name = name;
        creationDate = Instant.now();
    }
    // public String getId(){
    //     return id;
    //}

    public String getName() {

        return name;
    }

    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

    /* public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }*/



    public UUID getUniqueKey() {
        return uniqueKey;
    }

    public Instant getCreationDate() {

        return creationDate;
    }

  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(creationDate, patient.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate);
    }
}
