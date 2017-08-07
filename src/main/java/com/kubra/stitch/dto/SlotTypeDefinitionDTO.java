package com.kubra.stitch.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class SlotTypeDefinitionDTO implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String value;
}
