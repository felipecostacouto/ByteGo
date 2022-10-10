package com.gpti.bytego.model.DAO.question;

import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.question.AnswerComment;
import com.gpti.bytego.model.entity.question.AnswerCommentPK;
import com.gpti.bytego.model.entity.question.QuestionAnswer;
import com.gpti.bytego.model.entity.user.Professor;
import com.gpti.bytego.model.entity.user.ProfessorPK;

public class AnswerCommentDao extends GenericDao<AnswerComment>
{
    public void create(Long answerID, String profLogin, String comment)
    {
        AnswerCommentPK PK = new AnswerCommentPK(answerID, profLogin);
        if (isDuplicatePrimaryKey(AnswerComment.class, PK)) return;
        AnswerComment answerComment = new AnswerComment();
        answerComment.setAnswerCommentPK(PK);
        answerComment.setQuestionAnswer(entityManager.getReference(QuestionAnswer.class, answerID));
        answerComment.setProfessor(entityManager.getReference(Professor.class, new ProfessorPK(profLogin)));
        answerComment.setComment(comment);
        super.create(answerComment);
    }

    public void create(AnswerComment answerComment)
    {
        if (isDuplicatePrimaryKey(AnswerComment.class, answerComment.getAnswerCommentPK())) return;
        answerComment.setQuestionAnswer(entityManager.getReference(QuestionAnswer.class, answerComment.getAnswerCommentPK().getAnswerID()));
        answerComment.setProfessor(entityManager.getReference(Professor.class, answerComment.getAnswerCommentPK().getProfLogin()));
        super.create(answerComment);
    }

    public void remove(Long answerID, String profLogin)
    {
        super.remove(AnswerComment.class, new AnswerCommentPK(answerID, profLogin));
    }

    public void remove(AnswerComment answerComment)
    {
        super.remove(AnswerComment.class, answerComment.getAnswerCommentPK());
    }

    public AnswerComment find(Long answerID, String profLogin)
    {
        return super.find(AnswerComment.class, new AnswerCommentPK(answerID, profLogin));
    }
}
