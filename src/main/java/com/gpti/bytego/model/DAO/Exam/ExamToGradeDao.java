package com.gpti.bytego.model.DAO.Exam;


import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.exam.Exam;
import com.gpti.bytego.model.entity.exam.ExamToGrade;
import com.gpti.bytego.model.entity.exam.ExamToGradePK;
import com.gpti.bytego.model.entity.exam.SpecificExamInterface;
import com.gpti.bytego.model.entity.user.Professor;
import com.gpti.bytego.model.entity.user.ProfessorPK;

import java.util.ArrayList;
import java.util.List;

public class ExamToGradeDao extends GenericDao<ExamToGrade> implements SpecificExamDaoInterface
{
    public void create(Long examID, int openQuestionsGraded)
    {
        if (isDuplicatePrimaryKey(ExamToGrade.class, new ExamToGradePK(examID))) return;
        ExamToGrade examToGrade = new ExamToGrade();
        examToGrade.setExamToGradePK(new ExamToGradePK(examID));
        examToGrade.setExam(entityManager.getReference(Exam.class, examID));
        examToGrade.setOpenQuestionsGraded(openQuestionsGraded);
        super.create(examToGrade);
    }

    public void create(ExamToGrade examToGrade)
    {
        if (isDuplicatePrimaryKey(ExamToGrade.class, examToGrade.getExamToGradePK())) return;
        examToGrade.setExam(entityManager.getReference(Exam.class, examToGrade.getExam().getID()));
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

    @Override
    public ArrayList<SpecificExamInterface> findAllByExamID(Long examID) {
        ArrayList<SpecificExamInterface> exams = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM ExamToGrade WHERE examID = %d", examID),
                ExamToGrade.class);
        for (Object obj : list) if (obj instanceof ExamToGrade) exams.add((ExamToGrade) obj);

        return exams;
    }

    @Override
    public Exam findParentExamByID(Long examID) {
        return new ExamDao().find(examID);
    }

    public void update(ExamToGrade examToGrade)
    {
        super.update(String.format("UPDATE ExamToGrade SET openQuestionsGraded = %d WHERE examID = %d",
                examToGrade.getOpenQuestionsGraded(),
                examToGrade.getExam().getID()));
    }
}
