package com.gpti.bytego.model.entity.classroom;

import com.gpti.bytego.model.entity.user.Professor;
import jakarta.persistence.*;

@Entity
@Table(name = "ClassProfessor")
public class ClassProfessor implements ClassroomIndicator
{
    @EmbeddedId
    private ClassProfessorsPK classProfessorsPK;
    @MapsId(value = "classProfessorLogin")
    @JoinColumn(name = "classProfessorLogin", referencedColumnName = "professorLogin")
    @Transient
    private Professor professor;
    @MapsId(value = "classID")
    @JoinColumn(name = "classID", referencedColumnName = "classSubjectID")
    @Transient
    private ClassSubject classSubject;

    public ClassProfessor() {}

    public ClassProfessor(ClassProfessorsPK classProfessorsPK) {
        this.classProfessorsPK = classProfessorsPK;
    }

    public ClassProfessorsPK getClassProfessorsPK() {
        return classProfessorsPK;
    }

    public void setClassProfessorsPK(ClassProfessorsPK classProfessorsPK) {
        this.classProfessorsPK = classProfessorsPK;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public ClassSubject getClassSubject() {
        return classSubject;
    }

    public void setClassSubject(ClassSubject classSubject) {
        this.classSubject = classSubject;
    }
}
