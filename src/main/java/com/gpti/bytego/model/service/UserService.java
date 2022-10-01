package com.gpti.bytego.model.service;


import com.gpti.bytego.model.DAO.User.AdministratorDao;
import com.gpti.bytego.model.DAO.User.ProfessorDao;
import com.gpti.bytego.model.DAO.User.StudentDao;
import com.gpti.bytego.model.DAO.User.SystemUserDao;
import com.gpti.bytego.model.DTO.ExamDTO;
import com.gpti.bytego.model.DTO.UserDTO;
import com.gpti.bytego.model.entity.user.Administrator;
import com.gpti.bytego.model.entity.user.Professor;
import com.gpti.bytego.model.entity.user.Student;
import com.gpti.bytego.model.entity.user.UserType;

import java.util.ArrayList;

public class UserService
{
    private UserType userType;
    private String name;
    private final String login;
    private final String password;
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
            new StudentDao().create(login, name);
            return new UserDTO(name, login, UserType.STUDENT, null, password);
        }
        else
        {
            return new UserDTO(null, null, null, null, null);
        }
    }

    private boolean userFound()
    {
        SystemUserDao systemUserDao = new SystemUserDao();
        Student student = new StudentDao().find(login);

        if (student != null)
        {
            isPasswordCorrect = systemUserDao.find(student.getStudentPK().getStudentLogin()).getPassword().equals(password);
            name = student.getName();
            userType = UserType.STUDENT;
            return true;
        }
        else
        {
            Professor professor = new ProfessorDao().find(login);

            if (professor != null)
            {
                isPasswordCorrect = systemUserDao.find(professor.getProfessorPK().getProfessorLogin()).getPassword().equals(password);
                name = professor.getName();
                userType = UserType.PROFESSOR;
                return true;
            }
            else
            {
                Administrator administrator = new AdministratorDao().find(login);

                if (administrator != null)
                {
                    isPasswordCorrect = systemUserDao.find(administrator.getAdministratorPK().getADMlogin()).getPassword().equals(password);
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
