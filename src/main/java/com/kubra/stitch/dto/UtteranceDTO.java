package com.kubra.stitch.dto;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class UtteranceDTO {
    private Long id;
    private String utterance;
    public UtteranceDTO(String utterance){
        this.utterance = utterance;
    }
}
