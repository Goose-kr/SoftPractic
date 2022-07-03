package comand;

import comand.executor.*;
import main.Patient;
import repository.PatientRepository;
import repository.impl.PatientRepositoryImpl;

import java.util.Map;
import java.util.Scanner;

public class CommandReader {

    private static final Map<CommandType, Executor> COMMAND_EXECUTORS_GROUP_BY_COMMAND = Map.of(
            CommandType.CREATE_PATIENT, new PatientCreateExecutor(),
            CommandType.DELETE_PATIENT, new PatientDelete(),
            CommandType.WRITE_ALL_PATIENTS, new PatientViwer(),
            CommandType.UPDATE_PATIENT, new PatientUpdate(),
            CommandType.CREATE_DOCTOR, new DoctorCreate(),
            CommandType.WRITE_ALL_DOCTORS, new DoctorViwer(),
            CommandType.CREATE_ADMISSION, new AdmissionCreater(),
            CommandType.WRITE_ALL_ADMISSION, new AdmissionView(),
            CommandType.UPDATE_ADMISSION, new AdmissionUpdater()
    );


    public static void startReadCommand() {
        System.out.println("Program started. Write you command here:");
        Scanner s = new Scanner(System.in);

        int i = 1;
        while (i != 0) {
            i = readCommand(s);
        }
        s.close();
    }

    /**
     *  create Patient (Name)
     *  create Doctor (First name,Last name, specialization)
     *  create Admission(patientId, doctorId, date)
     *  delete Patient (patientId)
     *  update Patient (patientID newName)
     *  update Admission (admissionId newStatus)
     *  View All Patients
     *  View All Doctors
     *  View All Admission (patientID)
     */
    private static int readCommand(Scanner s) {
        var commandString = s.nextLine();

        CommandType commandType = getCommandType(commandString);

        if (COMMAND_EXECUTORS_GROUP_BY_COMMAND.containsKey(commandType)) {
            var commandExecuter = COMMAND_EXECUTORS_GROUP_BY_COMMAND.get(commandType);
            return commandExecuter.execute(commandString);
        }
        if (commandType == commandType.EXIT) {
            return 0;
        }
        System.out.println("Incorrect command");
        return -1;
    }

    private static CommandType getCommandType(String commandString) {

        if (commandString.contains("create Patient")) {
            return CommandType.CREATE_PATIENT;
        }
        if (commandString.contains("create Doctor")) {
            return CommandType.CREATE_DOCTOR;
        }
        if (commandString.contains("create Admission")) {
            return CommandType.CREATE_ADMISSION;
        }

        if (commandString.contains("delete Patient")) {
            return CommandType.DELETE_PATIENT;
        }

        if (commandString.contains("update Patient")) {
            return CommandType.UPDATE_PATIENT;
        }
        if (commandString.contains("update Admission")) {
            return CommandType.UPDATE_ADMISSION;
        }
        if (commandString.contains("View All Patients")) {
            return CommandType.WRITE_ALL_PATIENTS;
        }
        if (commandString.contains("View All Doctors")) {
            return CommandType.WRITE_ALL_DOCTORS;
        }
        if (commandString.contains("View All Admission")) {
            return CommandType.WRITE_ALL_ADMISSION;
        }
        if (commandString.contains("exit")) {
            return CommandType.EXIT;
        }
        return CommandType.UNDEFINED;
    }


}
