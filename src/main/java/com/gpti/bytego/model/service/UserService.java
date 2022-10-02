package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.User.AdministratorDao;
import com.gpti.bytego.model.DAO.User.ProfessorDao;
import com.gpti.bytego.model.DAO.User.StudentDao;
import com.gpti.bytego.model.DAO.User.SystemUserDao;
import com.gpti.bytego.model.DTO.ClassDTO;
import com.gpti.bytego.model.DTO.UserDTO;
import com.gpti.bytego.model.entity.user.*;

import java.util.ArrayList;

public class UserService
{
    public UserDTO getUserDTO(String login, String password)
    {
        User user = findUser(login);

        if (user != null)
        {
            if (isPasswordCorrect(login, password))
            {
                return new UserDTO(user.getName(), login, user.getUserType(), getClasses(login, user.getUserType()), password);
            }
            else
            {
                return new UserDTO(null, login, null, null, null);
            }
        }

        return new UserDTO(null, null, null, null, null);
    }

    public UserDTO createNewUser(String login, String password, byte[] imageProfile, String name)
    {
        User user = findUser(login);

        if (user == null)
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

    private User findUser(String username)
    {
        StudentDao studentDao = new StudentDao();
        ProfessorDao professorDao = new ProfessorDao();
        AdministratorDao administratorDao = new AdministratorDao();

        User user = studentDao.find(username);

        if (user == null) {
            user = professorDao.find(username);

            if (user == null) {
                user = administratorDao.find(username);
            }
        }

        return user;
    }

    private boolean isPasswordCorrect(String username, String password)
    {
        return new SystemUserDao().find(username).getPassword().equals(password);
    }

    private ArrayList<ClassDTO> getClasses(String username, UserType userType)
    {
        return new ClassService().getClassesByUser(username, userType);
    }
}
