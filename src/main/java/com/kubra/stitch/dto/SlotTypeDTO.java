package com.kubra.stitch.dto;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class SlotTypeDTO implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String version;
    private List<SlotTypeDefinitionDTO>  enumerationValues;
}


