package com.kubra.stitch.dto;

import com.kubra.stitch.model.BaseModel;
import lombok.*;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO extends BaseModel{
    private Long id;
    private String contentType;
    private String content;
}
