package com.gpti.bytego.model.DAO.Exam;

import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.exam.Exam;
import com.gpti.bytego.model.entity.exam.ExamToTake;
import com.gpti.bytego.model.entity.exam.ExamToTakePK;
import com.gpti.bytego.model.entity.exam.SpecificExamInterface;
import com.gpti.bytego.model.entity.user.Student;
import com.gpti.bytego.model.entity.user.StudentPK;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ExamToTakeDao extends GenericDao<ExamToTake> implements SpecificExamDaoInterface
{
    public void create(Long examID, Timestamp limitDate)
    {
        // TODO: limitDate deveria estar em uma tabela separada, pois evita que uma prova tenha data limite diferente p/ aluno diferente
        if (isDuplicatePrimaryKey(ExamToTake.class, new ExamToTakePK(examID))) return;
        ExamToTake examToTake = new ExamToTake();
        examToTake.setExamToTakePK(new ExamToTakePK(examID));
        examToTake.setExam(entityManager.getReference(Exam.class, examID));
        examToTake.setLimitDate(limitDate);
        super.create(examToTake);
    }

    public void create(ExamToTake examToTake)
    {
        if (isDuplicatePrimaryKey(ExamToTake.class, examToTake.getExamToTakePK())) return;
        examToTake.setExam(entityManager.getReference(Exam.class, examToTake.getExam().getID()));
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
    public ArrayList<SpecificExamInterface> findAllByExamID(Long examID)  {
        ArrayList<SpecificExamInterface> exams = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM ExamToTake WHERE examID = %d", examID),
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
