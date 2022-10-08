package com.gpti.bytego.model.DTO;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionDTO
{
    public Long questionID;
    public String statement;
    public byte[] statementImage;
    public int difficulty;
    public String studentAnswer;
    public byte[] studentAnswerImage;
    public String correctAnswer;
    public byte[] correctAnswerImage;
    public String professorComments;
    public Float score;
    public ArrayList<QuestionAlternativeDTO> alternatives;

    public QuestionDTO(Long questionID,
                       String statement,
                       byte[] statementImage,
                       int difficulty,
                       String studentAnswer,
                       byte[] studentAnswerImage,
                       String correctAnswer,
                       byte[] correctAnswerImage,
                       String professorComments,
                       Float score,
                       ArrayList<QuestionAlternativeDTO> alternatives)
    {
        this.questionID = questionID;
        this.statement = statement;
        this.statementImage = statementImage;
        this.difficulty = difficulty;
        this.studentAnswer = studentAnswer;
        this.studentAnswerImage = studentAnswerImage;
        this.correctAnswer = correctAnswer;
        this.correctAnswerImage = correctAnswerImage;
        this.professorComments = professorComments;
        this.score = score;
        this.alternatives = alternatives;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public String getStatement() {
        return statement;
    }

    public byte[] getStatementImage() {
        return statementImage;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    public byte[] getStudentAnswerImage() {
        return studentAnswerImage;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public byte[] getCorrectAnswerImage() {
        return correctAnswerImage;
    }

    public String getProfessorComments() {
        return professorComments;
    }

    public Float getScore() {
        return score;
    }

    public ArrayList<QuestionAlternativeDTO> getAlternatives() {
        return alternatives;
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
                ",\n" + tagsSpace + "\tstudentAnswer='" + studentAnswer + '\'' +
                ",\n" + tagsSpace + "\tstudentAnswerImage=" + Arrays.toString(studentAnswerImage) +
                ",\n" + tagsSpace + "\tcorrectAnswer='" + correctAnswer + '\'' +
                ",\n" + tagsSpace + "\tcorrectAnswerImage=" + Arrays.toString(correctAnswerImage) +
                ",\n" + tagsSpace + "\tprofessorComments='" + professorComments + '\'' +
                ",\n" + tagsSpace + "\tscore=" + score +
                '}';
    }
}
