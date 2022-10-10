package com.gpti.bytego.model.entity.question;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AnswerCommentPK implements Serializable
{
    private static final long serialVersionUID = 2978830422282821519L;
    @Column(name = "answerID", nullable = false, updatable = false)
    private Long answerID;
    @Column(name = "profLogin", nullable = false, updatable = false, length = 50)
    private String profLogin;

    public AnswerCommentPK() {}

    public AnswerCommentPK(Long answerID, String profLogin) {
        this.answerID = answerID;
        this.profLogin = profLogin;
    }

    public Long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Long answerID) {
        this.answerID = answerID;
    }

    public String getProfLogin() {
        return profLogin;
    }

    public void setProfLogin(String profLogin) {
        this.profLogin = profLogin;
    }
}
