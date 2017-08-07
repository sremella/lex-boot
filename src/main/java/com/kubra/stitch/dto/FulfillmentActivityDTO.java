package com.kubra.stitch.dto;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class FulfillmentActivityDTO implements Serializable {
    private Long id;
    private String type;
}
