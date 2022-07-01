package repository;

import main.Patient;

import java.util.List;
import java.util.Set;

public interface PatientRepository {
    void savePatient(Patient patient);

    Set<Patient> getAllPatient();

    void remove(String name);


    //DoctorRepository saveDoc(DoctorRepository doctor);
}
