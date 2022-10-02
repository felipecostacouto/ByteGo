package com.gpti.bytego.model.DAO.Class;

import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.classroom.ClassProfessors;
import com.gpti.bytego.model.entity.classroom.ClassProfessorsPK;
import com.gpti.bytego.model.entity.classroom.ClassSubject;
import com.gpti.bytego.model.entity.classroom.ClassroomIndicator;
import com.gpti.bytego.model.entity.user.Professor;
import com.gpti.bytego.model.entity.user.ProfessorPK;

import java.util.ArrayList;
import java.util.List;

public class ClassProfessorsDao extends GenericDao<ClassProfessors> implements ClassDao
{
    public void create(String classID, String classProfessorLogin)
    {
        if (isDuplicatePrimaryKey(ClassProfessors.class, new ClassProfessorsPK(classID, classProfessorLogin))) return;
        ClassProfessors classProfessors = new ClassProfessors(new ClassProfessorsPK(classID, classProfessorLogin));
        classProfessors.setProfessor(entityManager.getReference(Professor.class, new ProfessorPK(classProfessorLogin)));
        classProfessors.setClassSubject(entityManager.getReference(ClassSubject.class, classID));
        super.create(classProfessors);
    }

    public void create(ClassProfessors classProfessors)
    {
        if (isDuplicatePrimaryKey(ClassProfessors.class, classProfessors.getClassProfessorsPK())) return;
        classProfessors.setProfessor(entityManager.getReference(Professor.class, new ProfessorPK(classProfessors.getClassProfessorsPK().getClassProfessorLogin())));
        classProfessors.setClassSubject(entityManager.getReference(ClassSubject.class, classProfessors.getClassProfessorsPK().getClassID()));
        super.create(classProfessors);
    }

    public void remove(String classID, String classProfessorLogin)
    {
        super.remove(ClassProfessors.class, new ClassProfessorsPK(classID, classProfessorLogin));
    }

    public ClassProfessors find(ClassProfessors classProfessors)
    {
        return super.find(ClassProfessors.class, classProfessors.getClassProfessorsPK());
    }

    public ArrayList<ClassProfessors> findAllByProfessor(String classProfessorLogin)
    {
        ArrayList<ClassProfessors> classes = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM ClassProfessors WHERE classProfessorLogin = '%s'", classProfessorLogin),
                ClassProfessors.class);

        return getClassProfessors(classes, list);
    }

    @Override
    public ArrayList<ClassroomIndicator> findAllByUser(String username) {
        ArrayList<ClassroomIndicator> classes = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM ClassProfessors WHERE classProfessorLogin = '%s'", username),
                ClassProfessors.class);

        for (Object obj : list)
        {
            if (obj instanceof ClassProfessors)
            {
                ClassSubject classSubject = new ClassSubjectDao().find(((ClassProfessors) obj).getClassSubject().getClassSubjectID());
                ((ClassProfessors) obj).setClassSubject(classSubject);
                classes.add((ClassProfessors) obj);
            }
        }

        return classes;
    }

    public ArrayList<ClassProfessors> findAllByClass(String classID)
    {
        ArrayList<ClassProfessors> classes = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM ClassProfessors WHERE classID = '%s'", classID),
                ClassProfessors.class);

        return getClassProfessors(classes, list);
    }

    public void update(ClassProfessors classProfessors) {
        super.update(String.format("UPDATE ClassProfessors SET classID = '%s' WHERE classProfessorLogin = '%s'",
                classProfessors.getClassProfessorsPK().getClassID(),
                classProfessors.getClassProfessorsPK().getClassProfessorLogin()));
    }

    private ArrayList<ClassProfessors> getClassProfessors(ArrayList<ClassProfessors> classes, List<?> list)
    {
        for (Object obj : list)
        {
            if (obj instanceof ClassProfessors)
            {
                ClassSubject classSubject = new ClassSubjectDao().find(((ClassProfessors) obj).getClassSubject().getClassSubjectID());
                ((ClassProfessors) obj).setClassSubject(classSubject);
                classes.add((ClassProfessors) obj);
            }
        }

        return classes;
    }
}
