package com.gpti.bytego.model.DAO.Class;

import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.DAO.User.ProfessorDao;
import com.gpti.bytego.model.entity.classroom.ClassProfessor;
import com.gpti.bytego.model.entity.classroom.ClassProfessorsPK;
import com.gpti.bytego.model.entity.classroom.ClassSubject;
import com.gpti.bytego.model.entity.classroom.ClassroomIndicator;
import com.gpti.bytego.model.entity.user.Professor;
import com.gpti.bytego.model.entity.user.ProfessorPK;

import java.util.ArrayList;
import java.util.List;

public class ClassProfessorDao extends GenericDao<ClassProfessor> implements ClassDao
{
    public void create(String classID, String classProfessorLogin)
    {
        if (isDuplicatePrimaryKey(ClassProfessor.class, new ClassProfessorsPK(classID, classProfessorLogin))) return;
        ClassProfessor classProfessor = new ClassProfessor(new ClassProfessorsPK(classID, classProfessorLogin));
        classProfessor.setProfessor(entityManager.getReference(Professor.class, new ProfessorPK(classProfessorLogin)));
        classProfessor.setClassSubject(entityManager.getReference(ClassSubject.class, classID));
        super.create(classProfessor);
    }

    public void create(ClassProfessor classProfessor)
    {
        if (isDuplicatePrimaryKey(ClassProfessor.class, classProfessor.getClassProfessorsPK())) return;
        classProfessor.setProfessor(entityManager.getReference(Professor.class, new ProfessorPK(classProfessor.getClassProfessorsPK().getClassProfessorLogin())));
        classProfessor.setClassSubject(entityManager.getReference(ClassSubject.class, classProfessor.getClassProfessorsPK().getClassID()));
        super.create(classProfessor);
    }

    public void remove(String classID, String classProfessorLogin)
    {
        super.remove(ClassProfessor.class, new ClassProfessorsPK(classID, classProfessorLogin));
    }

    public ClassProfessor find(ClassProfessor classProfessor)
    {
        return super.find(ClassProfessor.class, classProfessor.getClassProfessorsPK());
    }

    public ArrayList<ClassProfessor> findAllByProfessor(String classProfessorLogin)
    {
        ArrayList<ClassProfessor> classes = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM ClassProfessor WHERE classProfessorLogin = '%s'", classProfessorLogin),
                ClassProfessor.class);

        return getClassProfessors(classes, list);
    }

    @Override
    public ArrayList<ClassroomIndicator> findAllByUser(String username) {
        ArrayList<ClassroomIndicator> classes = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM ClassProfessor WHERE classProfessorLogin = '%s'", username),
                ClassProfessor.class);

        for (Object obj : list)
        {
            if (obj instanceof ClassProfessor)
            {
                ClassSubject classSubject = new ClassSubjectDao().find(((ClassProfessor) obj).getClassSubject().getClassSubjectID());
                ((ClassProfessor) obj).setClassSubject(classSubject);
                classes.add((ClassProfessor) obj);
            }
        }

        return classes;
    }

    public ArrayList<ClassProfessor> findAllByClass(String classID)
    {
        ArrayList<ClassProfessor> classes = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM ClassProfessor WHERE classID = '%s'", classID),
                ClassProfessor.class);

        return getClassProfessors(classes, list);
    }

    public void update(ClassProfessor classProfessor) {
        super.update(String.format("UPDATE ClassProfessor SET classID = '%s' WHERE classProfessorLogin = '%s'",
                classProfessor.getClassProfessorsPK().getClassID(),
                classProfessor.getClassProfessorsPK().getClassProfessorLogin()));
    }

    private ArrayList<ClassProfessor> getClassProfessors(ArrayList<ClassProfessor> classes, List<?> list)
    {
        for (Object obj : list)
        {
            if (obj instanceof ClassProfessor)
            {
                ClassSubject classSubject = new ClassSubjectDao().find(((ClassProfessor) obj).getClassProfessorsPK().getClassID());
                Professor professor = new ProfessorDao().find(((ClassProfessor) obj).getClassProfessorsPK().getClassProfessorLogin());
                ((ClassProfessor) obj).setClassSubject(classSubject);
                ((ClassProfessor) obj).setProfessor(professor);
                classes.add((ClassProfessor) obj);
            }
        }

        return classes;
    }
}
