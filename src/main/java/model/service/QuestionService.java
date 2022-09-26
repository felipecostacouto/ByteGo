package model.service;

import model.DAO.Exam.ExamDao;
import model.DAO.Exam.QuestionDao;
import model.DTO.QuestionDTO;
import model.entity.exam.Exam;
import model.entity.exam.Question;

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
                    question.getAnswerText(),
                    question.getAnswerImage(),
                    question.getProfessorComments()));
        }
        
        return questions;
    }
}
