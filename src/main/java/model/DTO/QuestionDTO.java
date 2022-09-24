package model.DTO;

public class QuestionDTO
{
    public Long questionID;
    public String statement;
    public byte[] statementImage;
    public int difficulty;
    public String answerText;
    public byte[] answerImage;
    public String professorComments;

    public QuestionDTO(Long questionID,
                       String statement,
                       byte[] statementImage,
                       int difficulty,
                       String answerText,
                       byte[] answerImage,
                       String professorComments) {
        this.questionID = questionID;
        this.statement = statement;
        this.statementImage = statementImage;
        this.difficulty = difficulty;
        this.answerText = answerText;
        this.answerImage = answerImage;
        this.professorComments = professorComments;
    }
}
