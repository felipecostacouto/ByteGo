package com.gpti.bytego.model.entity.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ExamToTakePK implements Serializable {
    private static final long serialVersionUID = -7397154730669105360L;
    @Column(name = "examID")
    private Long examID;

    public ExamToTakePK() {}

    public ExamToTakePK(Long examID) {
        this.examID = examID;
    }

    public Long getExamID() {
        return examID;
    }

    public void setExamID(Long examID) {
        this.examID = examID;
    }
}
