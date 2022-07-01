package comand;

import comand.executor.Executor;
import comand.executor.PatientCreateExecutor;
import comand.executor.PatientDelete;
import comand.executor.PatientViwer;
import main.Patient;
import repository.PatientRepository;
import repository.impl.PatientRepositoryImpl;

import java.util.Map;
import java.util.Scanner;

public class CommandReader {

    private static final Map<CommandType, Executor> COMMAND_EXECUTORS_GROUP_BY_COMMAND = Map.of(
            CommandType.CREATE_PATIENT, new PatientCreateExecutor(),
            CommandType.DELETE_PATIENT, new PatientDelete(),
            CommandType.WRITE_ALL_PATIENTS, new PatientViwer()
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
     * create Doctor
     * create Patient
     * create Registration
     * remove Doctor
     * remove Patient
     * update Doctor
     * update Patient
     * update Registration
     * example: create Doctor id DoctorName DoctorPatronymic DoctorSecondName
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
        if (commandString.contains("create Registration")) {
            return CommandType.CREATE_REGISTRATION;
        }
        if (commandString.contains("remove Doctor")) {
            return CommandType.DELETE_DOCTOR;
        }
        if (commandString.contains("remove Patient")) {
            return CommandType.DELETE_PATIENT;
        }
        if (commandString.contains("update Doctor")) {
            return CommandType.UPDATE_DOCTOR;
        }
        if (commandString.contains("update Patient")) {
            return CommandType.UPDATE_PATIENT;
        }
        if (commandString.contains("update Registration")) {
            return CommandType.UPDATE_REGISTRATION;
        }
        if (commandString.contains("View All Patients")) {
            return CommandType.WRITE_ALL_PATIENTS;
        }
        if (commandString.contains("exit")) {
            return CommandType.EXIT;
        }
        return CommandType.UNDEFINED;
    }


}
