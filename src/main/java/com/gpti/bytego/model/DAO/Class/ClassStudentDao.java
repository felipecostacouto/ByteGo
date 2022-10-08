package com.gpti.bytego.model.DAO.Class;


import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.classroom.ClassStudent;
import com.gpti.bytego.model.entity.classroom.ClassStudentsPK;
import com.gpti.bytego.model.entity.classroom.ClassSubject;
import com.gpti.bytego.model.entity.classroom.ClassroomIndicator;
import com.gpti.bytego.model.entity.user.Student;
import com.gpti.bytego.model.entity.user.StudentPK;

import java.util.ArrayList;
import java.util.List;

public class ClassStudentDao extends GenericDao<ClassStudent> implements ClassDao
{
    public void create(String classID, String classStudentLogin)
    {
        if (isDuplicatePrimaryKey(ClassStudent.class, new ClassStudentsPK(classID, classStudentLogin))) return;
        ClassStudent classStudent = new ClassStudent(new ClassStudentsPK(classID, classStudentLogin));
        classStudent.setStudent(entityManager.getReference(Student.class, new StudentPK(classStudentLogin)));
        classStudent.setClassSubject(entityManager.getReference(ClassSubject.class, classID));
        super.create(classStudent);
    }

    public void create(ClassStudent classStudent)
    {
        if (isDuplicatePrimaryKey(ClassStudent.class, classStudent.getClassStudentsPK())) return;
        classStudent.setStudent(entityManager.getReference(Student.class, new StudentPK(classStudent.getClassStudentsPK().getClassStudentLogin())));
        classStudent.setClassSubject(entityManager.getReference(ClassSubject.class, classStudent.getClassStudentsPK().getClassID()));
        super.create(classStudent);
    }

    public void remove(String classID, String classStudentLogin)
    {
        //TODO: Verificar se tem chaves estrangeiras
        //TODO: Verificar se removendo aqui, remove tbm nas tabelas estrangeiras
        super.remove(ClassStudent.class, new ClassStudentsPK(classID, classStudentLogin));
    }

    public void remove(ClassStudent classStudent)
    {
        super.remove(ClassStudent.class, classStudent.getClassStudentsPK());
    }

    public ClassStudent find(ClassStudent classStudent)
    {
        return super.find(ClassStudent.class, classStudent.getClassStudentsPK());
    }

    public ArrayList<ClassStudent> findAllByStudent(String classStudentLogin)
    {
        ArrayList<ClassStudent> classes = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM ClassStudent WHERE classStudentLogin = '%s'", classStudentLogin),
                ClassStudent.class);
        for (Object obj : list)
        {
            if (obj instanceof ClassStudent)
            {
                ClassSubject classSubject = new ClassSubjectDao().find(((ClassStudent) obj).getClassStudentsPK().getClassID());
                ((ClassStudent) obj).setClassSubject(classSubject);
                classes.add((ClassStudent) obj);
            }
        }

        return classes;
    }

    @Override
    public ArrayList<ClassroomIndicator> findAllByUser(String username) {
        ArrayList<ClassroomIndicator> classes = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM ClassStudent WHERE classStudentLogin = '%s'", username),
                ClassStudent.class);
        for (Object obj : list)
        {
            if (obj instanceof ClassStudent)
            {
                ClassSubject classSubject = new ClassSubjectDao().find(((ClassStudent) obj).getClassStudentsPK().getClassID());
                ((ClassStudent) obj).setClassSubject(classSubject);
                classes.add((ClassStudent) obj);
            }
        }

        return classes;
    }

    public void update(ClassStudent classStudent) {
        super.update(String.format("UPDATE ClassStudent SET classID = '%s' WHERE classStudentLogin = '%s'",
                classStudent.getClassStudentsPK().getClassID(),
                classStudent.getClassStudentsPK().getClassStudentLogin()));
    }
}
