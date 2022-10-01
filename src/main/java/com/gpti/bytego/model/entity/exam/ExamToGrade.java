package com.gpti.bytego.model.entity.exam;

import com.gpti.bytego.model.DTO.SpecificExamDTO;
import com.gpti.bytego.model.entity.user.Professor;
import jakarta.persistence.*;

@Entity
@Table(name = "ExamToGrade")
public class ExamToGrade implements SpecificExamInterface
{
    @EmbeddedId
    private ExamToGradePK examToGradePK;
    @MapsId(value = "examID")
    @JoinColumn(name = "examID", referencedColumnName = "ID")
    @Transient
    private Exam exam;
    @ManyToOne
    @JoinColumn(name = "examToGradeProfessorLogin")
    private Professor professor;
    @Column(name = "openQuestionsGraded")
    private int openQuestionsGraded;

    public ExamToGrade() {}

    public ExamToGrade(ExamToGradePK examToGradePK, Professor professor, int openQuestionsGraded) {
        this.examToGradePK = examToGradePK;
        this.professor = professor;
        this.openQuestionsGraded = openQuestionsGraded;
    }

    @Override
    public Long getID() {
        return examToGradePK.getExamID();
    }

    @Override
    public SpecificExamDTO getSpecificExamDTO() {
        return new SpecificExamDTO(ExamType.EXAM_TO_GRADE, 0, openQuestionsGraded, null, null);
    }

    public int getOpenQuestionsGraded() {
        return openQuestionsGraded;
    }

    public void setOpenQuestionsGraded(int openQuestionsGraded) {
        this.openQuestionsGraded = openQuestionsGraded;
    }

    public ExamToGradePK getExamToGradePK() {
        return examToGradePK;
    }

    public void setExamToGradePK(ExamToGradePK examToGradePK) {
        this.examToGradePK = examToGradePK;
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
}