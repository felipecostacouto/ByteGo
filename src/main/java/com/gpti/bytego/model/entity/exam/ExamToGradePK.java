package com.gpti.bytego.model.entity.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ExamToGradePK implements Serializable {
    private static final long serialVersionUID = 1050749958890792985L;
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

