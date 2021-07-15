package model;

import dto.NotesDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Document("Notes")
public class Notes extends Auditable{
    @Id
    private String id;
    private String caseId;
    private String name;
    private String description;
    private Date dateOfNotes;



   /* public NotesDTO toDTO() {
        return NotesDTO.builder().id(this.getId()).caseId(this.getCaseId())
                .name(this.getName()).description(this.getDescription()).dateOfNotes(this.getDateOfNotes()).build();
    }*/
    public  NotesDTO toDTO(){
        return NotesDTO.builder().id(this.getId()).caseId(this.getCaseId())
                .name(this.getName()).description(this.description).dateOfNotes(this.dateOfNotes).build();

    }
    public static Notes fromDTO(NotesDTO dto) {
        return Notes.builder().id(dto.getId()).caseId(dto.getCaseId())
                .name(dto.getName()).description(dto.getDescription()).dateOfNotes(dto.getDateOfNotes()).build();
    }
}
