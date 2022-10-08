package com.gpti.bytego.model.entity.question;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class QuestionAlternativePK implements Serializable
{
    @Serial
    private static final long serialVersionUID = 3715839933836578723L;
    @ManyToOne
    @JoinColumn(name = "questionID")
    private Question question;
    @Column(name = "alternative", nullable = false, length = 1)
    private char alternative;

    public QuestionAlternativePK() {}

    public QuestionAlternativePK(Question question, char alternative) {
        this.question = question;
        this.alternative = alternative;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public char getAlternative() {
        return alternative;
    }

    public void setAlternative(char alternative) {
        this.alternative = alternative;
    }
}
