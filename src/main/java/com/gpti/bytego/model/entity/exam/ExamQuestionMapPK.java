package com.gpti.bytego.model.entity.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ExamQuestionMapPK implements Serializable
{
    @Column(name = "questionID")
    private Long questionID;
    @Column(name = "examID")
    private Long examID;

    public ExamQuestionMapPK() {}

    public ExamQuestionMapPK(Long questionID, Long examID) {
        this.questionID = questionID;
        this.examID = examID;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public Long getExamID() {
        return examID;
    }

    public void setExamID(Long examID) {
        this.examID = examID;
    }
}
