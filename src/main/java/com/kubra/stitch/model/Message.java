package com.kubra.stitch.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Message implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String contentType;
    private String content;
    public Message(String contentType, String content) {
        this.contentType = contentType;
        this.content = content;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
