package com.gpti.bytego.model.entity.classroom;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ClassSubject
{
    @Id
    @Column(name = "classSubjectID", nullable = false, length = 20)
    private String classSubjectID;
    @Column(name = "subject", nullable = false, length = 100)
    private String subject;

    public ClassSubject() {}

    public ClassSubject(String classSubjectID, String subject) {
        this.classSubjectID = classSubjectID;
        this.subject = subject;
    }

    public String getClassSubjectID() {
        return classSubjectID;
    }

    public void setClassSubjectID(String classSubjectID) {
        this.classSubjectID = classSubjectID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
