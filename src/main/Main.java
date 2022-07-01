package main;

import comand.CommandReader;
import repository.PatientRepository;
import repository.impl.PatientRepositoryImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int code = Authentication.authenticate();
        if (code == 0) {
            System.out.println("Успешно");
        } else {
            System.out.println("Не успешно");
        }

        CommandReader.startReadCommand();
        /*PatientRepository patientRepository = new PatientRepositoryImpl();*/

//        Patient patient = new Patient("FIO");
//        Patient patient1 = new Patient("FI");
//        Patient patient2 = new Patient("F");
//
//        patientRepository.savePatient(patient);
//        patientRepository.savePatient(patient1);
//        patientRepository.savePatient(patient2);


//        Doctor doctor  = new DoctorImpl();

        //      doctor.saveDoc(doctor);
        //     doctor.saveDoc(doctor2);
        //    doctor.saveDoc(doctor3);
    }
}