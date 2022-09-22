package model.entity.Exam;

import jakarta.persistence.*;
import model.entity.User.Professor;

import java.sql.Timestamp;

@Entity
@Table(name = "GradedExam")
public class GradedExam
{
    @EmbeddedId
    private GradedExamPK gradedExamPK;
    @MapsId(value = "examID")
    @JoinColumn(name = "examID", referencedColumnName = "ID")
    @Transient
    private Exam exam;
    @ManyToOne
    @JoinColumn(name = "gradedExamProfessorLogin")
    private Professor professor;
    @Column(name = "gradedTime", nullable = false)
    private Timestamp gradedTime;

    public GradedExam() {}

    public GradedExam(GradedExamPK gradedExamPK, Professor professor, Timestamp gradedTime) {
        this.gradedExamPK = gradedExamPK;
        this.professor = professor;
        this.gradedTime = gradedTime;
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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Timestamp getGradeTime() {
        return gradedTime;
    }

    public void setGradeTime(Timestamp gradeTime) {
        this.gradedTime = gradeTime;
    }
}
