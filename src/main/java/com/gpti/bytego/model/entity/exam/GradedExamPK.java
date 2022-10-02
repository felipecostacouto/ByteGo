package com.gpti.bytego.model.entity.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class GradedExamPK implements Serializable {
    private static final long serialVersionUID = -3885918974935931893L;
    @Column(name = "examID")
    private Long examID;

    public GradedExamPK() {}

    public GradedExamPK(Long examID) {
        this.examID = examID;
    }

    public Long getExamID() {
        return examID;
    }

    public void setExamID(Long examID) {
        this.examID = examID;
    }
}
