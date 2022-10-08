package com.gpti.bytego.model.entity.exam;

import com.gpti.bytego.model.DTO.SpecificExamDTO;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "GradedExam")
public class GradedExam implements SpecificExamInterface
{
    @EmbeddedId
    private GradedExamPK gradedExamPK;
    @MapsId(value = "examID")
    @JoinColumn(name = "examID", referencedColumnName = "ID")
    @Transient
    private Exam exam;
    @Column(name = "gradedTime", nullable = false)
    private Timestamp gradedTime;
    @Column(name = "score", nullable = false, updatable = false)
    private Float score;

    public GradedExam() {}


    public GradedExam(GradedExamPK gradedExamPK, Timestamp gradedTime, Float score) {
        this.gradedExamPK = gradedExamPK;
        this.gradedTime = gradedTime;
        this.score = score;
    }

    @Override
    public Long getID() {
        return gradedExamPK.getExamID();
    }

    @Override
    public SpecificExamDTO getSpecificExamDTO() {
        // Aqui, -1 significa que foram todas. Será um problema?
        return new SpecificExamDTO(ExamType.GRADED_EXAM, score, -1, null, gradedTime);
    }

    public GradedExamPK getGradedExamPK() {
        return gradedExamPK;
    }

    public void setGradedExamPK(GradedExamPK gradedExamPK) {
        this.gradedExamPK = gradedExamPK;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Timestamp getGradedTime() {
        return gradedTime;
    }

    public void setGradedTime(Timestamp gradedTime) {
        this.gradedTime = gradedTime;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
