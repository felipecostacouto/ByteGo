package model.service;

import model.DAO.Exam.*;
import model.DTO.ExamDTO;
import model.DTO.QuestionDTO;
import model.entity.Exam.*;

import java.util.ArrayList;

public class ExamService
{
    ExamDao examDao = new ExamDao();

    public ArrayList<ExamDTO> getExamToTakeDTOByStudent(String studentLogin)
    {
        ArrayList<ExamDTO> exams = new ArrayList<>();

        for (ExamToTake examToTake : new ExamToTakeDao().findAllByStudent(studentLogin))
        {
            Exam exam = examDao.find(examToTake.getExamToTakePK().getExamID());
            ArrayList<QuestionDTO> questions = new ArrayList<>();

            for (Question question : new QuestionDao().findAllByExamID(exam.getID()))
            {
                questions.add(new QuestionDTO(
                        question.getQuestionID(),
                        question.getStatement(),
                        question.getStatementImage(),
                        question.getDifficulty(),
                        question.getAnswerText(),
                        question.getAnswerImage(),
                        question.getProfessorComments()));
            }

            exams.add(new ExamDTO(
                    exam.getID(),
                    exam.getName(),
                    exam.getTimeToDeliverInSeconds(),
                    exam.getClosedQuestionsAmount(),
                    exam.getOpenQuestionsAmount(),
                    0,
                    0,
                    examToTake.getLimitDate(),
                    null,
                    questions));
        }

        return exams;
    }

    public ArrayList<ExamDTO> getDoneExamDTOByStudent(String studentLogin)
    {
        GradedExamDao gradedExamDao = new GradedExamDao();
        ArrayList<ExamDTO> exams = new ArrayList<>();

        for (DoneExam doneExam : new DoneExamDao().findAllByStudent(studentLogin))
        {
            Exam exam = examDao.find(doneExam.getDoneExamPK().getExamID());
            ArrayList<QuestionDTO> questions = new ArrayList<>();

            for (Question question : new QuestionDao().findAllByExamID(exam.getID()))
            {
                questions.add(new QuestionDTO(
                        question.getQuestionID(),
                        question.getStatement(),
                        question.getStatementImage(),
                        question.getDifficulty(),
                        question.getAnswerText(),
                        question.getAnswerImage(),
                        question.getProfessorComments()));
            }

            exams.add(new ExamDTO(
                    exam.getID(),
                    exam.getName(),
                    exam.getTimeToDeliverInSeconds(),
                    exam.getClosedQuestionsAmount(),
                    exam.getOpenQuestionsAmount(),
                    doneExam.getScore(),
                    exam.getOpenQuestionsAmount(),
                    null,
                    gradedExamDao.find(exam.getID()).getGradeTime(),
                    questions));
        }

        return exams;
    }

    public ArrayList<ExamDTO> getExamToGradeDTOByProfessor(String professorLogin)
    {
        DoneExamDao doneExamDao = new DoneExamDao();
        ArrayList<ExamDTO> exams = new ArrayList<>();

        for (ExamToGrade doneExam : new ExamToGradeDao().findAllByProfessor(professorLogin))
        {
            Exam exam = examDao.find(doneExam.getExamToGradePK().getExamID());
            ArrayList<QuestionDTO> questions = new ArrayList<>();

            for (Question question : new QuestionDao().findAllByExamID(exam.getID()))
            {
                questions.add(new QuestionDTO(
                        question.getQuestionID(),
                        question.getStatement(),
                        question.getStatementImage(),
                        question.getDifficulty(),
                        question.getAnswerText(),
                        question.getAnswerImage(),
                        question.getProfessorComments()));
            }

            exams.add(new ExamDTO(
                    exam.getID(),
                    exam.getName(),
                    exam.getTimeToDeliverInSeconds(),
                    exam.getClosedQuestionsAmount(),
                    exam.getOpenQuestionsAmount(),
                    doneExamDao.find(exam.getID()).getScore(),
                    doneExam.getOpenQuestionsGraded(),
                    null,
                    null,
                    questions));
        }

        return exams;
    }

    public ArrayList<ExamDTO> getGradedExamDTOByProfessor(String professorLogin)
    {
        DoneExamDao doneExamDao = new DoneExamDao();
        ArrayList<ExamDTO> exams = new ArrayList<>();

        for (GradedExam doneExam : new GradedExamDao().findAllByProfessor(professorLogin))
        {
            Exam exam = examDao.find(doneExam.getGradedExamPK().getExamID());
            ArrayList<QuestionDTO> questions = new ArrayList<>();

            for (Question question : new QuestionDao().findAllByExamID(exam.getID()))
            {
                questions.add(new QuestionDTO(
                        question.getQuestionID(),
                        question.getStatement(),
                        question.getStatementImage(),
                        question.getDifficulty(),
                        question.getAnswerText(),
                        question.getAnswerImage(),
                        question.getProfessorComments()));
            }

            exams.add(new ExamDTO(
                    exam.getID(),
                    exam.getName(),
                    exam.getTimeToDeliverInSeconds(),
                    exam.getClosedQuestionsAmount(),
                    exam.getOpenQuestionsAmount(),
                    doneExamDao.find(exam.getID()).getScore(),
                    exam.getOpenQuestionsAmount(),
                    null,
                    doneExam.getGradeTime(),
                    questions));
        }

        return exams;
    }
}
