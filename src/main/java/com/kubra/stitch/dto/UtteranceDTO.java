package com.kubra.stitch.dto;

import com.kubra.stitch.model.BaseModel;
import lombok.*;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class UtteranceDTO extends BaseModel{
    private Long id;
    private String utterance;
    public UtteranceDTO(String utterance){
        this.utterance = utterance;
    }
}
