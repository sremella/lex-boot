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
public class Bot implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String version;
    private String locale;
    private Integer idleSessionTTLInSeconds;
    private Boolean childDirected;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Intent> intents;
    @OneToOne(cascade = CascadeType.ALL)
    private Prompt clarificationPrompt;
    @OneToOne(cascade = CascadeType.ALL)
    private Statement abortStatement;
    private String status;
    private String failureReason;
    private String checksum;

    public Bot(String name, String version, String locale, Integer idleSessionTTLInSeconds, Boolean childDirected, List<Intent> intents, Prompt clarificationPrompt, Statement abortStatement, String status, String failureReason, String checksum) {
        this.name = name;
        this.version = version;
        this.locale = locale;
        this.idleSessionTTLInSeconds = idleSessionTTLInSeconds;
        this.childDirected = childDirected;
        this.intents = intents;
        this.clarificationPrompt = clarificationPrompt;
        this.abortStatement = abortStatement;
        this.status = status;
        this.failureReason = failureReason;
        this.checksum = checksum;
    }
    public Bot(String name, String version, String locale, Integer idleSessionTTLInSeconds, Boolean childDirected, Prompt clarificationPrompt, String status, String failureReason, String checksum) {
        this.name = name;
        this.version = version;
        this.locale = locale;
        this.idleSessionTTLInSeconds = idleSessionTTLInSeconds;
        this.childDirected = childDirected;
        this.clarificationPrompt = clarificationPrompt;
        this.abortStatement = abortStatement;
        this.status = status;
        this.failureReason = failureReason;
        this.checksum = checksum;
    }
}
