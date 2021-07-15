package model;

import dto.CaseDTO;
import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Document("Case")
public class Case extends Auditable {
    @Id
    private String id;
    private String patientId;
    private String name;
    private String description;
    private Date dateOfCase;

   /* public CaseDTO toDTO() {
        return CaseDTO.builder().id(this.getId()).patientId(this.getPatientId())
                .name(this.getName()).description(this.getDescription()).dateOfCase(this.getDateOfCase()).build();
    }*/
    public CaseDTO toDTO(){
        return CaseDTO.builder().id(this.getId()).patientId(this.getPatientId())
                .name(this.getName()).description(this.getDescription()).dateOfCase(this.getDateOfCase()).build();
    }

  /*  public static Case fromDTO(CaseDTO dto) {
        return Case.builder().id(dto.getId()).patientId(dto.getPatientId())
                .name(dto.getName()).description(dto.getDescription()).dateOfCase(dto.getDateOfCase()).build();
    }*/
    public static Case fromDTO(CaseDTO dto){
        return Case.builder().id(dto.getId()).patientId(dto.getPatientId())
                .name(dto.getName()).description(dto.getDescription()).dateOfCase(dto.getDateOfCase()).build();

    }
}
