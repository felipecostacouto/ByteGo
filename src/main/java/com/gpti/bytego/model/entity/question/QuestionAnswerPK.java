package com.gpti.bytego.model.entity.question;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class QuestionAnswerPK implements Serializable
{
    private static final long serialVersionUID = 5575543332914752612L;
    @Column(name = "login")
    private String login;
    @Column(name = "questionID")
    private Long questionID;

    public QuestionAnswerPK(String login, Long questionID) {
        this.login = login;
        this.questionID = questionID;
    }

    public QuestionAnswerPK() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }
}
