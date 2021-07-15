package dto;

import constant.BloodGroup;
import constant.Gender;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder (toBuilder = true)
public class PatientDTO {

    private String id;
    @NotNull(message = "Orgnization id can't be null")
    @NotEmpty(message = "Orgnization id can't be empty")
    private String organizationId;
    @NotEmpty(message = "First Name can't be empty")
    @NotNull(message = "First Name can't be null")
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private BloodGroup bloodGroup;
    private String phoneNumber;

}
