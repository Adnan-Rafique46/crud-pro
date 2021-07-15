package repository;

import model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class OrganizationRepositoryImpl implements OrganizationRepositoryCustom {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Page<Organization> findAll(String name, Pageable pageRequest) {
        org.springframework.data.mongodb.core.query.Query query = new Query();
        Criteria criteria = new Criteria();
        if (!isEmpty(name)) {
            criteria = Criteria.where("name").regex(".*"+name+".*", "i");
        }
        query.addCriteria(criteria);
        long count = mongoTemplate.count(query, Organization.class);
        List<Organization> patientList = mongoTemplate.find(query.with(pageRequest), Organization.class);
        return new PageImpl<Organization>(patientList, Pageable.unpaged(), count);
    }
}
