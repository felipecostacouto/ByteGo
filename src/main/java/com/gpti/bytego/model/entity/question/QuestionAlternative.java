package com.gpti.bytego.model.entity.question;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class QuestionAlternative
{
    @EmbeddedId
    private QuestionAlternativePK questionAlternativePK;
    @Column(name = "text", length = 500)
    private String text;
    @Column(name = "image")
    private byte[] image;

    public QuestionAlternative() {}

    public QuestionAlternative(QuestionAlternativePK questionAlternativePK, String text, byte[] image) {
        this.questionAlternativePK = questionAlternativePK;
        this.text = text;
        this.image = image;
    }

    public QuestionAlternativePK getQuestionAlternativePK() {
        return questionAlternativePK;
    }

    public void setQuestionAlternativePK(QuestionAlternativePK questionAlternativePK) {
        this.questionAlternativePK = questionAlternativePK;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
