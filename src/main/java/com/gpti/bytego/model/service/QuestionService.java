package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.question.QuestionAlternativeDao;
import com.gpti.bytego.model.DAO.question.QuestionDao;
import com.gpti.bytego.model.DTO.*;
import com.gpti.bytego.model.entity.question.Question;
import com.gpti.bytego.model.entity.question.QuestionAlternative;

import java.util.ArrayList;

public class QuestionService
{
    public void fillQuestionsByUserDTO(UserDTO userDTO)
    {
        for (ClassDTO classDTO : userDTO.classes)
        {
            for (ExamDTO examDTO : classDTO.exams)
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
                            null,
                            null
                    );

                    examDTO.questions.add(questionDTO);
                    fillAlternativesByQuestionDTO(questionDTO);
                    fillAnswerByQuestionDTO(questionDTO);
                    fillCommentByQuestionDTO(questionDTO);
                }
            }
        }
    }

    public void fillAlternativesByQuestionDTO(QuestionDTO questionDTO)
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

    public void fillAnswerByQuestionDTO(QuestionDTO questionDTO)
    {

    }

    public void fillCommentByQuestionDTO(QuestionDTO questionDTO)
    {

    }
}
