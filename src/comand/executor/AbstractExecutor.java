package comand.executor;

import main.Patient;
import repository.PatientRepository;
import repository.impl.PatientRepositoryImpl;

import java.util.Optional;

public abstract class AbstractExecutor implements Executor {

    protected final PatientRepository patientRepository = PatientRepositoryImpl.getSingleton();


    protected Optional<Patient> findPatient(String patientId) {
        for (Patient patient : patientRepository.getAllPatient()) {
            if (patient.getUniqueKey().equals(patientId)) {
                return Optional.of(patient);
            }
        }

        return Optional.empty();
    }
}

