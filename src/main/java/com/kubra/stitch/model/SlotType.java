package com.kubra.stitch.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SlotType implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String version;
    private String checksum;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SlotTypeDefinition>  enumerationValues;
}


