package com.kubra.stitch.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utterance implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String utterance;

    public Utterance(String utterance) {
        this.utterance = utterance;
    }
}
