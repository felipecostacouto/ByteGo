package com.gpti.bytego.model.DAO.Class;


import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.classroom.ClassProfessors;
import com.gpti.bytego.model.entity.classroom.ClassSubject;

import java.util.ArrayList;
import java.util.List;

public class ClassSubjectDao extends GenericDao<ClassSubject>
{
    public void create(String classSubjectID, String subject) {
        if (isDuplicatePrimaryKey(ClassSubject.class, classSubjectID)) return;
        super.create(new ClassSubject(classSubjectID, subject));
    }

    public void create(ClassSubject classSubject) {
        if (isDuplicatePrimaryKey(ClassSubject.class, classSubject.getClassSubjectID())) return;
        super.create(classSubject);
    }

    public void remove(String classSubjectID) {
        super.remove(ClassSubject.class, classSubjectID);
    }

    public void remove(ClassSubject classSubject) {
        super.remove(ClassSubject.class, classSubject.getClassSubjectID());
    }

    public ClassSubject find(String classSubjectID) {
        return super.find(ClassSubject.class, classSubjectID);
    }

    public void update(ClassSubject classSubject) {
        super.update(String.format("UPDATE ClassSubject SET classSubjectID = '%s', subject = '%s' WHERE classSubjectID = '%s'",
                classSubject.getClassSubjectID(),
                classSubject.getSubject(),
                classSubject.getClassSubjectID()));
    }
}
