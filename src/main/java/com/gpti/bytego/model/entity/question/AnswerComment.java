package com.gpti.bytego.model.entity.question;

import com.gpti.bytego.model.entity.user.Professor;
import jakarta.persistence.*;

@Entity
@Table(name = "AnswerComment")
public class AnswerComment
{
    @EmbeddedId
    private AnswerCommentPK answerCommentPK;
    @MapsId(value = "answerID")
    @JoinColumn(name = "answerID", referencedColumnName = "ID")
    @Transient
    private QuestionAnswer questionAnswer;
    @MapsId(value = "profLogin")
    @JoinColumn(name = "profLogin", referencedColumnName = "professorLogin")
    @Transient
    private Professor professor;
    @Column(name = "comment", length = 500)
    private String comment;

    public AnswerComment() {}

    public AnswerComment(AnswerCommentPK answerCommentPK, String comment) {
        this.answerCommentPK = answerCommentPK;
        this.comment = comment;
    }

    public AnswerCommentPK getAnswerCommentPK() {
        return answerCommentPK;
    }

    public void setAnswerCommentPK(AnswerCommentPK answerCommentPK) {
        this.answerCommentPK = answerCommentPK;
    }

    public QuestionAnswer getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(QuestionAnswer questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
