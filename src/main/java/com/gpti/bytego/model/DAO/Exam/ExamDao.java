package com.gpti.bytego.model.DAO.Exam;


import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.classroom.ClassSubject;
import com.gpti.bytego.model.entity.exam.Exam;
import com.gpti.bytego.model.entity.exam.ExamToGrade;
import com.gpti.bytego.model.entity.exam.SpecificExamInterface;

import java.util.ArrayList;
import java.util.List;

public class ExamDao extends GenericDao<Exam>
{
    public void create(String name, int timeToDeliverInSeconds, int closedQuestionsAmount, int openQuestionsAmount, String classID) {
        Exam exam = new Exam();
        exam.setName(name);
        exam.setTimeToDeliverInSeconds(timeToDeliverInSeconds);
        exam.setClosedQuestionsAmount(closedQuestionsAmount);
        exam.setOpenQuestionsAmount(openQuestionsAmount);
        exam.setClassID(entityManager.find(ClassSubject.class, classID));
        super.create(exam);
    }

    public void create(Exam exam) {
        super.create(exam);
    }

    public void remove(Long ID) {
        super.remove(Exam.class, ID);
    }

    public void remove(Exam exam) {
        super.remove(Exam.class, exam.getID());
    }

    public Exam find(Long ID) {
        return super.find(Exam.class, ID);
    }

    public ArrayList<Exam> findAllByClassID(String classID) {
        ArrayList<Exam> exams = new ArrayList<>();

        List<?> list = super.findAll(String.format("SELECT * FROM Exam WHERE classID = '%s'", classID), Exam.class);
        for (Object obj : list) if (obj instanceof Exam) exams.add((Exam) obj);

        return exams;
    }

    public void update(Exam exam) {
        super.update(String.format("UPDATE Exam SET " +
                        "name = '%s', " +
                        "timeToDeliverInSeconds = %d, " +
                        "closedQuestionsAmount = %d, " +
                        "openQuestionsAmount = %d, " +
                        "classID = '%s' " +
                        "WHERE ID = %d",
                exam.getName(),
                exam.getTimeToDeliverInSeconds(),
                exam.getClosedQuestionsAmount(),
                exam.getOpenQuestionsAmount(),
                exam.getClassID().getClassSubjectID(),
                exam.getID()));
    }
}
