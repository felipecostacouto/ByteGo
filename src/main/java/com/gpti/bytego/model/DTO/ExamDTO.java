package com.gpti.bytego.model.DTO;

import java.util.ArrayList;

public class ExamDTO
{
    public Long ID;
    public String name;
    public int timeToDeliverInSeconds;
    public int closedQuestionsAmount;
    public int openQuestionsAmount;
    public SpecificExamDTO specificExamDTO;
    public ArrayList<QuestionDTO> questions;

    public ExamDTO(Long ID,
                   String name,
                   int timeToDeliverInSeconds,
                   int closedQuestionsAmount,
                   int openQuestionsAmount,
                   SpecificExamDTO specificExamDTO,
                   ArrayList<QuestionDTO> questions)
    {
        this.ID = ID;
        this.name = name;
        this.timeToDeliverInSeconds = timeToDeliverInSeconds;
        this.closedQuestionsAmount = closedQuestionsAmount;
        this.openQuestionsAmount = openQuestionsAmount;
        this.specificExamDTO = specificExamDTO;
        this.questions = questions;
    }

    public Long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getTimeToDeliverInSeconds() {
        return timeToDeliverInSeconds;
    }

    public int getClosedQuestionsAmount() {
        return closedQuestionsAmount;
    }

    public int getOpenQuestionsAmount() {
        return openQuestionsAmount;
    }

    public SpecificExamDTO getSpecificExamDTO() {
        return specificExamDTO;
    }

    public ArrayList<QuestionDTO> getQuestions() {
        return questions;
    }

    public String getPrintExamInfo(int numberOfTags)
    {
        String tagsSpace = "";
        for (int i = 0; i < numberOfTags; i++) tagsSpace = tagsSpace.concat("\t");
        String specificExamInfo = specificExamDTO.getPrintSpecificExamInfo(numberOfTags + 2);
        String questionsPrints = "";
        if (questions != null) {
            for (QuestionDTO questionDTO : questions) questionsPrints = questionsPrints.concat(questionDTO.getPrintQuestionInfo(numberOfTags + 2));
        }

        return "\n" + tagsSpace + "ExamDTO{" +
                "\n" + tagsSpace + "\tID=" + ID +
                ", \n" + tagsSpace + "\tname='" + name + '\'' +
                ", \n" + tagsSpace + "\ttimeToDeliverInSeconds=" + timeToDeliverInSeconds +
                ", \n" + tagsSpace + "\tclosedQuestionsAmount=" + closedQuestionsAmount +
                ", \n" + tagsSpace + "\topenQuestionsAmount=" + openQuestionsAmount +
                ", \n" + tagsSpace + "\tspecificExamDTO=" + specificExamInfo +
                ", \n" + tagsSpace + "\tquestions=" + questionsPrints +
                "}";
    }
}
