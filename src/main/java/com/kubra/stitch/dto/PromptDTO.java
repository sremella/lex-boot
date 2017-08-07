package com.kubra.stitch.dto;

import com.kubra.stitch.model.BaseModel;
import lombok.*;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PromptDTO extends BaseModel{
    private Long id;
    private List<MessageDTO> messages;
    private Integer maxAttempts;
    private String responseCard;
}
