package comand.executor;

import comand.CommandType;
import main.Patient;
import repository.PatientRepository;
import repository.impl.PatientRepositoryImpl;

import java.util.UUID;

public class PatientCreateExecutor extends AbstractExecutor {

    @Override
    public int execute(String command) {
        return createPatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_PATIENT;
    }

    private int createPatient(String command) {
        var wordsArray = command.split(" ");

        var patientName = wordsArray[2];


        /*StringBuilder fioSb = new StringBuilder();
        for (int i = 3; i < words.length; i++){
            fioSb.append(words[i]);
        }*/

        //String fio =fioSb.toString();


        var newPatient = new Patient(patientName);
        patientRepository.savePatient(newPatient);

        System.out.println(newPatient.getUniqueKey());
        System.out.println("Patient creeted");
        return 1;
    }

}
