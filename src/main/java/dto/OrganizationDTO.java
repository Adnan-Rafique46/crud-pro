package dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Document("Organization")
public class OrganizationDTO {
    private String id;
    @NotEmpty(message = "Name can't be empty")
    @NotNull(message = "Name can't be null")
    @Size(min = 1, max = 10, message = "Name should be {min}-{max} characters long")
    private String name;
    @NotEmpty(message = "Description can't be empty")
    @NotNull(message = "Description can't be null")
    @Size(min = 1, max = 100, message = "Description should be {min}-{max} characters long")
    private String description;
    @NotEmpty(message = "Address Line1 can't be empty")
    @NotNull(message = "Address Line1 can't be null")
    @Size(min = 1, max = 100, message = "Address Line1 should be {min}-{max} characters long")
    private String addressLine1;
    @NotEmpty(message = "Address Line2 can't be empty")
    @NotNull(message = "Address Line2 can't be null")
    @Size(min = 1, max = 100, message = "Address Line2 should be {min}-{max} characters long")
    private String addressLine2;
}
