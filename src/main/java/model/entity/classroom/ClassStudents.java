package model.entity.classroom;

import jakarta.persistence.*;
import model.entity.user.Student;

@Entity
public class ClassStudents
{
    @EmbeddedId
    private ClassStudentsPK classStudentsPK;
    @MapsId(value = "classStudentLogin")
    @JoinColumn(name = "classStudentLogin", referencedColumnName = "studentLogin")
    @Transient
    private Student student;
    @MapsId(value = "classID")
    @JoinColumn(name = "classID", referencedColumnName = "classSubjectID")
    @Transient
    private ClassSubject classSubject;

    public ClassStudents() {}

    public ClassStudents(ClassStudentsPK classStudentsPK) {
        this.classStudentsPK = classStudentsPK;
    }

    public ClassStudentsPK getClassStudentsPK() {
        return classStudentsPK;
    }

    public void setClassStudentsPK(ClassStudentsPK classStudentsPK) {
        this.classStudentsPK = classStudentsPK;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ClassSubject getClassSubject() {
        return classSubject;
    }

    public void setClassSubject(ClassSubject classSubject) {
        this.classSubject = classSubject;
    }
}
