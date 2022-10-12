package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.question.QuestionAlternativeDao;
import com.gpti.bytego.model.DAO.question.QuestionAnswerDao;
import com.gpti.bytego.model.DAO.question.QuestionDao;
import com.gpti.bytego.model.DTO.*;
import com.gpti.bytego.model.entity.question.Question;
import com.gpti.bytego.model.entity.question.QuestionAlternative;

import java.util.ArrayList;
import java.util.List;

public class QuestionService
{
    public void fillExamWithQuestions(ExamDTO examDTO, String studentLogin)
    {
        examDTO.questions = new ArrayList<>();

        for (Question question : new QuestionDao().findAllByExamID(examDTO.ID))
        {
            QuestionDTO questionDTO = new QuestionDTO(
                    question.getQuestionID(),
                    question.getStatement(),
                    question.getStatementImage(),
                    question.getDifficulty(),
                    question.getCorrectAnswer(),
                    question.getCorrectAnswerImage(),
                    null,
                    null
            );

            examDTO.questions.add(questionDTO);
            fillQuestionWithAlternatives(questionDTO);

            new AnswerService().fillQuestionWithAnswer(questionDTO, studentLogin);
        }
    }

    public void fillQuestionWithAlternatives(QuestionDTO questionDTO)
    {
        questionDTO.alternatives = new ArrayList<>();

        for (QuestionAlternative alternative : new QuestionAlternativeDao().findAllByQuestion(questionDTO.questionID))
        {
            questionDTO.alternatives.add(new QuestionAlternativeDTO(
                    alternative.getQuestionAlternativePK().getAlternative(),
                    alternative.getText(),
                    alternative.getImage()));
        }
    }
}
