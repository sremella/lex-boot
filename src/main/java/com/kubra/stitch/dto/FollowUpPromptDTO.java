package com.kubra.stitch.dto;

import com.amazonaws.services.lexmodelbuilding.model.Prompt;
import com.amazonaws.services.lexmodelbuilding.model.Statement;
import lombok.*;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class FollowUpPromptDTO {
    private Long id;
    private Prompt prompt;
    private Statement rejectionStatement;
}
