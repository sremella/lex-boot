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
public class Statement implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages;
    private String responseCard;

    public Statement(List<Message> messages, String responseCard) {
        this.messages = messages;
        this.responseCard = responseCard;
    }
}
