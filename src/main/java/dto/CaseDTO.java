package dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class CaseDTO {
    public Object getD;
    private String id;
    @NotEmpty(message ="Patient id cannot be empty")
    @NotNull(message = "Patient id cannot be null")
    private String patientId;
    @NotEmpty(message = "Name cannot be empty")
    @NotNull(message = "Name cannot be null")
    @Size(min=1,max = 100,message = "Name should be {min}--{max} characters long")
    private String name;
    @NotEmpty(message = "Description cant't be empty")
    @NotNull(message = "Description cant't be null")
    @Size(min=1,max = 100,message = "Descripation should be {min} {max} characters long")
    private String description;
    private Date dateOfCase;
}
