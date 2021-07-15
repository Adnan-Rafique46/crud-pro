package services;

import dto.CaseDTO;
import dto.response.PageDTO;

public interface CaseService {
boolean create(CaseDTO dto);
boolean update(CaseDTO dto);
boolean deleteById(String id);
boolean findById(String id);
PageDTO<CaseDTO> findCases(String patientId,String name,String order,Integer pageSize,Integer pageIndex);
}
