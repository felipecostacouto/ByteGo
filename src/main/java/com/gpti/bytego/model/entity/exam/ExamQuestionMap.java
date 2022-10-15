package com.gpti.bytego.model.entity.exam;

import com.gpti.bytego.model.entity.question.Question;
import jakarta.persistence.*;

@Entity
public class ExamQuestionMap
{
    @EmbeddedId
    private ExamQuestionMapPK examQuestionMapPK;
    @MapsId(value = "questionID")
    @JoinColumn(name = "questionID", referencedColumnName = "questionID")
    @Transient
    private Question question;
    @MapsId(value = "examID")
    @JoinColumn(name = "examID", referencedColumnName = "ID")
    @Transient
    private Exam exam;

    public ExamQuestionMap() {}

    public ExamQuestionMap(ExamQuestionMapPK examQuestionMapPK) {
        this.examQuestionMapPK = examQuestionMapPK;
    }

    public ExamQuestionMapPK getExamQuestionMapPK() {
        return examQuestionMapPK;
    }

    public void setExamQuestionMapPK(ExamQuestionMapPK examQuestionMapPK) {
        this.examQuestionMapPK = examQuestionMapPK;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
