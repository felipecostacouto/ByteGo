package model.entity.exam;


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
    private Long questionID;
    @Column(name = "statement", nullable = false, updatable = false, length = 500)
    private String statement;
    @Column(name = "statementImage", updatable = false)
    private byte[] statementImage;
    @Column(name = "difficulty", nullable = false)
    private int difficulty;
    @Column(name = "answerText")
    private String answerText;
    @Column(name = "answerImage")
    private byte[] answerImage;
    @Column(name = "professorComments", length = 500)
    private String professorComments;

    public Question() {}

    public Question(Exam exam, String statement, byte[] statementImage, int difficulty) {
        this.exam = exam;
        this.statement = statement;
        this.statementImage = statementImage;
        this.difficulty = difficulty;
    }

    public String getProfessorComments() {
        return professorComments;
    }

    public void setProfessorComments(String professorComments) {
        this.professorComments = professorComments;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam examID) {
        this.exam = examID;
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

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public byte[] getAnswerImage() {
        return answerImage;
    }

    public void setAnswerImage(byte[] answerImage) {
        this.answerImage = answerImage;
    }
}
