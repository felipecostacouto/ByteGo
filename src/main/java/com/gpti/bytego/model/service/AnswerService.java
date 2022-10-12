package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.question.QuestionAnswerDao;
import com.gpti.bytego.model.DTO.QuestionAnswerDTO;
import com.gpti.bytego.model.DTO.QuestionDTO;
import com.gpti.bytego.model.entity.question.QuestionAnswer;

public class AnswerService
{
    public void fillQuestionWithAnswer(QuestionDTO questionDTO, String studentLogin)
    {
        QuestionAnswer questionAnswer = new QuestionAnswerDao().find(studentLogin, questionDTO.questionID);
        if (questionAnswer != null)
        {
            questionDTO.answer = new QuestionAnswerDTO(
                    questionAnswer.getStudent().getStudentPK().getStudentLogin(),
                    questionAnswer.getAlternative(),
                    questionAnswer.getText(),
                    questionAnswer.getImage(),
                    questionAnswer.getScore(),
                    questionDTO.getQuestionID(),
                    questionAnswer.getComment(),
                    questionAnswer.getProfessor());
        }
    }
}
