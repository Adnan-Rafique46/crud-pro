package repository;

import model.Case;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface CaseRepository extends MongoRepository<Case, String>, CaseRepositoryCustom {
    @Override
    Page<Case> findAll(Pageable pageable);

}