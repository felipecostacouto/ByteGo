package model.DTO;

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
}
