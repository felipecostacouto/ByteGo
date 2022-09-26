package model.entity.user;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student
{
    @EmbeddedId
    private StudentPK studentPK;
    @MapsId(value = "studentLogin")
    @JoinColumn(name = "studentLogin", referencedColumnName = "userLogin")
    @Transient
    private SystemUser systemUser;
    @Column(name = "name", nullable = false, length = 200)
    private String name;

    public Student() {}

    public Student(StudentPK studentPK, String name) {
        this.studentPK = studentPK;
        this.name = name;
    }

    public StudentPK getStudentPK() {
        return studentPK;
    }

    public void setStudentPK(StudentPK studentPK) {
        this.studentPK = studentPK;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
