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
public class Intent implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String version;
    private String checksum;
    @OneToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY)
    private List<Utterance> sampleUtterances;
    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Slot> slots;
    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private FollowUpPrompt confirmationPrompt;
    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private FollowUpPrompt followUpPrompt;
    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Statement rejectionStatement;
    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Statement conclusionStatement;
    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private FulfillmentActivity fulfillmentActivity;
    public Intent(String name, String version){
        this.name = name;
        this.version = version;
    }
    public Intent(String name, String version, String checksum, List<Utterance> sampleUtterances, List<Slot> slots, FollowUpPrompt confirmationPrompt, FollowUpPrompt followUpPrompt, Statement rejectionStatement, Statement conclusionStatement, FulfillmentActivity fulfillmentActivity) {
        this.name = name;
        this.version = version;
        this.checksum = checksum;
        this.sampleUtterances = sampleUtterances;
        this.slots = slots;
        this.confirmationPrompt = confirmationPrompt;
        this.followUpPrompt = followUpPrompt;
        this.rejectionStatement = rejectionStatement;
        this.conclusionStatement = conclusionStatement;
        this.fulfillmentActivity = fulfillmentActivity;
    }
}
