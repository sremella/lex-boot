package com.kubra.stitch.dto;

import lombok.*;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class IntentDTO {
    private Long id;
    private String name;
    private String version;
    private String checksum;
    private List<UtteranceDTO> sampleUtterances;
    private List<SlotDTO> slots;
    private FollowUpPromptDTO confirmationPrompt;
    private FollowUpPromptDTO followUpPrompt;
    private StatementDTO rejectionStatement;
    private StatementDTO conclusionStatement;
    private FulfillmentActivityDTO fulfillmentActivity;
}
