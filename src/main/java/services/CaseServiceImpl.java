package services;

import dto.CaseDTO;
import dto.response.PageDTO;
import model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import repository.CaseRepository;
import repository.PatientRepository;

import java.util.Optional;

import static constant.StringConstants.ID_NULL;
import static constant.StringConstants.PATIENT_ID_INVALID;
import static model.Case.fromDTO;
import static org.springframework.util.Assert.isNull;
import static org.springframework.util.Assert.isTrue;

public class CaseServiceImpl implements CaseService{

    @Autowired
    private CaseRepository repository;
    @Autowired
    private PatientRepository patientRepository;


    @Override
    public boolean create(CaseDTO dto) {
        isNull(dto.getId(), ID_NULL);
        Optional<Patient> optionalPatient = patientRepository.findById(dto.getPatientId());
        isTrue(optionalPatient.isPresent(),PATIENT_ID_INVALID);
        repository.save(fromDTO(dto));
        return true;
    }
    @Override
    public boolean update(CaseDTO dto) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public boolean findById(String id) {
        return false;
    }

    @Override
    public PageDTO<CaseDTO> findCases(String patientId, String name, String order, Integer pageSize, Integer pageIndex) {
        return null;
    }
}
