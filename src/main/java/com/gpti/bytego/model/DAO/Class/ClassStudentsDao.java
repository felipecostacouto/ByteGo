package com.gpti.bytego.model.DAO.Class;


import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.classroom.ClassStudents;
import com.gpti.bytego.model.entity.classroom.ClassStudentsPK;
import com.gpti.bytego.model.entity.classroom.ClassSubject;
import com.gpti.bytego.model.entity.classroom.ClassroomIndicator;
import com.gpti.bytego.model.entity.user.Student;
import com.gpti.bytego.model.entity.user.StudentPK;

import java.util.ArrayList;
import java.util.List;

public class ClassStudentsDao extends GenericDao<ClassStudents> implements ClassDao
{
    public void create(String classID, String classStudentLogin)
    {
        if (isDuplicatePrimaryKey(ClassStudents.class, new ClassStudentsPK(classID, classStudentLogin))) return;
        ClassStudents classStudents = new ClassStudents(new ClassStudentsPK(classID, classStudentLogin));
        classStudents.setStudent(entityManager.getReference(Student.class, new StudentPK(classStudentLogin)));
        classStudents.setClassSubject(entityManager.getReference(ClassSubject.class, classID));
        super.create(classStudents);
    }

    public void create(ClassStudents classStudents)
    {
        if (isDuplicatePrimaryKey(ClassStudents.class, classStudents.getClassStudentsPK())) return;
        classStudents.setStudent(entityManager.getReference(Student.class, new StudentPK(classStudents.getClassStudentsPK().getClassStudentLogin())));
        classStudents.setClassSubject(entityManager.getReference(ClassSubject.class, classStudents.getClassStudentsPK().getClassID()));
        super.create(classStudents);
    }

    public void remove(String classID, String classStudentLogin)
    {
        //TODO: Verificar se tem chaves estrangeiras
        //TODO: Verificar se removendo aqui, remove tbm nas tabelas estrangeiras
        super.remove(ClassStudents.class, new ClassStudentsPK(classID, classStudentLogin));
    }

    public void remove(ClassStudents classStudents)
    {
        super.remove(ClassStudents.class, classStudents.getClassStudentsPK());
    }

    public ClassStudents find(ClassStudents classStudents)
    {
        return super.find(ClassStudents.class, classStudents.getClassStudentsPK());
    }

    public ArrayList<ClassStudents> findAllByStudent(String classStudentLogin)
    {
        ArrayList<ClassStudents> classes = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM ClassStudents WHERE classStudentLogin = '%s'", classStudentLogin),
                ClassStudents.class);
        for (Object obj : list)
        {
            if (obj instanceof ClassStudents)
            {
                ClassSubject classSubject = new ClassSubjectDao().find(((ClassStudents) obj).getClassStudentsPK().getClassID());
                ((ClassStudents) obj).setClassSubject(classSubject);
                classes.add((ClassStudents) obj);
            }
        }

        return classes;
    }

    @Override
    public ArrayList<ClassroomIndicator> findAllByUser(String username) {
        ArrayList<ClassroomIndicator> classes = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM ClassStudents WHERE classStudentLogin = '%s'", username),
                ClassStudents.class);
        for (Object obj : list)
        {
            if (obj instanceof ClassStudents)
            {
                ClassSubject classSubject = new ClassSubjectDao().find(((ClassStudents) obj).getClassStudentsPK().getClassID());
                ((ClassStudents) obj).setClassSubject(classSubject);
                classes.add((ClassStudents) obj);
            }
        }

        return classes;
    }

    public void update(ClassStudents classStudents) {
        super.update(String.format("UPDATE ClassStudents SET classID = '%s' WHERE classStudentLogin = '%s'",
                classStudents.getClassStudentsPK().getClassID(),
                classStudents.getClassStudentsPK().getClassStudentLogin()));
    }
}
