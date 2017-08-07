package com.kubra.stitch.exception;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    private String statusCode;
    private String message;
}
