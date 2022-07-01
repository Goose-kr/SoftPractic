package comand.executor;

import comand.CommandType;
import main.Patient;
import repository.PatientRepository;

import java.util.Set;

public class PatientViwer extends AbstractExecutor{
    @Override
    public int execute(String command) {
        return viewPatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_PATIENTS;
    }


    private int viewPatient(String command){

        for (Patient patient : patientRepository.getAllPatient()){
            System.out.printf("ID: \"%s\". Имя: \"%s\". Дата регистрации: %s %n ",
                    patient.getUniqueKey(),
                    patient.getName(),
                    patient.getCreationDate());
        }
        return 1;
    }
}
