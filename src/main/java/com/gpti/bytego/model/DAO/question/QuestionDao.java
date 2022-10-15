package com.gpti.bytego.model.DAO.question;


import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.question.Question;

import java.util.Arrays;
import java.util.Set;

public class QuestionDao extends GenericDao<Question>
{
    public void create(String statement, byte[] statementImage, int difficulty, String correctAnswer, byte[] correctAnswerImage, Set<String> subjectTags)
    {
        Question question = new Question();
        question.setStatement(statement);
        question.setStatementImage(statementImage);
        question.setDifficulty(difficulty);
        question.setCorrectAnswer(correctAnswer);
        question.setCorrectAnswerImage(correctAnswerImage);
        question.setSubjectTags(subjectTags);
        super.create(question);
    }

    public void create(Question question)
    {
        super.create(question);
    }

    public void remove(Long questionID)
    {
        super.remove(Question.class, questionID);
    }

    public void remove(Question question)
    {
        super.remove(Question.class, question.getQuestionID());
    }

    public Question find(Long questionID)
    {
        return super.find(Question.class, questionID);
    }

    public void update(Question question)
    {
        super.update(String.format("UPDATE Question SET " +
                        "statement = '%s', " +
                        "statementImage = '%s', " +
                        "difficulty = %d, " +
                        "correctAnswer = '%s', " +
                        "correctAnswerImage = '%s', " +
                        "WHERE questionID = %d",
                question.getStatement(),
                Arrays.toString(question.getStatementImage()),
                question.getDifficulty(),
                question.getCorrectAnswer(),
                Arrays.toString(question.getCorrectAnswerImage()),
                question.getQuestionID()));
    }
}
