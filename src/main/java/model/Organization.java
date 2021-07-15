package model;

import dto.OrganizationDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Document("Organization")

public class Organization extends Auditable {
    @Id
    private String id;
    private String name;
    private String description;
    private String addressLine1;
    private String addressLine2;
/*

    public OrganizationDTO toDTO() {
        return OrganizationDTO.builder().id(this.getId()).name(this.getName()).description(this.getDescription())
                .addressLine1(this.getAddressLine1()).addressLine2(this.getAddressLine2()).build();
    }
*/
    public  OrganizationDTO toDTO(){
        return OrganizationDTO.builder().id(this.getId())
                .name(this.getName()).description(this.getDescription()).addressLine1(this.getAddressLine1()).addressLine2(this.getAddressLine2()).build();
    }
/*
    public static Organization fromDTO(OrganizationDTO dto) {
        return Organization.builder().id(dto.getId()).name(dto.getName()).description(dto.getDescription())
                .addressLine1(dto.getAddressLine1()).addressLine2(dto.getAddressLine2()).build();
    }*/
    public Organization fromDTO(OrganizationDTO dto){
        return Organization.builder().id(dto.getId())
                .name(dto.getName()).description(dto.getDescription()).addressLine1(dto.getAddressLine1()).addressLine2(dto.getAddressLine2()).build();
    }
}
