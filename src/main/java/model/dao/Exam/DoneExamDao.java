package model.dao.Exam;

import model.dao.GenericDao;
import model.entity.Exam.DoneExam;
import model.entity.Exam.DoneExamPK;
import model.entity.Exam.Exam;
import model.entity.User.Student;
import model.entity.User.StudentPK;

public class DoneExamDao extends GenericDao<DoneExam>
{
    public void create(Long examID, String studentLogin, float score)
    {
        if (isDuplicatePrimaryKey(DoneExam.class, new DoneExamPK(examID))) return;
        DoneExam doneExam = new DoneExam();
        doneExam.setDoneExamPK(new DoneExamPK(examID));
        doneExam.setExam(entityManager.getReference(Exam.class, examID));
        doneExam.setStudent(entityManager.getReference(Student.class, new StudentPK(studentLogin)));
        doneExam.setScore(score);
        super.create(doneExam);
    }

    public void create(DoneExam doneExam)
    {
        if (isDuplicatePrimaryKey(DoneExam.class, doneExam.getDoneExamPK())) return;
        doneExam.setExam(entityManager.getReference(Exam.class, doneExam.getExam().getID()));
        doneExam.setStudent(entityManager.getReference(Student.class, doneExam.getStudent().getStudentPK()));
        super.create(doneExam);
    }

    public void remove(Long examID)
    {
        super.remove(DoneExam.class, new DoneExamPK(examID));
    }

    public void remove(DoneExam doneExam)
    {
        super.remove(DoneExam.class, doneExam.getDoneExamPK());
    }

    public DoneExam find(Long examID)
    {
        return super.find(DoneExam.class, new DoneExamPK(examID));
    }

    public void update(DoneExam doneExam)
    {
        super.update(String.format("UPDATE DoneExam SET score = %.2f WHERE examID = %d",
                doneExam.getScore(),
                doneExam.getDoneExamPK().getExamID()));
    }
}
