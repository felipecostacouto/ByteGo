package com.gpti.bytego.model.DAO.question;

import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.question.*;
import com.gpti.bytego.model.entity.user.Professor;
import com.gpti.bytego.model.entity.user.ProfessorPK;
import com.gpti.bytego.model.entity.user.Student;
import com.gpti.bytego.model.entity.user.StudentPK;

public class QuestionAnswerDao extends GenericDao<QuestionAnswer>
{
    public void create(String studentLogin, char alternative, String text, byte[] image, float score, Long questionID, String comment, String professorLogin)
    {
        QuestionAnswerPK PK = new QuestionAnswerPK(studentLogin, questionID);
        if (isDuplicatePrimaryKey(QuestionAnswer.class, PK)) return;
        QuestionAnswer questionAnswer = new QuestionAnswer();
        questionAnswer.setQuestionAnswerPK(PK);
        questionAnswer.setStudent(entityManager.getReference(Student.class, new StudentPK(studentLogin)));
        questionAnswer.setAlternative(alternative);
        questionAnswer.setText(text);
        questionAnswer.setImage(image);
        questionAnswer.setScore(score);
        questionAnswer.setQuestion(entityManager.getReference(Question.class, questionID));
        questionAnswer.setComment(comment);
        questionAnswer.setProfessor(entityManager.getReference(Professor.class, new ProfessorPK(professorLogin)));
        super.create(questionAnswer);
    }

    public void create(QuestionAnswer questionAnswer)
    {
        if (isDuplicatePrimaryKey(QuestionAnswer.class, questionAnswer.getQuestionAnswerPK())) return;
        questionAnswer.setStudent(entityManager.getReference(Student.class, questionAnswer.getQuestionAnswerPK().getStudentLogin()));
        questionAnswer.setQuestion(entityManager.getReference(Question.class, questionAnswer.getQuestionAnswerPK().getQuestionID()));
        questionAnswer.setProfessor(entityManager.getReference(Professor.class, questionAnswer.getProfessor().getProfessorPK()));
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

    public QuestionAnswer find(String studentLogin, Long questionID, String professorLogin)
    {
        QuestionAnswer questionAnswer = super.find(QuestionAnswer.class, new QuestionAnswerPK(studentLogin, questionID));
        if (questionAnswer != null)
        {
            questionAnswer.setStudent(entityManager.getReference(Student.class, new StudentPK(studentLogin)));
            questionAnswer.setProfessor(entityManager.getReference(Professor.class, new ProfessorPK(professorLogin)));
        }
        return questionAnswer;
    }
}
