package model.entity.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ExamToTakePK
{
    @Column(name = "examID")
    private Long examID;

    public ExamToTakePK() {}

    public ExamToTakePK(Long examID) {
        this.examID = examID;
    }

    public Long getExamID() {
        return examID;
    }

    public void setExamID(Long examID) {
        this.examID = examID;
    }
}
