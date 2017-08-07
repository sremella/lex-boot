package com.kubra.stitch.dto;


import com.kubra.stitch.model.BaseModel;
import lombok.*;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class StatementDTO extends BaseModel{
    private Long id;
    private List<MessageDTO> messages;
    private String responseCard;
}
