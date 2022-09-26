package model.entity.classroom;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ClassStudentsPK
{
    @Column(name = "classStudentLogin", nullable = false, length = 50)
    private String classStudentLogin;
    @Column(name = "classID", nullable = false, length = 20)
    private String classID;

    public ClassStudentsPK() {}

    public ClassStudentsPK(String classID, String classStudentLogin) {
        this.classStudentLogin = classStudentLogin;
        this.classID = classID;
    }

    public String getClassStudentLogin() {
        return classStudentLogin;
    }

    public void setClassStudentLogin(String classStudentLogin) {
        this.classStudentLogin = classStudentLogin;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ClassStudentsPK)
        {
            return ((ClassStudentsPK) obj).getClassID().equals(classID) &&
                    ((ClassStudentsPK) obj).getClassStudentLogin().equals(classStudentLogin);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
