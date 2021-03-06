package main;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class Patient {
    private String name;
    //private int parentDoctor;
    private String id = generateID();
    private static int idCounter = 0;
    private int id1 = Integer.parseInt(id);


    public static synchronized String generateID(){
        return (String.valueOf(idCounter++));
    }



    private final String creationDate;
    private Instant updateDate;

    public Patient(String name) {
        this.name = name;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        creationDate = formatter.format(Date.from(Instant.now()));
       // this.parentDoctor = parentDoctor;
    }
    // public String getId(){
    //     return id;
    //}



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public int getIdCounter() {
        return id1;
    }

    public void setIdCounter() {
        this.id = id;
    }

    /* public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }*/



/*
    public UUID getUniqueKey() {
        return uniqueKey;
    }
*/

    public String getCreationDate() {

        return creationDate;
    }

  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(creationDate, patient.creationDate) && Objects.equals(id1, patient.id1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate, id1);
    }
}
