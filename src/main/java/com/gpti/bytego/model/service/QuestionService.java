package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.Exam.ExamDao;
import com.gpti.bytego.model.DAO.Exam.QuestionDao;
import com.gpti.bytego.model.DTO.QuestionDTO;
import com.gpti.bytego.model.entity.exam.Exam;
import com.gpti.bytego.model.entity.exam.Question;

import java.util.ArrayList;

public class QuestionService
{
    private final ExamDao examDao = new ExamDao();

    public ArrayList<QuestionDTO> getQuestionsDTOByExamID(Long examID)
    {
        Exam exam = examDao.find(examID);
        ArrayList<QuestionDTO> questions = new ArrayList<>();

        for (Question question : new QuestionDao().findAllByExamID(exam.getID()))
        {
            questions.add(new QuestionDTO(
                    question.getQuestionID(),
                    question.getStatement(),
                    question.getStatementImage(),
                    question.getDifficulty(),
                    question.getStudentAnswer(),
                    question.getStudentAnswerImage(),
                    question.getCorrectAnswer(),
                    question.getCorrectAnswerImage(),
                    question.getProfessorComments(),
                    question.getScore()));
        }
        
        return questions;
    }
}
