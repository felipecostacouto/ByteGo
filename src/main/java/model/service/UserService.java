package model.service;

import model.DAO.Exam.ExamDao;
import model.DAO.Exam.ExamToTakeDao;
import model.DAO.Exam.QuestionDao;
import model.DTO.ExamDTO;
import model.DTO.QuestionDTO;
import model.DTO.UserDTO;
import model.DAO.User.AdministratorDao;
import model.DAO.User.ProfessorDao;
import model.DAO.User.StudentDao;
import model.entity.Exam.Exam;
import model.entity.Exam.ExamToTake;
import model.entity.Exam.Question;
import model.entity.User.Administrator;
import model.entity.User.Professor;
import model.entity.User.Student;

import java.util.ArrayList;
import java.util.List;

public class UserService
{
    private String userType;
    private String name;
    private String login;
    private String password;
    private boolean isPasswordCorrect = false;

    public UserService(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public UserDTO getUserDTO()
    {
        if (!userFound()) return new UserDTO(null, null, null, null, null);
        if (!isPasswordCorrect) return new UserDTO(null, login, null, null, null);
        return new UserDTO(name, login, userType, getExams(), password);
    }

    private boolean userFound()
    {
        Student student = new StudentDao().find(login);

        if (student != null)
        {
            isPasswordCorrect = student.getSystemUser().getPassword().equals(password);
            name = student.getName();
            userType = "Student";
            return true;
        }
        else
        {
            Professor professor = new ProfessorDao().find(login);

            if (professor != null)
            {
                isPasswordCorrect = professor.getSystemUser().getPassword().equals(password);
                name = professor.getName();
                userType = "Professor";
                return true;
            }
            else
            {
                Administrator administrator = new AdministratorDao().find(login);

                if (administrator != null)
                {
                    isPasswordCorrect = administrator.getSystemUser().getPassword().equals(password);
                    name = administrator.getName();
                    userType = "Administrator";
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
    }

    private ArrayList<ExamDTO> getExams()
    {
        ExamService examService = new ExamService();
        ArrayList<ExamDTO> exams = new ArrayList<>();

        if (userType.equals("Student"))
        {
            exams.addAll(examService.getExamToTakeDTOByStudent(login));
            exams.addAll(examService.getDoneExamDTOByStudent(login));
        } else if (userType.equals("Professor"))
        {
            exams.addAll(examService.getExamToGradeDTOByProfessor(login));
            exams.addAll(examService.getGradedExamDTOByProfessor(login));
        } else
        {
            exams.addAll(examService.getExamToTakeDTOByStudent(login));
            exams.addAll(examService.getDoneExamDTOByStudent(login));
            exams.addAll(examService.getExamToGradeDTOByProfessor(login));
            exams.addAll(examService.getGradedExamDTOByProfessor(login));
        }

        return exams;
    }
}
