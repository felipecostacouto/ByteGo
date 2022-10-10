package com.gpti.bytego.model.entity.question;

import com.gpti.bytego.model.entity.user.Student;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "QuestionAnswer")
public class QuestionAnswer
{
    @EmbeddedId
    private QuestionAnswerPK questionAnswerPK;
    @MapsId(value = "login")
    @JoinColumn(name = "login", referencedColumnName = "studentLogin")
    @Transient
    private Student student;
    @MapsId(value = "questionID")
    @JoinColumn(name = "questionID", referencedColumnName = "questionID")
    @Transient
    private Question question;
    @Column(name = "ID", nullable = false, updatable = false)
    private Long ID;
    @Column(name = "alternative", updatable = false, length = 1)
    private char alternative;
    @Column(name = "text", updatable = false, length = 500)
    private String text;
    @Column(name = "image")
    private byte[] image;
    @Column(name = "score")
    private float score;

    public QuestionAnswer(QuestionAnswerPK questionAnswerPK, char alternative, String text, byte[] image, float score) {
        this.ID = (long)((int)UUID.randomUUID().getLeastSignificantBits());
        this.questionAnswerPK = questionAnswerPK;
        this.alternative = alternative;
        this.text = text;
        this.image = image;
        this.score = score;
    }

    public QuestionAnswer()
    {
        this.ID = (long)((int)UUID.randomUUID().getLeastSignificantBits());
    }

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

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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
}
