package com.gpti.bytego.model.DTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class QuestionDTO
{
    public Long questionID;
    public String statement;
    public byte[] statementImage;
    public int difficulty;
    public String correctAnswer;
    public byte[] correctAnswerImage;
    public ArrayList<QuestionAlternativeDTO> alternatives;
    public QuestionAnswerDTO answer;
    public Set<String> subjectTags;

    public QuestionDTO(Long questionID,
                       String statement,
                       byte[] statementImage,
                       int difficulty,
                       String correctAnswer,
                       byte[] correctAnswerImage,
                       ArrayList<QuestionAlternativeDTO> alternatives,
                       QuestionAnswerDTO answer,
                       Set<String> subjectTags)
    {
        this.questionID = questionID;
        this.statement = statement;
        this.statementImage = statementImage;
        this.difficulty = difficulty;
        this.correctAnswer = correctAnswer;
        this.correctAnswerImage = correctAnswerImage;
        this.alternatives = alternatives;
        this.answer = answer;
        this.subjectTags = subjectTags;
    }

    public Set<String> getSubjectTags() {
        return subjectTags;
    }

    public QuestionAnswerDTO getAnswer() {
        return answer;
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

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public byte[] getCorrectAnswerImage() {
        return correctAnswerImage;
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
                ",\n" + tagsSpace + "\tcorrectAnswer='" + correctAnswer + '\'' +
                ",\n" + tagsSpace + "\tcorrectAnswerImage=" + Arrays.toString(correctAnswerImage) +
                '}';
    }
}
