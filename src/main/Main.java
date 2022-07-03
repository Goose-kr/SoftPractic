package main;

import comand.CommandReader;
import repository.PatientRepository;
import repository.impl.PatientRepositoryImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int code = Authentication.authenticate();
        if (code == 0) {
            System.out.println("Successfully: \n Command List: \n create Patient (Name) \n create Doctor (First name,Last name, specialization) \n create Admission(patientId, doctorId, date) \n" +
                    " delete Patient (patientId) \n update Patient (patientID newName) \n update Admission (admissionId newStatus) \n View All Patients\n View All Doctors \n View All Admission (patientID)");
        } else {
            System.out.println("Failed");
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