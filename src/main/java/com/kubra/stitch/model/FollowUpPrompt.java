package com.kubra.stitch.model;

import com.amazonaws.services.lexmodelbuilding.model.Prompt;
import com.amazonaws.services.lexmodelbuilding.model.Statement;
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
public class FollowUpPrompt implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private Prompt prompt;
    private Statement rejectionStatement;

    public FollowUpPrompt(Prompt prompt, Statement rejectionStatement) {
        this.prompt = prompt;
        this.rejectionStatement = rejectionStatement;
    }
}
