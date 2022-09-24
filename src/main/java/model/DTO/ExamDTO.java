package model.DTO;

import model.entity.Exam.Question;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ExamDTO
{
    public Long ID;
    public String name;
    public int timeToDeliverInSeconds;
    public int closedQuestionsAmount;
    public int openQuestionsAmount;
    public float score;
    public int openQuestionsGraded;
    public Timestamp limitDateToTake;
    public Timestamp gradedTime;
    public ArrayList<QuestionDTO> questions;

    public ExamDTO(Long ID,
                   String name,
                   int timeToDeliverInSeconds,
                   int closedQuestionsAmount,
                   int openQuestionsAmount,
                   float score,
                   int openQuestionsGraded,
                   Timestamp limitDateToTake,
                   Timestamp gradedTime,
                   ArrayList<QuestionDTO> questions) {
        this.ID = ID;
        this.name = name;
        this.timeToDeliverInSeconds = timeToDeliverInSeconds;
        this.closedQuestionsAmount = closedQuestionsAmount;
        this.openQuestionsAmount = openQuestionsAmount;
        this.score = score;
        this.openQuestionsGraded = openQuestionsGraded;
        this.limitDateToTake = limitDateToTake;
        this.gradedTime = gradedTime;
        this.questions = questions;
    }
}
