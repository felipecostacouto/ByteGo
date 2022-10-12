package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.Class.ClassDao;
import com.gpti.bytego.model.DAO.Class.ClassProfessorDao;
import com.gpti.bytego.model.DAO.Class.ClassSubjectDao;
import com.gpti.bytego.model.DAO.User.ProfessorDao;
import com.gpti.bytego.model.DTO.ClassDTO;
import com.gpti.bytego.model.DTO.UserDTO;
import com.gpti.bytego.model.entity.classroom.ClassroomIndicator;

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
            new ClassProfessorDao().create(classID, username);
            return new ClassDTO(classID, new ArrayList<>(List.of(username)), subject, null);
        }

        return new ClassDTO(null, new ArrayList<>(List.of(username)), subject, null);
    }

    public void fillUserWithClasses(UserDTO userDTO)
    {
        userDTO.classes = new ArrayList<>();
        ClassDao classDao = UserTypeMapper.getClassDaoByUserType(userDTO.userType);

        for (ClassroomIndicator classFound : classDao.findAllByUser(userDTO.login))
        {
            String classID = classFound.getClassSubject().getClassSubjectID();
            String classSubject = classFound.getClassSubject().getSubject();
            ArrayList<String> classProfessors = new ProfessorService().getAllProfessorsByClass(classID);

            ClassDTO classDTO = new ClassDTO(classID, classProfessors, classSubject, null);
            userDTO.classes.add(classDTO);

            new ExamService().fillClassWithExams(classDTO, userDTO.userType, userDTO.login);
        }
    }

    private boolean canCreateClasses(String username)
    {
        // Somente professores podem criar turmas.
        return new ProfessorDao().find(username) != null;
    }
}
