package com.kubra.stitch.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SlotTypeDefinition implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String value;
}
