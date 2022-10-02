package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.Class.ClassDao;
import com.gpti.bytego.model.DAO.Class.ClassProfessorsDao;
import com.gpti.bytego.model.DAO.Class.ClassSubjectDao;
import com.gpti.bytego.model.DAO.User.ProfessorDao;
import com.gpti.bytego.model.DTO.ClassDTO;
import com.gpti.bytego.model.entity.classroom.ClassroomIndicator;
import com.gpti.bytego.model.entity.user.UserType;

import java.util.ArrayList;
import java.util.List;

public class ClassService
{
    public ClassDTO create(String username, String subject)
    {
        if (canCreateClasses(username))
        {
            String classID = "USP-EACH-" + subject + "-" + System.currentTimeMillis();
            new ClassSubjectDao().create(classID, subject);
            new ClassProfessorsDao().create(classID, username);
            return new ClassDTO(classID, new ArrayList<>(List.of(username)), subject, null);
        }

        return new ClassDTO(null, new ArrayList<>(List.of(username)), subject, null);
    }

    public ArrayList<ClassDTO> getClassesByUser(String username, UserType userType)
    {
        ArrayList<ClassDTO> classDTOs = new ArrayList<>();
        ClassDao classDao = UserTypeMapper.getClassDaoByUserType(userType);

        for (ClassroomIndicator classFound : classDao.findAllByUser(username))
        {
            classDTOs.add(new ClassDTO(
                    classFound.getClassSubject().getClassSubjectID(),
                    new ProfessorService(username).getAllProfessorsByClass(classFound.getClassSubject().getClassSubjectID()),
                    classFound.getClassSubject().getSubject(),
                    UserTypeMapper.getUserServiceByUser(username, userType).getAllExamsDTO()));
        }

        return classDTOs;
    }

    private boolean canCreateClasses(String username)
    {
        // Somente professores podem criar turmas.
        return new ProfessorDao().find(username) != null;
    }
}
