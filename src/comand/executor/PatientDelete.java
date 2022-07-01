package comand.executor;

import comand.CommandType;
import main.Patient;

import java.util.Optional;

public class PatientDelete extends AbstractExecutor {
    @Override
    public int execute(String command) {
        return patientDelete(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DELETE_PATIENT;
    }

    private int patientDelete(String command) {
        var idArray = command.split(" ");

        var patientIdToDelete = idArray[2];

        Optional<Patient> patientToDelete = findPatient(patientIdToDelete);

        if (patientToDelete.isPresent()) {
            patientRepository.remove(patientToDelete.get().toString());

            System.out.println("Пациент удален!");
        } else {
            System.out.println("Пациент не найден!");
        }
        return 1;
    }
}