package com.gpti.bytego.model.DAO.Exam;


import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.exam.Exam;

public class ExamDao extends GenericDao<Exam>
{
    public void create(String name, int timeToDeliverInSeconds, int closedQuestionsAmount, int openQuestionsAmount) {
        super.create(new Exam(name, timeToDeliverInSeconds, closedQuestionsAmount, openQuestionsAmount));
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

    public void update(Exam exam) {
        super.update(String.format("UPDATE Exam SET name = '%s', timeToDeliverInSeconds = %d, closedQuestionsAmount = %d, openQuestionsAmount = %d WHERE ID = %d",
                exam.getName(),
                exam.getTimeToDeliverInSeconds(),
                exam.getClosedQuestionsAmount(),
                exam.getOpenQuestionsAmount(),
                exam.getID()));
    }
}
