package model.DAO.Exam;

import model.DAO.GenericDao;
import model.entity.exam.Exam;
import model.entity.exam.SpecificExamInterface;
import model.entity.exam.GradedExam;
import model.entity.exam.GradedExamPK;
import model.entity.user.Professor;
import model.entity.user.ProfessorPK;
import model.entity.user.Student;
import model.entity.user.StudentPK;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class GradedExamDao extends GenericDao<GradedExam> implements SpecificExamDaoInterface
{
    public void create(Long examID, String professorLogin, String studentLogin, Timestamp gradedTime, Float score)
    {
        if (isDuplicatePrimaryKey(GradedExam.class, new GradedExamPK(examID))) return;
        GradedExam gradedExam = new GradedExam();
        gradedExam.setExam(entityManager.getReference(Exam.class, examID));
        gradedExam.setProfessor(entityManager.getReference(Professor.class, new ProfessorPK(professorLogin)));
        gradedExam.setStudent(entityManager.getReference(Student.class, new StudentPK(studentLogin)));
        gradedExam.setGradedTime(gradedTime);
        gradedExam.setScore(score);
        super.create(gradedExam);
    }

    public void create(GradedExam gradedExam)
    {
        if (isDuplicatePrimaryKey(GradedExam.class, gradedExam.getGradedExamPK())) return;
        gradedExam.setExam(entityManager.getReference(Exam.class, gradedExam.getGradedExamPK().getExamID()));
        gradedExam.setProfessor(entityManager.getReference(Professor.class, gradedExam.getProfessor().getProfessorPK()));
        gradedExam.setStudent(entityManager.getReference(Student.class, gradedExam.getStudent().getStudentPK()));
        super.create(gradedExam);
    }

    public void remove(Long examID)
    {
        super.remove(GradedExam.class, new GradedExamPK(examID));
    }

    public void remove(GradedExam gradedExam)
    {
        super.remove(GradedExam.class, gradedExam.getGradedExamPK());
    }

    public GradedExam find(Long examID)
    {
        return super.find(GradedExam.class, new GradedExamPK(examID));
    }

    @Override
    public ArrayList<SpecificExamInterface> findAllExamByUserLogin(String login) {
        ArrayList<SpecificExamInterface> exams = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM GradedExam WHERE gradedExamProfessorLogin = '%s'", login),
                GradedExam.class);
        for (Object obj : list) if (obj instanceof GradedExam) exams.add((GradedExam) obj);

        return exams;
    }

    @Override
    public Exam findParentExamByID(Long examID) {
        return new ExamDao().find(examID);
    }

    public void update(GradedExam gradedExam)
    {
        super.update(String.format("UPDATE GradedExam SET gradedTime = '%s', score = %.2f WHERE examID = %d",
                gradedExam.getGradedTime(),
                gradedExam.getScore(),
                gradedExam.getGradedExamPK().getExamID()));
    }

}
