package com.gpti.bytego.model.DAO.question;


import com.gpti.bytego.model.DAO.GenericDao;
import com.gpti.bytego.model.entity.exam.Exam;
import com.gpti.bytego.model.entity.question.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionDao extends GenericDao<Question>
{
    public void create(Long examID, String statement, byte[] statementImage, int difficulty, String correctAnswer, byte[] correctAnswerImage)
    {
        Question question = new Question();
        question.setStatement(statement);
        question.setStatementImage(statementImage);
        question.setDifficulty(difficulty);
        question.setCorrectAnswer(correctAnswer);
        question.setCorrectAnswerImage(correctAnswerImage);
        question.setExam(entityManager.getReference(Exam.class, examID));
        super.create(question);
    }

    public void create(Question question)
    {
        question.setExam(entityManager.getReference(Exam.class, question.getExam().getID()));
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

    public ArrayList<Question> findAllByExamID(Long examID)
    {
        ArrayList<Question> questions = new ArrayList<>();

        List<?> list = super.findAll(String.format(
                        "SELECT * FROM Question WHERE examID = %d", examID),
                Question.class);
        for (Object obj : list) if (obj instanceof Question) questions.add((Question) obj);

        return questions;
    }

    public void update(Question question)
    {
        super.update(String.format("UPDATE Question SET " +
                        "statement = '%s', " +
                        "statementImage = '%s', " +
                        "difficulty = %d, " +
                        "studentAnswer = '%s', " +
                        "studentAnswerImage = '%s', " +
                        "correctAnswer = '%s', " +
                        "correctAnswerImage = '%s', " +
                        "professorComments = '%s', " +
                        "score = %.2f WHERE questionID = %d",
                question.getStatement(),
                Arrays.toString(question.getStatementImage()),
                question.getDifficulty(),
                question.getStudentAnswer(),
                Arrays.toString(question.getStudentAnswerImage()),
                question.getCorrectAnswer(),
                Arrays.toString(question.getCorrectAnswerImage()),
                question.getProfessorComments(),
                question.getScore(),
                question.getQuestionID()));
    }
}
