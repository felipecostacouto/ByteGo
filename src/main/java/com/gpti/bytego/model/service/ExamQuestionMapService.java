package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.question.ExamQuestionMapDao;
import com.gpti.bytego.model.DTO.ExamDTO;
import com.gpti.bytego.model.DTO.QuestionDTO;
import com.gpti.bytego.model.entity.question.Question;

import java.util.ArrayList;

public class ExamQuestionMapService
{
    public void fillExamWithQuestions(ExamDTO examDTO)
    {
        examDTO.questions = new ArrayList<>();

        for (Question question : new ExamQuestionMapDao().findAllQuestionByExam(examDTO.ID))
        {
            QuestionDTO questionDTO = new QuestionDTO(
                    question.getQuestionID(),
                    question.getStatement(),
                    question.getStatementImage(),
                    question.getDifficulty(),
                    question.getCorrectAnswer(),
                    question.getCorrectAnswerImage(),
                    null,
                    null,
                    question.getSubjectTags()
            );

            examDTO.questions.add(questionDTO);
        }
    }
}
