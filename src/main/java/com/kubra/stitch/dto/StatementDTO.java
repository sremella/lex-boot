package com.kubra.stitch.dto;


import lombok.*;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class StatementDTO {
    private Long id;
    private List<MessageDTO> messages;
    private String responseCard;
}
