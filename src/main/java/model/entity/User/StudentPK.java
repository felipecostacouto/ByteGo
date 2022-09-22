package model.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class StudentPK
{
    @Column(name = "studentLogin")
    private String studentLogin;

    public StudentPK() {}

    public StudentPK(String studentLogin) {
        this.studentLogin = studentLogin;
    }

    public String getStudentLogin() {
        return studentLogin;
    }

    public void setStudentLogin(String student_Login) {
        this.studentLogin = student_Login;
    }

    @Override
    public String toString() {
        return studentLogin;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StudentPK)
        {
            return ((StudentPK) obj).getStudentLogin().equals(studentLogin);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
