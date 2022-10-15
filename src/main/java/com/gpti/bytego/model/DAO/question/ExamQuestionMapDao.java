package com.gpti.bytego.model.DAO.question;

import com.gpti.bytego.model.DAO.Exam.ExamDao;
import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.exam.*;
import com.gpti.bytego.model.entity.question.Question;

import java.util.ArrayList;
import java.util.List;

public class ExamQuestionMapDao extends GenericDao<ExamQuestionMap>
{
    public void create(Long questionID, Long examID)
    {
        ExamQuestionMapPK PK = new ExamQuestionMapPK(questionID, examID);
        if (isDuplicatePrimaryKey(ExamQuestionMap.class, PK)) return;
        ExamQuestionMap examQuestionMap = new ExamQuestionMap(PK);
        examQuestionMap.setQuestion(entityManager.getReference(Question.class, questionID));
        examQuestionMap.setExam(entityManager.getReference(Exam.class, examID));
        super.create(examQuestionMap);
    }

    public void create(ExamQuestionMap examQuestionMap)
    {
        if (isDuplicatePrimaryKey(ExamQuestionMap.class, examQuestionMap.getExamQuestionMapPK())) return;
        examQuestionMap.setQuestion(entityManager.getReference(Question.class, examQuestionMap.getQuestion().getQuestionID()));
        examQuestionMap.setExam(entityManager.getReference(Exam.class, examQuestionMap.getExam().getID()));
        super.create(examQuestionMap);
    }

    public void remove(Long questionID, Long examID)
    {
        super.remove(ExamQuestionMap.class, new ExamQuestionMapPK(questionID, examID));
    }

    public void remove(ExamQuestionMap examQuestionMap)
    {
        super.remove(ExamQuestionMap.class, examQuestionMap.getExamQuestionMapPK());
    }

    public ArrayList<Question> findAllQuestionByExam(Long examID)  {
        QuestionDao questionDao = new QuestionDao();
        ArrayList<Question> questions = new ArrayList<>();

        List<?> list = super.findAll(String.format("SELECT * FROM ExamQuestionMap WHERE examID = %d", examID), ExamQuestionMap.class);

        for (Object obj : list)
        {
            if (obj instanceof ExamQuestionMap)
            {
                questions.add(questionDao.find(((ExamQuestionMap) obj).getExamQuestionMapPK().getQuestionID()));
            }
        }

        return questions;
    }

    public ArrayList<Exam> findAllExamByQuestion(Long questionID)  {
        ExamDao examDao = new ExamDao();
        ArrayList<Exam> exams = new ArrayList<>();

        List<?> list = super.findAll(String.format("SELECT * FROM ExamQuestionMap WHERE questionID = %d", questionID), ExamQuestionMap.class);

        for (Object obj : list)
        {
            if (obj instanceof ExamQuestionMap)
            {
                exams.add(examDao.find(((ExamQuestionMap) obj).getExamQuestionMapPK().getExamID()));
            }
        }

        return exams;
    }
}
