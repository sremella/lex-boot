package com.kubra.stitch.dto;

import lombok.*;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PromptDTO {
    private Long id;
    private List<MessageDTO> messages;
    private Integer maxAttempts;
    private String responseCard;
}
