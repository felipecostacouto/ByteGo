package model.entity.Exam;

import jakarta.persistence.*;
import model.entity.User.Student;

@Entity
@Table(name = "DoneExam")
public class DoneExam
{
    @EmbeddedId
    private DoneExamPK doneExamPK;
    @MapsId(value = "examID")
    @JoinColumn(name = "examID", referencedColumnName = "ID")
    @Transient
    private Exam exam;
    @ManyToOne
    @JoinColumn(name = "doneExamStudentLogin")
    private Student student;
    @Column(name = "score", nullable = false, updatable = false)
    private Float score;

    public DoneExam() {}

    public DoneExam(DoneExamPK doneExamPK, Student student, Float score) {
        this.doneExamPK = doneExamPK;
        this.student = student;
        this.score = score;
    }

    public DoneExamPK getDoneExamPK() {
        return doneExamPK;
    }

    public void setDoneExamPK(DoneExamPK doneExamPK) {
        this.doneExamPK = doneExamPK;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
