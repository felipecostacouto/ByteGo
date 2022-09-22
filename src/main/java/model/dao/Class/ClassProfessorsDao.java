package model.dao.Class;

import model.dao.GenericDao;
import model.entity.Class.ClassProfessors;
import model.entity.Class.ClassProfessorsPK;
import model.entity.Class.ClassSubject;
import model.entity.User.Professor;
import model.entity.User.ProfessorPK;

public class ClassProfessorsDao extends GenericDao<ClassProfessors>
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

    public void update(ClassProfessors classProfessors) {
        super.update(String.format("UPDATE ClassProfessors SET classID = '%s' WHERE classProfessorLogin = '%s'",
                classProfessors.getClassProfessorsPK().getClassID(),
                classProfessors.getClassProfessorsPK().getClassProfessorLogin()));
    }
}
