package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.User.AdministratorDao;
import com.gpti.bytego.model.DAO.User.ProfessorDao;
import com.gpti.bytego.model.DAO.User.StudentDao;
import com.gpti.bytego.model.DAO.User.SystemUserDao;
import com.gpti.bytego.model.DTO.UserDTO;
import com.gpti.bytego.model.entity.user.*;

public class UserService
{
    public UserDTO getUserDTO(String login, String password)
    {
        UserDTO userFound = findUser(login);

        if (userFound != null)
        {
            if (isPasswordCorrect(login, password))
            {
                userFound.password = password;
                fillClasses(userFound);
                return userFound;
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
        UserDTO userFound = findUser(login);

        if (userFound == null)
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

    private UserDTO findUser(String username)
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

        if (user == null) return null;
        return new UserDTO(user.getName(), username, user.getUserType(), null, null);
    }

    private boolean isPasswordCorrect(String username, String password)
    {
        return new SystemUserDao().find(username).getPassword().equals(password);
    }

    private void fillClasses(UserDTO userDTO)
    {
        new ClassService().fillClassesByUserDTO(userDTO);
    }
}
