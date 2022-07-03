package comand.executor;

import comand.CommandType;
import main.Doctor;

public class DoctorCreate extends AbstractExecutor{
    @Override
    public int execute(String command) {
        return createDoctor(command);
    }

    private int createDoctor(String command) {
        var wordsArray = command.split(" ");
        doctorRepository.saveDoctor(new Doctor(wordsArray[2],wordsArray[3],wordsArray[4]));
        System.out.println("Doctor created");
        return 1;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_DOCTOR;
    }
}
