package com.gpti.bytego.model.entity.question;

import com.gpti.bytego.model.entity.user.Student;
import jakarta.persistence.*;

@Entity
@Table(name = "QuestionAnswer")
public class QuestionAnswer
{
    @EmbeddedId
    private QuestionAnswerPK questionAnswerPK;
    @MapsId(value = "studentLogin")
    @JoinColumn(name = "studentLogin", referencedColumnName = "studentLogin")
    @Transient
    private Student student;
    @MapsId(value = "questionID")
    @JoinColumn(name = "questionID", referencedColumnName = "questionID")
    @Transient
    private Question question;
    @Column(name = "professorLogin", updatable = false, length = 1)
    private String professorLogin;
    @Column(name = "alternative", updatable = false, length = 1)
    private char alternative;
    @Column(name = "text", updatable = false, length = 500)
    private String text;
    @Column(name = "image")
    private byte[] image;
    @Column(name = "score")
    private float score;
    @Column(name = "comment")
    private String comment;

    public QuestionAnswer(QuestionAnswerPK questionAnswerPK, String professorLogin, char alternative, String text, byte[] image, float score, String comment) {
        this.questionAnswerPK = questionAnswerPK;
        this.professorLogin = professorLogin;
        this.alternative = alternative;
        this.text = text;
        this.image = image;
        this.score = score;
        this.comment = comment;
    }

    public QuestionAnswer() {}

    public QuestionAnswerPK getQuestionAnswerPK() {
        return questionAnswerPK;
    }

    public void setQuestionAnswerPK(QuestionAnswerPK questionAnswerPK) {
        this.questionAnswerPK = questionAnswerPK;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getProfessor() {
        return professorLogin;
    }

    public void setProfessor(String professorLogin) {
        this.professorLogin = professorLogin;
    }

    public char getAlternative() {
        return alternative;
    }

    public void setAlternative(char alternative) {
        this.alternative = alternative;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
