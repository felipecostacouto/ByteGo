package model.DTO;

import java.sql.Timestamp;

public class SpecificExamDTO
{
    public String examType;
    public float score;
    public int openQuestionsGraded;
    public Timestamp limitDateToTake;
    public Timestamp gradedTime;

    public SpecificExamDTO(String examType,
                           float score,
                           int openQuestionsGraded,
                           Timestamp limitDateToTake,
                           Timestamp gradedTime)
    {
        this.examType = examType;
        this.score = score;
        this.openQuestionsGraded = openQuestionsGraded;
        this.limitDateToTake = limitDateToTake;
        this.gradedTime = gradedTime;
    }
}
