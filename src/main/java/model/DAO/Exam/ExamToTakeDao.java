package model.DAO.Exam;

import model.DAO.GenericDao;
import model.entity.Exam.Exam;
import model.entity.Exam.SpecificExamInterface;
import model.entity.Exam.ExamToTake;
import model.entity.Exam.ExamToTakePK;
import model.entity.User.Student;
import model.entity.User.StudentPK;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ExamToTakeDao extends GenericDao<ExamToTake> implements SpecificExamDaoInterface
{
    public void create(Long examID, String studentLogin, Timestamp limitDate)
    {
        if (isDuplicatePrimaryKey(ExamToTake.class, new ExamToTakePK(examID))) return;
        ExamToTake examToTake = new ExamToTake();
        examToTake.setExamToTakePK(new ExamToTakePK(examID));
        examToTake.setExam(entityManager.getReference(Exam.class, examID));
        examToTake.setStudent(entityManager.getReference(Student.class, new StudentPK(studentLogin)));
        examToTake.setLimitDate(limitDate);
        super.create(examToTake);
    }

    public void create(ExamToTake examToTake)
    {
        if (isDuplicatePrimaryKey(ExamToTake.class, examToTake.getExamToTakePK())) return;
        examToTake.setExam(entityManager.getReference(Exam.class, examToTake.getExam().getID()));
        examToTake.setStudent(entityManager.getReference(Student.class, examToTake.getStudent().getStudentPK()));
        super.create(examToTake);
    }

    public void remove(Long examID)
    {
        super.remove(ExamToTake.class, new ExamToTakePK(examID));
    }

    public void remove(ExamToTake examToTake)
    {
        super.remove(ExamToTake.class, examToTake.getExamToTakePK());
    }

    public ExamToTake find(Long examID)
    {
        return super.find(ExamToTake.class, new ExamToTakePK(examID));
    }

    @Override
    public ArrayList<SpecificExamInterface> findAllExamByUserLogin(String login) {
        ArrayList<SpecificExamInterface> exams = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM ExamToTake WHERE examToTakeStudentLogin = '%s'", login),
                ExamToTake.class);
        for (Object obj : list) if (obj instanceof ExamToTake) exams.add((ExamToTake) obj);

        return exams;
    }

    @Override
    public Exam findParentExamByID(Long examID) {
        return new ExamDao().find(examID);
    }

    public void update(ExamToTake examToTake)
    {
        super.update(String.format("UPDATE ExamToTake SET limitDate = '%s' WHERE examID = %d",
                examToTake.getLimitDate(),
                examToTake.getExamToTakePK().getExamID()));
    }
}
