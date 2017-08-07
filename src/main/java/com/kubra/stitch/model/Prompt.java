package com.kubra.stitch.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prompt implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages;
    private Integer maxAttempts;
    private String responseCard;
    public Prompt(List<Message> messages, Integer maxAttempts, String responseCard) {
        this.messages = messages;
        this.maxAttempts = maxAttempts;
        this.responseCard = responseCard;
    }
}
