package repository;

import model.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrganizationRepositoryCustom {
    Page<Organization> findAll(String name, Pageable pageRequest);
}
