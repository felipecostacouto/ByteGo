package model.service;

import model.DAO.Exam.ExamToTakeDao;
import model.DAO.Exam.GradedExamDao;
import model.DTO.ExamDTO;

import java.util.ArrayList;

public class StudentService
{
    private final String login;
    private final ExamService examToTakeService = new ExamService(new ExamToTakeDao());
    private final ExamService gradedExamService = new ExamService(new GradedExamDao());

    public StudentService(String login)
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
