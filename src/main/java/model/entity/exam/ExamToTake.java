package model.entity.exam;

import jakarta.persistence.*;
import model.DTO.SpecificExamDTO;
import model.entity.user.Student;

import java.sql.Timestamp;

@Entity
@Table(name = "ExamToTake")
public class ExamToTake implements SpecificExamInterface
{
    @EmbeddedId
    private ExamToTakePK examToTakePK;
    @MapsId(value = "examID")
    @JoinColumn(name = "examID", referencedColumnName = "ID")
    @Transient
    private Exam exam;
    @ManyToOne
    @JoinColumn(name = "examToTakeStudentLogin")
    private Student student;
    @Column(name = "limitDate", nullable = false)
    private Timestamp limitDate;

    public ExamToTake() {}

    public ExamToTake(ExamToTakePK examToTakePK, Student student, Timestamp limitDate) {
        this.examToTakePK = examToTakePK;
        this.student = student;
        this.limitDate = limitDate;
    }

    @Override
    public Long getID() {
        return examToTakePK.getExamID();
    }

    @Override
    public SpecificExamDTO getSpecificExamDTO() {
        return new SpecificExamDTO(ExamType.EXAM_TO_TAKE,0, 0, limitDate, null);
    }

    public Timestamp getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Timestamp limitDate) {
        this.limitDate = limitDate;
    }

    public ExamToTakePK getExamToTakePK() {
        return examToTakePK;
    }

    public void setExamToTakePK(ExamToTakePK examToTakePK) {
        this.examToTakePK = examToTakePK;
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
}
