package com.gpti.bytego.model.service;

import com.gpti.bytego.model.DAO.Class.ClassProfessorDao;
import com.gpti.bytego.model.DAO.question.QuestionAlternativeDao;
import com.gpti.bytego.model.DAO.question.QuestionAnswerDao;
import com.gpti.bytego.model.DAO.question.QuestionDao;
import com.gpti.bytego.model.DTO.*;
import com.gpti.bytego.model.entity.classroom.ClassroomIndicator;
import com.gpti.bytego.model.entity.question.Question;
import com.gpti.bytego.model.entity.question.QuestionAlternative;
import com.gpti.bytego.model.entity.question.QuestionAnswer;

import java.util.ArrayList;
import java.util.List;

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
                            null
                    );

                    examDTO.questions.add(questionDTO);
                    fillAlternativesByQuestionDTO(questionDTO);
                    fillAnswerByUserDTO(questionDTO, userDTO, classDTO.getProfessorsLogins());
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

    public void fillAnswerByUserDTO(QuestionDTO questionDTO, UserDTO userDTO, List<String> professorLogins)
    {
        for (String profLogin : professorLogins)
        {
            QuestionAnswer questionAnswer = new QuestionAnswerDao().find(userDTO.login, questionDTO.questionID, profLogin);
            if (questionAnswer != null && questionAnswer.getProfessor() != null)
            {
                questionDTO.answer = new QuestionAnswerDTO(
                        questionAnswer.getStudent().getStudentPK().getStudentLogin(),
                        questionAnswer.getAlternative(),
                        questionAnswer.getText(),
                        questionAnswer.getImage(),
                        questionAnswer.getScore(),
                        questionDTO.getQuestionID(),
                        questionAnswer.getComment(),
                        questionAnswer.getProfessor().getProfessorPK().getProfessorLogin());
                break;
            }
        }
    }
}
