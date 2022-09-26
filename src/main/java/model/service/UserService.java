package model.service;

import model.DAO.User.SystemUserDao;
import model.DTO.ExamDTO;
import model.DTO.UserDTO;
import model.DAO.User.AdministratorDao;
import model.DAO.User.ProfessorDao;
import model.DAO.User.StudentDao;
import model.entity.User.Administrator;
import model.entity.User.Professor;
import model.entity.User.Student;
import model.entity.User.UserType;

import java.util.ArrayList;

public class UserService
{
    private UserType userType;
    private String name;
    private String login;
    private String password;
    private byte[] imageProfile;
    private boolean isPasswordCorrect = false;

    public UserService(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public UserService(String login, String password, byte[] imageProfile, String name)
    {
        this(login, password);
        this.imageProfile = imageProfile;
        this.name = name;
    }

    public UserDTO getUserDTO()
    {
        // Talvez mandar uma exception?
        if (!userFound()) return new UserDTO(null, null, null, null, null);
        if (!isPasswordCorrect) return new UserDTO(null, login, null, null, null);
        return new UserDTO(name, login, userType, getExams(), password);
    }

    public UserDTO createNewUser()
    {
        if (!userFound())
        {
            new SystemUserDao().create(login, password, imageProfile);
            new StudentDao().create(login, password);
            return new UserDTO(name, login, UserType.STUDENT, null, password);
        }
        else
        {
            return null;
        }
    }

    private boolean userFound()
    {
        Student student = new StudentDao().find(login);

        if (student != null)
        {
            isPasswordCorrect = student.getSystemUser().getPassword().equals(password);
            name = student.getName();
            userType = UserType.STUDENT;
            return true;
        }
        else
        {
            Professor professor = new ProfessorDao().find(login);

            if (professor != null)
            {
                isPasswordCorrect = professor.getSystemUser().getPassword().equals(password);
                name = professor.getName();
                userType = UserType.PROFESSOR;
                return true;
            }
            else
            {
                Administrator administrator = new AdministratorDao().find(login);

                if (administrator != null)
                {
                    isPasswordCorrect = administrator.getSystemUser().getPassword().equals(password);
                    name = administrator.getName();
                    userType = UserType.ADMINISTRATOR;
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
        ArrayList<ExamDTO> exams = new ArrayList<>();

        switch (userType) {
            case STUDENT -> exams.addAll(new StudentService(login).getAllExamsDTO());
            case PROFESSOR -> exams.addAll(new ProfessorService(login).getAllExamsDTO());
            case ADMINISTRATOR -> exams.addAll(new AdministratorService(login).getAllExamsDTO());
        }

        return exams;
    }
}
