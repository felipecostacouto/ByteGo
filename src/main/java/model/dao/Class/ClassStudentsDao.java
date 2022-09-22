package model.dao.Class;

import model.dao.GenericDao;
import model.entity.Class.ClassStudents;
import model.entity.Class.ClassStudentsPK;
import model.entity.Class.ClassSubject;
import model.entity.User.Student;
import model.entity.User.StudentPK;

public class ClassStudentsDao extends GenericDao<ClassStudents>
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

    public void update(ClassStudents classStudents) {
        super.update(String.format("UPDATE ClassStudents SET classID = '%s' WHERE classStudentLogin = '%s'",
                classStudents.getClassStudentsPK().getClassID(),
                classStudents.getClassStudentsPK().getClassStudentLogin()));
    }
}
