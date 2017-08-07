package com.kubra.stitch.dto;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    private Long id;
    private String contentType;
    private String content;
}
