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
public class Slot implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String slotConstraint;
    private String slotType;
    private String slotTypeVersion;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Utterance> sampleUtterances;
    private String responseCard;
    private Integer priority;
    @OneToOne(cascade = CascadeType.ALL)
    private Prompt valueElicitationPrompt;

    public Slot(String name, String description, String slotConstraint, String slotType, String slotTypeVersion, List<Utterance> sampleUtterances, String responseCard, Integer priority, Prompt valueElicitationPrompt) {
        this.name = name;
        this.description = description;
        this.slotConstraint = slotConstraint;
        this.slotType = slotType;
        this.slotTypeVersion = slotTypeVersion;
        this.sampleUtterances = sampleUtterances;
        this.responseCard = responseCard;
        this.priority = priority;
        this.valueElicitationPrompt = valueElicitationPrompt;
    }
}
