package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.Class.ClassDao;
import com.gpti.bytego.model.DAO.Class.ClassProfessorsDao;
import com.gpti.bytego.model.DAO.Class.ClassStudentsDao;
import com.gpti.bytego.model.entity.user.UserType;

public class UserTypeMapper
{
    public static SpecificUserService getUserServiceByUser(String username, UserType userType)
    {
        if (userType == UserType.STUDENT)
        {
            return new StudentService(username);
        }
        else if (userType == UserType.PROFESSOR)
        {
            return new ProfessorService(username);
        }
        else if (userType == UserType.ADMINISTRATOR)
        {
            return new AdministratorService(username);
        }

        return null;
    }

    public static ClassDao getClassDaoByUserType(UserType userType)
    {
        if (userType == UserType.STUDENT)
        {
            return new ClassStudentsDao();
        }
        else if (userType == UserType.PROFESSOR || userType == UserType.ADMINISTRATOR)
        {
            return new ClassProfessorsDao();
        }

        return null;
    }
}
