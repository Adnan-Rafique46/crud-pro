package repository;

import model.Case;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CaseRepositoryCustom {
    Page<Case> findAll(String patientId, String name, Pageable pageRequest);
}
