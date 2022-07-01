package comand.executor;

import comand.CommandType;

public class PatientDeleteExecutor extends AbstractExecutor {

    @Override
    public int execute(String command) {
        return deletePatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DELETE_PATIENT;
    }

    private int deletePatient(String command) {
        var patients = patientRepository.getAllPatient();

        for (var patient : patients) {
            System.out.printf("Доктор: %s /n ", patient.getName());
        }
        return 1;
    }
}