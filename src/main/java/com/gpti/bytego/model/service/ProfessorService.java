package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.Exam.ExamToTakeDao;
import com.gpti.bytego.model.DAO.Exam.GradedExamDao;
import com.gpti.bytego.model.DTO.ExamDTO;

import java.util.ArrayList;

public class ProfessorService
{
    private final String login;
    private final ExamService examToTakeService = new ExamService(new ExamToTakeDao());
    private final ExamService gradedExamService = new ExamService(new GradedExamDao());

    public ProfessorService(String login)
    {
        this.login = login;
    }

    public ArrayList<ExamDTO> getAllExamsDTO()
    {
        ArrayList<ExamDTO> exams = new ArrayList<>();
        exams.addAll(examToTakeService.getAllExamDTOsByUserLogin(login));
        exams.addAll(gradedExamService.getAllExamDTOsByUserLogin(login));
        return exams;
    }
}
