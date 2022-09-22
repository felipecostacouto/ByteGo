package model.entity.Exam;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DoneExamPK
{
    @Column(name = "examID")
    private Long examID;

    public DoneExamPK() {}

    public DoneExamPK(Long examID) {
        this.examID = examID;
    }

    public Long getExamID() {
        return examID;
    }

    public void setExamID(Long examID) {
        this.examID = examID;
    }
}
