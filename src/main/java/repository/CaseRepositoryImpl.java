package repository;

import model.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class CaseRepositoryImpl implements CaseRepositoryCustom{
@Autowired
    MongoTemplate mongoTemplate;


    @Override
    public Page<Case> findAll(String patientId, String name, Pageable pageRequest) {

        Query query=new Query();
        Criteria criteria=new Criteria();
        if (!isEmpty(patientId)){
            criteria = criteria.andOperator(Criteria.where("patientId").is(patientId));
        }
        if(!isEmpty(name)){
        criteria = criteria.where("name").regex(".*"+name +".*","i");
        }
        query.addCriteria(criteria);
        long count =mongoTemplate.count(query,Case.class);
        List<Case> patientList= mongoTemplate.find(query.with(pageRequest),Case.class);
        return new PageImpl<Case>(patientList,Pageable.unpaged(),count);
    }
}
