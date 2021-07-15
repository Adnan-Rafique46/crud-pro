package repository;

import model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class PatientRepositoryImpl implements PatientRepositoryCustom {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Page<Patient> findAll(String organizationId, String name, Pageable pageRequest) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        if (!isEmpty(organizationId)) {
            criteria = criteria.andOperator(Criteria.where("organizationId").is(organizationId));
        }
        if (!isEmpty(name)) {
            criteria = criteria.orOperator(Criteria.where("firstName").regex(".*"+name+".*", "i"), Criteria.where("lastName").regex(".*"+name+".*", "i"));
        }
        query.addCriteria(criteria);
        long count = mongoTemplate.count(query, Patient.class);
        List<Patient> patientList = mongoTemplate.find(query.with(pageRequest), Patient.class);
        return new PageImpl<Patient>(patientList, Pageable.unpaged(), count);
    }

    @Override
    public long findCountByOrganizationId(String organizationId) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        if (!isEmpty(organizationId)) {
            criteria = criteria.andOperator(Criteria.where("organizationId").is(organizationId));
        }
        query.addCriteria(criteria);
        return mongoTemplate.count(query, Patient.class);
    }
    @Override
    public Page<Patient> findAllByAge(String organizationId, Integer minAge, Integer maxAge, Pageable pageRequest) {
        Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();
        if (!isEmpty(organizationId)) {
            criteria.add(Criteria.where("organizationId").is(organizationId));
        }
        if (nonNull(minAge)) {
            criteria.add((Criteria.where("dateOfBirth").lte(LocalDate.now().minusYears(minAge))));
        }

        if (nonNull(maxAge)) {
            criteria.add((Criteria.where("dateOfBirth").gte(LocalDate.now().minusYears(maxAge))));
        }

        if (!criteria.isEmpty())
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        long count = mongoTemplate.count(query, Patient.class);
        List<Patient> patientList = mongoTemplate.find(query.with(pageRequest), Patient.class);
        return new PageImpl<Patient>(patientList, Pageable.unpaged(), count);
    }
}



