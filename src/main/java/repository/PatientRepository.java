package repository;

import model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String>, PatientRepositoryCustom {
    @Override
    Page<Patient> findAll(Pageable pageable);
}