package com.kubra.stitch.dto;

import com.kubra.stitch.model.BaseModel;
import lombok.*;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class SlotDTO extends BaseModel{
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
