package com.gpti.bytego.model.DAO.question;

import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.question.Question;
import com.gpti.bytego.model.entity.question.QuestionAlternative;
import com.gpti.bytego.model.entity.question.QuestionAlternativePK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionAlternativeDao extends GenericDao<QuestionAlternative>
{
    public void create(Long questionID, char alternative, String text, byte[] image)
    {
        QuestionAlternative questionAlternative = new QuestionAlternative();
        QuestionAlternativePK PK = new QuestionAlternativePK(entityManager.find(Question.class, questionID), alternative);
        questionAlternative.setQuestionAlternativePK(PK);
        questionAlternative.setText(text);
        questionAlternative.setImage(image);
        super.create(questionAlternative);
    }

    public void create(QuestionAlternative questionAlternative)
    {
        super.create(questionAlternative);
    }

    public void remove(Long questionID, char alternative)
    {
        super.remove(QuestionAlternative.class, new QuestionAlternativePK(
                entityManager.find(Question.class, questionID),
                alternative));
    }

    public void remove(QuestionAlternative questionAlternative)
    {
        super.remove(QuestionAlternative.class, questionAlternative.getQuestionAlternativePK());
    }

    public QuestionAlternative find(Long questionID, char alternative)
    {
        return super.find(QuestionAlternative.class, new QuestionAlternativePK(
                entityManager.find(Question.class, questionID),
                alternative));
    }

    public ArrayList<QuestionAlternative> findAllByQuestion(Long questionID)
    {
        ArrayList<QuestionAlternative> alternatives = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM QuestionAlternative WHERE questionID = %d", questionID),
                QuestionAlternative.class);
        for (Object obj : list) if (obj instanceof QuestionAlternative) alternatives.add((QuestionAlternative) obj);

        return alternatives;
    }

    public void update(QuestionAlternative questionAlternative)
    {
        super.update(String.format("UPDATE QuestionAlternative SET " +
                        "text = '%s', " +
                        "image = '%s', " +
                        "WHERE questionID = %d" +
                        "AND alternative = '%s'",
                questionAlternative.getText(),
                Arrays.toString(questionAlternative.getImage()),
                questionAlternative.getQuestionAlternativePK().getQuestion().getQuestionID(),
                questionAlternative.getQuestionAlternativePK().getAlternative()));
    }
}
