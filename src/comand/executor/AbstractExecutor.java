package comand.executor;

import main.Patient;
import repository.PatientRepository;
import repository.impl.PatientRepositoryImpl;

import java.util.Optional;

public abstract class AbstractExecutor implements Executor {

    protected final PatientRepository patientRepository = PatientRepositoryImpl.getSingleton();


    protected Optional<Patient> findPatient(int patientId) {
        for (Patient patient : patientRepository.getAllPatient()) {
            if (patient.getIdCounter() == patientId) {
                return Optional.of(patient);
            }
        }

        return Optional.empty();
    }
}

