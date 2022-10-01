package com.gpti.bytego.model.entity.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ExamToGradePK
{
    @Column(name = "examID")
    private Long examID;

    public ExamToGradePK() {}

    public ExamToGradePK(Long examID) {
        this.examID = examID;
    }

    public Long getExamID() {
        return examID;
    }

    public void setExamID(Long examID) {
        this.examID = examID;
    }
}

