package dto;

import lombok.*;
import org.springframework.context.annotation.Description;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class NotesDTO {
    private String id;
    @NotEmpty(message = "Case Id can't be empty")
    @NotNull(message = "Case Id can't be null")
    private String caseId;
    @NotEmpty(message = "Name can't be empty")
    @NotNull(message = "Name can't be null")
    @Size(min = 1, max = 20, message = "Name should be {min}-{max} characters long")
    private String name;
    @NotEmpty(message = "Description can't be empty")
    @NotNull(message = "Description can't be null")
    @Size(min = 1, max = 100, message = "Description should be {min}-{max} characters long")
    private String description;
    private Date dateOfNotes;
}
