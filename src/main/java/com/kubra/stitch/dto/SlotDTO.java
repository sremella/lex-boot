package com.kubra.stitch.dto;

import lombok.*;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class SlotDTO {
    private Long id;
    private String name;
    private String description;
    private String slotConstraint;
    private String slotType;
    private String slotTypeVersion;
    private List<UtteranceDTO> sampleUtterances;
    private String responseCard;
    private Integer priority;
    private PromptDTO valueElicitationPrompt;
}
