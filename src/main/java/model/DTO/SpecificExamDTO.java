package model.DTO;

import model.entity.Exam.ExamType;

import java.sql.Timestamp;

public class SpecificExamDTO
{
    public ExamType examType;
    public float score;
    public int openQuestionsGraded;
    public Timestamp limitDateToTake;
    public Timestamp gradedTime;

    public SpecificExamDTO(ExamType examType,
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
