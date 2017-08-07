package com.kubra.stitch.dto;

import lombok.*;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class BotDTO {
    private Long id;
    private String name;
    private String version;
    private String locale;
    private Integer idleSessionTTLInSeconds;
    private Boolean childDirected;
    private List<IntentDTO> intents;
    private PromptDTO clarificationPrompt;
    private StatementDTO abortStatement;
    private String status;
    private String failureReason;
    private String checksum;
}
