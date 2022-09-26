package model.service;

import model.DAO.Exam.ExamToGradeDao;
import model.DAO.Exam.ExamToTakeDao;
import model.DAO.Exam.GradedExamDao;
import model.DAO.User.SystemUserDao;
import model.DTO.ExamDTO;
import model.entity.user.SystemUser;

import java.util.ArrayList;

public class AdministratorService
{
    private final String login;

    public AdministratorService(String login)
    {
        this.login = login;
    }

    public ArrayList<ExamDTO> getAllExamsDTO()
    {
        ArrayList<ExamDTO> exams = new ArrayList<>();
        SystemUserDao systemUserDao = new SystemUserDao();

        for (SystemUser systemUser : systemUserDao.findAll())
        {
            exams.addAll(new ExamService(new ExamToTakeDao()).getAllExamDTOsByUserLogin(systemUser.getUserLogin()));
            exams.addAll(new ExamService(new ExamToGradeDao()).getAllExamDTOsByUserLogin(systemUser.getUserLogin()));
            exams.addAll(new ExamService(new GradedExamDao()).getAllExamDTOsByUserLogin(systemUser.getUserLogin()));
        }

        return exams;
    }
}
