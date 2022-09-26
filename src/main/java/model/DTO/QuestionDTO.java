package model.DTO;

import java.util.Arrays;

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
                       String professorComments)
    {
        this.questionID = questionID;
        this.statement = statement;
        this.statementImage = statementImage;
        this.difficulty = difficulty;
        this.answerText = answerText;
        this.answerImage = answerImage;
        this.professorComments = professorComments;
    }

    public String getPrintQuestionInfo(int numberOfTags)
    {
        String tagsSpace = "";
        for (int i = 0; i < numberOfTags; i++) tagsSpace = tagsSpace.concat("\t");

        return "\n" + tagsSpace + "QuestionDTO{" +
                ",\n" + tagsSpace + "\tquestionID=" + questionID +
                ",\n" + tagsSpace + "\tstatement='" + statement + '\'' +
                ",\n" + tagsSpace + "\tstatementImage=" + Arrays.toString(statementImage) +
                ",\n" + tagsSpace + "\tdifficulty=" + difficulty +
                ",\n" + tagsSpace + "\tanswerText='" + answerText + '\'' +
                ",\n" + tagsSpace + "\tanswerImage=" + Arrays.toString(answerImage) +
                ",\n" + tagsSpace + "\tprofessorComments='" + professorComments + '\'' +
                '}';
    }
}
