package model.DAO.Exam;

import model.DAO.GenericDao;
import model.entity.Exam.Exam;
import model.entity.Exam.ExamToGrade;
import model.entity.Exam.ExamToGradePK;
import model.entity.Exam.ExamToTake;
import model.entity.User.Professor;
import model.entity.User.ProfessorPK;

import java.util.ArrayList;
import java.util.List;

public class ExamToGradeDao extends GenericDao<ExamToGrade>
{
    public void create(Long examID, String professorLogin, int openQuestionsGraded)
    {
        if (isDuplicatePrimaryKey(ExamToGrade.class, new ExamToGradePK(examID))) return;
        ExamToGrade examToGrade = new ExamToGrade();
        examToGrade.setExamToGradePK(new ExamToGradePK(examID));
        examToGrade.setExam(entityManager.getReference(Exam.class, examID));
        examToGrade.setProfessor(entityManager.getReference(Professor.class, new ProfessorPK(professorLogin)));
        examToGrade.setOpenQuestionsGraded(openQuestionsGraded);
        super.create(examToGrade);
    }

    public void create(ExamToGrade examToGrade)
    {
        if (isDuplicatePrimaryKey(ExamToGrade.class, examToGrade.getExamToGradePK())) return;
        examToGrade.setExam(entityManager.getReference(Exam.class, examToGrade.getExam().getID()));
        examToGrade.setProfessor(entityManager.getReference(Professor.class, examToGrade.getProfessor().getProfessorPK()));
        super.create(examToGrade);
    }

    public void remove(Long examID)
    {
        super.remove(ExamToGrade.class, new ExamToGradePK(examID));
    }

    public void remove(ExamToGrade examToGrade)
    {
        super.remove(ExamToGrade.class, examToGrade.getExamToGradePK());
    }

    public ExamToGrade find(Long examID)
    {
        return super.find(ExamToGrade.class, new ExamToGradePK(examID));
    }

    public ArrayList<ExamToGrade> findAllByProfessor(String professorLogin)
    {
        ArrayList<ExamToGrade> exams = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                "SELECT * FROM ExamToGrade WHERE examToGradeProfessorLogin = '%s'", professorLogin),
                ExamToGrade.class);
        for (Object obj : list) if (obj instanceof ExamToGrade) exams.add((ExamToGrade) obj);

        return exams;
    }

    public void update(ExamToGrade examToGrade)
    {
        super.update(String.format("UPDATE ExamToGrade SET openQuestionsGraded = %d WHERE examID = %d",
                examToGrade.getOpenQuestionsGraded(),
                examToGrade.getExam().getID()));
    }
}
