package repository;

import model.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface OrganizationRepository extends MongoRepository<Organization, String>, OrganizationRepositoryCustom{

    @Override
    Page<Organization> findAll(Pageable pageable);

}
