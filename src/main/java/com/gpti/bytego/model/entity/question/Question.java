package com.gpti.bytego.model.entity.question;

import com.gpti.bytego.model.entity.exam.Exam;
import jakarta.persistence.*;

@Entity
@Table(name = "Question")
public class Question
{
    @ManyToOne
    @JoinColumn(name = "examID")
    private Exam exam;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionID", nullable = false)
    private Long questionID;
    @Column(name = "statement", nullable = false, updatable = false, length = 500)
    private String statement;
    @Column(name = "statementImage", updatable = false)
    private byte[] statementImage;
    @Column(name = "difficulty", nullable = false)
    private int difficulty;
    @Column(name = "correctAnswer")
    private String correctAnswer;
    @Column(name = "correctAnswerImage")
    private byte[] correctAnswerImage;

    public Question() {}

    public Question(Exam exam, String statement, byte[] statementImage, int difficulty, String correctAnswer, byte[] correctAnswerImage) {
        this.exam = exam;
        this.statement = statement;
        this.statementImage = statementImage;
        this.difficulty = difficulty;
        this.correctAnswer = correctAnswer;
        this.correctAnswerImage = correctAnswerImage;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public byte[] getStatementImage() {
        return statementImage;
    }

    public void setStatementImage(byte[] statementImage) {
        this.statementImage = statementImage;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public byte[] getCorrectAnswerImage() {
        return correctAnswerImage;
    }

    public void setCorrectAnswerImage(byte[] correctAnswerImage) {
        this.correctAnswerImage = correctAnswerImage;
    }
}
