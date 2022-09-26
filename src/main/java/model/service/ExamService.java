package model.service;

import model.DAO.Exam.*;
import model.DTO.ExamDTO;
import model.DTO.QuestionDTO;
import model.entity.exam.*;

import java.util.ArrayList;

public class ExamService
{
    SpecificExamDaoInterface examDao;
    QuestionService questionService = new QuestionService();

    public ExamService(SpecificExamDaoInterface examDao)
    {
        this.examDao = examDao;
    }

    ArrayList<ExamDTO> getAllExamDTOsByUserLogin(String login)
    {
        ArrayList<ExamDTO> examsDTOs = new ArrayList<>();

        for (SpecificExamInterface exam : examDao.findAllExamByUserLogin(login))
        {
            Exam parentExam = examDao.findParentExamByID(exam.getID());
            ArrayList<QuestionDTO> questions = questionService.getQuestionsDTOByExamID(parentExam.getID());

            examsDTOs.add(new ExamDTO(
                    parentExam.getID(),
                    parentExam.getName(),
                    parentExam.getTimeToDeliverInSeconds(),
                    parentExam.getClosedQuestionsAmount(),
                    parentExam.getOpenQuestionsAmount(),
                    exam.getSpecificExamDTO(),
                    questions));
        }

        return examsDTOs;
    }
}
