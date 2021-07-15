package repository;

import model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientRepositoryCustom
{
    Page<Patient> findAll(String organizationId, String name, Pageable pageRequest);
    Page<Patient> findAllByAge(String organizationId, Integer minAge, Integer maxAge, Pageable pageRequest);
    long findCountByOrganizationId(String organizationId);

}
