package com.kubra.stitch.lex;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class InputMessage {
    private String from;
    private String text;
}
