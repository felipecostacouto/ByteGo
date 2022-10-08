package com.gpti.bytego.model.DAO.Exam;


import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.exam.Exam;
import com.gpti.bytego.model.entity.exam.GradedExam;
import com.gpti.bytego.model.entity.exam.GradedExamPK;
import com.gpti.bytego.model.entity.exam.SpecificExamInterface;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class GradedExamDao extends GenericDao<GradedExam> implements SpecificExamDaoInterface
{
    public void create(Long examID, Timestamp gradedTime, Float score)
    {
        if (isDuplicatePrimaryKey(GradedExam.class, new GradedExamPK(examID))) return;
        GradedExam gradedExam = new GradedExam();
        gradedExam.setExam(entityManager.getReference(Exam.class, examID));
        gradedExam.setGradedTime(gradedTime);
        gradedExam.setScore(score);
        super.create(gradedExam);
    }

    public void create(GradedExam gradedExam)
    {
        if (isDuplicatePrimaryKey(GradedExam.class, gradedExam.getGradedExamPK())) return;
        gradedExam.setExam(entityManager.getReference(Exam.class, gradedExam.getGradedExamPK().getExamID()));
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
    public ArrayList<SpecificExamInterface> findAllByExamID(Long examID)  {
        ArrayList<SpecificExamInterface> exams = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM GradedExam WHERE examID = %d", examID),
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
