package main;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Patient {
    private final String name;
    // private final String id;
    private final UUID uniqueKey = UUID.randomUUID();


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
        return Objects.equals(name, patient.name) && Objects.equals(creationDate, patient.creationDate) && Objects.equals(updateDate, patient.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creationDate, updateDate);
    }
}
