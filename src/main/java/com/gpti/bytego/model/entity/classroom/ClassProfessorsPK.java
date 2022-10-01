package com.gpti.bytego.model.entity.classroom;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ClassProfessorsPK
{
    @Column(name = "classProfessorLogin", nullable = false, length = 50)
    private String classProfessorLogin;
    @Column(name = "classID", nullable = false, length = 20)
    private String classID;

    public ClassProfessorsPK() {}

    public ClassProfessorsPK(String classID, String classProfessorLogin) {
        this.classProfessorLogin = classProfessorLogin;
        this.classID = classID;
    }

    public String getClassProfessorLogin() {
        return classProfessorLogin;
    }

    public void setClassProfessorLogin(String classProfessorLogin) {
        this.classProfessorLogin = classProfessorLogin;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ClassProfessorsPK)
        {
            return ((ClassProfessorsPK) obj).getClassID().equals(classID) &&
                    ((ClassProfessorsPK) obj).getClassProfessorLogin().equals(classProfessorLogin);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
