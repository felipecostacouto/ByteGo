package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.Exam.SpecificExamDaoInterface;
import com.gpti.bytego.model.DTO.ExamDTO;
import com.gpti.bytego.model.DTO.QuestionDTO;
import com.gpti.bytego.model.entity.exam.Exam;
import com.gpti.bytego.model.entity.exam.SpecificExamInterface;

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
