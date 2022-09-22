package model.dao.Exam;

import model.dao.GenericDao;
import model.entity.Exam.Exam;
import model.entity.Exam.GradedExam;
import model.entity.Exam.Question;

import java.util.Arrays;

public class QuestionDao extends GenericDao<Question>
{
    public void create(Long examID, String statement, byte[] statementImage, int difficulty)
    {
        Question question = new Question();
        question.setStatement(statement);
        question.setStatementImage(statementImage);
        question.setDifficulty(difficulty);
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

    public void update(Question question)
    {
        super.update(String.format("UPDATE Question SET " +
                        "statement = '%s', " +
                        "statementImage = '%s', " +
                        "difficulty = %d, " +
                        "answerText = '%s', " +
                        "answerImage = '%s', " +
                        "professorComments = '%s' WHERE questionID = %d",
                question.getStatement(),
                Arrays.toString(question.getStatementImage()),
                question.getDifficulty(),
                question.getAnswerText(),
                Arrays.toString(question.getAnswerImage()),
                question.getProfessorComments(),
                question.getQuestionID()));
    }
}
