package model.DAO.User;

import model.DAO.GenericDao;
import model.entity.User.Student;
import model.entity.User.StudentPK;
import model.entity.User.SystemUser;

public class StudentDao extends GenericDao<Student>
{
    public void create(String studentLogin, String name) {
        if (isDuplicatePrimaryKey(Student.class, new StudentPK(studentLogin))) return;
        if (!doesExistForeignKey(studentLogin)) return;
        Student student = new Student(new StudentPK(studentLogin), name);
        student.setSystemUser(entityManager.getReference(SystemUser.class, studentLogin));
        student.setName(name);
        super.create(student);
    }

    public void create(Student student) {
        if (isDuplicatePrimaryKey(Student.class, student.getStudentPK())) return;
        if (!doesExistForeignKey(student.getStudentPK().getStudentLogin())) return;
        super.create(student);
    }

    public void remove(String studentLogin) {
        if (!doesExistForeignKey(studentLogin)) return;
        super.remove(Student.class, new StudentPK(studentLogin));
    }

    public void remove(Student student) {
        if (!doesExistForeignKey(student.getStudentPK().getStudentLogin())) return;
        super.remove(Student.class, student.getStudentPK());
    }

    public Student find(String studentLogin) {
        return super.find(Student.class, new StudentPK(studentLogin));
    }

    public void update(Student student) {
        super.update(String.format("UPDATE Student SET name = '%s' WHERE studentLogin = '%s'",
                student.getName(),
                student.getStudentPK().getStudentLogin()));
    }

    private boolean doesExistForeignKey(String studentLogin)
    {
        if (new SystemUserDao().find(studentLogin) == null)
        {
            System.out.println("Does not exist a student with login " + studentLogin +
                    " on referenced entity SystemUser");
            return false;
        }
        return true;
    }
}
