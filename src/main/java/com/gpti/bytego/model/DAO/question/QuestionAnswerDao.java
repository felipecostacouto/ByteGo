package com.gpti.bytego.model.DAO.question;

import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.question.*;
import com.gpti.bytego.model.entity.user.Student;
import com.gpti.bytego.model.entity.user.StudentPK;

public class QuestionAnswerDao extends GenericDao<QuestionAnswer>
{
    public void create(String login, char alternative, String text, byte[] image, float score, Long questionID)
    {
        QuestionAnswerPK PK = new QuestionAnswerPK(login, questionID);
        if (isDuplicatePrimaryKey(QuestionAnswer.class, PK)) return;
        QuestionAnswer questionAnswer = new QuestionAnswer();
        questionAnswer.setQuestionAnswerPK(PK);
        questionAnswer.setStudent(entityManager.getReference(Student.class, new StudentPK(login)));
        questionAnswer.setAlternative(alternative);
        questionAnswer.setText(text);
        questionAnswer.setImage(image);
        questionAnswer.setScore(score);
        questionAnswer.setQuestion(entityManager.getReference(Question.class, questionID));
        super.create(questionAnswer);
    }

    public void create(QuestionAnswer questionAnswer)
    {
        if (isDuplicatePrimaryKey(QuestionAnswer.class, questionAnswer.getQuestionAnswerPK())) return;
        questionAnswer.setStudent(entityManager.getReference(Student.class, questionAnswer.getQuestionAnswerPK().getLogin()));
        questionAnswer.setQuestion(entityManager.getReference(Question.class, questionAnswer.getQuestionAnswerPK().getQuestionID()));
        super.create(questionAnswer);
    }

    public void remove(String login, Long questionID)
    {
        super.remove(QuestionAnswer.class, new QuestionAnswerPK(login, questionID));
    }

    public void remove(QuestionAnswer questionAnswer)
    {
        super.remove(QuestionAnswer.class, questionAnswer.getQuestionAnswerPK());
    }

    public QuestionAnswer find(String login, Long questionID)
    {
        return super.find(QuestionAnswer.class, new QuestionAnswerPK(login, questionID));
    }
}
