package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.question.QuestionAlternativeDao;
import com.gpti.bytego.model.DTO.*;
import com.gpti.bytego.model.entity.question.QuestionAlternative;

import java.util.ArrayList;

public class QuestionService
{
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
