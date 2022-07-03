package main;

import java.util.List;

public class Doctor {
    private String firstName;
    private String lastName;
    private String specialization;
    private Integer id = generateID();
    private static int idCounter = 0;
    //private int id1 = Integer.parseInt(id);

   // List<String> registrahions = new List<String>();



    public static synchronized Integer generateID(){
        return (idCounter++);
    }


    public Doctor(String firstName, String lastName, String specialization){
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
