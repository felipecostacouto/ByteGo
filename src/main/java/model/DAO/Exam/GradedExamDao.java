package model.DAO.Exam;

import model.DAO.GenericDao;
import model.entity.Exam.DoneExam;
import model.entity.Exam.Exam;
import model.entity.Exam.GradedExam;
import model.entity.Exam.GradedExamPK;
import model.entity.User.Professor;
import model.entity.User.ProfessorPK;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class GradedExamDao extends GenericDao<GradedExam>
{
    public void create(Long examID, String professorLogin, Timestamp gradedTime)
    {
        if (isDuplicatePrimaryKey(GradedExam.class, new GradedExamPK(examID))) return;
        GradedExam gradedExam = new GradedExam();
        gradedExam.setExam(entityManager.getReference(Exam.class, examID));
        gradedExam.setProfessor(entityManager.getReference(Professor.class, new ProfessorPK(professorLogin)));
        gradedExam.setGradeTime(gradedTime);
        super.create(gradedExam);
    }

    public void create(GradedExam gradedExam)
    {
        if (isDuplicatePrimaryKey(GradedExam.class, gradedExam.getGradedExamPK())) return;
        gradedExam.setExam(entityManager.getReference(Exam.class, gradedExam.getGradedExamPK().getExamID()));
        gradedExam.setProfessor(entityManager.getReference(Professor.class, gradedExam.getProfessor().getProfessorPK()));
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

    public ArrayList<GradedExam> findAllByProfessor(String professorLogin)
    {
        ArrayList<GradedExam> exams = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                "SELECT * FROM GradedExam WHERE gradedExamProfessorLogin = '%s'", professorLogin),
                GradedExam.class);
        for (Object obj : list) if (obj instanceof GradedExam) exams.add((GradedExam) obj);

        return exams;
    }

    public void update(GradedExam gradedExam)
    {
        super.update(String.format("UPDATE GradedExam SET gradedTime = '%s' WHERE examID = %d",
                gradedExam.getGradeTime(),
                gradedExam.getGradedExamPK().getExamID()));
    }

}
