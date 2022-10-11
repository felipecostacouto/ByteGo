package com.gpti.bytego.model.entity.question;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class QuestionAnswerPK implements Serializable
{
    private static final long serialVersionUID = 5575543332914752612L;
    @Column(name = "studentLogin")
    private String studentLogin;
    @Column(name = "questionID")
    private Long questionID;

    public QuestionAnswerPK(String studentLogin, Long questionID) {
        this.studentLogin = studentLogin;
        this.questionID = questionID;
    }

    public QuestionAnswerPK() {}

    public String getStudentLogin() {
        return studentLogin;
    }

    public void setStudentLogin(String studentLogin) {
        this.studentLogin = studentLogin;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }
}
