package com.kubra.stitch.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id"})
public class BaseDTO {
    private Long id;
    private String self;
}
