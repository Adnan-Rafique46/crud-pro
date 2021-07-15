package model;

import constant.BloodGroup;
import constant.Gender;
import dto.PatientDTO;
import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
@Document("Patient")
public class Patient extends Auditable{
    @Id
    private String id;
    private String organizationId;
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
    private BloodGroup bloodGroup;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    public PatientDTO toDTO() {
        return PatientDTO.builder().id(this.getId()).organizationId(this.getOrganizationId())
                .firstName(this.getFirstName()).lastName(this.getLastName())
                .dateOfBirth(this.getDateOfBirth()).gender(this.getGender()).bloodGroup(this.getBloodGroup())
                .phoneNumber(this.getPhoneNumber()).build();
    }

    public static Patient fromDTO(PatientDTO dto) {
        return Patient.builder().id(dto.getId()).organizationId(dto.getOrganizationId())
                .firstName(dto.getFirstName()).lastName(dto.getLastName())
                .dateOfBirth(dto.getDateOfBirth()).gender(dto.getGender()).bloodGroup(dto.getBloodGroup())
                .phoneNumber(dto.getPhoneNumber()).build();
    }
}
